/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.Course;
import DTO.Lecturers;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class CourseBLL {

    CourseDAL courseDAL = new CourseDAL();

    public ArrayList<Course> getList() {
        return courseDAL.getList();
    }
    public ArrayList<Integer> getListDepartmentId(){
        return courseDAL.getListDepartmentId();
    }

    public int addCourse(Course value) {
        if (value.getCourseId() <= 0 || value.getCredits() <= 0 || value.getDepartmentId() <= 0) {
            JOptionPane.showMessageDialog(null, "CourseId, Credits, DepartmentId must be positive");
            return 0;
        }
        for (Course x : this.getList()) {
            if (x.getCourseId() == value.getCourseId()) {
                JOptionPane.showMessageDialog(null, "CourseId already exists");
                return 0;
            }
        }
        return courseDAL.addCourse(value);
    }
    
    public int getLastCourseId() throws SQLException {
        return courseDAL.getLastCourseId();
    }

    public int updateCourse(Course value) {
        if (value.getCourseId() <= 0 || value.getCredits() <= 0 || value.getDepartmentId() <= 0) {
            JOptionPane.showMessageDialog(null, "CourseId, Credits, DepartmentId must be positive");
            return 0;
        }
        boolean flag = false;
        for (Course x : this.getList()) {
            if (x.getCourseId() == value.getCourseId()) {
                flag = true;
            }
        }
        if (flag == false) {
            JOptionPane.showMessageDialog(null, "CourseId does not exist yet");
            return 0;
        }
        return courseDAL.updateCourse(value);
    }

    public int deleteCourse(int value) {
        return courseDAL.deleteCourse(value);
    }

    public ArrayList<Course> searchCourse(String value) {
        ArrayList<Course> list = new ArrayList<Course>();
        for (Course x : this.getList()) {

            String id = Integer.toString(x.getCourseId()).toLowerCase();
            String credits = Integer.toString(x.getCredits()).toLowerCase();
            String department = Integer.toString(x.getDepartmentId()).toLowerCase();
            if (id.contains(value.toLowerCase()) || x.getTitle().toLowerCase().contains(value.toLowerCase()) || credits.contains(value.toLowerCase()) || department.contains(value.toLowerCase())) {
                list.add(x);
            }
        }
        return list;
    }
     public ArrayList<Course> loadData() throws Exception{
        return courseDAL.loadDatabase();
    }
      public Course findElement(int id) throws Exception{
        ArrayList<Course> list = courseDAL.loadDatabase();
        for(Course co : list){
            if(co.getCourseId() == id)
                return co;
        }
        return null;
    } 
    
    
}
