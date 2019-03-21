package com.egoist.parent.ext.disruptor;

import com.egoist.parent.pojo.dto.EgoistResult;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.WorkHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description: 事件处理父类，要使用Disruptor队列只需要继承这个类
 */
public abstract class EgoistDisruptorEventHandler<E> implements EventHandler<E>, WorkHandler<E>, EventTranslatorVararg<E> {
    private EgoistDisruptor egoistDisruptor;

    public EgoistDisruptorEventHandler() {
        Type[] actualTypeArguments = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        egoistDisruptor = new EgoistDisruptor((Class) actualTypeArguments[0], this);
    }

    /**
     * 提交请求时要做的事，例如先把请求参数存到数据库，校验是否有请求权限
     *
     * @param args 参数
     **/
    protected abstract EgoistResult onSubmit(Object... args);

    /**
     * 当队列拒绝加入时要做的事，例如转交给rabbit mq处理请求
     *
     * @param args 参数
     **/
    protected abstract EgoistResult onReject(Object... args);

    /**
     * 提交处理
     *
     * @param args args
     * @return
     */
    public EgoistResult submit(Object... args) {
        return egoistDisruptor.onData(args);
    }
}
