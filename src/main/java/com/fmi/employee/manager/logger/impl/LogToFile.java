package com.fmi.employee.manager.logger.impl;

import com.fmi.employee.manager.configurator.AppConfig;
import com.fmi.employee.manager.logger.Logger;
import com.fmi.employee.manager.vo.LoggerLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Profile("dev")
@Component
public class LogToFile implements Logger {
    private LoggerLevel loggerLevel;

    @Autowired
    private AppConfig appConfig;

    @PostConstruct
    public void setup() {
        loggerLevel = LoggerLevel.valueOf(appConfig.getLogger().getLvl());
    }

    @Override
    public void info(Object toLog) {
        LoggerLevel currentLogger = LoggerLevel.INFO;

        if (isLoggingAllowed(currentLogger)) {
            logInformation(toLog, currentLogger);
        }
    }

    @Override
    public void debug(Object toLog) {
        LoggerLevel currentLogger = LoggerLevel.DEBUG;

        if (isLoggingAllowed(currentLogger)) {
            logInformation(toLog, currentLogger);
        }
    }

    @Override
    public void trace(Object toLog) {
        LoggerLevel currentLogger = LoggerLevel.TRACE;

        if (isLoggingAllowed(currentLogger)) {
            logInformation(toLog, currentLogger);
        }
    }

    @Override
    public void error(Object toLog) {
        logInformation(toLog, LoggerLevel.ERROR);
    }

    private boolean isLoggingAllowed(LoggerLevel loggerLevel) {
        return  loggerLevel.getCode().compareTo(this.loggerLevel.getCode()) <= 0;
    }

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        File log = new File("log.txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
