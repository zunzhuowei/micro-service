package com.qs.game.controller;

import com.qs.game.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@RestController
@RequestMapping(value = "/consumer",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConsumerController {

    private static final String URL_PROFIX = "http://127.0.0.1:8001";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dept/get/list")
    public Object getDeptList() {
        System.out.println("URL_PROFIX = " + 111111);
        Object o = restTemplate.getForObject(URL_PROFIX + "/dept/list", List.class);
        return o;
    }

    @GetMapping(value = "/dept/get/{id}")
    public Object getDept(@PathVariable("id") long id) {
        return restTemplate.getForObject(URL_PROFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping("/dept/add")
    public Object add(Dept dept) {
        System.out.println("consumer --- dept = " + dept);
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("id", dept.getId() + "");
        requestEntity.add("name", dept.getName());
        return restTemplate.postForObject(URL_PROFIX + "/dept/add", requestEntity, Object.class);
        //return restTemplate.postForObject(URL_PROFIX + "/dept/add", dept, Object.class);
    }

    @GetMapping("/dept/get/list/{start}/{end}")
    public Object getListByLimit(@PathVariable("start") long start,
                                 @PathVariable("end") long end) {
        return restTemplate.getForObject(URL_PROFIX + "/dept/list/" + start + "/" + end, List.class);
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
        return uri + " -- " + host + " -- " + port;
    }

}
