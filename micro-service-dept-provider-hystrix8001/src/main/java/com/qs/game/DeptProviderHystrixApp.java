package com.qs.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //暴露自己给eureka ,给其他服务调用
@EnableHystrix
public class DeptProviderHystrixApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrixApp.class, args);
}

}
