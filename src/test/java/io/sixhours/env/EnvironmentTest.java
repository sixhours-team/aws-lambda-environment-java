package io.sixhours.env;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Environment variable tests.
 *
 * @author Igor Bolic
 */
public class EnvironmentTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void thatResolvingEnvironmentFromEnvironmentVariableReturnsTestEnvironment() throws Exception {
        System.setProperty("LAMBDA_ENVIRONMENT", "test");

        Environment environment = Environment.value();

        assertThat(environment, is(Environment.test));
    }

    @Test
    public void thatResolvingEnvironmentFromEnvironmentVariableReturnsDevEnvironment() throws Exception {
        System.setProperty("LAMBDA_ENVIRONMENT", "dev");

        Environment environment = Environment.value();

        assertThat(environment, is(Environment.dev));
    }

    @Test
    public void thatResolvingEnvironmentFromEnvironmentVariableReturnsStageEnvironment() throws Exception {
        System.setProperty("LAMBDA_ENVIRONMENT", "stage");

        Environment environment = Environment.value();

        assertThat(environment, is(Environment.stage));
    }

    @Test
    public void thatResolvingEnvironmentFromEnvironmentVariableReturnsProdEnvironment() throws Exception {
        System.setProperty("LAMBDA_ENVIRONMENT", "prod");

        Environment environment = Environment.value();

        assertThat(environment, is(Environment.prod));
    }

    @Test
    public void thatResolvingEnvironmentFromEmptyEnvironmentVariableThrowsException() throws Exception {
        System.setProperty("LAMBDA_ENVIRONMENT", "");

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No enum constant io.sixhours.env.Environment.");

        Environment.value();
    }

    @Test
    public void thatResolvingEnvironmentFromNullEnvironmentVariableThrowsException() throws Exception {
        System.clearProperty("LAMBDA_ENVIRONMENT");

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid lambda environment");

        Environment.value();
    }

    @Test
    public void thatResolvingEnvironmentFromIllegalEnvironmentVariableThrowsException() throws Exception {
        System.setProperty("LAMBDA_ENVIRONMENT", "illegal");

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No enum constant io.sixhours.env.Environment.illegal");

        Environment.value();
    }

}