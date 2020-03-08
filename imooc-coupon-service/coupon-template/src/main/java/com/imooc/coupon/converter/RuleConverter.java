package com.imooc.coupon.converter;

import com.alibaba.fastjson.JSON;
import com.imooc.coupon.vo.TemplateRule;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * ClassName: RuleConverter
 * Package: com.imooc.coupon.converter
 * description: 优惠券规则属性转换器
 * Date: 2020/3/8 19:08
 * Author: chendaoguang
 */
@Converter
public class RuleConverter
        implements AttributeConverter<TemplateRule, String> {
    @Override
    public String convertToDatabaseColumn(TemplateRule rule) {
        return JSON.toJSONString(rule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JSON.parseObject(rule, TemplateRule.class);
    }
}
