package com.xll.frameworks.pro.common.design.wrapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import lombok.Setter;

import java.util.List;
/**
 * 功能描述: <br>
 * <p>
 *  <分页包装器>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 20:15
 * @version 1.0.0
 */
@Setter
public class PageWrapper extends AbstractWrapper{
    private final int maxPageNum;
    private final int maxPageSize;

    /**
     * 初始化
     *
     * @param maxPageNum 页码
     * @param maxPageSize 每页数量
     */
    public PageWrapper(int maxPageNum, int maxPageSize) {
        this.maxPageNum = maxPageNum;
        this.maxPageSize = maxPageSize;
    }

    @Override
    public <T> List<T> wrap(Query<T> query) {
        try(Page<T> page = PageMethod.startPage(maxPageNum, maxPageSize).doSelectPage(query::doQuery)){
            return page.getResult();
        }
    }

    @FunctionalInterface
    public interface Query<T>{
        /**
         * 业务查询方法
         * @return 结果集
         */
        List<T> doQuery();
    }
}
