/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnlineCourse;
import DAL.OnsiteCourse;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class CourseBLL {
    CourseDAL dal;
    
    public CourseBLL() {
        dal = new CourseDAL();
    }
    public void readOnlineCourse() throws SQLException {
        dal.readOnlineCourse();
    }
    public void readOnsiteCourse() throws SQLException {
        dal.readOnsiteCourse();
    }
    public int updateOnlineCourse(OnlineCourse s) throws SQLException {
        return dal.updateOnlineCourse(s);
    }
    public int updateOnsiteCourse(OnsiteCourse s) throws SQLException {
        return dal.updateOnsiteCourse(s);
    }
    public int insertCourse(OnlineCourse s) throws SQLException {
        return dal.insertCourse(s);
    }
    public int insertCourse(OnsiteCourse s) throws SQLException {
        return dal.insertCourse(s);
    }
    public void findCourse(String title) throws SQLException {
        dal.findCourse(title);
    }
    public int deleteCourse(int courseID) throws SQLException {
        return dal.deleteCourse(courseID);
    }
}
