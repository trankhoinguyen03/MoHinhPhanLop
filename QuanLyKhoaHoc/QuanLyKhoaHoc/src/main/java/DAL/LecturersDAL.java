/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Lecturers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                    rs.getDate("HireDate")
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
        PreparedStatement p = c.prepareStatement(query); 
        try {
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Lecturers cs = new Lecturers(
                    rs.getInt("PersonID"),
                    rs.getString("LastName"),
                    rs.getString("FirstName"),
                    rs.getDate("HireDate")
                );
                list.add(cs);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Khong the load database person: " + ex);
        }

        return list;
    }
    public int updateLecturers(Lecturers s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "+ " WHERE PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonId());
        int result = p.executeUpdate();
        return result;
    }
    public int insertLecturers(Lecturers s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, HireDate) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getHireDate().toString());
        int result = p.executeUpdate();
        return result;
    }
    public void findLecturers(String fullName) throws SQLException {
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
    public int deleteLecturers(int personID) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        //this.readLecturerss();
        return result;
    }
}
