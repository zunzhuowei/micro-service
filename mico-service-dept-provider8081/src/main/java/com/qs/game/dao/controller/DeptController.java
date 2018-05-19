package com.qs.game.dao.controller;

import com.qs.game.dao.service.IDeptService;
import com.qs.game.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return deptService.getDeptAllByList();
    }

    @GetMapping("/get/{id}")
    public Object getDept(@PathVariable("id") long id) {
        return deptService.getDeptById(id);
    }

    @PostMapping("/add")
    public Object add(Dept dept) {
        return deptService.addDept(dept);
    }


}
