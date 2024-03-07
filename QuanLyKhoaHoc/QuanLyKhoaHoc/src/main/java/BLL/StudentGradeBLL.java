package BLL;

import DAL.StudentGradeDAL;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeBLL {

    private final StudentGradeDAL studentGradeDAL;

    public StudentGradeBLL() {
        this.studentGradeDAL = new StudentGradeDAL();
    }

    public List<List<Object>> readStudent() {
        return studentGradeDAL.readStudent();
    }

    public int insertStudentGrade(int courseID, int studentID, float grade) {
        return studentGradeDAL.InsertStudentGradeDAL(courseID, studentID, grade);
    }

    public boolean deleteStudentGrade(int enrollmentID) {
        return studentGradeDAL.deleteStudentgradeDAL(enrollmentID);
    }

    public boolean editStudentGrade(int enrollmentID, int courseID, int studentID, float grade) {
        return studentGradeDAL.editStudentGrade(enrollmentID, courseID, studentID, grade);
    }

    public List<List<Object>> searchStudentGrade(String keyword) {
        return studentGradeDAL.searchStudentGrade(keyword);
    }

}
