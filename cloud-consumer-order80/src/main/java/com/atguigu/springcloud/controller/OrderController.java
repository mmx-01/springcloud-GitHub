package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @Author LIMENGJIE
 * @ClassName OrderController
 * @Date 2021/9/18 5:03 下午 2021
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;
    /**
     * 新增对象
     * @PARAM
     * @RETURN
     * @DATE 2021/9/18 5:19 下午
    */
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create (Payment payment) {
        log.info(payment.getSerial());
        if (null == payment) {
            log.info("传入参数错误！！");
        }
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create" , payment , CommonResult.class);
    }
    /**
     * 根据主键id查询数据
     * @PARAM
     * @RETURN
     * @DATE 2021/9/18 5:19 下午
    */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymant (@PathVariable ("id") Long id) {
        if (id == null) {
            log.info("传入参数为空，请检查");
        }
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"  + id, CommonResult.class);
    }

}
