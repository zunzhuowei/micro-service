package com.qs.game.dao;

import com.qs.game.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@Mapper
public interface IDeptDao {

    Dept findById(long id);

    List<Dept> findAll();

    List<Dept> findListByLimit(Map<String, Object> parameters);

    int addDept(Dept dept);

}
