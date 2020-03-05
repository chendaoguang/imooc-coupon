package com.imooc.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ClassName: PreRequestFilter
 * Package: com.imooc.coupon.filter
 * description: 在过滤器中存储客户端发起请求的时间戳
 * Date: 2020/3/5 13:30
 * Author: chendaoguang
 */
@Slf4j
@Component
public class PreRequestFilter extends AbstractPreZuulFilter {
    @Override
    protected Object cRun() {
        context.set("startTime", System.currentTimeMillis());
        return sucess();
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
