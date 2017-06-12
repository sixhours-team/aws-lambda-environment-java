package io.sixhours.service;

import io.sixhours.conf.Configuration;
import io.sixhours.conf.ConfigurationHolder;

/**
 * Default service implementation.
 *
 * @author Igor Bolic
 */
public enum DefaultService implements Service {
    instance;

    private final Configuration config = ConfigurationHolder.instance.configuration();

    @Override
    public String fullName() {
        String firstName = config.getUser().getFirstName();
        String lastName = config.getUser().getLastName();

        return firstName + " " + lastName;
    }
}
