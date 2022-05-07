package com.fmi.employee.manager.logger;

public interface Logger {
    void info(Object toLog);

    void debug(Object toLog);

    void trace(Object toLog);

    void error(Object toLog);
}
