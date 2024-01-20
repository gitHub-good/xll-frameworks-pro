package com.xll.frameworks.pro.system.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.xll.frameworks.pro.system.repository", sqlSessionTemplateRef = "sqlSessionTemplate")
public class MybatisPlusConfig {

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("systemDataSource") DataSource dataSource) throws Exception {
        var configuration = new MybatisConfiguration();
        // 数据库与bean字段名一致
        configuration.setMapUnderscoreToCamelCase(false);
        // 关闭一级缓存
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        // 关闭二级缓存
        configuration.setCacheEnabled(false);
        configuration.setLogImpl(StdOutImpl.class);

        var factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setConfiguration(configuration);
        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:xml/**Mapper.xml"));
        factoryBean.setTypeAliasesPackage("com.xll.frameworks.pro.system.repository.po");

        //mybatis 分页插件
        Interceptor[] plugins = {mybatisPlusInterceptor()};
        factoryBean.setPlugins(plugins);
        return factoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("systemDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        var interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
