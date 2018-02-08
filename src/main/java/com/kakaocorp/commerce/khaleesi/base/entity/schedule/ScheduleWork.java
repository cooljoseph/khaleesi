/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi.base.entity.schedule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class ScheduleWork implements Serializable{
    private static final long serialVersionUID = 3375033560611747799L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "end_ddtm", length = 14)
    private String endDttm;
    @Column(name = "start_dttm", length = 14, nullable = false)
    private String startDttm;
    @Column(name = "error_msg", length = 1000)
    private String errorMsg;
    @Column(name = "status", length = 1)
    private String status = ScheduleWorkStatus.PROCESSING.getValue();

    @OneToOne
    @JsonBackReference
    private Worker worker;
    @OneToOne
    @JsonBackReference
    private Schedule schedule;

    public enum ScheduleWorkStatus{

        PROCESSING("P"), FINISHED("F"), ERROR("E");

        private final String value;

        public String getValue() {
            return value;
        }

        ScheduleWorkStatus(String value){
            this.value = value;
        }
    }
}
