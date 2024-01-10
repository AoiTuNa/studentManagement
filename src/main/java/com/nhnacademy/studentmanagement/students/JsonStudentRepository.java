package com.nhnacademy.studentmanagement.students;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.studentmanagement.exception.NoSerchStudentIdException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonStudentRepository implements StudentRepository {
    private final ObjectMapper objectMapper;
    private final File file;
    private List<Student> students;
    //json file 저장 경로
    private static final String JSON_FILE_PATH="/home/nhnacademy/IdeaProjects/servlet-jsp/studentManagement/src/main/json/student.json";

    public JsonStudentRepository(){
        objectMapper = new ObjectMapper();
        //LocalDatetime json 직열화/역직렬화 가능하도록 설정
        objectMapper.registerModule(new JavaTimeModule());
        file = new File(JSON_FILE_PATH);
        if(file.exists()){
            boolean delete = file.delete();
            if(!delete){
                //throw new FileDoNotDeleteException();
            }
        }
        //todo JSON_FILE_PATH 경로에 json 파일이 존재하면 삭제 합니다.

    }

    private synchronized List<Student> readJsonFile(){
        if(!file.exists()){
            students = new ArrayList<>();
            return  students;
        }
        //todo json 파일이 존재하지 않다면 비어있는 List<Student> 리턴

        //json read & 역직렬화 ( json string -> Object )
        try(FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            students = objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>() {});
            return  students;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private synchronized void writeJsonFile(List<Student> studentList){
        // List<Student> 객체를 -> json 파일로 저장 : 직렬화
        File file = new File(JSON_FILE_PATH);

        try(
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            objectMapper.writeValue(bufferedWriter,studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student) {
        //json String -> Object 형태로 변화 (직렬화)
        List<Student> students = readJsonFile();
        //List에 student 추가
        students.add(student);
        //List<Student>객체를 -> json String 형태로 저장(직렬화)
        writeJsonFile(students);
    }

    @Override
    public void update(Student targetStudent) {
        List<Student> students = readJsonFile();
        Optional<Student> student =students.stream().filter(s -> s.getId().equals(targetStudent.getId())).findFirst();
        if(student.isPresent()){
            Student student1 = student.get();
            student1.setName(targetStudent.getName());
            student1.setGender(targetStudent.getGender());
            student1.setAge(targetStudent.getAge());
            writeJsonFile(students);
        }else{
            throw new NoSerchStudentIdException();
        }
    }

    @Override
    public void deleteById(String id) {
        List<Student> students = readJsonFile();
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        student.ifPresent(students::remove);
        writeJsonFile(students);
    }

    @Override
    public Student getStudentById(String id) {
        List<Student> students = readJsonFile();
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        if(student.isPresent()){
            return student.get();
        }else{
            throw  new NoSerchStudentIdException();
        }

    }

    @Override
    public List<Student> getStudents() {
        return readJsonFile();
    }

    @Override
    public boolean existById(String id) {
        List<Student> students = readJsonFile();
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        if(student.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    //todo 나머지 method는 직접 구현하기
}