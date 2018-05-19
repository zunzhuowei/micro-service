package com.qs.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * 网关
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy
@EnableEurekaClient
@EnableZuulServer
public class ZuulGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApp.class, args);
    }
}
