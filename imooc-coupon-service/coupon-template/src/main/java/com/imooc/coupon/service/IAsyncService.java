package com.imooc.coupon.service;

import com.imooc.coupon.entity.CouponTemplate;

/**
 * ClassName: IAsyncService
 * Package: com.imooc.coupon.service
 * description: 异步服务接口定义
 * Date: 2020/3/8 23:08
 * Author: chendaoguang
 */
public interface IAsyncService {

    /**
     * 根据模板异步的创建优惠券吗
     * @param template {@link CouponTemplate} 优惠券模板实体
     */
    void asyncConstructCouponByTemplate(CouponTemplate template);
}
