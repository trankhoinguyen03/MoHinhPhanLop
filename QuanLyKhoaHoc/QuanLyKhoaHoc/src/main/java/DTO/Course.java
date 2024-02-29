/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author HOME
 */
public class Course {
     private int CourseId;
    private String Title;
    private int Credits;
    private int DepartmentId;
    
    public Course() {
    }

    public Course(int CourseId, String Title, int Credits, int DepartmentId) {
        this.CourseId = CourseId;
        this.Title = Title;
        this.Credits = Credits;
        this.DepartmentId = DepartmentId;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }
    @Override
    public String toString() {
        return getTitle();
    }
    
}
