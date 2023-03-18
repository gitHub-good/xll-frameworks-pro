package com.xll.frameworks.pro.common.core;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述: <br>
 * <P>
 * @Description 持久化model （Persistant Object - 持久化对象）
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 21:21
 */
@Data
public class PO implements POJO{
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
}
