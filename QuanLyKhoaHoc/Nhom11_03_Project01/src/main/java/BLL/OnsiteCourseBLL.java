/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnsiteCourseDAL;
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

    public boolean addCourse(OnsiteCourse onsite) {
        return onsiteCourseDAL.addOnsiteCourse(onsite);
    }

    public boolean updateCourse(OnsiteCourse onsite) {
        return onsiteCourseDAL.updateOnsiteCourse(onsite);
    }
    
    public String checkValue(OnsiteCourse onsite) {
        if("".equals(onsite.getLocation())) {
            return "location not null!";
        }
        else if("".equals(onsite.getDays())) {
            return "days not null!";
        }
        else if(!onsite.getDays().matches("[MTWHFS]*")) {
            return "days must only contain M T W H F S";
        }
        else if("".equals(onsite.getTime())) {
            return "time not null!";
        }
        else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:00");
                LocalTime.parse(onsite.getTime(), formatter);
            } catch (DateTimeParseException e) {
                return "Invalid time!";
            }
        }
        return "valid";
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
