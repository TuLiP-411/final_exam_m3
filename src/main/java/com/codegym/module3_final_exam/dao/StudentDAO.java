package com.codegym.module3_final_exam.dao;

import com.codegym.module3_final_exam.connection.ConnectionCMS;
import com.codegym.module3_final_exam.connection.ConnectionCMS;
import com.codegym.module3_final_exam.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private static final String INSERT_STUDENTS_SQL = "INSERT INTO student (`name`, `dob`, `address`, `phone`, `email`, `class_id`)  VALUES (?, ?, ?,?,?,?);";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * from student where id =?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * from student";
    private static final String DELETE_STUDENTS_SQL = "delete from student where id = ?;";
    private static final String UPDATE_STUDENTS_SQL = "update student set name = ?,dob= ?, address =?, phone = ?, email = ?, class_id = ? where id = ?;";

    private static final String SEARCH_STUDENTS_BY_NAME_SQL = "SELECT * from student where name like ?";
    ;

    private Connection connection = ConnectionCMS.getConnection();

    public StudentDAO() {
    }


    @Override
    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENTS_SQL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf((student.getDob())));
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClass_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dob = LocalDate.parse(resultSet.getString("dob"));
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int class_id = resultSet.getInt("class_id");
                student = new Student(studentId, name, dob, address, phone, email, class_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dob = LocalDate.parse(resultSet.getString("dob"));
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int class_id = resultSet.getInt("class_id");
                students.add(new Student(studentId, name, dob, address, phone, email, class_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS_SQL);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS_SQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getDob()));
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClass_id());
            preparedStatement.setInt(7, student.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Student> findByName(String searchName) {
        List<Student> students = selectAllStudent();
        List<Student> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENTS_BY_NAME_SQL);
            preparedStatement.setString(1, "%" + searchName + "%");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dob = LocalDate.parse(resultSet.getString("dob"));
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int class_id = resultSet.getInt("class_id");
                result.add(new Student(studentId, name, dob, address, phone, email, class_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}

