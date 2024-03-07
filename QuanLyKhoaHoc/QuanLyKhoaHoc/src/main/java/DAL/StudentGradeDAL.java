package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StudentGradeDAL extends MyDatabaseManager {

    public StudentGradeDAL() {
        super();
        this.connectDB();
    }

    public List<List<Object>> readStudent() {
        List<List<Object>> studentGradeList = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "ORDER BY sg.EnrollmentID ASC";
            ResultSet rs = this.doReadQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    List<Object> studentGradeInfo = new ArrayList<>();

                    studentGradeInfo.add(rs.getInt("EnrollmentID"));
                    studentGradeInfo.add(rs.getInt("CourseID"));
                    studentGradeInfo.add(rs.getInt("StudentID"));
                    studentGradeInfo.add(rs.getFloat("Grade"));
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                    studentGradeInfo.add(rs.getString("Title"));

                    studentGradeList.add(studentGradeInfo);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());

        }
        return studentGradeList;
    }

    public int InsertStudentGradeDAL(int CourseID, int StudentID, float Grade) {
        try {
            String query = "INSERT INTO studentgrade(`CourseID`, `StudentID`, `Grade`) VALUES (?, ? ,?)";
            try (PreparedStatement pst = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pst.setInt(1, CourseID);
                pst.setInt(2, StudentID);
                pst.setFloat(3, Grade);
                pst.executeUpdate();

                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return 0;
    }

    public boolean deleteStudentgradeDAL(int EnrollmentID) {
        try {
            String query = "DELETE FROM studentgrade WHERE `EnrollMentID` = '" + EnrollmentID + "'";
            PreparedStatement pst = c.prepareStatement(query);
            pst.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return false;
    }

    public boolean editStudentGrade(int EnrollmentID, int CourseID, int StudentID, float Grade) {
        try {
            String query = "UPDATE studentgrade SET `CourseID`=?,`StudentID`=?,`Grade`=? WHERE `EnrollmentID` = '" + EnrollmentID + "'";
            PreparedStatement pst = c.prepareStatement(query);

            pst.setInt(1, CourseID);
            pst.setInt(2, StudentID);
            pst.setFloat(3, Grade);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public List<List<Object>> searchStudentGrade(String keyword) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "WHERE sg.CourseID LIKE ? "
                    + "OR sg.StudentID LIKE ? "
                    + "OR sg.Grade LIKE ? "
                    + "OR CONCAT_WS(' ', p.Lastname, p.Firstname) LIKE ? "
                    + "OR c.Title LIKE ? "
                    + "ORDER BY sg.EnrollmentID ASC";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            pst.setString(3, "%" + keyword + "%");
            pst.setString(4, "%" + keyword + "%");
            pst.setString(5, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                List<Object> studentGradeInfo = new ArrayList<>();

                studentGradeInfo.add(rs.getInt("EnrollmentID"));
                studentGradeInfo.add(rs.getInt("CourseID"));
                studentGradeInfo.add(rs.getInt("StudentID"));
                studentGradeInfo.add(rs.getFloat("Grade"));
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));

                searchResult.add(studentGradeInfo);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return searchResult;
    }
}
