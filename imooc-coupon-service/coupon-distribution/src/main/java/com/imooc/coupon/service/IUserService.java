package com.imooc.coupon.service;

import com.imooc.coupon.entity.Coupon;
import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.vo.AcquireTemplateRequest;
import com.imooc.coupon.vo.CouponTemplateSDK;
import com.imooc.coupon.vo.SettlementInfo;

import java.util.List;

/**
 * ClassName: IUserService
 * Package: com.imooc.coupon.service
 * description: 用户服务相关的接口定义
 * 1. 用户三类状态优惠券信息展示服务
 * 2. 查看用户当前可以领取的优惠券模板
 * 3. 用户领取优惠券服务
 * 4. 用户消费优惠券服务  --- coupon-settlement微服务配合实现
 * Date: 2020/3/13 0:17
 * Author: chendaoguang
 */
public interface IUserService {

    /**
     * 根据用户id和状态查询优惠券记录
     * @param userId 用户id
     * @param status 优惠券状态
     * @return {@link Coupon}
     * @throws CouponException
     */
    List<Coupon> findCouponByStatus(Long userId, Integer status)
        throws CouponException;

    /**
     * 根据用户id查找当前可以领取的优惠券模板
     * @param userId
     * @return {@link CouponTemplateSDK}
     */
    List<CouponTemplateSDK> findAvailableTemplate(Long userId)
        throws CouponException;

    /**
     * 用户领取优惠券
     * @param request {@link AcquireTemplateRequest}
     * @return {@link Coupon}
     * @throws CouponException
     */
    Coupon acquireTemolate(AcquireTemplateRequest request) throws CouponException;

    /**
     * 结算(核销)优惠券
     * @param info {@link SettlementInfo}
     * @return {@link SettlementInfo}
     * @throws CouponException
     */
    SettlementInfo settlement(SettlementInfo info) throws CouponException;
}
