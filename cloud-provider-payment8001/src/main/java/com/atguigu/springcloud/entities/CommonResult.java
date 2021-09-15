package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: MJLI
 * @date: 2021/09/15 10:50 上午
 * @MONTH：9月
 */

/**
 * @Author MJLI
 * @Date 10:54 上午 2021/9/15
 * 返回给前端的通用json实体串
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    /**
     * @Author MJLI
     * @Date 10:55 上午 2021/9/15
     * code: 判断是否成功！
     * message: 返回消息提醒
     * data: 实际数据
     **/
    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code , String message) {
        this(code , message , null);
    }
}
