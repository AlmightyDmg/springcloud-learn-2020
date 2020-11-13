package cn.com.dmg.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"cn.com.dmg.springcloud.alibaba.dao"})
public class MyBatisConfig {}