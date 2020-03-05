package com.imooc.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: AccessLogFilter
 * Package: com.imooc.coupon.filter
 * description: <br/>
 * Date: 2020/3/5 13:33
 * Author: chendaoguang
 */
@Slf4j
@Component
public class AccessLogFilter extends AbstractPostZuulFilter{
    @Override
    protected Object cRun() {

        HttpServletRequest request = context.getRequest();

        // 从PreRequestFilter中获取时间戳
        Long startTime = (Long) request.getAttribute("startTime");
        String uri = request.getRequestURI();
        long duration = System.currentTimeMillis() - startTime;

        // 从网关通过的请求都会打印日志记录uri + duration
        log.info("uri: {}, duration: {}", uri, duration);
        return sucess();
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }
}
