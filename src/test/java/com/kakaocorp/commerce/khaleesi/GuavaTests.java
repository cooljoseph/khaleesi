/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Guava Library 에 대해 모르는 것이 많이 있어서 테스트 케이스로 만들어서 라이브러리에 대한 이해 증진
 * */
public class GuavaTests {
    @Test
    public void testTable() {
        Table<Integer, Integer, List<String>> testTable = HashBasedTable.create();

        testTable.put(1,11, Arrays.asList("A", "B", "C"));

        System.out.println(testTable);

        testTable.get(1,11).forEach(System.out::println);
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testImmutableCollections() {
        List<String> mutableList = Arrays.asList("A", "B", "C");
        mutableList.set(1, "D");

        // 변경 가능하다.
        mutableList.forEach(System.out::println);

        List<String> immutableList = Arrays.asList("A", "B", "C").stream().collect(ImmutableList.toImmutableList());

        // 변경 가능하면 안된다.
        immutableList.set(1, "D");
    }
}
