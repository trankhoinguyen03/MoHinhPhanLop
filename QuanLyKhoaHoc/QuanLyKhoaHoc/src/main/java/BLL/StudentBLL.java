/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudentDAL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class StudentBLL {
    StudentDAL dal;
    
    public StudentBLL() {
        dal = new StudentDAL();
    }
    
    public ArrayList<Student> readStudents() throws SQLException {
        return dal.readStudents();
    }
    public int updateStudent(Student s) throws SQLException {
        return dal.updateStudent(s);
    }
    public int insertStudent(Student s) throws SQLException {
        return dal.insertStudent(s);
    }
    public ArrayList<Student> searchStudents(String value) throws SQLException {
        ArrayList<Student> list = new ArrayList<>();
        for (Student x : readStudents()) {
            String id = Integer.toString(x.getPersonId()).toLowerCase();
            String firtName = x.getFirstName().toLowerCase();
            String lastName = x.getLastName().toLowerCase();
            String hireDate = x.getEnrollmentDate().toLowerCase();
            if (id.contains(value.toLowerCase()) || firtName.contains(value.toLowerCase()) || lastName.contains(value.toLowerCase()) || hireDate.contains(value.toLowerCase())) {
                list.add(x);
            }
        }
        return list;
    }
    public int deleteStudent(int personID) throws SQLException {
        return dal.deleteStudent(personID);
    }
    public List<String> getStudentIDs() {
        return dal.getStudentIDs();
    }
}
