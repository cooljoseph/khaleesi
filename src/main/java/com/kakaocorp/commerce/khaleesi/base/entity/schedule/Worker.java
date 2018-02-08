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

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Worker implements Serializable{
    private static final long serialVersionUID = 13811671852952957L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "description", length = 10000)
    private String description;
    @Column(name="host")
    private String host;
    @Column(name="ip", length = 100)
    private String ip;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "port", length = 20)
    private String port;
    @Enumerated(EnumType.STRING)
    private ScheduleMode scheduleMode = ScheduleMode.dev;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedDateTime;
}
