package com.sunrise.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description:
 * @date: 2019/5/25 23:07
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway_App {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway_App.class,args);
    }
}
