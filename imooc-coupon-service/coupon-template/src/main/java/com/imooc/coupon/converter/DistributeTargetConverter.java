package com.imooc.coupon.converter;

import com.imooc.coupon.constant.DistributeTarget;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * ClassName: DistributeTargetConverter
 * Package: com.imooc.coupon.converter
 * description: 分发目标属性转换器
 * Date: 2020/3/8 18:41
 * Author: chendaoguang
 */
@Converter
public class DistributeTargetConverter
            implements AttributeConverter<DistributeTarget, Integer> {
    @Override
    public Integer convertToDatabaseColumn(DistributeTarget distributeTarget) {
        return distributeTarget.getCode();
    }

    @Override
    public DistributeTarget convertToEntityAttribute(Integer code) {
        return DistributeTarget.of(code);
    }
}
