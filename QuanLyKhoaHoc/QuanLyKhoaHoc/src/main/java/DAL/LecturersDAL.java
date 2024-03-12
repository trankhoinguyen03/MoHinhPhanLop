/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Lecturers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class LecturersDAL extends MyDatabaseManager {

    public LecturersDAL() {
        super();
        this.connectDB();
    }
    public ArrayList<Lecturers> loadDatabase() throws Exception {
        ArrayList<Lecturers> list = new ArrayList<>();
        Statement st = c.createStatement(); 
        String query ="SELECT * FROM  Person WHERE HireDate >0 ;";
        try {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Lecturers cs = new Lecturers(
                    rs.getInt("PersonID"),
                    rs.getString("LastName"),
                    rs.getString("FirstName"),
                    rs.getString("HireDate")
                );
                list.add(cs);
            }
            rs.close();
            

        } catch (SQLException ex) {
            System.out.println("Khong the load database person: " + ex);
        }

        return list;
    }
    public ArrayList<Lecturers> readLecturers() throws SQLException {
        ArrayList<Lecturers> list = new ArrayList<>();
        String query ="SELECT * FROM  Person WHERE HireDate >0 ;";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lecturers cs = new Lecturers(
                    rs.getInt("PersonID"),
                    rs.getString("LastName"),
                    rs.getString("FirstName"),
                    rs.getString("HireDate")
                );
                list.add(cs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean updateLecturers(Lecturers s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "+ " WHERE PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonId());
        int result = p.executeUpdate();
        return result > 0;
    }
    public boolean insertLecturers(Lecturers s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, HireDate) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getHireDate());
        int result = p.executeUpdate();
        return result > 0;
    }
    public boolean deleteLecturers(int personID) throws SQLException {
        String query = "DELETE FROM person WHERE HireDate > 0 AND "
                + "PersonID = ? AND "
                + "NOT EXISTS (SELECT 1 FROM courseinstructor WHERE person.PersonID = courseinstructor.PersonID)";
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        //this.readLecturerss();
        return result > 0;
    }
}
