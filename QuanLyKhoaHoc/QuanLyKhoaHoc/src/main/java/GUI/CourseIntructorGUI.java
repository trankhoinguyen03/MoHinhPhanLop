/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import BLL.CourseInstructorBLL;
import BLL.LecturersBLL;;
import DTO.*;
import com.mysql.cj.LicenseConfiguration;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CourseIntructorGUI extends javax.swing.JFrame {
    public CourseInstructorBLL cIBLL  = new CourseInstructorBLL();
    CourseBLL courseBLL = new CourseBLL();
    LecturersBLL personBLL = new LecturersBLL();
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel<Course> comboBoxModel;
    DefaultComboBoxModel<Lecturers> comboBoxModelPS;   

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
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCourseIns = new javax.swing.JTable();
        nameCourse = new javax.swing.JComboBox<>();
        namePerson = new javax.swing.JComboBox<>();
        btnXong = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ THÔNG TIN PHÂN CÔNG GIẢNG DẠY");

        jLabel2.setText("Mã khóa học:");

        jLabel3.setText("Mã giảng viên:");

        maKH.setEditable(false);
        maKH.setEnabled(false);
        maKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKHActionPerformed(evt);
            }
        });

        maGV.setEditable(false);
        maGV.setEnabled(false);
        maGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maGVActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên khóa học:");

        jLabel5.setText("Tên giảng viên:");

        btnThem.setText("Thêm");

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jButton4.setText("Tìm kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        nameCourse.setEnabled(false);
        nameCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCourseActionPerformed(evt);
            }
        });

        namePerson.setEnabled(false);
        namePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namePersonActionPerformed(evt);
            }
        });

        btnXong.setText("Xong");
        btnXong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXongActionPerformed(evt);
            }
        });

        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maGV, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(namePerson, javax.swing.GroupLayout.Alignment.LEADING, 0, 287, Short.MAX_VALUE)
                                    .addComponent(nameCourse, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXong)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXong))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maKH)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maGV)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(namePerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHuy)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

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

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        if(jTextField5.getText().isEmpty()){
            model.setRowCount(0);
            try {
                model = addArrayListToTable(cIBLL.loadDSCourseInstructor());
            } catch (Exception ex) {
                Logger.getLogger(CourseIntructorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(cIBLL.searchCourseInstructor(jTextField5.getText().trim()).size()>0){
            model.setRowCount(0);
            model = addArrayListToTable(cIBLL.searchCourseInstructor(jTextField5.getText().trim()));
        } else{
        model.setRowCount(0);
        }
        tableCourseIns.setModel(model);
    }//GEN-LAST:event_jTextField5KeyReleased

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

    private void btnXongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXongActionPerformed
        // TODO add your handling code here:
        int maKhoahoc = Integer.parseInt(maKH.getText());
        int maGiangvien = Integer.parseInt(maGV.getText());
        try {
            CourseInstructor a =   cIBLL.returnOld();
            CourseInstructor b =   cIBLL.getCourseInstructorNewByID(courseBLL.findElement(maKhoahoc),personBLL.findElement(maGiangvien));

            if(!cIBLL.updateCourseInstructor(a, b)){
                JOptionPane.showMessageDialog( null, "Update fail!!!?" );
                
            }else{
              JOptionPane.showMessageDialog( null, "Update success!!!?" );

            }                
            jTextField5.setText("");
            model.setRowCount(0);
            model = addArrayListToTable(cIBLL.loadDSCourseInstructor());
            tableCourseIns.setModel(model);
            cIBLL.resetCourseIOld();
            btnHuyActionPerformed(evt);
        } catch (Exception ex) {
            Logger.getLogger(CourseIntructorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXongActionPerformed
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
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField maGV;
    private javax.swing.JTextField maKH;
    private javax.swing.JComboBox<Course> nameCourse;
    private javax.swing.JComboBox<Lecturers> namePerson;
    private javax.swing.JTable tableCourseIns;
    // End of variables declaration//GEN-END:variables
}
