package com.healthcare.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtils {

    private static final Logger logger = LoggerFactory.getLogger(LoggingUtils.class);

    // Logs an info message
    public static void logInfo(String message) {
        logger.info(message);
    }

    // Logs an error message
    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    // Logs a debug message
    public static void logDebug(String message) {
        logger.debug(message);
    }
}
