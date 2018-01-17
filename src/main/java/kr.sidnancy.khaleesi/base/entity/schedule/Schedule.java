/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package kr.sidnancy.khaleesi.base.entity.schedule;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Schedule implements Serializable{

    private String monthly; // 월 단위
    private String daily; // 일 단위
    private String weekly; // 요일 단위
    private String hourly; // 시간 단위
    private String minutely; // 분 단위

}