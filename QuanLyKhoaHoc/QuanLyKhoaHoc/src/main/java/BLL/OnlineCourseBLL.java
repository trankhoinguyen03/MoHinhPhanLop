/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.OnlineCourse;
import DAL.OnlineCourseDAL;
import DTO.Course;
import java.net.MalformedURLException;
import java.net.URL;
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
        if(checkValue(value.getUrl())) {
            return onlineCourseDAL.addOnlineCourse(value);
        }
        return 0;
    }

    public int updateCourse(OnlineCourse value) {
        if(checkValue(value.getUrl())) {
            return onlineCourseDAL.updateOnlineCourse(value);
        }
        return 0;
    }
    
    public boolean checkValue(String url) {
        if("".equals(url)) {
            JOptionPane.showMessageDialog(null, "url not null!");
            return false;
        }
        else {
            try {
                new URL(url);
            } catch (MalformedURLException e) {
                JOptionPane.showMessageDialog(null, "url not invalid!");
                return false;
            }
        }
        return true;
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
    public ArrayList<Course> searchCourse(){
        ArrayList<Course> searchList= new ArrayList<>();
        for (Course x : courseDAL.getList()) {
            for(OnlineCourse y : getList()) {
                if(x.getCourseId() == y.getCourseId()){
                    searchList.add(x);
                }
            }               
        }
        return searchList;
    }
}
