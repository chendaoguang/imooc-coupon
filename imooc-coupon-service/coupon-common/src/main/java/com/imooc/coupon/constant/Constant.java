package com.imooc.coupon.constant;

/**
 * ClassName: Constant
 * Package: com.imooc.coupon.constant
 * description: 通用常量定义
 * Date: 2020/3/9 0:09
 * Author: chendaoguang
 */
public class Constant {

    /**
     * kafka消息的Topic
     */
    public static final String TOPIC = "imooc_user_op";

    public static class RedisPrefix{

        /**
         * 优惠券码key前缀
         */
        public static final String COUPON_TEMPLATE = "imooc_coupon_template_code_";

        /**
         * 用户当前所有可用的优惠券key前缀
         */
        public static final String USER_COUPON_USABLE = "imooc_user_coupon_usable_";

        /**
         * 用户当前所有已使用的优惠券key前缀
         */
        public static final String USER_COUPON_USED = "imooc_user_coupon_used_";

        /**
         * 用户当前所有已过期的优惠券key前缀
         */
        public static final String USER_COUPON_EXPIRED = "imooc_user_coupon_expired_";
    }
}
