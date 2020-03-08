package com.imooc.coupon.service.impl;

import com.imooc.coupon.dao.CouponTemplateDao;
import com.imooc.coupon.entity.CouponTemplate;
import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.service.ITemplateBaseService;
import com.imooc.coupon.vo.CouponTemplateSDK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName: TemplateBaseServiceImpl
 * Package: com.imooc.coupon.service.impl
 * description: 优惠券模板基础服务接口实现
 * Date: 2020/3/9 1:04
 * Author: chendaoguang
 */
@Slf4j
@Service
public class TemplateBaseServiceImpl implements ITemplateBaseService {

    /**
     * CouponTemplateDao
     */
    private final CouponTemplateDao templateDao;

    @Autowired
    public TemplateBaseServiceImpl(CouponTemplateDao templateDao) {
        this.templateDao = templateDao;
    }

    /**
     * 根据优惠券模板id 获取优惠券模板信息
     * @param id 模板id
     * @return {@link CouponTemplate} 优惠券模板实体
     * @throws CouponException
     */
    public CouponTemplate buildTemplateInfo(Integer id) throws CouponException {
        Optional<CouponTemplate> template = templateDao.findById(id);
        if (!template.isPresent()) {
            throw new CouponException("Template Is Not Exist: " + id);
        }
        return template.get();
    }

    /**
     * 查找所有可用的优惠券模板
     * @return {@link CouponTemplateSDK}s
     */
    @Override
    public List<CouponTemplateSDK> findAllUsableTemplate() {

        List<CouponTemplate> templates =
                templateDao.findAllByAvailableAndExpired(true, false);

        return templates.stream().map(this::template2TemplateSDK).collect(Collectors.toList());
    }

    /**
     * 获取模板ids到CouponTemplateSDK的映射
     * @param ids 模板ids
     * @return Map<key: 模板id, value: CouponTemplateSDK>
     */
    @Override
    public Map<Integer, CouponTemplateSDK> findIds2TemplateSDK(
            Collection<Integer> ids) {
        List<CouponTemplate> templates = templateDao.findAllById(ids);
        return templates.stream().map(this::template2TemplateSDK)
                .collect(Collectors.toMap(
                        CouponTemplateSDK::getId, Function.identity()
                ));
    }

    /**
     * 将CouponTemplate转换为CouponTemplateSDK
     * @return
     */
    private CouponTemplateSDK template2TemplateSDK(CouponTemplate template) {
        return new CouponTemplateSDK(
                template.getId(),
                template.getName(),
                template.getLogo(),
                template.getDesc(),
                template.getCategory().getCode(),
                template.getProductLine().getCode(),
                template.getKey(), // 并不是拼装好的TemplateKey
                template.getTarget().getCode(),
                template.getRule()
        );
    }
}
