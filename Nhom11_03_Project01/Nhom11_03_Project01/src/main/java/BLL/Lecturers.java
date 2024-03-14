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
public class Lecturers {
    private String firstName, lastName;
    private int personId;
    private String hireDate;
    
    public Lecturers() {
    }

    public Lecturers(int personId, String firstName, String lastName, String hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
        this.hireDate = hireDate;
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

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    @Override
    public String toString() {
        return this.lastName + " " + this.firstName;
    }
    
}
