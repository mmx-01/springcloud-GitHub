package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: MJLI
 * @date: 2021/09/15 11:28 上午
 * @MONTH：9月
 */
public interface PaymentService {

    public int create (Payment payment);

    public Payment getPaymentById (@Param("id") Long id);

    public int deleteById (@Param("id") Long id);
}
