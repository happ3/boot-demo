package com.boot.demo.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@MapperScan(basePackages = {"com.boot.demo.dao.mapper"})
@PropertySource({"classpath:dubbo.properties","classpath:redis.properties"})
@ImportResource({"classpath:datasource-application.xml","classpath:dubbo-consume.xml"})
public class DataConfig {

}
