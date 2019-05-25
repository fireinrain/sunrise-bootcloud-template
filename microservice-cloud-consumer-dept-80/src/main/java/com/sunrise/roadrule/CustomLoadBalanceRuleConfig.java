package com.sunrise.roadrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @date: 2019/5/25 15:02
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@Configuration
public class CustomLoadBalanceRuleConfig {
    @Bean
    public IRule getMyCustomLoadBalanceRule(){
        return new CustomLoadBalanceRule();
    }
}
