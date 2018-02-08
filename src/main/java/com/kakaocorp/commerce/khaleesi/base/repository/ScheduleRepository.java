/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.repository;

import com.kakaocorp.commerce.khaleesi.base.entity.schedule.Schedule;
import com.kakaocorp.commerce.khaleesi.base.repository.custom.ScheduleRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>, ScheduleRepositoryCustom{
}
