package com.imooc.coupon.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * ClassName: AbstractPreFilter
 * Package: com.imooc.coupon.filter
 * description: <br/>
 * Date: 2020/3/5 0:55
 * Author: chendaoguang
 */
public abstract class AbstractPreZuulFilter extends AbstractZuulFilter{
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
}
