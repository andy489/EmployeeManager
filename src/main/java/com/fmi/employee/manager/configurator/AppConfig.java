package com.fmi.employee.manager.configurator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "config")
public class AppConfig {
    private final LoggerConfig logger = new LoggerConfig();

    @Getter
    @Setter
    public static class LoggerConfig {
        private String lvl;
    }
}