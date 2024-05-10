package com.springmvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.beans.Student;

@Repository
public class StudentDao {
	
	



    public int save(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, email, number, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getNumber());
            statement.setString(4, student.getAddress());
            return statement.executeUpdate();
        }
    }

    public int update(Student student) throws SQLException {
        String sql = "UPDATE students SET name=?, email=?, number=?, address=? WHERE id=?";
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getNumber());
            statement.setString(4, student.getAddress());
            statement.setInt(5, student.getId());
            return statement.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }

    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id=?";
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setEmail(resultSet.getString("email"));
                    student.setNumber(resultSet.getInt("number"));
                    student.setAddress(resultSet.getString("address"));
                    return student;
                } else {
                    return null; 
                }
            }
        }
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setNumber(resultSet.getInt("number"));
                student.setAddress(resultSet.getString("address"));
                students.add(student);
            }
        }
        return students;
    }
}

