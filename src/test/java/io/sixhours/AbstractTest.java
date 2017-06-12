package io.sixhours;

import org.junit.BeforeClass;

/**
 * Base class for test environment configuration.
 *
 * @author Igor Bolic
 */
public abstract class AbstractTest {

    @BeforeClass
    public static void setSystemProperty() {
        System.setProperty("LAMBDA_ENVIRONMENT", "test");
    }
}
