package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: MJLI
 * @date: 2021/09/15 11:36 上午
 * @MONTH：9月
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping ("/payment/create")
    public CommonResult create (Payment payment) {
        if (null == payment && "".equals(payment)) {
            log.info("传入数据不能为空！！");
        }
        int result = paymentService.create(payment);

        log.info("插入结果: " + result);

        if (result > 0) {
            log.info("插入成功！！！！");
            return new CommonResult(200 , "插入成功" , result);
        }else {
            return new CommonResult(400 , "插入失败" , null);
        }
    }
    @GetMapping ("/payment/get/{id}")
    public CommonResult getPaymentById (@PathVariable ("id") Long id) {
        if (id == null) {
            log.info("传入数据有误，id不能为空值");
        }
        Payment paymentById = paymentService.getPaymentById(id);
        System.out.println("paymentById = " + paymentById);
        if (paymentById != null) {
            return new CommonResult(200 , "查询成功" , paymentById);
        }else  {
            return new CommonResult(400 , "查询失败,没有对应的数据，查询id为：" + id , null);
        }
    }
}
