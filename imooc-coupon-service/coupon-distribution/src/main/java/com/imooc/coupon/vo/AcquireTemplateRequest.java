package com.imooc.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: AcquireTemplateRequest
 * Package: com.imooc.coupon.vo
 * description: 获取优惠券请求对象定义
 * Date: 2020/3/13 0:23
 * Author: chendaoguang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcquireTemplateRequest {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 优惠券模板信息
     */
    private CouponTemplateSDK templateSDK;
}
