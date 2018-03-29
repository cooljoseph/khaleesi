/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.controller;

import com.kakaocorp.commerce.khaleesi.base.entity.schedule.Schedule;
import com.kakaocorp.commerce.khaleesi.base.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> create(Schedule schedule){
        log.info("{}", schedule);

        return ResponseEntity.ok(scheduleService.save(schedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(Schedule schedule){
        log.info("{}",schedule);

        return ResponseEntity.ok(scheduleService.save(schedule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> schedule(@PathVariable Long id){
        try{
            return ResponseEntity.ok(scheduleService.findById(id));
        }catch(NoSuchElementException e){
            log.info("id::{} is not exists", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch(RuntimeException e){
            log.error(ExceptionUtils.getStackTrace(e));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        scheduleService.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
