package io.sixhours.conf;

import io.sixhours.env.Environment;
import lombok.Data;

/**
 * Configuration properties.
 *
 * @author Igor Bolic
 */
@Data
public class Configuration {

    private Environment environment;
    private User user;

    @Data
    public static final class User {
        private String firstName;
        private String lastName;
    }
}
