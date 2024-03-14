/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudentDAL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    public boolean updateStudent(Student s) throws SQLException {
        return dal.updateStudent(s);
    }
    public boolean insertStudent(Student s) throws SQLException {
        return dal.insertStudent(s);
    }
    public String checkValue(Student s) {
        if("".equals(s.getFirstName())) {
            return "first name not null!";
        }
        else if("".equals(s.getLastName())) {
            return "last name not null!";
        }
        else if("".equals(s.getEnrollmentDate())) {
            return "date not null!";
        }
        else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate.parse(s.getEnrollmentDate(), formatter);
            } catch (DateTimeParseException e) {
                return "Invalid date!";
            }
        }
        return "valid";
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
    public boolean deleteStudent(int personID) throws SQLException {
        return dal.deleteStudent(personID);
    }
    public List<String> getStudentIDs() {
        return dal.getStudentIDs();
    }
}
