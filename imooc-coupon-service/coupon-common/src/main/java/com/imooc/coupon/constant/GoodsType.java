package com.imooc.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * ClassName: GoodsType
 * Package: com.imooc.coupon.constant
 * description: <br/>
 * Date: 2020/3/13 0:28
 * Author: chendaoguang
 */
@Getter
@AllArgsConstructor
public enum GoodsType {

    WENYU("文娱", 1),
    SHENGXIAN("生鲜", 2),
    JIAJU("家居", 3),
    OTHER("其他", 4),
    ALL("全品类", 5);

    /**
     * 商品类型编码
     */
    private String description;

    /**
     * 商品类型编码
     */
    private Integer code;

    public static GoodsType of(Integer code) {
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + "not exists!")
                );
    }
}
