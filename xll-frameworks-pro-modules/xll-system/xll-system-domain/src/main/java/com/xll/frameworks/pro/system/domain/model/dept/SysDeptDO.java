package com.xll.frameworks.pro.system.domain.model.dept;

import com.xll.frameworks.pro.common.core.DO;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述: <br>
 * <P>
 * @Description 部门领域对象
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 23:13
 */
@Data
public class SysDeptDO implements DO {
    private Long id;
    /**
     * 部门父类ID
     */
    private Long parentId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 显示顺序
     */
    private Integer sort;
    /**
     * 部门状态（0:停用 1:正常)
     */
    private Integer status;
    /**
     * 删除标志（0:存在 1:删除)
     */
    private Integer delFlag;
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
