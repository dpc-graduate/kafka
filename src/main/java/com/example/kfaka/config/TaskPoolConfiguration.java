package com.example.kfaka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : daipengcheng
 * @description : 任务线程配置
 * @date :  2022/6/7-10:27
 **/
@Configuration
@EnableAsync
public class TaskPoolConfiguration {
    private final Logger logger = LoggerFactory.getLogger(TaskPoolConfiguration.class);
    /**
     * 公共线程池
     */
    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor commonThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        // 返回可用处理器的Java虚拟机的数量
        int processNum = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors:"+processNum);
        int corePoolSize = (int) (processNum / (1 - 0.2));
        int maxPoolSize = (int) (processNum / (1 - 0.5));
        // 核心池大小
        logger.info("线程池大小:" + corePoolSize);
        pool.setCorePoolSize(corePoolSize);
        // 最大线程数
        pool.setMaxPoolSize(maxPoolSize);
        // 队列程度
        pool.setQueueCapacity(maxPoolSize * 1000);
        pool.setThreadPriority(Thread.MAX_PRIORITY);
        pool.setDaemon(false);
        // 线程空闲时间
        pool.setKeepAliveSeconds(300);
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return pool;
    }
}
