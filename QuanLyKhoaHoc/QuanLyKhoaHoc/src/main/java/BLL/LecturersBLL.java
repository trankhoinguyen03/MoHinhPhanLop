/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Lecturers;
import DAL.LecturersDAL;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class LecturersBLL {
    LecturersDAL dal;
    
    public LecturersBLL() {
        dal = new LecturersDAL();
    }
    
    public void readLecturers() throws SQLException {
        dal.readLecturers();
    }
    public int updateLecturers(Lecturers s) throws SQLException {
        return dal.updateLecturers(s);
    }
    public int insertLecturers(Lecturers s) throws SQLException {
        return dal.insertLecturers(s);
    }
    public void findLecturers(String fullName) throws SQLException {
        dal.findLecturers(fullName);
    }
    public int deleteLecturers(int personID) throws SQLException {
        return dal.deleteLecturers(personID);
    }
}
