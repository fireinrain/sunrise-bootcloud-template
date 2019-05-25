package com.sunrise.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @date: 2019/5/24 21:51
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced   //开启客户端负载均衡ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
