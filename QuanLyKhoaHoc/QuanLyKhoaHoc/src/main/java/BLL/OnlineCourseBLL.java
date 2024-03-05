/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
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

    public boolean addCourse(OnlineCourse online) {
        return onlineCourseDAL.addOnlineCourse(online);
    }

    public boolean updateCourse(OnlineCourse online) {
        return onlineCourseDAL.updateOnlineCourse(online);
    }
    
    public String checkValue(OnlineCourse online) {
        if("".equals(online.getUrl())) {
            return "Url not null!";
        }
        else {
            try {
                new URL(online.getUrl());
            } catch (MalformedURLException e) {
                return "Invalid url!";
            }
        }
        return "valid";
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
