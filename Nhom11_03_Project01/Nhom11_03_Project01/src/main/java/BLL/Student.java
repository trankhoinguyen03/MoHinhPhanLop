/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class Student {
    String firstName, lastName;
    int personId;
    String enrollmentDate;
    public Student() {
        
    }

    public Student(int personId, String firstName, String lastName, String enrollmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
        this.enrollmentDate = enrollmentDate;
    }

    
    
    public String getName() {
        return firstName + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
}
