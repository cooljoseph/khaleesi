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

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Schedule implements Serializable{
    private static final long serialVersionUID = -8212326866057196212L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "code", length = 100, nullable = false)
    private String code;
    @Column(name = "group_code", nullable = false)
    private String groupCode;
    @Column(name = "title", length = 500, nullable = false)
    private String title;
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name="id_concurrent_yn", length = 1, nullable = false)
    private String idConcurrentYn;
    @Column(name="code_concurrent_yn", length = 1, nullable = false)
    private String codeConcurrentYn;
    @Column(name="group_concurrent_yn", length = 1, nullable = false)
    private String groupConcurrentYn;

    @Column(name="args1", length =500)
    private String args1;
    @Column(name="args1name", length =500)
    private String args1name;
    @Column(name="args2", length =500)
    private String args2;
    @Column(name="args2name", length =500)
    private String args2name;
    @Column(name="args3", length =500)
    private String args3;
    @Column(name="args3name", length =500)
    private String args3name;
    @Column(name="args4", length =500)
    private String args4;
    @Column(name="args4name", length =500)
    private String args4name;
    @Column(name="args5", length =500)
    private String args5;
    @Column(name="args5name", length =500)
    private String args5name;

    @Column(name = "validflag", length = 2,  nullable = false)
    private String validflag; // "Y":정상, "N":비활성화, "D":삭제

    @Column(name="month", length = 100, nullable = false)
    private String month; // 월 단위
    @Column(name="day_of_month", length = 100, nullable = false)
    private String dayOfMonth; // 일 단위
    @Column(name="day_of_week", length = 100, nullable = false)
    private String dayOfWeek; // 요일 단위
    @Column(name="hour", length = 100, nullable = false)
    private String hour; // 시간 단위
    @Column(name="minute", length = 100, nullable = false)
    private String minute; // 분 단위
    @Column(name="second", length = 100, nullable = false)
    private String second;   // 초 단위

    @ManyToMany
    private List<Worker> workerList;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedDateTime;
}