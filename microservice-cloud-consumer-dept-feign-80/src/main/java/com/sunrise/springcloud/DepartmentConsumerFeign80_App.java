package com.sunrise.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @date: 2019/5/24 22:11
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.sunrise.springcloud")
public class DepartmentConsumerFeign80_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumerFeign80_App.class, args);
    }
}
