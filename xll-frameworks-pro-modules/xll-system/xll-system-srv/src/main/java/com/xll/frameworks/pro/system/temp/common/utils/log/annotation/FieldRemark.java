package com.xll.frameworks.pro.system.temp.common.utils.log.annotation;

import java.lang.annotation.*;

/**
 * <p>作者：</p>
 * <p>创建时间： 2015-11-27 下午2:07:37 </p>
 * <p>类说明：DTO字段注解</p>
 * <p>修改记录： </p>
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface FieldRemark {

	String field() default "";

	String name() default "";
}
