/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.repository.custom;

import com.kakaocorp.commerce.khaleesi.base.cond.schedule.ScheduleCond;
import com.kakaocorp.commerce.khaleesi.base.entity.schedule.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScheduleRepositoryCustom {
    Page<Schedule> search(ScheduleCond cond, Pageable pageable);
}
