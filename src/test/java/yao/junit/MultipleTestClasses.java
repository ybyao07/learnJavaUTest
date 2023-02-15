package yao.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import yao.mockito.lesson02.AccountLoginControllerTest;

/**
 * @author yongboyao
 * create_date 2023/1/31$
 * 多个类同事测试
 **/

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ParameterTest.class,
        AccountLoginControllerTest.class
})
public class MultipleTestClasses {
}
