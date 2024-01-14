package com.xll.frameworks.pro.common.design.iterator;

import com.xll.frameworks.pro.common.design.wrapper.PageWrapper;
import org.springframework.util.CollectionUtils;

import java.util.List;
/**
 * 功能描述: <br>
 * <p>
 *  <分页迭代器>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 18:22
 * @version 1.0.0
 */
public class PageIterator<E> extends AbstractCommonIterator<List<E>> {

    private final PageWrapper pageWrapper;
    private final PageWrapper.Query<E> query;
    private  List<E> dataList;

    public PageIterator(PageWrapper pageWrapper, PageWrapper.Query<E> query) {
        this.pageWrapper = pageWrapper;
        this.query = query;
    }

    @Override
    public boolean hasNext() {
        List<E> wrap = pageWrapper.wrap(query);
        return !CollectionUtils.isEmpty(wrap);
    }

    @Override
    public List<E> next() {
        try{
            return dataList;
        }finally {
            clean();
        }
    }

    private void clean(){
        dataList = null;
    }
}
