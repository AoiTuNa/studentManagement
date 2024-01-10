package com.nhnacademy.reflection;

public class DiTest {
    public static void main(String[] args) {
        UserService userService = InjectUtil.getObject(UserService.class);
        User user = new User("AoiTuNa",7);
        userService.addUser(user);
        System.out.println(userService.getUser("AoiTuNa"));
    }
}
