package com.nhnacademy.reflection;

/**
 * JavaDoc Example class
 *
 * @author AoiTuNa
 * @version 1972.11.21
 * @see Example01#printMessage(String)
 */
public class Example01 {
    /**
     * message parameter에 대한 설명을 일장 연설로 늘어 놓아라..
     */
    private  String message = "hello java";

    /**
     * message parameter을 받아서 console에 출력하는 method 이다...
     * @param message console에 출력할 메시지를 나타낸단다...
     * @see Example01
     * @return message가 정상 출려되면 true 실패하면 false 반환한단다..
     */
    public boolean printMessage(String message) {
        boolean result = true;
        try {
            System.out.println(message);
        }catch (Exception e) {
            result = false;
        }
        return result;
    }
}
