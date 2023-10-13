//package com.example.blog.common;
//
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//
//@Configuration
//public class MybatisConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() throws Exception {
//        Properties props = new Properties();
//        props.put("driverClassName", env.getProperty("spring.datasource.driverClassName"));
//        props.put("url", env.getProperty("spring.datasource.url"));
//        props.put("username", env.getProperty("spring.datasource.username"));
//        props.put("password", env.getProperty("spring.datasource.password"));
//        return DruidDataSourceFactory.createDataSource(props);
//    }
//
//}