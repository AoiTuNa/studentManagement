package com.nhnacademy.studentmanagement.listener;

import com.nhnacademy.studentmanagement.exception.StudentMapException;
import com.nhnacademy.studentmanagement.students.MapStudentRepository;
import com.nhnacademy.studentmanagement.students.Student;
import com.nhnacademy.studentmanagement.students.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Random;

@Slf4j
@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();
        Random random = new Random();

        for(int i =1; i<=10; i++){
            String id = "Student"+i;
            String name = "AoiTuNa_"+i;
            Student.Gender gender;
            if(i%2==1){
                gender = Student.Gender.M;
            }else{
                gender = Student.Gender.F;
            }
            int age = random.nextInt(10)+20;

            try {
                studentRepository.save(new Student(id,name,gender,age));
            }catch (StudentMapException e){
                log.error("문제 발생!");
            }
        }
        context.setAttribute("studentRepository",studentRepository);

    }
}
