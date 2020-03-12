package com.imooc.coupon.serialization;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.imooc.coupon.entity.Coupon;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * ClassName: CouponSerialize
 * Package: com.imooc.coupon.serialization
 * description: 优惠券实体类自定义序列化器
 * Date: 2020/3/11 23:59
 * Author: chendaoguang
 */
public class CouponSerialize extends JsonSerializer<Coupon> {
    @Override
    public void serialize(Coupon coupon, JsonGenerator generator,
                          SerializerProvider serializerProvider)
            throws IOException {

        // 开始序列化
        generator.writeStartObject();
        generator.writeStringField("id", coupon.getId().toString());
        generator.writeStringField("templateId", coupon.getTemplateId().toString());
        generator.writeStringField("userId", coupon.getUserId().toString());
        generator.writeStringField("couponCode", coupon.getCouponCode());
        generator.writeStringField("assignTime",
                new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss")
                        .format(coupon.getAssignTime()));
        generator.writeStringField("name",
                coupon.getTemplateSDK().getName());
        generator.writeStringField("logo",
                coupon.getTemplateSDK().getLogo());
        generator.writeStringField("desc",
                coupon.getTemplateSDK().getDesc());
        generator.writeStringField("expired",
                JSON.toJSONString(coupon.getTemplateSDK().getRule().getExpiration()));
        generator.writeStringField("discount",
                JSON.toJSONString(coupon.getTemplateSDK().getRule().getDiscount()));
        generator.writeStringField("usage",
                JSON.toJSONString(coupon.getTemplateSDK().getRule().getUsage()));

        // 结束序列化
        generator.writeEndObject();
    }
}
