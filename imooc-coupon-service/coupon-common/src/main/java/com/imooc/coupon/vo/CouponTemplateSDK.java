package com.imooc.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: CouponTemplateSDK
 * Package: com.imooc.coupon.vo
 * description: 微服务之间用的优惠券模板信息定义
 * Date: 2020/3/8 23:14
 * Author: chendaoguang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponTemplateSDK {

    /**
     * 优惠券模板主键
     */
    private Integer id;

    /**
     * 优惠券模板名称
     */
    private String name;

    /**
     * 优惠券logo
     */
    private String logo;

    /**
     * 优惠券描述
     */
    private String desc;

    /**
     * 优惠券分类
     */
    private String category;

    /**
     * 产品线
     */
    private Integer productLine;

    /**
     * 优惠券模板的编码
     */
    private String key;

    /**
     * 目标用户
     */
    private Integer target;

    /**
     * 优惠券规则
     */
    private TemplateRule rule;
}
