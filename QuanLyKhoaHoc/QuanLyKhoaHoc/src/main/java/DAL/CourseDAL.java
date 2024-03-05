/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class CourseDAL extends MyDatabaseManager {

    public CourseDAL() {
        super();
        this.connectDB();
    }  
    public ArrayList<Course> loadDatabase() throws Exception {
        ArrayList<Course> list = new ArrayList<>();
        Statement st = c.createStatement(); 
        String query ="SELECT * FROM  Course ";
        try {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Course cs = new Course(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                         rs.getInt("DepartmentID")
                );
                list.add(cs);
            }
            rs.close();
            

        } catch (SQLException ex) {
            System.out.println("Khong the load database Course: " + ex);
        }

        return list;
    }
    public ArrayList<Course> getList() {
        ArrayList list = new ArrayList<Course>();
        String query = "select *from Course";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Course value = new Course();
                value.setCourseId(rs.getInt(1));
                value.setTitle(rs.getString(2));
                value.setCredits(rs.getInt(3));
                value.setDepartmentId(rs.getInt(4));
                list.add(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Integer> getListDepartmentId() {
        ArrayList list = new ArrayList<Integer>();
        String query = "select *from department";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {              
                int value= rs.getInt(1);
                list.add(value);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean addCourse(Course value) {
        try {
            String query = "Insert into Course (Title, Credits, DepartmentID ) VALUES(?,?,?)";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setNString(1, value.getTitle());
            pst.setInt(2, value.getCredits());
            pst.setInt(3, value.getDepartmentId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int getLastCourseId() throws SQLException {
        String query = "Select Max(CourseId) From Course";
        PreparedStatement pst = c.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt(1);
            return id;
        } else {
            // Xử lý trường hợp không có dữ liệu, ví dụ:
            throw new SQLException("No data found");
        }
    }
    
    public boolean updateCourse(Course value) {
        try {
            String query = "update Course set Title=?, Credits=?, DepartmentID=? where CourseID=? ";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setNString(1, value.getTitle());
            pst.setInt(2, value.getCredits());
            pst.setInt(3, value.getDepartmentId());
            pst.setInt(4, value.getCourseId());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int deleteCourse(int value) {
        try {
            String query = "update Course set Title=? where CourseID=?";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setNString(1, "null");
            pst.setInt(2, value);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
