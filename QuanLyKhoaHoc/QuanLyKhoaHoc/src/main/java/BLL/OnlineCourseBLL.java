/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.OnlineCourse;
import DAL.OnlineCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class OnlineCourseBLL {
    CourseDAL courseDAL= new CourseDAL();
    OnlineCourseDAL onlineCourseDAL = new OnlineCourseDAL();

    public ArrayList<OnlineCourse> getList() {
        return onlineCourseDAL.getList();
    }

    public int addCourse(OnlineCourse value) {
        if (value.getCourseId() <= 0 ) {
            JOptionPane.showMessageDialog(null, "CourseId must be positive");
            return 0;
        }
        for (OnlineCourse x : this.getList()) {
            if (x.getCourseId() == value.getCourseId()) {
                JOptionPane.showMessageDialog(null, "CourseId already exists");
                return 0;
            }
        }
        return onlineCourseDAL.addOnlineCourse(value);
    }

    public int updateCourse(OnlineCourse value) {
        if (value.getCourseId() <= 0) {
            JOptionPane.showMessageDialog(null, "CourseId must be positive");
            return 0;
        }
        boolean flag=false;
        for (OnlineCourse x : this.getList()) {
            if (x.getCourseId() == value.getCourseId()) {
                flag=true;
            }
        }
        if(flag==false){
           JOptionPane.showMessageDialog(null, "CourseId does not exist yet");
           return 0;
        }
        return onlineCourseDAL.updateOnlineCourse(value);
    }

    public int deleteCourse(int value) {
        boolean flag=false;
        for (OnlineCourse x : this.getList()) {
            if (x.getCourseId() == value) {
                flag=true;
            }
        }
        if(flag==false){
           JOptionPane.showMessageDialog(null, "CourseId does not exist yet");
           return 0;
        }
        return onlineCourseDAL.deleteOnlineCourse(value);
    }
    public ArrayList<OnlineCourse> searchCourse(String value){
        ArrayList<OnlineCourse> list= new ArrayList<OnlineCourse>();
        for (OnlineCourse x : this.getList()) {
            String id= Integer.toString(x.getCourseId()).toLowerCase();                    
            if(id.contains(value.toLowerCase())|| x.getUrl().toLowerCase().contains(value.toLowerCase())){
                list.add(x);
            }
        }
        return list;
    }
}
