package com.xll.frameworks.pro.batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * <p>
 *  <属性>
 * </p>
 * @author xuliangliang
 * @since 2023/5/31 23:38
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
public class PlanParameter<T> implements Serializable {

    private T value;

    private Class<T> type;
}
