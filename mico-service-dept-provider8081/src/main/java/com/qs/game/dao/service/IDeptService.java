package com.qs.game.dao.service;

import com.qs.game.entity.Dept;

import java.util.List;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
public interface IDeptService {

    Dept getDeptById(long id);

    List<Dept> getDeptAllByList();

    int addDept(Dept dept);

}
