package com.imooc.coupon.converter;

import com.imooc.coupon.constant.CouponStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

/**
 * ClassName: CouponStatusConverter
 * Package: com.imooc.coupon.converter
 * description: 优惠券状态枚举转换器
 * Date: 2020/3/11 23:57
 * Author: chendaoguang
 */
@Convert
public class CouponStatusConverter
        implements AttributeConverter<CouponStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CouponStatus status) {
        return status.getCode();
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer code) {
        return CouponStatus.of(code);
    }
}
