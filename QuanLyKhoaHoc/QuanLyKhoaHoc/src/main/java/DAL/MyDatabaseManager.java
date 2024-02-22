/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class MyDatabaseManager {
    protected Connection c;
    private Statement s;
    private String host, port, dbName, dbUser, dbPassword;
    
    MyDatabaseManager() {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "school";
        dbPassword = "";
    }
    
    public void connectDB() {
        String dbPath = "jdbc:mysql://"+host+":"+port+"/"+dbName+"?useUnicode=yes&characterEncoding=UTF-8";
        try {
            c = DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s = c.createStatement();
            System.out.println("Connected");
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
    public ResultSet doReadQuery(String sql) {
        ResultSet rs = null;
        try {
            rs = s.executeQuery(sql);
            } catch (SQLException ex) {
            Logger.getLogger(MyDatabaseManager.class.getName())
            .log(Level.SEVERE, null, ex);
            }
        return rs;
    }
    
//    public void doUpdateQuery() throws SQLException {
//
//    }
    
    public static void main(String[] args) {
        new MyDatabaseManager().connectDB();
    }
}

