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
public non-sealed class PageWrapper extends AbstractWrapper{
    private final int pageNum;
    private final int pageSize;

    /**
     * 初始化
     *
     * @param pageNum 页码
     * @param pageSize 每页数量
     */
    public PageWrapper(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Override
    public <T> List<T> wrap(Query<T> query) {
        try(Page<T> page = PageMethod.startPage(pageNum, pageSize).doSelectPage(query::doQuery)){
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
