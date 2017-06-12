package io.sixhours.conf;

import io.sixhours.AbstractTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Configuration holder tests.
 *
 * @author Igor Bolic
 */
public class ConfigurationHolderTest extends AbstractTest {

    @Test
    public void thatConfigurationValuesAreLoaded() throws Exception {
        Configuration configuration = ConfigurationHolder.instance.configuration();

        assertThat(configuration, notNullValue());
        assertThat(configuration.getUser(), notNullValue());
        assertThat(configuration.getUser().getFirstName(), is("Kent"));
        assertThat(configuration.getUser().getLastName(), is("Beck"));
    }

}