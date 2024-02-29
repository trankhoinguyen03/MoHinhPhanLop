/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class Lecturers {
    String firstName, lastName;
    int personId;
    Date hireDate;
    Date enrollmentDate;
    public Lecturers() {
    }

    public Lecturers(String firstName, String lastName, int personId, Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
        this.hireDate = hireDate;
    }

    public Lecturers(int personId,String lastName,String firstName,  Date hireDate,Date EnrollmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
        this.hireDate = hireDate;
        this.enrollmentDate=EnrollmentDate;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    @Override
    public String toString() {
        return this.lastName + " " + this.firstName;
    }
    
}
