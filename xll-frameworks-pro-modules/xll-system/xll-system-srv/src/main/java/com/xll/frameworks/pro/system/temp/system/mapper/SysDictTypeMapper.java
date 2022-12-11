package com.xll.frameworks.pro.system.temp.system.mapper;

import com.xll.frameworks.pro.common.core.core.mapper.BaseMapper;
import com.xll.frameworks.pro.system.temp.system.domain.SysDictType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典表 数据层
 * 
 * @author ruoyi
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
     * 批量删除字典类型信息
     * 
     * @param dictTypeIds 需要删除的字典ID
     * @return 结果
     */
    public int deleteDictTypeByIds(@Param("dictTypeIds") String[] dictTypeIds, @Param("DEL_FLAG_DELETE") String DEL_FLAG_DELETE);

    /**
     * 校验字典类型称是否唯一
     * 
     * @param dictType 字典类型
     * @return 结果
     */
    @Override
    public List<SysDictType> findListWithUnique(SysDictType dictType);
}
