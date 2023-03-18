package com.xll.frameworks.pro.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 功能描述: <br>
 * <P>
 * @Description web启动
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 20:53
 */
@Slf4j
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FrameworksProWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrameworksProWebApplication.class, args);
        log.info("service start xll-frameworks-pro-web");
    }
}