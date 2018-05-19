package com.qs.game.controller;

import com.qs.game.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private static final String URL_PROFIX = "http://127.0.0.1:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dept/get/list")
    public Object getDeptList() {
        return restTemplate.getForObject(URL_PROFIX + "/dept/list", Object.class);
    }

    @GetMapping("/dept/get/{id}")
    public Object getDept(@PathVariable("id") long id) {
        return restTemplate.getForObject(URL_PROFIX + "/dept/get/" + id, Object.class);
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
        return restTemplate.getForObject(URL_PROFIX + "/dept/list/" + start + "/" + end, Object.class);
    }

}
