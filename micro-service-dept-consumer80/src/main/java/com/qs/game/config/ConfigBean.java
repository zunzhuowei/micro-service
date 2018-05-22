package com.qs.game.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@Configuration
public class ConfigBean {

    @Bean
    //默认轮询方式
    @LoadBalanced//spring cloud ribbon 是基于Netflix ribbon实现的一套客户端负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @Bean//修改负载均衡为随机算法
    public IRule myRule() {
        return new RandomRule();
    }

}
