package org.ydy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 姚端阳
 * @date 2018/10/4 16:07
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.ydy.mapper")
public class CustomerApplication {
    public static void main(String[] args){
        SpringApplication.run(CustomerApplication.class,args);
    }
}
