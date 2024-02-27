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
public class OnlineCourseDAL extends MyDatabaseManager {
    
    public OnlineCourseDAL() {
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
    public int insertOnlineCourse(OnlineCourse s) throws SQLException {
        String query = "Insert OnlineCourse (url) VALUES (?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getUrl());
        int result = p.executeUpdate();
        return result;
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
}
