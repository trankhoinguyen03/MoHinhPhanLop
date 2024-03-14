/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.sql.Time;

/**
 *
 * @author Acer
 */
public class OnsiteCourse {
    private int courseId;
    private String location;
    private String days;
    private String time;

    public OnsiteCourse() {
    }

    public OnsiteCourse(int courseId, String location, String days, String time) {
        this.courseId = courseId;
        this.location = location;
        this.days = days;
        this.time = time;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
