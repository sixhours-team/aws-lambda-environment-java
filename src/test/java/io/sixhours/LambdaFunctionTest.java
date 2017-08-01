package io.sixhours;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Lambda handler tests.
 *
 * @author Igor Bolic
 */
public class LambdaFunctionTest extends AbstractTest {

    private final String input = "";
    private final Context context = new TestContext();

    @Test
    public void thatHandleRequestReturnsResult() throws Exception {
        LambdaFunction handler = new LambdaFunction();

        String result = handler.handleRequest(input, context);

        assertThat(result, notNullValue());
        assertThat(result, is("Kent Beck"));
    }

}