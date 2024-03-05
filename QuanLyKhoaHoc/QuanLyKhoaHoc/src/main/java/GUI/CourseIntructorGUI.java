/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.*;
import com.mysql.cj.LicenseConfiguration;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CourseIntructorGUI extends javax.swing.JInternalFrame {
    public CourseInstructorBLL cIBLL  = new CourseInstructorBLL();
    CourseBLL courseBLL = new CourseBLL();
    LecturersBLL personBLL = new LecturersBLL();
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel<Course> comboBoxModel;
    DefaultComboBoxModel<Lecturers> comboBoxModelPS;   
    private boolean insert = false;

    /**
     * Creates new form TeachingAssignment
     */
    public CourseIntructorGUI() throws Exception {
        initComponents();
         btnXong.setVisible(!true);
        btnHuy.setVisible(!true);
        
        loadDataTable(cIBLL.loadDSCourseInstructor());
        
        comboBoxModel = loadDataCourseToCombobox( courseBLL.loadData());
        nameCourse.setModel(comboBoxModel);
        
        
        
        comboBoxModelPS = loadDataPersonToCombobox(personBLL.loadData());
        namePerson.setModel(comboBoxModelPS);
        nameCourse.setSelectedIndex(0);
        namePerson.setSelectedIndex(0);
    }
    public void loadDataTable( ArrayList<CourseInstructor> data) throws Exception{
        model.setRowCount(0);
        model = addArrayListToTable(data);
        tableCourseIns.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        maKH = new javax.swing.JTextField();
        maGV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCourseIns = new javax.swing.JTable();
        nameCourse = new javax.swing.JComboBox<>();
        namePerson = new javax.swing.JComboBox<>();
        btnXong = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ THÔNG TIN PHÂN CÔNG GIẢNG DẠY");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 536, 55));

        jLabel2.setText("Mã khóa học:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 82, 22));

        jLabel3.setText("Mã giảng viên:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 82, 24));

        maKH.setEditable(false);
        maKH.setEnabled(false);
        maKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKHActionPerformed(evt);
            }
        });
        getContentPane().add(maKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 189, -1));

        maGV.setEditable(false);
        maGV.setEnabled(false);
        maGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maGVActionPerformed(evt);
            }
        });
        getContentPane().add(maGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 189, -1));

        jLabel4.setText("Tên khóa học:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 82, -1));

        jLabel5.setText("Tên giảng viên:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 82, 24));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 259, -1));

        jButton4.setText("Tìm kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, -1, -1));

        tableCourseIns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã khóa học", "Tên khóa học", "Mã giảng viên", "Tên giảng viên"
            }
        ));
        tableCourseIns.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableCourseIns.setShowHorizontalLines(true);
        tableCourseIns.setShowVerticalLines(true);
        tableCourseIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCourseInsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCourseIns);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 730, 260));

        nameCourse.setEnabled(false);
        nameCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCourseActionPerformed(evt);
            }
        });
        getContentPane().add(nameCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 260, -1));

        namePerson.setEnabled(false);
        namePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namePersonActionPerformed(evt);
            }
        });
        getContentPane().add(namePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 260, -1));

        btnXong.setText("Xong");
        btnXong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXongActionPerformed(evt);
            }
        });
        getContentPane().add(btnXong, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 80, -1));

        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        getContentPane().add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maGVActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int luaChon = JOptionPane.showConfirmDialog(null, "Có chỉnh sửa không?", "Hỏi", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            nameCourse.setEnabled(true);
            namePerson.setEnabled(true);
            btnThem.setEnabled(false);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnXong.setVisible(true);
            btnHuy.setVisible(true);
            
        } else {
            System.out.println("Người dùng đã chọn Không");
            
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void nameCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameCourseActionPerformed
        // TODO add your handling code here:
        maKH.setText(((Course) nameCourse.getSelectedItem()).getCourseId()+"");
    }//GEN-LAST:event_nameCourseActionPerformed

    private void maKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maKHActionPerformed

    private void namePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namePersonActionPerformed
        // TODO add your handling code here:
        maGV.setText(((Lecturers) namePerson.getSelectedItem()).getPersonId()+"");

    }//GEN-LAST:event_namePersonActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if(txtSearch.getText().isEmpty()){
            model.setRowCount(0);
            try {
                model = addArrayListToTable(cIBLL.loadDSCourseInstructor());
            } catch (Exception ex) {
                Logger.getLogger(CourseIntructorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(cIBLL.searchCourseInstructor(txtSearch.getText().trim()).size()>0){
            model.setRowCount(0);
            model = addArrayListToTable(cIBLL.searchCourseInstructor(txtSearch.getText().trim()));
        } else{
        model.setRowCount(0);
        }
        tableCourseIns.setModel(model);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:  
        nameCourse.setEnabled(false);
        namePerson.setEnabled(false);
        btnThem.setEnabled(!false);
        btnSua.setEnabled(!false);
        btnXoa.setEnabled(!false);
        btnXong.setVisible(!true);
        btnHuy.setVisible(!true);
        try {
            Course cour= (Course) courseBLL.findElement(cIBLL.returnOld().getCourseID());
            Lecturers lect = (Lecturers) personBLL.findElement(cIBLL.returnOld().getPersonID());
            comboBoxModel.setSelectedItem(cour);
            comboBoxModelPS.setSelectedItem(lect);
            cIBLL.resetCourseIOld();
        } catch (Exception ex) {
            Logger.getLogger(CourseIntructorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tableCourseInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCourseInsMouseClicked
        // TODO add your handling code here:
        
        int selectedRow = tableCourseIns.getSelectedRow();
        nameCourse.setEnabled(false);
        namePerson.setEnabled(false);
        int courseID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        int personID = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
        try {
            Course cour= (Course) courseBLL.findElement(courseID);
            Lecturers lect = (Lecturers) personBLL.findElement(personID);
            
            comboBoxModel.setSelectedItem(cour);
            comboBoxModelPS.setSelectedItem(lect);            
            cIBLL.saveold(courseID,cour.getTitle(),personID,lect.toString());
        } catch (Exception ex) {
            Logger.getLogger(CourseIntructorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tableCourseInsMouseClicked
    
    /**
     * @param evt
     */
    private void btnXongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXongActionPerformed
        // TODO add your handling code here:
        if(!insert) {
            int maKhoahoc = Integer.parseInt(maKH.getText());
            int maGiangvien = Integer.parseInt(maGV.getText());
            try {
                CourseInstructor a =  cIBLL.returnOld();
                CourseInstructor b =  cIBLL.getCourseInstructorNewByID(courseBLL.findElement(maKhoahoc),personBLL.findElement(maGiangvien));

                if(!cIBLL.updateCourseInstructor(a, b)){
                    JOptionPane.showMessageDialog( null, "Update fail!!!?" );

                }else{
                  JOptionPane.showMessageDialog( null, "Update success!!!?" );

                }                
                txtSearch.setText("");
                model.setRowCount(0);
                model = addArrayListToTable(cIBLL.loadDSCourseInstructor());
                tableCourseIns.setModel(model);
                btnHuyActionPerformed(evt);
            } catch (Exception ex) {
                Logger.getLogger(CourseIntructorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            int maKhoahoc = Integer.parseInt(maKH.getText());
            int maGiangvien = Integer.parseInt(maGV.getText());
            try {
                if (CourseInstructorBLL.checkAddCourseInstructor(maKhoahoc, maGiangvien) == 0) {
                    if(CourseInstructorBLL.addCourseInstructor(maKhoahoc, maGiangvien)) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi! id đã tồn tại");
                }
                // Cập nhật bảng hiển thị
                txtSearch.setText("");
                model.setRowCount(0);
                model = addArrayListToTable(cIBLL.loadDSCourseInstructor());
                tableCourseIns.setModel(model);
                nameCourse.setEnabled(false);
                namePerson.setEnabled(false);
                btnThem.setEnabled(!false);
                btnSua.setEnabled(!false);
                btnXoa.setEnabled(!false);
                btnXong.setVisible(!true);
                btnHuy.setVisible(!true); 
            } catch (Exception e) {
                // Xử lý ngoại lệ nếu có
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }  
    }//GEN-LAST:event_btnXongActionPerformed
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        int luaChon = JOptionPane.showConfirmDialog(null, "Có thêm không?", "Hỏi", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            insert = true;
            nameCourse.setEnabled(true);
            namePerson.setEnabled(true);
            btnThem.setEnabled(false);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnXong.setVisible(true);
            btnHuy.setVisible(true);
            
        }
    }
    
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = (int) ((JTable) this.tableCourseIns).getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khóa học muốn xóa");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    if (CourseInstructorBLL.deleteCourseInstructor(Integer.parseInt(maKH.getText()),Integer.parseInt(maGV.getText())) != 0 )  {
                        JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        model = addArrayListToTable(cIBLL.loadDSCourseInstructor());
                        tableCourseIns.setModel(model);
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {               
                try {
                    new CourseIntructorGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CourseIntructorGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    public DefaultTableModel addArrayListToTable(ArrayList<CourseInstructor> dataList) {
        DefaultTableModel model = new DefaultTableModel();

        // Thêm tên cột vào mô hình bảng
        model.addColumn("Mã khoá học");
        model.addColumn("Tên khoá học");
        model.addColumn("Mã giảng viên");
        model.addColumn("Tên giảng viên");
        

        // Thêm dữ liệu từ ArrayList vào mô hình bảng
        for (CourseInstructor rowData : dataList) {
             model.addRow(new Object[]{
                 rowData.getCourseID(),
                 rowData.getTitleCourse(),
                 rowData.getPersonID(),
                 rowData.getTeacherName()
             });
        }

        return model;
    }
     public DefaultComboBoxModel loadDataCourseToCombobox(ArrayList<Course> dataList){
         DefaultComboBoxModel<Course> comboBoxModel = new DefaultComboBoxModel<>();
         for (Course c : dataList) {              
                comboBoxModel.addElement( c);            
        }
         return comboBoxModel;
     }
    public DefaultComboBoxModel loadDataPersonToCombobox(ArrayList<Lecturers> dataList){
         DefaultComboBoxModel<Lecturers> comboBoxModel = new DefaultComboBoxModel<>();
         for (Lecturers person : dataList) {  
            
                comboBoxModel.addElement( person);
            
        }
         return comboBoxModel;
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXong;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maGV;
    private javax.swing.JTextField maKH;
    private javax.swing.JComboBox<Course> nameCourse;
    private javax.swing.JComboBox<Lecturers> namePerson;
    private javax.swing.JTable tableCourseIns;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
