package com.nhnacademy.StopWatch.ArratList;

import com.nhnacademy.StopWatch.PerformanceTestable;
import com.nhnacademy.StopWatch.StopWatch;

import java.lang.reflect.Method;
import java.util.Objects;

public class ArrayListTestProxy implements PerformanceTestable {
    private final PerformanceTestable performanceTestable;

    public ArrayListTestProxy(PerformanceTestable performanceTestable){
        this.performanceTestable = performanceTestable;
    }

    @Override
    public void test(){
        if(hasStopWatch()){
            long start = System.currentTimeMillis();
            System.out.println("##시간측정 시작: " + start);
            performanceTestable.test();
            long end = System.currentTimeMillis();
            System.out.println("##시간측정 종료 " + end);
            long result = (end - start)/1000;
            System.out.println("실행시간 : "+result);
        }
    }
    private boolean hasStopWatch(){
        for(Method method : performanceTestable.getClass().getDeclaredMethods()){
            StopWatch stopWatch = method.getAnnotation(StopWatch.class);
            if(Objects.nonNull(stopWatch)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayListTestProxy arrayListTestProxy = new ArrayListTestProxy(new ArrayListTest());
        arrayListTestProxy.test();
    }
}
