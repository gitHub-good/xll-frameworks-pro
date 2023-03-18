package com.xll.frameworks.pro.system.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xll.frameworks.pro.common.core.PO;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述: <br>
 * <P>
 * @Description 部门信息
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 22:00
 */
@Data
@TableName("SysDept")
public class SysDeptPO extends PO {
    @TableId(type = IdType.AUTO)
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
}
