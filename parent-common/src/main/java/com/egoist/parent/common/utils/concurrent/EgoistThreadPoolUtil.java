package com.egoist.parent.common.utils.concurrent;

import com.egoist.parent.common.constants.EgoistConstant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具类
 */
public class EgoistThreadPoolUtil {
    private EgoistThreadPoolUtil(){}

    /**
     *  cachedThreadPool 适合短生命周期的异步任务
     */
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    /**
     *  固定大小线程池 默认10个
     */
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(EgoistConstant.FIXED_POOL_SIZE);

    /**
     * 获取固定大小线程池
     * @return 线程池
     */
    public static ExecutorService getFixedThreadPool() {
        return fixedThreadPool;
    }

    /**
     * 关闭固定大小线程池
     */
    public static void shutDownFixedThreadPool() {
        fixedThreadPool.shutdown();
    }

    /**
     * 获取固定大小线程池
     * @return 线程池
     */
    public static ExecutorService getCachedThreadPool() {
        return cachedThreadPool;
    }

    /**
     * 关闭固定大小线程池
     */
    public static void shutCachedThreadPool() {
        cachedThreadPool.shutdown();
    }
}
