package com.qs.game.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zun.wei on 2018/5/27.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String springApplicationName;


    @GetMapping("/config/client/index")
    public Object getResult() {
        return springApplicationName;
    }

}
