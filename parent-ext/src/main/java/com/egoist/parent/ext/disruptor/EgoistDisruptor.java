package com.egoist.parent.ext.disruptor;

import com.egoist.parent.common.constants.EgoistResultStatusConstants;
import com.egoist.parent.pojo.dto.EgoistResult;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.InsufficientCapacityException;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * @Description: 对disruptor的封装
 */
public class EgoistDisruptor<E> {

    /**
     * 队列大小
     **/
    private static final int RING_BUFFER_SIZE = 32;

    /**
     * 消费者数量
     **/
    private static final int CONSUMER_NUM = 5;

    /**
     * eventHandler
     **/
    private EgoistDisruptorEventHandler<E> eventHandler;

    /**
     * disruptor
     **/
    private Disruptor disruptor;

    /**
     * ringBuffer
     **/
    private RingBuffer<E> ringBuffer;

    /**
     * evntFactory
     **/
    private EventFactory eventFactory;

    /**
     * ThreadPoolWithDisruptor
     **/
    public EgoistDisruptor(Class<E> eventType, EgoistDisruptorEventHandler<E> eventHandler) {
        // 创建事件工厂
        eventFactory = new EventFactory<E>() {
            @Override
            public E newInstance() {
                try {
                    E result = eventType.newInstance();
                    return result;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        // 创建队列
        EgoistDisruptorEventHandler[] eventHandlerList = (EgoistDisruptorEventHandler[]) Array.newInstance(EgoistDisruptorEventHandler.class, CONSUMER_NUM);
        this.eventHandler = eventHandler;
        disruptor = new Disruptor(eventFactory, RING_BUFFER_SIZE, Executors.defaultThreadFactory(), ProducerType.MULTI, new BlockingWaitStrategy());
        ringBuffer = disruptor.getRingBuffer();
        Arrays.fill(eventHandlerList, eventHandler);
        disruptor.handleEventsWithWorkerPool(eventHandlerList);
        // 启动队列
        disruptor.start();
    }

    /**
     * 接收请求
     *
     * @param args 参数
     * @return 异步结果
     */
    public EgoistResult onData(Object... args) {
        E event = null;
        EgoistResult result = EgoistResult.ok();
        long sequeue = RingBuffer.INITIAL_CURSOR_VALUE;
        EgoistResult submitResult = eventHandler.onSubmit(args);
        if (!EgoistResult.isOk(submitResult)) {
            return new EgoistResult(EgoistResultStatusConstants.STATUS_400, String.format("提交处理时出现异常：%s",
                    submitResult.getMsg()), null);
        }
        try {
            sequeue = ringBuffer.tryNext();
            event = ringBuffer.get(sequeue);
            // 装填事件
            eventHandler.translateTo(event, sequeue, args);
            // 发布事件
            ringBuffer.publish(sequeue);
        } catch (InsufficientCapacityException e) {
            result = eventHandler.onReject(args);
        } catch (Exception e) {
            result = new EgoistResult(EgoistResultStatusConstants.STATUS_400, String.format("发布事件时出现异常：%s",
                    e.toString()), null);
        }

        return result;
    }

}
