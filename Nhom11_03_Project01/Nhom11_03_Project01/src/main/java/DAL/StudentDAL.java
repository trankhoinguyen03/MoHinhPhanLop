/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public ArrayList<Student> readStudents() throws SQLException {
        ArrayList<Student> list = new ArrayList<>();
        String query ="SELECT * FROM  Person WHERE EnrollmentDate > 0 ;";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student cs = new Student(
                    rs.getInt("PersonID"),
                    rs.getString("LastName"),
                    rs.getString("FirstName"),
                    rs.getString("EnrollmentDate")
                );
                list.add(cs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean updateStudent(Student s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "+ " WHERE PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonId());
        int result = p.executeUpdate();
        return result > 0;
    }
    public boolean insertStudent(Student s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, EnrollmentDate) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getEnrollmentDate());
        int result = p.executeUpdate();
        return result > 0;
    }
    public boolean deleteStudent(int personID) throws SQLException {
        String query = "DELETE FROM person WHERE EnrollmentDate > 0 AND "
                + "PersonID = ? AND "
                + "NOT EXISTS (SELECT 1 FROM studentgrade WHERE person.PersonID = studentgrade.StudentID)";
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        return result > 0;
    }
    public List<String> getStudentIDs() {
        List<String> personID = new ArrayList<>();

        String query = "SELECT PersonID FROM Person";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                personID.add(rs.getString("PersonID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personID;
    }
}
