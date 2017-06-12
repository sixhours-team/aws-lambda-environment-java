package io.sixhours.conf;

import io.sixhours.env.Environment;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Holds a configuration loaded from the {@code application.yml} file on the classpath.
 *
 * @author Igor Bolic
 */
public enum ConfigurationHolder {
    instance;

    private final Yaml yaml = new Yaml(new Constructor(Configuration.class));
    private Map<Environment, Configuration> configuration;

    ConfigurationHolder() {
        load();
    }

    private void load() {
        InputStream inputStream = ConfigurationHolder.class.getResourceAsStream("/application.yml");
        Iterable<Object> iterable = yaml.loadAll(inputStream);

        this.configuration = StreamSupport.stream(iterable.spliterator(), false)
                .map(Configuration.class::cast)
                .collect(Collectors.toMap(item -> item.getEnvironment(), item -> item));
    }

    public Configuration configuration() {
        return this.configuration.get(Environment.value());
    }
}
