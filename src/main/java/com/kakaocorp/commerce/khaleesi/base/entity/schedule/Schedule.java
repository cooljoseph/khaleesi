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
    private Integer id;
    private String code;
    private String title;

    private String monthly; // 월 단위
    private String daily; // 일 단위
    private String weekly; // 요일 단위
    private String hourly; // 시간 단위
    private String minutely; // 분 단위

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedDateTime;

}