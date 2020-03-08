package com.imooc.coupon.service;

import com.imooc.coupon.entity.CouponTemplate;
import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.vo.TemplateRequest;

/**
 * ClassName: IBuildTemplateService
 * Package: com.imooc.coupon.service
 * description: 构建优惠券模板接口定义
 * Date: 2020/3/8 22:14
 * Author: chendaoguang
 */
public interface IBuildTemplateService {

    /**
     * 创建优惠券模板
     * @param request {@link TemplateRequest} 模板信息请求对象
     * @return {@link CouponTemplate} 优惠券模板实体
     * @throws CouponException
     */
    CouponTemplate buildTemplate(TemplateRequest request)
            throws CouponException;
}
