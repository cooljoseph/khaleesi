/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.repository;

import com.kakaocorp.commerce.khaleesi.TestBase;
import com.kakaocorp.commerce.khaleesi.base.cond.schedule.ScheduleCond;
import com.kakaocorp.commerce.khaleesi.base.entity.schedule.Schedule;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

@Transactional
public class ScheduleRepositoryTests extends TestBase{

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void saveAndSearch() {
        Schedule schedule = new Schedule();

        schedule.setValidflag("Y");
        schedule.setTitle("TEST");
        schedule.setCode("TEST");
        schedule.setGroupCode("TEST_GRP");
        scheduleRepository.save(schedule);

        ScheduleCond cond = new ScheduleCond();
        cond.setValidflagCond("Y");

        Page<Schedule> schedulePage = scheduleRepository.search(cond, Pageable.unpaged());

        Assert.assertThat(schedulePage.getTotalElements(), greaterThanOrEqualTo(1L));

        schedulePage.forEach(System.out::println);

        cond.setValidflagCond("N");
        Page<Schedule> anotherSchedulePage = scheduleRepository.search(cond, Pageable.unpaged());

        Assert.assertThat(anotherSchedulePage.getTotalElements(), lessThan(1L));
    }
}
