package com.egoist.parent.ext.disruptor;

import com.egoist.parent.pojo.dto.EgoistResult;

/**
 * 测试Disruptor
 */
public class TestDisruptorEventHandler extends EgoistDisruptorEventHandler<TestObject> {
    /**
     * 提交请求时要做的事，例如先把请求参数存到数据库，校验是否有请求权限
     *
     * @param args 参数
     **/
    @Override
    protected EgoistResult onSubmit(Object... args) {
        return EgoistResult.ok();
    }

    /**
     * 当队列拒绝加入时要做的事，例如转交给rabbit mq处理请求
     *
     * @param args 参数
     **/
    @Override
    protected EgoistResult onReject(Object... args) {
        System.out.println("队列拒绝了事件发布");
        return EgoistResult.ok();
    }

    @Override
    public void onEvent(TestObject testObject, long l, boolean b) throws Exception {
        System.out.println(testObject.toString());
    }

    @Override
    public void translateTo(TestObject testObject, long l, Object... objects) {
        if ((Integer)objects[0] == 3) {
            int a = 0;
            int b = 1/a;
        }

        if ((Integer)objects[0] == 6) {
            String a = null;
            a.toString();
        }

        testObject.setId((Integer) objects[0]);
        testObject.setName((String) objects[1]);
    }

    @Override
    public void onEvent(TestObject testObject) throws Exception {
        System.out.println(testObject.toString());
    }

    public static void main(String[] args) {
        try {
            TestDisruptorEventHandler eventHandler = new TestDisruptorEventHandler();
            // 10个生产者
            for (int i = 0; i < 10; i++) {
                int id = i + 1;
                String name = String.format("name%s", id);
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        EgoistResult result = eventHandler.submit(id, name);
                        if (!EgoistResult.isOk(result)) {
                            System.out.println(String.format("线程%s异常：%s", id, result.getMsg()));
                        }
                    }
                };
                thread.setName("producer thread " + id);
                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
