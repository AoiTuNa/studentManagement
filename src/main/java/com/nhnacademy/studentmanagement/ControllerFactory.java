package com.nhnacademy.studentmanagement;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ControllerFactory {
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c){
        for (class<?> clazz : c)
        //todo beanMap에 key = method + servletPath, value = Controller instance를 저장합니다.
    }

    public Object getBean(String method, String path){
        //todo beanMap 에서 method+servletPath을 key로 이용하여 Controller instance를 구합니다.
        return null;
    }
}
