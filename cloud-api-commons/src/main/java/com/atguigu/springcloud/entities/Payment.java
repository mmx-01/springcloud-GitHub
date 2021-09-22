package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: MJLI
 * @date: 2021/09/15 10:46 上午
 * @MONTH：9月
 */
@Data//get/set
@AllArgsConstructor//构造函数，全参数
@NoArgsConstructor//构造函数，非全参数
public class Payment implements Serializable {
    private Long id;
    private String serial;

}
