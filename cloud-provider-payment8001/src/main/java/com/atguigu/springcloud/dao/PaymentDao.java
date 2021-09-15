package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: MJLI
 * @date: 2021/09/15 10:57 上午
 * @MONTH：9月
 */
@Mapper
public interface PaymentDao {
    public int create (Payment payment);
    public Payment getPaymentById (@Param("id") Long id);
}
