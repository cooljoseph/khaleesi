/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.entity.schedule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Schedule implements Serializable{

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "title")
    private String title;

    @Column(name="month")
    private String month; // 월 단위
    @Column(name="day_of_month")
    private String dayOfMonth; // 일 단위
    @Column(name="day_of_week")
    private String dayOfWeek; // 요일 단위
    @Column(name="hour")
    private String hour; // 시간 단위
    @Column(name="minute")
    private String minute; // 분 단위
    @Column(name="second")
    private String second;   // 초 단위

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedDateTime;

}