package com.nhnacademy.StopWatch.LinkedList;

import com.nhnacademy.StopWatch.PerformanceTestable;
import com.nhnacademy.StopWatch.StopWatch;

import java.lang.reflect.Method;
import java.util.Objects;

public class LinkedListProxyTest implements PerformanceTestable {
    PerformanceTestable performanceTestable;
    public LinkedListProxyTest(PerformanceTestable performanceTestable){
        this.performanceTestable = performanceTestable;
    }

    @Override
    public void test() {
        if(hasStopwatch()){
            long start = System.currentTimeMillis();
            System.out.println("##측정 시작한다 인간아"+start);
            performanceTestable.test();
            long end = System.currentTimeMillis();
            System.out.println("##측정 끗났다 인간아"+end);
            long result = (end-start)/1000;
            System.out.println(result+"초 걸렸다 인간아");
        }
    }
    private boolean hasStopwatch(){
        for(Method method : performanceTestable.getClass().getDeclaredMethods()){
            StopWatch stopWatch = method.getAnnotation(StopWatch.class);
            if(Objects.nonNull(stopWatch)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListProxyTest linkedListProxyTest = new LinkedListProxyTest(new LinkedListTest());
        linkedListProxyTest.test();
    }
}
