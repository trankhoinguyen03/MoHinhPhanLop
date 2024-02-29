/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.OnsiteCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class OnsiteCourseDAL extends MyDatabaseManager {
    
    public OnsiteCourseDAL() {
        super();
        this.connectDB();
    }
    public ArrayList<OnsiteCourse> getList() {
        ArrayList list = new ArrayList<OnsiteCourse>();
        String query = "select *from onsitecourse";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OnsiteCourse value = new OnsiteCourse();
                value.setCourseId(rs.getInt(1));
                value.setLocation(rs.getString(2));
                value.setDays(rs.getString(3));
                value.setTime(rs.getString(4));               
                list.add(value);              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int addOnsiteCourse(OnsiteCourse value) {
        try {
            String query= "Insert into onsitecourse (CourseID, Location, Days, Time ) VALUES(?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setInt(1, value.getCourseId());
            pst.setNString(2, value.getLocation());
            pst.setNString(3, value.getDays());
            pst.setString(4, value.getTime().toString());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int updateOnsiteCourse(OnsiteCourse value){
        try {
            String query= "update onsitecourse set Location=?, Days=?, Time=?  where CourseID=? ";
            PreparedStatement pst= c.prepareStatement(query);
            pst.setNString(1, value.getLocation());
            pst.setNString(2, value.getDays());
            pst.setString(3, value.getTime().toString());
            pst.setInt(4, value.getCourseId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int deleteOnsiteCourse(int value){
        try {
            String query="delete from onsitecourse where CourseID=?";
            PreparedStatement pst= c.prepareStatement(query);
            pst.setInt(1, value);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }    
}
