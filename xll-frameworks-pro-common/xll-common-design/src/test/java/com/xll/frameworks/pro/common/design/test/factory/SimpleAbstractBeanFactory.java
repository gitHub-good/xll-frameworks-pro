package com.xll.frameworks.pro.common.design.test.factory;

import com.xll.frameworks.pro.common.design.factory.AbstractBeanFactory;
import com.xll.frameworks.pro.common.design.test.factory.bean.SimpleBean;
import org.springframework.test.annotation.Commit;

@Commit
public class SimpleAbstractBeanFactory extends AbstractBeanFactory<SimpleBean> {

    @Override
    protected SimpleBean getDefaultBean() {
        return null;
    }
}
