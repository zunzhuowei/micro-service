package com.qs.game.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 新版本的2.0 spring boot 开启Hystrix DashBoard 需要在
 * 熔断的应用各种添加这个Servlet Bean 的注入。
 * 并且需要打开监控的时候看到一直都是Loading ,需要去访问
 * 增加了熔断的方法接口才有流量，才显示图标
 */
@Configuration
public class ConfigBean {

    @Bean
    public ServletRegistrationBean getServletBean() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
