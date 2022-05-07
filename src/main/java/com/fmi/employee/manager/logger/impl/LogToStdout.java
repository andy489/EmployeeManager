package com.fmi.employee.manager.logger.impl;

import com.fmi.employee.manager.configurator.AppConfig;
import com.fmi.employee.manager.logger.Logger;
import com.fmi.employee.manager.vo.LoggerLevel;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class LogToStdout implements Logger {
    private final LoggerLevel logLvl;

    public LogToStdout(final AppConfig appConfig) {
        logLvl = LoggerLevel.valueOf(appConfig.getLogger().getLvl());
    }

    @Override
    public void info(final Object toLog) {
        if (logLvl.getCode().compareTo(LoggerLevel.INFO.getCode()) <= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void debug(Object toLog) {
        if (logLvl.getCode().compareTo(LoggerLevel.DEBUG.getCode()) <= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void trace(Object toLog) {
        if (logLvl.getCode().compareTo(LoggerLevel.TRACE.getCode()) <= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void error(Object toLog) {
        System.out.println(toLog);
    }
}
