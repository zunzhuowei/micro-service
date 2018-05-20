package com.qs.game.microserviceeurekaserver7003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
 * 等效于
 *  @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 *  用于排除因为包含了依赖而默认启动得配置。
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class MicroServiceEurekaServer7002Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEurekaServer7002Application.class, args);
    }
}
