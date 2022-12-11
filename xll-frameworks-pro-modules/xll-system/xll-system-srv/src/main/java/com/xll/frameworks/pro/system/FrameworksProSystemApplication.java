package com.xll.frameworks.pro.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 功能描述: <br>
 * <p>
 * 〈启动〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/10/15 23:43
 */
@Slf4j
@SpringBootApplication
public class FrameworksProSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworksProSystemApplication.class, args);
        log.info("service start xll-system-srv");
    }
}
