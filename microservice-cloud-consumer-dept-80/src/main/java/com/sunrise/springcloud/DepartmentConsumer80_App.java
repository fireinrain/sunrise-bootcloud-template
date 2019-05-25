package com.sunrise.springcloud;

import com.sunrise.roadrule.CustomLoadBalanceRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description:
 * @date: 2019/5/24 22:11
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@SpringBootApplication
@EnableEurekaClient
/*在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效。
并且官方文档明确给出了警告：
    这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
    否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说
    我们达不到特殊化定制的目的了。*/
//那么解决方案是重新在java包下再建一个包名，并把MySelfRule类放入该包内。
// 比如我们需要访问一个Product 微服务，接口还在这里，想要定制和其他的ribbon实例
//不一样的负载均衡算法，就可以使用这种方式
@RibbonClient(name="MICROSERVICECLOUD-USER",configuration= CustomLoadBalanceRuleConfig.class)
public class DepartmentConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumer80_App.class, args);
    }
}
