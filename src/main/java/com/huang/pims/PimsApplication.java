package com.huang.pims;

import com.huang.pims.configuration.CacheConfiguration;
import com.huang.pims.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@ComponentScan(basePackages = {"com.huang.pims.*"}) // 组件扫描
//@EnableScheduling // 开启计划任务支持
//@EnableAsync // 开启异步支持
//@EnableEurekaClient
@Import(value = {
        JpaConfiguration.class,
        CacheConfiguration.class
})
public class PimsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PimsApplication.class, args);
    }

//    @Bean
//    public ThreadPoolTaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        taskExecutor.setCorePoolSize(10);
//        taskExecutor.setMaxPoolSize(15);
//        taskExecutor.initialize();
//        return taskExecutor;
//    }

}

