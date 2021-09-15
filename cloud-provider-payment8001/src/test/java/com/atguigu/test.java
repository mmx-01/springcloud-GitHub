package com.atguigu;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author: MJLI
 * @date: 2021/09/15 2:36 下午
 * @MONTH：9月
 */
public class test {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PaymentDao paymentDao;
    @Test
    public void TestService () {
        Payment payment = new Payment();
        payment.setSerial("123131");
        paymentService.create(payment);
    }
    @Test
    public void TestDao () {
        Payment payment = new Payment();
        payment.setSerial("123131");
        paymentDao.create(payment);
    }
    @Test
    public void TestDaoa () {

        Payment paymentById = paymentDao.getPaymentById(31L);
        System.out.println("paymentById = " + paymentById);
    }
}
