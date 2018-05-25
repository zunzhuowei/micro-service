package com.qs.game.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by zun.wei on 2018/5/25.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DashBoardApp {

    public static void main(String[] args) {
        SpringApplication.run(DashBoardApp.class, args);
    }

}
