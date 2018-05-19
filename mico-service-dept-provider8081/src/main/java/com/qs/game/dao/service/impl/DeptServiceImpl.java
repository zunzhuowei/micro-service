package com.qs.game.dao.service.impl;

import com.qs.game.dao.dao.IDeptDao;
import com.qs.game.dao.service.IDeptService;
import com.qs.game.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@Service
public class DeptServiceImpl implements IDeptService {


    @Autowired
    private IDeptDao deptDao;

    @Override
    public Dept getDeptById(long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> getDeptAllByList() {
        return deptDao.findAll();
    }

    @Override
    public int addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

}
