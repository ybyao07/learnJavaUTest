package yao.mockito.lesson10;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * @author yongboyao
 * create_date 2022/11/18$
 * @Description
 **/

public class CompareNumberMatcher<T extends Number> extends BaseMatcher<T> {
    /**
     * 期望值
     */
    private final T value;
    private final Compare<T> COMPARE;

    public CompareNumberMatcher(T value, Boolean isGreater) {
        this.value = value;
        this.COMPARE = new DefaultNumberCompare<>(isGreater);
    }

    @Override
    public boolean matches(Object actual) {
        return this.COMPARE.compare(value, (T)actual);
    }
    public static <T extends Number> CompareNumberMatcher<T> gt(T value){
        return new CompareNumberMatcher<>(value,true);
    }

    public static <T extends Number> CompareNumberMatcher<T> lt(T value){
        return new CompareNumberMatcher<>(value, false);
    }
    private interface Compare<T extends Number>{
        boolean compare(T expected, T actual);
    }
    private static class DefaultNumberCompare<T extends Number> implements Compare<T>{
        public final Boolean isGreater;

        public DefaultNumberCompare(Boolean isGreater) {
            this.isGreater = isGreater;
        }
        @Override
        public boolean compare(T expected, T actual) {
            Class<?> aClass = actual.getClass();
            if (aClass == Integer.class){
                return isGreater ? (Integer)actual > (Integer ) expected : (Integer)actual < (Integer ) expected;
            } else if (aClass == Long.class) {
                return isGreater ? (Long)actual > (Long) expected : (Long)actual < (Long) expected;
            }else {
                throw new AssertionError("the number type " + aClass + " not supported.");
            }
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("this is ybyao custer matcher");
    }
}
