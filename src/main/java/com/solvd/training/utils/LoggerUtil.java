package com.solvd.training.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    public static final Logger LOGGER = LogManager.getLogger(LoggerUtil.class.getName());

    public static Logger getLogger() {
        return LOGGER;
    }
}