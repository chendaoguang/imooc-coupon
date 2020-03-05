package com.imooc.coupon.advice;

import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: GlobalExceptionAdvice
 * Package: com.imooc.coupon.advice
 * description: 全局异常处理
 * Date: 2020/3/6 0:52
 * Author: chendaoguang
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 对CouponException进行统一异常处理
     * */
    @ExceptionHandler(value = CouponException.class)
    public CommonResponse<String> handlerCouponException(
            HttpServletRequest req, CouponException ex
    ) {
        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
