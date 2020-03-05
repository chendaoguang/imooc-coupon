package com.imooc.coupon.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * ClassName: AbstractPostZuulFilter
 * Package: com.imooc.coupon.filter
 * description: <br/>
 * Date: 2020/3/5 0:58
 * Author: chendaoguang
 */
public abstract class AbstractPostZuulFilter extends  AbstractZuulFilter{
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }
}
