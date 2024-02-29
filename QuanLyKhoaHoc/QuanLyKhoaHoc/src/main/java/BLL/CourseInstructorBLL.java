/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseInstructorDAL;
import DTO.Course;
import DTO.CourseInstructor;
import DTO.Lecturers;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HuynhQuocTien
 */
public class CourseInstructorBLL {
    private CourseInstructorDAL dal=new CourseInstructorDAL();
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
       
        ArrayList<CourseInstructor> data = new ArrayList<CourseInstructor>();
        data=dal.loadDatabase();
        return data;
    }
    public boolean updateCourseInstructor(CourseInstructor csinOld, CourseInstructor csinNew) throws Exception{
                if(csinOld.getCourseID()==csinNew.getCourseID() && csinOld.getPersonID()== csinNew.getPersonID())
                    return false;
                try {                   
                    dal.updateCourseInstructor(csinOld,csinNew);
                    return true;
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat CourseInstructor vao database !!!");
                   
                }
                
                return false;
            
    }
     public ArrayList<CourseInstructor> searchCourseInstructor(String keyword)
    {
        ArrayList<CourseInstructor> searchID = new ArrayList<>();
        searchID.addAll(dal.findByChar(keyword));
        return searchID;
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
}
