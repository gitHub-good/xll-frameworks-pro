package com.xll.frameworks.pro.system.temp.common.utils.log.annotation;

import java.lang.annotation.*;

/**
 * <p>作者：</p>
 * <p>创建时间： 2015-11-27 下午2:35:43 </p>
 * <p>类说明：用于在POJO上标注哪些字段的值要写入到日志信息中</p>
 * <p>修改记录： </p>
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface LogField {

}
