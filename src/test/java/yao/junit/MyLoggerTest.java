package yao.junit;

import org.junit.Rule;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yongboyao
 * create_date 2023/1/31$
 * @Description
 **/

public class MyLoggerTest {
    @Rule
    public final TestLogger logger = new TestLogger();

    @Test
    public void checkOutMyLogger() {
        final Logger log = logger.getLogger();
        log.log(Level.WARNING, "Your test is showing!");
    }
}
