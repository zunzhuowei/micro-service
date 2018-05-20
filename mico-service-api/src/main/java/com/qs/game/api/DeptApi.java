package com.qs.game.api;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zun.wei on 2018/5/20.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@EnableFeignClients(basePackages = {"com.qs.game"})
public interface DeptApi {

    @GetMapping("/consumer/dept/get/list")
    Object getListByCumsumerService();

    @GetMapping("/consumer/dept/get/{id}")
    Object getDept(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    Object getAllDeptByList();

}
