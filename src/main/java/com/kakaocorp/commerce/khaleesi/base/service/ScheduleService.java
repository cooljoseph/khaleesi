/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.service;

import com.kakaocorp.commerce.khaleesi.base.entity.schedule.Schedule;

public interface ScheduleService {
    Schedule save(Schedule schedule);

    Schedule findById(Long id);

    void deleteById(Long id);
}
