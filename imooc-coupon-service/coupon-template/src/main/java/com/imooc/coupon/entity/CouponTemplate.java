package com.imooc.coupon.entity;

import com.imooc.coupon.constant.CouponCategory;
import com.imooc.coupon.constant.DistributeTarget;
import com.imooc.coupon.constant.ProductLine;
import com.imooc.coupon.converter.CouponCategoryConverter;
import com.imooc.coupon.converter.DistributeTargetConverter;
import com.imooc.coupon.converter.ProductLineConverter;
import com.imooc.coupon.converter.RuleConverter;
import com.imooc.coupon.vo.TemplateRule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: CouponTemplate
 * Package: com.imooc.coupon.entity
 * description: 优惠券模板实体类定义：基础属性+规则属性
 * Date: 2020/3/8 1:06
 * Author: chendaoguang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon_template")
public class CouponTemplate implements Serializable {

    /** 自增主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Basic
    private Integer id;

    /** 是否可用 */
    @Column(name = "available", nullable = false)
    private Boolean available;

    /** 是否过期 */
    @Column(name = "expired", nullable = false)
    private Boolean expired;

    /** 优惠券名称 */
    @Column(name = "name", nullable = false)
    private String name;

    /** 优惠券logo */
    @Column(name = "logo", nullable = false)
    private String logo;

    /** 优惠券描述 */
    @Column(name = "intro", nullable = false)
    private String desc;

    /** 优惠券分类 */
    @Column(name = "category", nullable = false)
    @Convert(converter = CouponCategoryConverter.class)
    private CouponCategory category;

    /** 产品线 */
    @Column(name = "product_line", nullable = false)
    @Convert(converter = ProductLineConverter.class)
    private ProductLine productLine;

    /** 总数 */
    @Column(name = "coupon_count", nullable = false)
    private Integer count;

    /** 创建时间 */
    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /** 创建用户 */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /** 优惠券模板的编码 */
    @Column(name = "template_key", nullable = false)
    private String key;

    /** 用户目标 */
    @Column(name = "target", nullable = false)
    @Convert(converter = DistributeTargetConverter.class)
    private DistributeTarget target;

    /** 优惠券规则 */
    @Column(name = "rule", nullable = false)
    @Convert(converter = RuleConverter.class)
    private TemplateRule rule;

    public CouponTemplate(String name, String logo, String desc, String category,
                          Integer productLine, Integer count, Long userId,
                          Integer target, TemplateRule rule) {
        this.available = false;
        this.expired = false;
        this.name = name;
        this.logo = logo;
        this.desc = desc;
        this.category = CouponCategory.of(category);
        this.productLine = ProductLine.of(productLine);
        this.count = count;
        this.userId = userId;
        // 优惠券唯一编码 = 4(产品线类型) + 8(日期： 20190101) + id(扩充为4位)
        this.key = productLine.toString() + category +
                new SimpleDateFormat("yyyyMMdd").format(new Date());
        this.target = DistributeTarget.of(target);
        this.rule = rule;
    }




}
