package com.imooc.coupon.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * ClassName: IKafkaService
 * Package: com.imooc.coupon.service
 * description: Kafka相关的服务接口定义
 * Date: 2020/3/13 0:14
 * Author: chendaoguang
 */
public interface IKafkaService {

    /**
     * 消费优惠券Kafka消息
     * @param record {@link ConsumerRecord}
     */
    void consumeCouponKafkaMessage(ConsumerRecord<?, ?> record);
}
