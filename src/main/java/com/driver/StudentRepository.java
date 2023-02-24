package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
    public class StudentRepository {

        Map<String,Student> studentMap ;
        Map<String,Teacher> teacherMap ;
        Map<String, List<String>> studentTeacherMap ;
        public StudentRepository() {
            studentMap = new HashMap<>();
            teacherMap = new HashMap<>();
            studentTeacherMap = new HashMap<>();
        }

        public void addStudent(Student student) {
            studentMap.put(student.getName() , student);
        }

        public void addTeacher(Teacher teacher) {
            teacherMap.put(teacher.getName(),teacher);
        }

        public Student getStudentByName(String name) {
            return studentMap.get(name);
        }

        public Teacher getTeacherByName(String name) {
            return teacherMap.get(name);
        }

        public List<String> getStudentsByTeacherName(String teacher) {
            return studentTeacherMap.get(teacher);
        }

        public List<String> getAllStudents() {
            List<String> res = new ArrayList<>();
            for (String student:studentMap.keySet()){
                res.add(student);
            }
            return res;
        }

        public void deleteTeacherByName(String teacher) {
            for (String s : studentTeacherMap.get(teacher)){
                studentMap.remove(s);
            }
            teacherMap.remove(teacher);
            studentTeacherMap.remove(teacher);
        }

        public void deleteAllTeachers() {
            for (String t:studentTeacherMap.keySet()){
                deleteTeacherByName(t);
            }
        }

        public void addStudentTeacherPair(String student, String teacher) {
            List<String> temp = new ArrayList<>();
            if (studentTeacherMap.containsKey(teacher)){
                temp = studentTeacherMap.get(teacher);
            }
            temp.add(student);
            studentTeacherMap.put(teacher,temp);
        }
    }

