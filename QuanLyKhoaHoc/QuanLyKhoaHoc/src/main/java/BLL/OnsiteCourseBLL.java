/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.OnsiteCourse;
import DAL.OnsiteCourseDAL;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class OnsiteCourseBLL {
    OnsiteCourseDAL dal;

    public OnsiteCourseBLL() {
        dal = new OnsiteCourseDAL();
    }    
    public void readOnsiteCourse() throws SQLException {
        dal.readOnsiteCourse();
    }
    public int updateOnsiteCourse(OnsiteCourse s) throws SQLException {
        return dal.updateOnsiteCourse(s);
    }
    public int insertCourse(OnsiteCourse s) throws SQLException {
        return dal.insertCourse(s);
    }
}
