/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class DepartmentDAL extends MyDatabaseManager {
    
    public DepartmentDAL() {
        super();
        this.connectDB();
    }
    
    public Department getDepartment(int id) throws SQLException {
        Department department = new Department();
        String query = "Select * From Department Where DepartmentID = ?";
        PreparedStatement pst = c.prepareStatement(query);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                department.setDepartmentId(rs.getInt(1));
                department.setName(rs.getString(2));
                department.setBudget(rs.getInt(3));
                department.setStartDate(rs.getDate(4));
                department.setAdministrator(rs.getInt(5));
            }
        return department;
    }
    
    public ArrayList<Department> getListDepartment() throws SQLException {
        ArrayList list = new ArrayList<Department>();
        String query = "Select * From Department";
        PreparedStatement pst = c.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Department department = new Department();
            department.setDepartmentId(rs.getInt(1));
            department.setName(rs.getString(2));
            department.setBudget(rs.getInt(3));
            department.setStartDate(rs.getDate(4));
            department.setAdministrator(rs.getInt(5));
            list.add(department);
        }
        return list;
    }
}
