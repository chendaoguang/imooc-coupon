package com.imooc.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ClassName: TemplateApplication
 * Package: com.imooc.coupon
 * description: <br/>
 * Date: 2020/3/8 0:13
 * Author: chendaoguang
 */
@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}
