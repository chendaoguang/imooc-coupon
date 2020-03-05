package com.imooc.coupon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: IgnoreResponseAdvice
 * Package: com.imooc.coupon.annotation
 * description: 忽略统一相应注解定义
 * Date: 2020/3/6 0:28
 * Author: chendaoguang
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
