/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

appender("ConsoleAppender", ConsoleAppender){
    encoder(PatternLayoutEncoder){
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}

root(INFO, ["ConsoleAppender"])

logger("com.kakaocorp.commerce.khaleesi", DEBUG, ["ConsoleAppender"], false)