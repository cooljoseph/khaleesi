/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.manager.worker;

import com.kakaocorp.commerce.khaleesi.base.entity.schedule.Schedule;

public interface WorkerProcess {
    ScheduleResult runGather(Schedule schedule) throws RuntimeException;
}
