package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@Repository
public class StudentRepository {

    HashMap<String,Student> studentHashMap ;
    HashMap<String,Teacher> teacherHashMap ;
    HashMap<String, ArrayList<String>> studentTeacherHashMap ;
    public StudentRepository() {
        studentHashMap = new HashMap<>();
        teacherHashMap = new HashMap<>();
        studentTeacherHashMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentHashMap.put(student.getName() , student);
    }

    public void addTeacher(Teacher teacher) {
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public Student getStudentByName(String name) {
        return studentHashMap.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teacherHashMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentTeacherHashMap.get(teacher);
    }

    public List<String> getAllStudents() {
        List<String> res = new ArrayList<>();
        for (String stud:studentHashMap.keySet()){
            res.add(stud);
        }
        return res;
    }

    public void deleteTeacherByName(String teacher) {
        for (String s : studentTeacherHashMap.get(teacher)){
            studentHashMap.remove(s);
        }
        teacherHashMap.remove(teacher);
        studentTeacherHashMap.remove(teacher);
        return;
    }

    public void deleteAllTeachers() {
        for (String t:studentTeacherHashMap.keySet()){
            deleteTeacherByName(t);
        }
    }

    public void addStudentTeacherPair(String student, String teacher) {
        ArrayList<String> temp = new ArrayList<>();
        if (studentTeacherHashMap.containsKey(teacher)){
            temp = studentTeacherHashMap.get(teacher);
        }
        temp.add(student);
        studentTeacherHashMap.put(teacher,temp);
    }
}