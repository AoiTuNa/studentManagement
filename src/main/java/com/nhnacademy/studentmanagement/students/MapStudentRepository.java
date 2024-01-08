package com.nhnacademy.studentmanagement.students;

import com.nhnacademy.studentmanagement.exception.StudentMapException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MapStudentRepository implements StudentRepository {
    private Map<String, Student> studentMap = new ConcurrentHashMap<>();
    @Override
    public void save(Student student) {
        if(studentMap.containsKey(student.getId())){
            log.error("already use id : {}",student.getId());
            throw new StudentMapException();
        }
        studentMap.put(student.getId(),student);
    }

    @Override
    public void update(Student student) {
        if(!studentMap.containsKey(student.getId())){
            log.error("don't find student id:{}",student.getId());
            throw new StudentMapException();
        }
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(String id) {
        if(!studentMap.containsKey(id)){
            log.error("Don't delete student id. Reason: {} not found",id);
            throw new StudentMapException();
        }
        studentMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        if(studentMap.containsKey(id)){
            return studentMap.get(id);
        }else{
            log.error("don't find student id:{}",id);
            throw new StudentMapException();
        }
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public boolean existById(String id) {
        return studentMap.containsKey(id);
    }
}
