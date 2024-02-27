/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
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
    public void findCourse(String title) throws SQLException {
        dal.findCourse(title);
    }
    public int deleteCourse(int courseID) throws SQLException {
        return dal.deleteCourse(courseID);
    }
}
