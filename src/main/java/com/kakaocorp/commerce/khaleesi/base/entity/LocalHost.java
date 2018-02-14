/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Slf4j
@Getter
public class LocalHost {

    private String ipAddress;
    private String hostName;

    public LocalHost(){
        try{
            java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
            ipAddress = localMachine.getHostAddress();
            hostName = localMachine.getHostName();
            log.info("IP of local machine : {}, HostName of local machine : {}", ipAddress, hostName);
        } catch(Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
