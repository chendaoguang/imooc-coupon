package com.imooc.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ClassName: ZuulGatewayApplication
 * Package: com.imooc.coupon
 * @SpringCloudApplication 组合了 SpringBoot 应用 + 服务发现 +熔断
 * description: 网管应用启动入口
 * Date: 2020/3/3 23:59
 * Author: chendaoguang
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
