package com.nhnacademy.StopWatch.ArratList;

import com.nhnacademy.StopWatch.PerformanceTestable;
import com.nhnacademy.StopWatch.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest implements PerformanceTestable {

    @StopWatch
    @Override
    public void test(){
        List<Integer> integerList = new ArrayList<>();
        for(int i=0; i<100000000; i++){
            integerList.add(i);
        }
    }

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.test();
    }
}
