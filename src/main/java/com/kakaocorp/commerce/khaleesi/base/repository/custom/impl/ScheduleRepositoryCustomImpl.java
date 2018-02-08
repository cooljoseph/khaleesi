/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.repository.custom.impl;

import com.kakaocorp.commerce.khaleesi.base.cond.schedule.ScheduleCond;
import com.kakaocorp.commerce.khaleesi.base.entity.schedule.QSchedule;
import com.kakaocorp.commerce.khaleesi.base.entity.schedule.Schedule;
import com.kakaocorp.commerce.khaleesi.base.repository.custom.ScheduleRepositoryCustom;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ScheduleRepositoryCustomImpl extends QuerydslRepositorySupport implements ScheduleRepositoryCustom{
    public ScheduleRepositoryCustomImpl() {
        super(Schedule.class);
    }

    @Override
    public Page<Schedule> search(ScheduleCond cond, Pageable pageable) {
        QSchedule schedule = QSchedule.schedule;

        JPQLQuery query = from(schedule);

        if(StringUtils.isNotEmpty(cond.getValidflagCond())){
            query.where(schedule.validflag.eq(cond.getValidflagCond()));
        }

        List<Schedule> scheduleList = getQuerydsl().applyPagination(pageable, query).fetch();
        Long count = query.fetchCount();

        return new PageImpl<>(scheduleList, pageable, count);
    }
}
