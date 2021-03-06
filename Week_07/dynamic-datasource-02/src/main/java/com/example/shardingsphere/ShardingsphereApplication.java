package com.example.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("github.zhanggang.version2.mapper")
@SpringBootApplication
public class ShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereApplication.class, args);
    }

}
