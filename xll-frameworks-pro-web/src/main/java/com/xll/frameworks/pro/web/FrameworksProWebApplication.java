package com.xll.frameworks.pro.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 功能描述: <br>
 * <p>
 * 〈启动〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/10/15 20:19
 */
@Slf4j
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FrameworksProWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrameworksProWebApplication.class, args);
        log.info("service start xll-frameworks-pro-web");
    }
}