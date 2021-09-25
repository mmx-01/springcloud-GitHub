package com.atguigu.springcloud.controller;
import cn.hutool.log.Log;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Value("${server.port}")
    private String serverPort;
    @PostMapping ("/payment/create")
    public CommonResult create (@RequestBody  Payment payment) {
        if (null == payment && "".equals(payment)) {
            log.info("传入数据不能为空！！");
            log.info("测试热部署");
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
            log.info("测试热部署");
        }
        Payment paymentById = paymentService.getPaymentById(id);
        System.out.println("paymentById = " + paymentById);
        if (paymentById != null) {
            return new CommonResult(200 , "查询成功 , 访问的端口号为：" + serverPort , paymentById);
        }else  {
            return new CommonResult(400 , "查询失败,没有对应的数据，查询id为：" + id , null);
        }
    }
//    @GetMapping ("/payment/delete/{id}")
    @RequestMapping (value = "/payment/delete/{id}" , method = {RequestMethod.DELETE})
    public CommonResult deleteById (@PathVariable ("id") Long id) {
        if (null == id) {
            log.info("传入参数为空，请检查！");
        }
        int i = 0;
        if (paymentService.deleteById(id) != 1) {
            i = 1;
        }else {
            i = -1;
        }
        System.out.println("i = " + i);
        log.info("返回值：" + i  +"返回值若为1，表示删除成功！若为-1表示删除失败！");
        if (-1 == i) {
            return new CommonResult(400 , "删除失败" , -1);
        }else {
            return new CommonResult(200 , "删除成功" , 1);
        }
    }
}
