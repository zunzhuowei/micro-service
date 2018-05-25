package com.qs.game.api;

import com.qs.game.api.common.DeptFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zun.wei on 2018/5/20.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
//@FeignClient(name = "MICRO-SERVICECLOUD-DEPT")
@FeignClient(name = "MICRO-SERVICECLOUD-DEPT", fallbackFactory = DeptFallbackFactory.class)//服务降级
public interface DeptApi {

    @GetMapping("/dept/list")
    Object getListByCumsumerService();

    @GetMapping("/dept/get/{id}")
    Object getDept(@PathVariable("id") long id);

}
