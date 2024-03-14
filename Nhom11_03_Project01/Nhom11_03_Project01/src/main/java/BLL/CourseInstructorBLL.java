/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseInstructorDAL;
import BLL.Course;
import BLL.CourseInstructor;
import BLL.Lecturers;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HuynhQuocTien
 */
public class CourseInstructorBLL {
    private static CourseInstructorDAL dal = new CourseInstructorDAL();
    CourseInstructor saveCiold;
    public CourseInstructorBLL() {
    }
    
    public String printNameByPerson(int id){
        return dal.findNameByPerson(id);
    }
    public String printNameByCourse(int id){
        return dal.findNameByCourse(id);
    }
    public CourseInstructor getCourseInstructorByIDCourse(String idcourse, String idPerson){
        return dal.findCourseInstructorByIDCourse(idcourse, idPerson);
    }
    public ArrayList<CourseInstructor>  loadDSCourseInstructor() throws Exception{
       
        return dal.loadDatabase();
    }
    public boolean updateCourseInstructor(CourseInstructor csinOld, CourseInstructor csinNew) throws Exception{
                if(csinOld.getCourseID()==csinNew.getCourseID() && csinOld.getPersonID()== csinNew.getPersonID())
                    return false;
                try {                   
                    return dal.updateCourseInstructor(csinOld,csinNew);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat CourseInstructor vao database !!!");   
                }
                
                return false;
            
    }
     public ArrayList<CourseInstructor> searchCourseInstructor(String keyword)
    {
         return dal.findByChar(keyword);
    }
     public void saveold(int id,String Title,int personID,String fullName){
         this.saveCiold = new CourseInstructor(id,Title,personID,fullName);
     }
     public CourseInstructor returnOld(){
         return this.saveCiold;
     }
     public void resetCourseIOld(){
         this.saveCiold = new CourseInstructor();
     }
     public CourseInstructor getCourseInstructorNewByID(Course cour, Lecturers pers){
        return new CourseInstructor(cour.getCourseId(),cour.getTitle(),pers.getPersonId(),pers.toString());
    }
    public static boolean addCourseInstructor( int idcorse, int idperson) throws SQLException {
        return dal.addCourseInstructor(  idcorse, idperson);
    }
    public static int checkAddCourseInstructor( int idcourse, int idperson) throws SQLException {
        return dal.checkAddCourseInstructor( idcourse, idperson);
    }
    public static int deleteCourseInstructor( int idcorse, int idperson) throws SQLException {
        return dal.deleteCourseInstructor(  idcorse, idperson);
    }

}
