package com.sunrise.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * hystrix 监控面板启动类
 *
 * @description:
 * @date: 2019/5/25 22:02
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashBoard_App {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashBoard_App.class,args);
    }
}
