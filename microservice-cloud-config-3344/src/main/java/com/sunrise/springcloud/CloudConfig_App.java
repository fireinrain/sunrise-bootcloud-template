package com.sunrise.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description:
 * @date: 2019/5/26 00:44
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfig_App {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig_App.class, args);
    }
}
