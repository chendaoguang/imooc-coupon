package com.imooc.coupon.dao;

import com.imooc.coupon.entity.CouponTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ClassName: CouponTemplateDao
 * Package: com.imooc.coupon.dao
 * description: CouponTemplate Dao接口定义
 * Date: 2020/3/8 20:39
 * Author: chendaoguang
 */
public interface CouponTemplateDao
        extends JpaRepository<CouponTemplate, Integer> {

    /**
     * 根据模板名称查询模板
     * @param name where name = ...
     * @return
     */
    CouponTemplate findByName(String name);

    /**
     * 根据 available 和 expired 标记查找模板记录
     * @param available where available  = ... and expired = ...
     * @param expired
     * @return
     */
    List<CouponTemplate> findAllByAvailableAndExpired(
            Boolean available,
            Boolean expired
    );

    /**
     * 根据expired标记查找模板记录
     * @param expired where expired = ...
     * @return
     */
    List<CouponTemplate> findAllByExpired(Boolean expired);
}
