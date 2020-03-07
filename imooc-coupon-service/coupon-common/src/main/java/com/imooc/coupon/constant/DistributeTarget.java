package com.imooc.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * ClassName: DistributeTarget
 * Package: com.imooc.coupon.constant
 * description: 分发目标
 * Date: 2020/3/8 0:37
 * Author: chendaoguang
 */
@Getter
@AllArgsConstructor
public enum DistributeTarget {

    SINGLE("单用户", 1),
    MULTI("多用户", 2);

    /**
     * 分发目标描述
     */
    private String description;

    /**
     * 分发目标编码
     */
    private Integer code;

    public static DistributeTarget of(Integer code) {
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + "not exists"));

    }
}
