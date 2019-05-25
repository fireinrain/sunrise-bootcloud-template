package com.sunrise.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @date: 2019/5/26 02:02
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudConfigedEurekaServer_App {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigedEurekaServer_App.class,args);
    }
}
