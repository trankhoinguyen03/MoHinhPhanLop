/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public ArrayList<Integer> getListDepartmentId() {
        return courseDAL.getListDepartmentId();
    }

    public boolean addCourse(Course course) {
        return courseDAL.addCourse(course);
    }

    public int getLastCourseId() throws SQLException {
        return courseDAL.getLastCourseId();
    }

    public boolean updateCourse(Course course) {
        return courseDAL.updateCourse(course);
    }

    public String checkValue(Course course) {
        if ("".equals(course.getTitle())) {
            return "Title not null!";
        } else if (course.getCredits() <= 0 || course.getCredits() > 4) {
            return "Credits must be numbers 1 through 4!";
        }
        return "valid";
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

    public ArrayList<Course> loadData() throws Exception {
        return courseDAL.loadDatabase();
    }

    public Course findElement(int id) throws Exception {
        ArrayList<Course> list = courseDAL.loadDatabase();
        for (Course co : list) {
            if (co.getCourseId() == id) {
                return co;
            }
        }
        return null;
    }

    public List<String> getCourseIDs() {
        return courseDAL.getCourseIDs();
    }

}
