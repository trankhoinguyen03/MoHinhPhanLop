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
public class OnsiteCourseDAL extends MyDatabaseManager {
    
    public OnsiteCourseDAL() {
        super();
        this.connectDB();
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
    public int insertOnsiteCourse(OnsiteCourse s) throws SQLException {
        String query = "Insert OnsiteCourse (Location, Days, Time) VALUES (?, ?, ?)";
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, s.getLocation());
        p.setString(2, s.getDays());
        p.setString(3, s.getTime().toString());
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
}
