package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LIMENGJIE
 * @ClassName OrderController
 * @Date 2021/9/18 5:03 下午 2021
 */
@RestController
@Slf4j
public class OrderController {
    /**
     * 直接使用注册中心里的为服务名字随机访问该微服务的某个主机
     * 例如：CLOUD-PAYMENT-SERVICE该微服务下面有端口号为8001和8002的两个主机
     * 那么会随机访问8001和8002
    */

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
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
        log.info("查询的结果为：" +restTemplate.getForObject(PAYMENT_URL + "/payment/get/"  + id, CommonResult.class).getData() );
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"  + id, CommonResult.class);
    }

    @DeleteMapping("/consumer/payment/delete/{id}")
//    @RequestMapping (value = "/consumer/payment/delete/{id}" , method = {RequestMethod.DELETE})
    public Map<String , Object> deleteById (@PathVariable ("id") Long id) {
        if (null == id) {
            log.info("传入参数为空，请检查");
        }
        log.info("删除的id为：" + id);
        HashMap<String, Object> hashMap = null;
        try {
            restTemplate.delete(PAYMENT_URL + "/payment/delete/" + id);
        }catch (Exception e) {
            hashMap = new HashMap<>();
            hashMap.put("code" , 401);
            hashMap.put("message" , "删除失败");
            hashMap.put("data" , null);
            return hashMap;
        }
        hashMap = new HashMap<>();
        hashMap.put("code" , 200);
        hashMap.put("message" , "删除成功");
        hashMap.put("data" , null);
        return hashMap;
    }
}
