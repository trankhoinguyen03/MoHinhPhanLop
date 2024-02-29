/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.OnsiteCourse;
import DAL.OnsiteCourseDAL;
import DTO.Course;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class OnsiteCourseBLL {
    CourseDAL courseDAL = new CourseDAL();
    OnsiteCourseDAL onsiteCourseDAL = new OnsiteCourseDAL();

    public ArrayList<OnsiteCourse> getList() {
        return onsiteCourseDAL.getList();
    }

    public int addCourse(OnsiteCourse value) {
        if(checkValue(value.getLocation(), value.getDays(), value.getTime())) {
            return onsiteCourseDAL.addOnsiteCourse(value);
        }
        return 0;
    }

    public int updateCourse(OnsiteCourse value) {
        if(checkValue(value.getLocation(), value.getDays(), value.getTime())) {
            return onsiteCourseDAL.updateOnsiteCourse(value);
        }
        return 0;
    }
    
    public boolean checkValue(String location, String days, String time) {
        if("".equals(location)) {
            JOptionPane.showMessageDialog(null, "location not null!");
            return false;
        }
        else if("".equals(days)) {
            JOptionPane.showMessageDialog(null, "days not null!");
            return false;
        }
        else if(!days.matches("[MTWHFS]*")) {
            JOptionPane.showMessageDialog(null, "days must only contain M T W H F S");
            return false;
        }
        else if("".equals(time)) {
            JOptionPane.showMessageDialog(null, "time not null!");
            return false;
        }
        else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:00");
                LocalTime.parse(time, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "time not invalid!");
                return false;
            }
        }
        return true;
    }

    public int deleteCourse(int value) {
        boolean flag=false;
        for (OnsiteCourse x : this.getList()) {
            if (x.getCourseId() == value) {
                flag=true;
            }
        }
        if(flag==false){
           JOptionPane.showMessageDialog(null, "CourseId does not exist yet");
           return 0;
        }
        return onsiteCourseDAL.deleteOnsiteCourse(value);
    }
    public ArrayList<Course> searchCourse(){
        ArrayList<Course> searchList= new ArrayList<>();
        for (Course x : courseDAL.getList()) {
            for(OnsiteCourse y : getList()) {
                if(x.getCourseId() == y.getCourseId()){
                    searchList.add(x);
                }
            }               
        }
        return searchList;
    }
}
