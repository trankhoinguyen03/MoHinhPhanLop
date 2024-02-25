/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class CourseDAL extends MyDatabaseManager{
    
    public CourseDAL() {
        super();
        this.connectDB();
    }
    
    public void readOnlineCourse() throws SQLException {
        String query = "SELECT * FROM Course INNER JOIN OnlineCourse ON Course.CourseID = OnlineCourse.CourseID;";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            //int i = 1;
            while (rs.next()) {
//                System.out.print(rs.getString("PersonId") + " - ");
//                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
//                //i++;
            }
        }
    }
    public void readOnsiteCourse() throws SQLException {
        String query = "SELECT * FROM Course INNER JOIN OnsiteCourse ON Course.CourseID = OnsiteCourse.CourseID;";
        ResultSet rs = this.doReadQuery(query);
        if (rs != null) {
            //int i = 1;
            while (rs.next()) {
//                System.out.print(rs.getString("PersonId") + " - ");
//                System.out.println(rs.getString("Lastname") + " " + rs.getString("Firstname"));
//                //i++;
            }
        }
    }
    public int updateOnlineCourse(OnlineCourse s) throws SQLException {
        String query = "UPDATE Course\n" +
                        "INNER JOIN OnlineCourse ON Course.CourseID = OnlineCourse.CourseID\n" +
                        "SET Title = ?, Credits = ?, DepartmentID = ?, url = ?" +
                        "WHERE OnlineCourse.CourseID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getTitle());
        p.setInt(2, s.getCredits());
        p.setInt(3, s.getDepartmentId());
        p.setString(4, s.getUrl());
        int result = p.executeUpdate();
        return result;
    }
    public int updateOnsiteCourse(OnsiteCourse s) throws SQLException {
        String query = "UPDATE Course\n" +
                        "INNER JOIN OnsiteCourse ON Course.CourseID = OnsiteCourse.CourseID\n" +
                        "SET Title = ?, Credits = ?, DepartmentID = ?, Location = ?, Days = ?, Time = ?" +
                        "WHERE OnsiteCourse.CourseID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getTitle());
        p.setInt(2, s.getCredits());
        p.setInt(3, s.getDepartmentId());
        p.setString(4, s.getLocation());
        p.setString(5, s.getDays());
        p.setString(6, s.getTime().toString());
        int result = p.executeUpdate();
        return result;
    }
    public int insertCourse(OnlineCourse s) throws SQLException {
        String query = "Insert Course (Title, Credits, DepartmentID) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getTitle());
        p.setInt(2, s.getCredits());
        p.setInt(3, s.getDepartmentId());
        int result = p.executeUpdate();
        insertOnlineCourse(s);
        return result;
    }
        public int insertCourse(OnsiteCourse s) throws SQLException {
        String query = "Insert Course (Title, Credits, DepartmentID) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getTitle());
        p.setInt(2, s.getCredits());
        p.setInt(3, s.getDepartmentId());
        int result = p.executeUpdate();
        insertOnsiteCourse(s);
        return result;
    }
    public int insertOnlineCourse(OnlineCourse s) throws SQLException {
        String query = "Insert OnlineCourse (url) VALUES (?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getUrl());
        int result = p.executeUpdate();
        return result;
    }
    public int insertOnsiteCourse(OnsiteCourse s) throws SQLException {
        String query = "Insert OnsiteCourse (Location, Days, Time) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getLocation());
        p.setString(2, s.getDays());
        p.setString(3, s.getTime().toString());
        int result = p.executeUpdate();
        return result;
    }
    public void findCourse(String title) throws SQLException {
        String query = "SELECT * FROM Course INNER JOIN OnlineCourse ON Course.CourseID = OnlineCourse.CourseID WHERE Title LIKE ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, title);
        ResultSet rs = p.executeQuery();
        if (rs != null) {

        }
        else {
            query = "SELECT * FROM Course INNER JOIN OnsiteCourse ON Course.CourseID = OnsiteCourse.CourseID WHERE Title LIKE ?";
            p = c.prepareStatement(query);
            p.setString(1, title);
            rs = p.executeQuery();
            if(rs != null) {
                
            }
            else {
                System.out.println("Not found");
            }
        }
    }
    public int deleteCourse(int courseID) throws SQLException {
        String query = "DELETE FROM OnlineCourse WHERE CourseID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();
        if(result == 0) {
            query = "DELETE FROM OnlineCourse WHERE CourseID = ?";
            p = c.prepareStatement(query);
            p.setInt(1, courseID);
            result = p.executeUpdate();
            if(result == 0) {
                System.out.println("Delete fail");
            }
        }
        else {
            query = "DELETE FROM Course WHERE CourseID = ?";
            p = c.prepareStatement(query);
            p.setInt(1, courseID);
            result = p.executeUpdate();
        }
        return result;
    }
}
