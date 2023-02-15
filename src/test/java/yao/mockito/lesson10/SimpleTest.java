package yao.mockito.lesson10;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static yao.mockito.lesson10.CompareNumberMatcher.gt;
import static yao.mockito.lesson10.CompareNumberMatcher.lt;


/**
 * @author yongboyao
 * create_date 2022/11/18$
 * @Description
 **/

public class SimpleTest {

    @Test
    public void test(){
        assertThat(10, both(gt((8))).and(lt(11)));
        assertThat(10, Matchers.greaterThan(9));
    }
}
