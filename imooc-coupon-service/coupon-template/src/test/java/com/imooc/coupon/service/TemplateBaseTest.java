package com.imooc.coupon.service;

import com.alibaba.fastjson.JSON;
import com.imooc.coupon.exception.CouponException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * ClassName: TemplateBaseTest
 * Package: com.imooc.coupon.service
 * description: 优惠券模板基础服务测试
 * Date: 2020/3/10 23:19
 * Author: chendaoguang
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateBaseTest {

    @Autowired
    private ITemplateBaseService baseService;

    @Test
    public void testBuildTemplateInfo() throws CouponException {
        System.out.println(JSON.toJSONString(
                baseService.buildTemplateInfo(10)));
        System.out.println(JSON.toJSONString(
                baseService.buildTemplateInfo(12)));
    }

    @Test
    public void testFindAllUsableTemplate() {
        System.out.println(JSON.toJSONString(
                baseService.findAllUsableTemplate()));
    }

    @Test
    public void testFindId2Template() {
        System.out.println(JSON.toJSONString(
                baseService.findIds2TemplateSDK(Arrays.asList(10, 11, 12))));
    }
}
