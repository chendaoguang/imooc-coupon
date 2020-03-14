package com.imooc.coupon.service;

import com.imooc.coupon.entity.Coupon;
import com.imooc.coupon.exception.CouponException;

import java.util.List;

/**
 * ClassName: IRedisService
 * Package: com.imooc.coupon.service
 * description: redis相关的操作服务接口定义
 *  1. 用户的三个状态优惠券Cache操作
 *  2. 优惠券模板生成的优惠券码
 * Date: 2020/3/13 0:03
 * Author: chendaoguang
 */
public interface IRedisService {

    /**
     * 根据userId和状态找到缓存的优惠券列表数据
     * @param userId 用户id
     * @param status 优惠券状态{@link com.imooc.coupon.constant.CouponStatus}
     * @return {@link Coupon}z注意，可能会返回null，代表从来没有货记录
     */
    List<Coupon> getCacheCoupons(Long userId, Integer status);

    /**
     * 保存空的优惠券列表到缓存中
     * @param userId 用户id
     * @param status 优惠券状态列表
     */
    void saveEmptyCouponListToCache(Long userId, List<Integer> status);

    /**
     * 尝试从Cache中获取一个优惠券码
     * @param templateId 优惠券模板主键
     * @return 优惠券码
     */
    String tryToAcquireCouponCodeFromCache(Integer templateId);

    /**
     * 将优惠券保存带Cache中
     * @param userId 用户id
     * @param coupons {@link Coupon}
     * @param status 优惠券状态
     * @return 保存成功的个数
     * @throws CouponException
     */
    Integer addCouponToCache(Long userId, List<Coupon> coupons,
                             Integer status) throws CouponException;
}
