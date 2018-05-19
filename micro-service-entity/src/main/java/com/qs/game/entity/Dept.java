package com.qs.game.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by zun.wei on 2018/5/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Dept implements Serializable {


    private long id;

    private String name;

    private String db_source;

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDb_source("dbName").setId(1).setName("zhangsan");
        System.out.println("dept = " + dept);
        System.out.println("dept = " + dept.getName());

    }

}
