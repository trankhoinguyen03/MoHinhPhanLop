/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author HuynhQuocTien
 */
public class CourseInstructorDAL extends MyDatabaseManager{
    public CourseInstructorDAL(){
        super();
        this.connectDB();
    }
    public ArrayList<CourseInstructor> loadDatabase() throws Exception {
        ArrayList<CourseInstructor> list = new ArrayList<>();
        Statement st = c.createStatement(); 
        String query ="SELECT CourseInstructor.CourseID, CourseInstructor.PersonID,"                
                + " CONCAT(Person.LastName, ' ', Person.FirstName) AS Name,Course.Title  "
                + " FROM  Person " 
                + "JOIN CourseInstructor ON Person.PersonID = CourseInstructor.PersonID" 
                + " JOIN Course ON CourseInstructor.CourseID = Course.CourseID ";
        try {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CourseInstructor csin = new CourseInstructor(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("PersonID"),
                         rs.getString("Name")
                );
                list.add(csin);
            }
            rs.close();
            

        } catch (SQLException ex) {
            System.out.println("Khong the load database CourseInstructor: " + ex);
        }

        return list;
    }
     public void updateCourseInstructor(CourseInstructor csinOld, CourseInstructor csinNew) throws Exception {
        
        String sql = "UPDATE CourseInstructor SET CourseID = ?, PersonID = ? WHERE CourseID = ? AND PersonID = ?";        
        try {
            PreparedStatement preparedStatement = c.prepareStatement(sql);

            preparedStatement.setString(1, Integer.toString(csinNew.getCourseID()));
            preparedStatement.setString(2, Integer.toString(csinNew.getPersonID()));
            preparedStatement.setString(3, Integer.toString(csinOld.getCourseID()));
            preparedStatement.setString(4, Integer.toString(csinOld.getPersonID()));
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Khong the Cap nhat CourseInstructor vao database !!!");
        }
    }  
    public String findNameByCourse(int id){
        String sql = " SELECT * FROM Course WHERE CourseID = ?";
        Course csin = null;
        try{
            
           PreparedStatement preparedStatement = c.prepareStatement(sql);
           preparedStatement.setString(1, id + "");
           ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                csin = new Course(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentID")
                );
                
            } 
//            c.close();
        }
        catch (SQLException ex) {
            System.out.println("Khong the tim CourseInstructor  !!!");
        }
        if(csin!=null)
            return csin.getTitle();
        return "";
    }
    public String findNameByPerson(int id){
        String sql = " SELECT * FROM Person WHERE PersonID = ?";
        Lecturers ps = null;
        try{
            
           PreparedStatement preparedStatement = c.prepareStatement(sql);
           preparedStatement.setString(1, id + "");
           ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                ps = new Lecturers(
                        rs.getInt("PersonID"),
                        rs.getString("LastName"),
                        rs.getString("FirstName"),    
                        rs.getDate("HireDate")
                );
                
            } 
//            c.close();
        }
        catch (SQLException ex) {
            System.out.println("Khong the tim CourseInstructor  !!!");
        }
        if(ps!=null)
            return ps.getLastName() + " " + ps.getFirstName();
        return "";
    }
    public ArrayList<CourseInstructor> findByChar(String keyword){
        ArrayList<CourseInstructor> list = new ArrayList<>(); 
        String sql = "SELECT DISTINCT "
                + " CourseInstructor.CourseID, CourseInstructor.PersonID, "
                + " CONCAT(Person.LastName, ' ', Person.FirstName) AS Name,Course.Title "
                + " FROM  Person "
                + " JOIN CourseInstructor ON Person.PersonID = CourseInstructor.PersonID "
                + " JOIN Course ON CourseInstructor.CourseID = Course.CourseID "
                + " WHERE CONCAT(Person.LastName, ' ', Person.FirstName) LIKE ? "
                + " OR Course.Title LIKE ?; ";
         
        try{
            
           PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CourseInstructor csin = new CourseInstructor(
                        rs.getInt("CourseID"),
                         rs.getString("Title"),
                        rs.getInt("PersonID"),
                         rs.getString("Name")
                );
                list.add(csin);
            } 
//            c.close();
        }
        catch (SQLException ex) {
            System.out.println("Khong the tim CourseInstructor  !!!");
        }
       return list; 
    }
    public CourseInstructor findIDByNamePerson(String keyword){
        ArrayList<CourseInstructor> list = new ArrayList<>(); 
        String sql = " SELECT CourseInstructor.CourseID, CourseInstructor.PersonID, "
                + " CONCAT(Person.LastName, ' ', Person.FirstName) AS Name, Course.Title "
                + " FROM  Person "
                + " JOIN CourseInstructor ON Person.PersonID = CourseInstructor.PersonID "
                + " JOIN Course ON CourseInstructor.CourseID = Course.CourseID "
                + " WHERE CONCAT(Person.LastName, ' ', Person.FirstName) LIKE ?;";
         
        try{
            
           PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CourseInstructor csin = new CourseInstructor(
                        rs.getInt("CourseID"),
                         rs.getString("Title"),
                        rs.getInt("PersonID"),
                         rs.getString("Name")
                );
                list.add(csin);
            }          
        }
        catch (SQLException ex) {
            System.out.println("Khong the tim CourseInstructor1  !!!");
        }
//        finally {
//        try {
//            if (c != null) {
//                c.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
       return list.isEmpty() ? null : list.get(0);
    }
    public CourseInstructor findCourseInstructorByIDCourse(String idCourse, String idPerson){
        ArrayList<CourseInstructor> list = new ArrayList<>(); 
        String sql = "SELECT DISTINCT "
                + " CourseInstructor.CourseID, CourseInstructor.PersonID, "
                + " CONCAT(Person.LastName, ' ', Person.FirstName) AS Name,Course.Title "
                + " FROM  Person "
                + " JOIN CourseInstructor ON Person.PersonID = CourseInstructor.PersonID "
                + " JOIN Course ON CourseInstructor.CourseID = Course.CourseID "
                + " WHERE CourseInstructor.CourseID = ? AND CourseInstructor.PersonID = ?; ";         
        try{            
           PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, "%" + idCourse + "%");
            preparedStatement.setString(2, "%" + idPerson + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CourseInstructor csin = new CourseInstructor(
                        rs.getInt("CourseID"),
                         rs.getString("Title"),
                        rs.getInt("PersonID"),
                         rs.getString("Name")
                );
                list.add(csin);
            } 
//            c.close();
        }
        catch (SQLException ex) {
            System.out.println("Khong the tim CourseInstructor2  !!!");
        }
       return list.get(0); 
    }
    public boolean addCourseInstructor(int CourseID, int PersonID) throws SQLException {
        String query = "INSERT INTO CourseInstructor (CourseID, PersonID) VALUES (?, ?)";
        try (PreparedStatement p = c.prepareStatement(query)) {
            p.setInt(1, CourseID);
            p.setInt(2, PersonID);
            int rowsAffected = p.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public int deleteCourseInstructor(int CourseID, int PersonID) throws SQLException {
        String query = "DELETE FROM CourseInstructor WHERE CourseID = ? And PersonID = ?";
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, CourseID);
        p.setInt(2, PersonID);
        int result = p.executeUpdate();
        return result;
    }
    
}
