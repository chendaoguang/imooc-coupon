package com.imooc.coupon.converter;

import com.imooc.coupon.constant.ProductLine;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

/**
 * ClassName: ProductLineConverter
 * Package: com.imooc.coupon.converter
 * description: 产品线枚举属性转换器
 * Date: 2020/3/8 17:47
 * Author: chendaoguang
 */
@Convert
public class ProductLineConverter
        implements AttributeConverter<ProductLine, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductLine productLine) {
        return productLine.getCode();
    }

    @Override
    public ProductLine convertToEntityAttribute(Integer code) {
        return ProductLine.of(code);
    }
}
