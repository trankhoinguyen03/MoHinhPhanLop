/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DepartmentDAL;
import DTO.Department;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class DepartmentBLL {
    DepartmentDAL dal;
    
    public DepartmentBLL() {
        dal = new DepartmentDAL();
    }
    
    public Department getDeparment(int id) throws SQLException {
        return dal.getDepartment(id);
    }
    
    public ArrayList<Department> getListDepartment() throws SQLException {
        return dal.getListDepartment();
    }
}
