/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.config;

import com.google.common.collect.Maps;
import com.kakaocorp.commerce.khaleesi.base.entity.worker.ServerMode;
import com.kakaocorp.commerce.khaleesi.base.manager.worker.WorkerBean;
import com.kakaocorp.commerce.khaleesi.base.manager.worker.WorkerProcess;
import com.mysql.fabric.Server;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
/**
 * TODO Factory면 Factory 답게 WorkerProcess 를 찍어내자
 * */
public class WorkerBeanFactory implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;
    @Value("${server.mode:all}")
    private String serverMode;

    private Map<String, WorkerProcess> workerProcessMap = Maps.newHashMap();

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!(serverMode.equalsIgnoreCase(ServerMode.all.name())
                || serverMode.equalsIgnoreCase(ServerMode.master.name())
                || serverMode.equalsIgnoreCase(ServerMode.worker.name()))){
            throw new IllegalArgumentException("server.mode only accept \"master\", \"worker\", \"all\"");
        }

        log.info("server mode [{}] is starting", serverMode);

        final Map<String, Object> workerCandidates = applicationContext.getBeansWithAnnotation(WorkerBean.class);

        // Worker Only
        if(serverMode.equalsIgnoreCase(ServerMode.master.name())){
           return ;
        }

        workerCandidates.forEach((key, value) ->{
            WorkerProcess workerProcess = (WorkerProcess) value;
            String name = workerProcess.getClass().getCanonicalName();
            if(workerProcessMap.containsKey(key)){
                log.info("WorkerProcess : {}({}) has already registered...", key, name);
            }else{
                workerProcessMap.put(key, workerProcess);
                log.info("WorkerProcess : {}({}) has registered", key, name);
            }
        });

        // TODO Worker 자동 등록
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
