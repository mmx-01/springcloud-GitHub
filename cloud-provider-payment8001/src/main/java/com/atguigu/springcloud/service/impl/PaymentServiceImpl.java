package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: MJLI
 * @date: 2021/09/15 11:29 上午
 * @MONTH：9月
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //依赖注入,Resource和Autowired都是一样的功能，只是Resource是java自带的，Autowired是Spring的
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int deleteById(Long id) {
        if (paymentDao.deleteById(id) == 0) {
            return 1;
        }
        return -1;
    }
}
