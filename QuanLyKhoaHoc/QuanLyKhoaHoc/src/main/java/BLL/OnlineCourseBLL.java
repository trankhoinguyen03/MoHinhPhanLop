/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnlineCourse;
import DAL.OnlineCourseDAL;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class OnlineCourseBLL {
    OnlineCourseDAL dal;

    public OnlineCourseBLL() {
        dal = new OnlineCourseDAL();
    }
    public void readOnlineCourse() throws SQLException {
        dal.readOnlineCourse();
    }
    public int updateOnlineCourse(OnlineCourse s) throws SQLException {
        return dal.updateOnlineCourse(s);
    }
    public int insertCourse(OnlineCourse s) throws SQLException {
        return dal.insertCourse(s);
    }    
}
