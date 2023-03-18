package com.xll.frameworks.pro.system;

import com.xll.frameworks.pro.system.config.MybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {MybatisPlusConfig.class})
@MapperScan(basePackages = "com.xll.frameworks.pro.system.repository")
public class SystemRepositoryAutoConfiguration {

}
