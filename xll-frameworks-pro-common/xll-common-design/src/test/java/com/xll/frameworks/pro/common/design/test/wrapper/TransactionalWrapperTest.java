package com.xll.frameworks.pro.common.design.test.wrapper;

import com.xll.frameworks.pro.common.design.iterator.PageIterator;
import com.xll.frameworks.pro.common.design.wrapper.PageWrapper;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 功能描述: <br>
 * <p>
 *  <测试>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 18:09
 * @version 1.0.0
 */
public class TransactionalWrapperTest {

    @Test
    public void test() {
        var pageIterator = new PageIterator<>(new PageWrapper(1, 10),
                ()-> List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        while (pageIterator.hasNext()){
            System.out.println(pageIterator.next());
        }
    }
}
