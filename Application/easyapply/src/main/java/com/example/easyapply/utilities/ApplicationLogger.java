package com.example.easyapply.utilities;

import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import java.util.logging.Logger;

public class ApplicationLogger {
    private static ApplicationLogger logger;

    private ApplicationLogger(){
        logger = (ApplicationLogger) LoggerFactory.getLogger(ApplicationLogger.class);
    }

    public static synchronized ApplicationLogger getInstance(){
        if(logger == null){
            new ApplicationLogger();
        }

        return logger;
    }

    /**
     * Logs exception
     * @param exception
     */
    public void logException(@NonNull Exception exception){
        logger.logException(exception);
    }

    /**
     * Logs trace message
     * @param traceMessage
     */
    public void logTrace(@NonNull String traceMessage){
        logger.logTrace(traceMessage);
    }
}
