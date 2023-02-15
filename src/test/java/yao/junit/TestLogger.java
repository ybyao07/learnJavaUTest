package yao.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.logging.Logger;

/**
 * @author yongboyao
 * create_date 2023/1/31$
 * @Description
 **/

public class TestLogger implements TestRule {
    private Logger logger;

    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                logger = Logger.getLogger(description.getTestClass().getName() + '.' + description.getDisplayName());
                statement.evaluate();
            }
        };
    }
}
