package com.codegym.module3_final_exam.dao;

import com.codegym.module3_final_exam.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student student) throws SQLException;

    public Student selectStudent(int id);

    public List<Student> selectAllStudent();

    public boolean deleteStudent(int id) throws SQLException;

    public boolean updateStudent(Student student) throws SQLException;

    List<Student> findByName(String name);


}
