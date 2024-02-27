/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.OnlineCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class OnlineCourseDAL extends MyDatabaseManager {
    
    public OnlineCourseDAL() {
        super();
        this.connectDB();
    }
    
    public ArrayList<OnlineCourse> getList() {
        ArrayList list = new ArrayList<OnlineCourse>();
        String query = "select *from onlinecourse";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OnlineCourse value = new OnlineCourse();
                value.setCourseId(rs.getInt(1));
                value.setUrl(rs.getString(2));              
                list.add(value);              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int addOnlineCourse(OnlineCourse value) {
        try {
            String query= "Insert into onlinecourse (CourseID, url ) VALUES(?,?)";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setInt(1, value.getCourseId());
            pst.setNString(2, value.getUrl());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int updateOnlineCourse(OnlineCourse value){
        try {
            String query= "update onlinecourse set url=? where CourseID=? ";
            PreparedStatement pst= c.prepareStatement(query);
            pst.setNString(1, value.getUrl());
            pst.setInt(2, value.getCourseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int deleteOnlineCourse(int value){
        try {
            String query="delete from onlinecourse where CourseID=?";
            PreparedStatement pst= c.prepareStatement(query);
            pst.setInt(1, value);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
