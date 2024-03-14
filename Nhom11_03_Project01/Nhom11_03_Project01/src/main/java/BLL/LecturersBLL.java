/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.LecturersDAL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class LecturersBLL {
    LecturersDAL dal;
    
    public LecturersBLL() {
        dal = new LecturersDAL();
    }
    
    public ArrayList<Lecturers> readLecturers() throws SQLException {
        return dal.readLecturers();
    }
    public boolean updateLecturers(Lecturers s) throws SQLException {
        return dal.updateLecturers(s);
    }
    public boolean insertLecturers(Lecturers s) throws SQLException {
        return dal.insertLecturers(s);
    }
    public String checkValue(Lecturers s) {
        if("".equals(s.getFirstName())) {
            return "first name not null!";
        }
        else if("".equals(s.getLastName())) {
            return "last name not null!";
        }
        else if("".equals(s.getHireDate())) {
            return "date not null!";
        }
        else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate.parse(s.getHireDate(), formatter);
            } catch (DateTimeParseException e) {
                return "Invalid date!";
            }
        }
        return "valid";
    }
    public ArrayList<Lecturers> searchLecturers(String value) throws SQLException {
        ArrayList<Lecturers> list = new ArrayList<>();
        for (Lecturers x : readLecturers()) {
            String id = Integer.toString(x.getPersonId()).toLowerCase();
            String firtName = x.getFirstName().toLowerCase();
            String lastName = x.getLastName().toLowerCase();
            String hireDate = x.getHireDate().toLowerCase();
            if (id.contains(value.toLowerCase()) || firtName.contains(value.toLowerCase()) || lastName.contains(value.toLowerCase()) || hireDate.contains(value.toLowerCase())) {
                list.add(x);
            }
        }
        return list;
    }
    public boolean deleteLecturers(int personID) throws SQLException {
        return dal.deleteLecturers(personID);
    }
    public ArrayList<Lecturers> loadData() throws Exception{
        return dal.loadDatabase();
    }
    public Lecturers findElement(int id) throws Exception{
        ArrayList<Lecturers> list = dal.loadDatabase();
        for(Lecturers ps : list){
            if(ps.getPersonId() == id)
                return ps;
        }
        return null;
    }
}
