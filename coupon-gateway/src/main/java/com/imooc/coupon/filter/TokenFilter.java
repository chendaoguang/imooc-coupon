package com.imooc.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: TokenFilter
 * Package: com.imooc.coupon.filter
 * description: 校验请求中传递的Token
 * Date: 2020/3/5 13:15
 * Author: chendaoguang
 */
@Slf4j
@Component
public class TokenFilter extends AbstractPreZuulFilter{
    @Override
    protected Object cRun() {
        HttpServletRequest request = context.getRequest();
        log.info("%s request to %s", request.getMethod(), request.getRequestURL().toString());
        Object token = request.getParameter("token");

        if (null == token) {
            log.error("error: token is empty");
            return fail(401, "error: token is empty");
        }

        return sucess();
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
