package com.imooc.coupon.service.impl;

import com.imooc.coupon.dao.CouponTemplateDao;
import com.imooc.coupon.entity.CouponTemplate;
import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.service.IAsyncService;
import com.imooc.coupon.service.IBuildTemplateService;
import com.imooc.coupon.vo.TemplateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: BuildTemplateServiceImpl
 * Package: com.imooc.coupon.service.impl
 * description: 构建优惠券模板接口实现
 * Date: 2020/3/9 0:50
 * Author: chendaoguang
 */
@Slf4j
@Service
public class BuildTemplateServiceImpl implements IBuildTemplateService {

    /**
     * 异步服务
     */
    private IAsyncService asyncService;

    /**
     * CouponTemplateDao
     */
    private CouponTemplateDao templateDao;

    @Autowired
    public BuildTemplateServiceImpl(IAsyncService asyncService, CouponTemplateDao templateDao) {
        this.asyncService = asyncService;
        this.templateDao = templateDao;
    }

    /**
     * 创建优惠券模板
     * @param request {@link TemplateRequest} 模板信息请求对象
     * @return {@link CouponTemplate} 优惠券模板实体
     * @throws CouponException
     */
    @Override
    public CouponTemplate buildTemplate(TemplateRequest request)
            throws CouponException {

        // 参数合法性验证
        if (!request.validate()) {
            throw new CouponException("BuildTemplate Param Is Not Valid!");
        }

        // 判断同名的模板是否存在
        if (null != templateDao.findByName(request.getName())) {
            throw new CouponException("Exist Same Name Template!");
        }

        //构造 CouponTemplate 并保存到数据库中
        CouponTemplate template = requestToTemplate(request);
        template = templateDao.save(template);

        // 根据优惠券模板异步生成优惠券码
        asyncService.asyncConstructCouponByTemplate(template);

        return template;
    }

    /**
     * 将TemplateRequest转换为CouponTemplate
     * @param request
     * @return
     */
    private CouponTemplate requestToTemplate(TemplateRequest request){
        return new CouponTemplate(
                request.getName(),
                request.getLogo(),
                request.getDesc(),
                request.getCategory(),
                request.getProductLine(),
                request.getCount(),
                request.getUserId(),
                request.getTarget(),
                request.getRule()
        );
    }
}
