package com.qs.game.api.common;

import com.qs.game.api.DeptApi;
import com.qs.game.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 客户端实现fallbackFactory对服务整体异常处理
 */
@Component
public class DeptFallbackFactory implements FallbackFactory<DeptApi> {


    @Override
    public DeptApi create(Throwable throwable) {

        return new DeptApi() {

            @Override
            public Object getListByCumsumerService() {
                return new Dept().setId(0).setName("服务端口异常").setDb_source("err");
            }

            @Override
            public Object getDept(long id) {
                return new Dept().setId(1).setName("服务端口异常1").setDb_source("err");
            }

        };
    }

}
