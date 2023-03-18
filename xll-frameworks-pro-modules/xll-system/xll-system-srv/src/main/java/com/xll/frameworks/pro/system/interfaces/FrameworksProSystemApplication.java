package com.xll.frameworks.pro.system.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 功能描述: <br>
 * <P>
 * @Description 启动类
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 20:37
 */
@Slf4j
@SpringBootApplication
public class FrameworksProSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworksProSystemApplication.class, args);
        log.info("service start xll-system-srv");
    }
}
