package com.qs.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指定已负载均衡算法，每个服务访问五次换下一个。
 */
@Configuration
public class MySelfRule {


    @Bean
    public IRule mySelfRule() {
        return new MyRule();
    }

}
