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
