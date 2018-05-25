package com.qs.game.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qs.game.entity.Dept;
import com.qs.game.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@RestController
@RequestMapping("/dept")
public class DeptController {


    @Autowired
    private IDeptService deptService;

    @GetMapping("/list")
    public Object getAllDeptByList() {
        List<Dept> depts = deptService.getDeptAllByList();
        return depts;
    }

    @GetMapping("/get/{id}")
    //发生异常回调此方法。（此为单独处理），依赖服务端，应该把降级放到客户端中做。
    @HystrixCommand(fallbackMethod = "getDeptFallback")
    public Object getDept(@PathVariable("id") long id) {
        Dept dept = deptService.getDeptById(id);
        if (Objects.nonNull(dept))
            return dept;
        throw new RuntimeException("object is null");
    }

    public Object getDeptFallback(@PathVariable("id") long id) {
        return new Dept().setName("err").setId(id).setDb_source("err_db");
    }

    @PostMapping("/add")
    public Object add(Dept dept) {
        System.out.println("provider ---  dept = " + dept);
        return deptService.addDept(dept);
    }

    @GetMapping("/list/{start}/{end}")
    public Object getListByLimit(@PathVariable("start") long start,
                                 @PathVariable("end") long end) {
        Map<String, Object> parameters = new ConcurrentHashMap<>();
        parameters.put("start", start);
        parameters.put("end", end);
        return deptService.findListByLimit(parameters);
    }

}
