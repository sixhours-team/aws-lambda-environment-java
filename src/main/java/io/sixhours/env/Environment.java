package io.sixhours.env;

import java.util.Optional;

/**
 * Enum constant with available lambda environments.
 *
 * @author Igor Bolic
 */
public enum Environment {
    test, dev, stage, prod;

    private static final String LAMBDA_ENVIRONMENT = "LAMBDA_ENVIRONMENT";

    /**
     * Returns {@link Environment} enum constant resolved from the lambda environment variable.
     *
     * @return Environment
     * @throws IllegalArgumentException If the enum type has no constant matching the specified environment variable.
     */
    public static Environment value() {
        String env = Optional.ofNullable(System.getenv(LAMBDA_ENVIRONMENT))
                .orElse(System.getProperty(LAMBDA_ENVIRONMENT));

        if (env != null) {
            return Environment.valueOf(env);
        }
        throw new IllegalArgumentException("Invalid lambda environment");
    }
}
