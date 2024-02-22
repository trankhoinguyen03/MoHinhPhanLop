/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Student;
import DAL.StudentDAL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class StudentBLL {
    StudentDAL dal;
    
    public StudentBLL() {
        dal = new StudentDAL();
    }
    
    public void readStudents() throws SQLException {
        dal.readStudents();
    }
    public int updateStudent(Student s) throws SQLException {
        return dal.updateStudent(s);
    }
    public int insertStudent(Student s) throws SQLException {
        return dal.insertStudent(s);
    }
    public void findStudent(String fullName) throws SQLException {
        dal.findStudent(fullName);
    }
    public int deleteStudent(int personID) throws SQLException {
        return dal.deleteStudent(personID);
    }
}
