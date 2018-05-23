package com.qs.game.controller;

import com.qs.game.api.DeptApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private DeptApi deptApi;

    @GetMapping("dept/get/list")
    public Object getDeptList() {
        return this.deptApi.getListByCumsumerService();
    }

    @GetMapping(value = "dept/get/{id}")
    public Object getDept(@PathVariable("id") long id) {
        return this.deptApi.getDept(id);
    }

    /**
     * 获取发现的服务
     * @return
     */
    @GetMapping("/dept/get/service")
    public Object getService() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instanceList = discoveryClient.getInstances(services.get(0));
        ServiceInstance si = instanceList.get(0);
        String uri = si.getUri().toString();
        String host = si.getHost();
        int port = si.getPort();
        return uri + " --- " + host + " --- " + port;
    }

}
