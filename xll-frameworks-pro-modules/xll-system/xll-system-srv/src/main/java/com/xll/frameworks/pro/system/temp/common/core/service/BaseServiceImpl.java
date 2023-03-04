
package com.xll.frameworks.pro.system.temp.common.core.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xll.frameworks.pro.common.core.core.domain.BaseEntity;
import com.xll.frameworks.pro.common.core.core.mapper.BaseMapper;
import com.xll.frameworks.pro.common.core.core.page.PageDomain;
import com.xll.frameworks.pro.common.core.exception.SysException;
import com.xll.frameworks.pro.common.core.utils.StringUtils;
import com.xll.frameworks.pro.common.core.utils.bean.BeanUtils;
import com.xll.frameworks.pro.common.core.utils.reflect.ReflectUtils;
import com.xll.frameworks.pro.common.core.utils.sql.SqlUtil;
import com.xll.frameworks.pro.system.temp.common.utils.log.ContextHandler;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service基类
 * @author aidex
 * @email aidex@qq.com
 * @version 2020-02-27
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity<T>> implements BaseService<T> {

	/**
	 * 日志对象
	 */
	protected Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * mapper对象
	 */
	@Autowired(required = false)
	protected M mapper;

	/**
	 * 获取单条数据
	 *
	 * @param id
	 * @return
	 */
	@Override
	public T get(String id) {
		return mapper.get(id);
	}

	/**
	 * 获取单条数据
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public T get(T entity) {
		return mapper.get(entity);
	}

	/**
	 * 查询列表数据
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public List<T> findList(T entity) {
		//如果为空，则调用反射方法动态实例化，否则传入参数为空时，无法查询出数据
		if(null == entity){
			Class<T> entityClass = ReflectUtils.getClassGenricType(getClass(), 1);
			try {
				entity = entityClass.getConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				throw new SysException(e.getMessage());
			}
		}
		return mapper.findList(entity);
	}

	/**
	 * 查询分页数据
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public PageInfo<T> findPage(T entity) {
		PageDomain page = entity.getPage();
		Integer pageNum = page.getPageNum();
		Integer pageSize = page.getPageSize();
		if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
		{
			String orderBy = SqlUtil.escapeOrderBySql(page.getOrderBy());
			Boolean reasonable = page.getReasonable();
			PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
		}
		return new PageInfo(findList(entity));
	}

	/**
	 * 保存数据（插入或更新）
	 *
	 * @param entity
	 * @return
	 */
	@Override
	@Transactional(readOnly = false)
	public boolean save(T entity) {
		if (entity.getIsNewRecord()) {
			entity.preInsert();
			int count =  mapper.insert(entity) ;
			if (entity.isRecordLog()) {
				ContextHandler.set(BaseEntity.LOG_NEW_DATA, entity);
				ContextHandler.set(BaseEntity.LOG_TYPE, "insert");
			}
			return count > 0;
		} else {
			T oldBaseEntity = mapper.get(entity);
			//使用序列化方式进行深度拷贝避免对于引用赋值
			T oldBaseEntityLog = (T) SerializationUtils.clone(oldBaseEntity);
			BeanUtils.copyBeanProp(oldBaseEntity,entity);
			oldBaseEntity.preUpdate();
			if (mapper.update(oldBaseEntity) == 0) {
				throw new SysException("数据失效，请重新更新！");
			}
			if (entity.isRecordLog()) {
				ContextHandler.set(BaseEntity.LOG_OLD_DATA, oldBaseEntityLog);
				ContextHandler.set(BaseEntity.LOG_NEW_DATA, entity);
				ContextHandler.set(BaseEntity.LOG_TYPE, "update");
			}
			return Boolean.TRUE;
		}
	}

	/**
	 * 删除数据
	 * @param entity
	 * @return
	 */
	@Override
	public boolean remove(T entity) {
		int count =  mapper.delete(entity);
		if (entity.isRecordLog()) {
			ContextHandler.set(BaseEntity.LOG_NEW_DATA, entity);
			ContextHandler.set(BaseEntity.LOG_TYPE, "delete");
		}
		return count > 0;
	}

}