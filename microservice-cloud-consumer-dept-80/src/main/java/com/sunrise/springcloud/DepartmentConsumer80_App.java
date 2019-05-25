package com.sunrise.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @date: 2019/5/24 22:11
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@SpringBootApplication
@EnableEurekaClient
public class DepartmentConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumer80_App.class, args);
    }
}
