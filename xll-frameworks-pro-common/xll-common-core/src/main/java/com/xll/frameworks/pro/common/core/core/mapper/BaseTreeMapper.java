package com.xll.frameworks.pro.common.core.core.mapper;

public interface BaseTreeMapper<T> extends BaseMapper<T>{

	/**
	 *  查询当前父节点下，子节点中最大的treeSort值
	 * @param parentId
	 * @return
	 */
	Integer findMaxTreeSortByParentId(String parentId);


}