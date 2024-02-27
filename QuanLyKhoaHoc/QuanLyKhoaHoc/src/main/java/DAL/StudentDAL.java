/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class StudentDAL extends MyDatabaseManager {
    public StudentDAL() {
        super();
        this.connectDB();
    }
    public void readStudents() throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate >0";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            //int i = 1;
            while (rs.next()) {
                System.out.print(rs.getString("PersonId") + " - ");
                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                //i++;
            }
        }
    }
    public int updateStudent(Student s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "+ " WHERE PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonId());
        int result = p.executeUpdate();
        return result;
    }
    public int insertStudent(Student s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, EnrollmentDate) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getEnrollmentDate().toString());
        int result = p.executeUpdate();
        return result;
    }
    public void findStudent(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                System.out.print(i + " - ");
                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                i++;
            }
        }
        else {
            System.out.println("Not found");
        }
    }
    public int deleteStudent(int personID) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        //this.readStudents();
        return result;
    }
//    public static void main(String[] args) {
//        StudentDAL dal = new StudentDAL();
////        try {
////            dal.readStudents();
////        } catch (SQLException ex) {
////            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        Student student = new Student();
//        student.setFirstName("Tran Khoi");
//        student.setLastName("Nguyen");
//        student.setEnrollmentDate(java.sql.Date.valueOf("2003-10-15"));
//        try {
//            dal.readStudents();
//            //dal.insertStudent(student);
//            //dal.deleteStudent(37);
//            dal.readStudents();
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
