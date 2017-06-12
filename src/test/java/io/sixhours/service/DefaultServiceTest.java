package io.sixhours.service;

import io.sixhours.AbstractTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Service tests.
 *
 * @author Igor Bolic
 */
public class DefaultServiceTest extends AbstractTest {

    private final Service service = DefaultService.instance;

    @Test
    public void thatAddReturnsCorrectResult() throws Exception {
        String result = service.fullName();

        assertThat(result, notNullValue());
        assertThat(result, is("Kent Beck"));
    }
}