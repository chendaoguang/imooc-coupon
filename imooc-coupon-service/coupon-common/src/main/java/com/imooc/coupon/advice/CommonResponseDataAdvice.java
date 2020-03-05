package com.imooc.coupon.advice;

import com.imooc.coupon.annotation.IgnoreResponseAdvice;
import com.imooc.coupon.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * ClassName: CommonResponseDataAdvice
 * Package: com.imooc.coupon.advice
 * description: 统一相应
 * Date: 2020/3/6 0:30
 * Author: chendaoguang
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice {

    /**
     * 判断是否需要对相应进行处理
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class aClass) {

        // 如果当前方法所在的类标识了 @IgnoreResponseAdvice 注解， 则不需要处理
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 如果当前方法标识了 @IgnoreResponseAdvice 注解， 则不需要处理
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 对相应进行处理，执行beforeBodyWrite方法
        return true;
    }
    /**
     * 响应之前的处理
     * */
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        // 定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");

        // 如果 o 是 null， response不需要设置data
        if (null == o) {
            return response;
            // 如果 o 已经是 CommonResponse，不需要再次处理
        } else if(o instanceof CommonResponse) {
            response = (CommonResponse<Object>) o;
            // 否则，把响应对象作为 CommonResponse的data部分
        } else {
            response.setData(o);
        }

        return null;
    }
}
