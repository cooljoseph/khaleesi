
/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */
/**
 * <h1>Khaleesi 에서 사용되는 cron expression Validation, 시간 비교 용도</h1>
 *
 * <p>Khaleesi 에서는 간편하게 Full Cron Expression 을 지원 하지 않는다. Schedule 에 딱 적합하게만 지원한다.</p>
 *
 * <p>딱 다음의 5개 필드만 제공한다.</p>
 *
 * <ol>
 *     <li>분(Minute)</li>
 *     <li>시(Hour)</li>
 *     <li>요일(DayOfWeek)</li>
 *     <li>일(DayOfMonth)</li>
 *     <li>월(Month)</li>
 * </ol>
 *
 * 각 필드는 다음의 기본 값을 가진다.
 * <ol>
 *     <li>분: 0,59 사이의 수</li>
 *     <li>시: 0,23 사이의 수</li>
 *     <li>요일: 1, 7 사이의 수(1은 월요일) 혹은 MON, TUE, WED, THU, FRI, SAT, SUN 와 같은 문자열 혹은 ?(설정하지 않음)</li>
 *     <li>일: 1, 31 사이의 수 혹은 ?(설정하지 않음) </li>
 *     <li>월: 1, 12 사이의 수, 혹은 JAN, FEB, MAR, APR, MAY, JUN. JUL, AUG, SEP, OCT, NOV, DEC 와 같은 문자열</li>
 * </ol>
 *
 * <p>여러 값을 사용 할 때에는 <strong>comma(,)</strong> 로 구분한다.</p>
 *
 * <p>모든 시간의 표현은 <strong>wild card (*)</strong> 를 사용한다.</p>
 *
 * <p><strong>증분 표현 (/)</strong> 도 포함한다. 예를 들어 Minute : 0/15 는 0분 부터 15, 30, 45 분의 시간을 의미한다.</p>
 */
package com.kakaocorp.commerce.khaleesi.base.entity.cron;
