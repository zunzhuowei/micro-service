package com.qs.game.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zun.wei on 2018/5/20.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@FeignClient(name="MICRO-SERVICECLOUD-DEPT")
public interface DeptApi {

    @GetMapping("/dept/list")
    Object getListByCumsumerService();

    @GetMapping("/dept/get/{id}")
    Object getDept(@PathVariable("id") long id);

}
