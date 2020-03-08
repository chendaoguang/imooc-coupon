package com.imooc.coupon.converter;

import com.imooc.coupon.constant.CouponCategory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * ClassName: CouponCategoryConverter
 * Package: com.imooc.coupon.converter
 * description: 优惠券分类枚举转换器
 * X：是实体属性的类型
 * Y：是数据库字段的类型
 * Date: 2020/3/8 17:40
 * Author: chendaoguang
 */
@Converter
public class CouponCategoryConverter
        implements AttributeConverter<CouponCategory, String> {

    /**
     * 将实体属性X转换为Y存储到数据库中，插入和更新时的操作
     * @param couponCategory
     * @return
     */
    @Override
    public String convertToDatabaseColumn(CouponCategory couponCategory) {
        return couponCategory.getCode();
    }

    /**
     * 将数据库中的字段Y转换为实体属性X，查询操作时执行的操作
     * @param s
     * @return
     */
    @Override
    public CouponCategory convertToEntityAttribute(String code) {
        return CouponCategory.of(code);
    }
}
