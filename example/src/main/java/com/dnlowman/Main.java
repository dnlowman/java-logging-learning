package com.dnlowman;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/*
    @timestamp -> time
    @version -> REMOVE
    message -> details {
                    type: TYPE
               }
    logger_name ?
    thread_name -> threadName
    level -> level
    level_value -> REMOVE
    stack_trace -> REMOVE
    tags -> REMOVE
*/


public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        MDC.put("activityId", UUID.randomUUID().toString());

        MyObject test = new MyObject();

        logger.info("{}", test);

        MDC.clear();

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}