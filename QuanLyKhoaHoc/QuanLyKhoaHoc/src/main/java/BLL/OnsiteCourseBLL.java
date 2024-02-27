/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.OnsiteCourse;
import DAL.OnsiteCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class OnsiteCourseBLL {
    OnsiteCourseDAL onsiteCourseDAL = new OnsiteCourseDAL();

    public ArrayList<OnsiteCourse> getList() {
        return onsiteCourseDAL.getList();
    }

    public int addCourse(OnsiteCourse value) {
        if (value.getCourseId() <= 0 ) {
            JOptionPane.showMessageDialog(null, "CourseId must be positive");
            return 0;
        }
        for (OnsiteCourse x : this.getList()) {
            if (x.getCourseId() == value.getCourseId()) {
                JOptionPane.showMessageDialog(null, "CourseId already exists");
                return 0;
            }
        }
        return onsiteCourseDAL.addOnsiteCourse(value);
    }

    public int updateCourse(OnsiteCourse value) {
        if (value.getCourseId() <= 0) {
            JOptionPane.showMessageDialog(null, "CourseId must be positive");
            return 0;
        }
        boolean flag=false;
        for (OnsiteCourse x : this.getList()) {
            if (x.getCourseId() == value.getCourseId()) {
                flag=true;
            }
        }
        if(flag==false){
           JOptionPane.showMessageDialog(null, "CourseId does not exist yet");
           return 0;
        }
        return onsiteCourseDAL.updateOnsiteCourse(value);
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
    public ArrayList<OnsiteCourse> searchCourse(String value){
        ArrayList<OnsiteCourse> list= new ArrayList<OnsiteCourse>();
        for (OnsiteCourse x : this.getList()) {
            String id= Integer.toString(x.getCourseId()).toLowerCase();   
            String time= x.getTime().toString().toLowerCase();
            if(id.contains(value.toLowerCase())|| x.getLocation().toLowerCase().contains(value.toLowerCase())|| x.getDays().toLowerCase().contains(value.toLowerCase())|| time.contains(value.toLowerCase())){
                list.add(x);
            }
        }
        return list;
    }
}
