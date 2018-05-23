package com.qs.game;

import com.qs.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
 * 等效于
 *  @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 *  用于排除因为包含了依赖而默认启动得配置
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@RibbonClient(value = "MICRO-SERVICECLOUD-DEPT",configuration = MyRule.class)
public class DeptConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApp.class, args);
    }

}
