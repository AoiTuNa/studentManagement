package com.nhnacademy.StopWatch.LinkedList;

import com.nhnacademy.StopWatch.PerformanceTestable;
import com.nhnacademy.StopWatch.StopWatch;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest implements PerformanceTestable {

    @Override
    @StopWatch
    public void test() {
        List<Integer> integerList = new LinkedList<>();
        for(int i = 0; i < 100000000; i++){
            integerList.add(i);
        }
    }
}
