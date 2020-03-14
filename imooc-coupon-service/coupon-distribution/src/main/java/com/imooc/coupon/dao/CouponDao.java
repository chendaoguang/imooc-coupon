package com.imooc.coupon.dao;

import com.imooc.coupon.constant.CouponStatus;
import com.imooc.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ClassName: CouponDao
 * Package: com.imooc.coupon.dao
 * description: CouponDao接口定义
 * Date: 2020/3/12 23:59
 * Author: chendaoguang
 */
public interface CouponDao extends JpaRepository<Coupon, Integer> {

    /**
     * 根据userId + 状态 寻找优惠券记录
     * where userId = ... and status = ...
     * @param userId
     * @param status
     * @return
     */
    List<Coupon> findByUserIdAndStatus(Long userId, CouponStatus status);
}
