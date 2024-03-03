/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
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
        if (checkValue(value.getTitle(), value.getCredits())) {
            return courseDAL.addCourse(value);
        }
        return 0;
    }
    
    public int getLastCourseId() throws SQLException {
        return courseDAL.getLastCourseId();
    }

    public int updateCourse(Course value) {
        if (checkValue(value.getTitle(), value.getCredits())) {
            return courseDAL.updateCourse(value);
        }
        return 0;
    }
    
    public boolean checkValue(String title, int credits) {
        if("".equals(title)) {
            JOptionPane.showMessageDialog(null, "Title not null!");
            return false;
        }
        else if(credits <= 0) {
            JOptionPane.showMessageDialog(null, "Credits must be numbers 1 through 4!");
            return false;
        }
        return true;
    }

    public int deleteCourse(int value) {
        return courseDAL.deleteCourse(value);
    }

    public ArrayList<Course> searchCourse(String value) {
        ArrayList<Course> list = new ArrayList<>();
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
