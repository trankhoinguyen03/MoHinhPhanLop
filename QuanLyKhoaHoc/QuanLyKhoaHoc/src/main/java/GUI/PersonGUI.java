/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class PersonGUI extends javax.swing.JInternalFrame {
    private DefaultTableModel modelSV;
    private DefaultTableModel modelGV;
    private LecturersBLL lecturersBLL = new LecturersBLL();
    private StudentBLL studentBLL = new StudentBLL();
    /**
     * Creates new form NewJFrame
     */
    public PersonGUI() throws SQLException {
        initComponents();
        loadToTableSV(studentBLL.readStudents());
        loadToTableGV(lecturersBLL.readLecturers());
    }
    
    public void loadToTableSV(ArrayList<Student> list) {
        String[] header = {"Mã sinh viên", "Họ sinh viên", "Tên sinh viên", "Ngày tham gia"};
        modelSV = new DefaultTableModel(header, 0);
        this.jTableSinhVien.setModel(modelSV);
        for (Student x : list) {
            Object[] data = {x.getPersonId(), x.getFirstName(), x.getLastName(), x.getEnrollmentDate()};
            modelSV.addRow(data);
        }
    }
    
    public void loadToTableGV(ArrayList<Lecturers> list) {
        String[] header = {"Mã giảng viên", "Họ giảng viên", "Tên giảng viên", "Ngày thuê"};
        modelGV = new DefaultTableModel(header, 0);
        this.jTableGiangVien.setModel(modelGV);
        for (Lecturers x : list) {
            Object[] data = {x.getPersonId(), x.getFirstName(),  x.getLastName(), x.getHireDate().toString()};
            modelGV.addRow(data);
        }
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
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelSV = new javax.swing.JPanel();
        jButtonXoaSV = new javax.swing.JButton();
        jTextFieldTenSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTimKiemSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonTimKiemSV = new javax.swing.JButton();
        jTextFieldMaSV = new javax.swing.JTextField();
        jTextFieldNgayThamGia = new javax.swing.JTextField();
        jTextFieldHoSV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSinhVien = new javax.swing.JTable();
        jButtonThemSV = new javax.swing.JButton();
        jButtonSuaSV = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelGV = new javax.swing.JPanel();
        jButtonXoaGV = new javax.swing.JButton();
        jTextFieldTenGV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTimKiemGV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonTimKiemGV = new javax.swing.JButton();
        jTextFieldMaGV = new javax.swing.JTextField();
        jTextFieldNgayThue = new javax.swing.JTextField();
        jTextFieldHoGV = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGiangVien = new javax.swing.JTable();
        jButtonThemGV = new javax.swing.JButton();
        jButtonSuaGV = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(782, 527));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ THÔNG TIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 30, 244, -1));

        jPanelSV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonXoaSV.setText("Xóa");
        jButtonXoaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaSVActionPerformed(evt);
            }
        });
        jPanelSV.add(jButtonXoaSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 96, -1, -1));

        jTextFieldTenSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenSVActionPerformed(evt);
            }
        });
        jPanelSV.add(jTextFieldTenSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 55, 189, -1));

        jLabel2.setText("Mã sinh viên:");
        jPanelSV.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 26, 82, 22));
        jPanelSV.add(jTextFieldTimKiemSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 96, 259, -1));

        jLabel3.setText("Họ:");
        jPanelSV.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 24, 25, 24));

        jButtonTimKiemSV.setText("Tìm kiếm");
        jButtonTimKiemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemSVActionPerformed(evt);
            }
        });
        jPanelSV.add(jButtonTimKiemSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 96, 81, -1));
        jPanelSV.add(jTextFieldMaSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 25, 189, -1));

        jTextFieldNgayThamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNgayThamGiaActionPerformed(evt);
            }
        });
        jPanelSV.add(jTextFieldNgayThamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 55, 189, -1));

        jTextFieldHoSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoSVActionPerformed(evt);
            }
        });
        jPanelSV.add(jTextFieldHoSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 25, 189, -1));

        jTableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã sinh viên", "Họ", "Tên", "Ngày tham gia"
            }
        ));
        jTableSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSinhVien);

        jPanelSV.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 131, 754, 245));

        jButtonThemSV.setText("Thêm");
        jButtonThemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemSVActionPerformed(evt);
            }
        });
        jPanelSV.add(jButtonThemSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 96, -1, -1));

        jButtonSuaSV.setText("Sửa");
        jButtonSuaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaSVActionPerformed(evt);
            }
        });
        jPanelSV.add(jButtonSuaSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 96, -1, -1));

        jLabel4.setText("Ngày tham gia:");
        jPanelSV.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 58, 82, -1));

        jLabel6.setText("Tên: ");
        jPanelSV.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 54, -1, 24));

        jTabbedPane.addTab("Sinh viên", jPanelSV);

        jPanelGV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonXoaGV.setText("Xóa");
        jButtonXoaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaGVActionPerformed(evt);
            }
        });
        jPanelGV.add(jButtonXoaGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 96, -1, -1));

        jTextFieldTenGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenGVActionPerformed(evt);
            }
        });
        jPanelGV.add(jTextFieldTenGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 55, 189, -1));

        jLabel5.setText("Mã giảng viên");
        jPanelGV.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 26, 82, 22));
        jPanelGV.add(jTextFieldTimKiemGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 96, 259, -1));

        jLabel8.setText("Họ:");
        jPanelGV.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 24, 25, 24));

        jButtonTimKiemGV.setText("Tìm kiếm");
        jButtonTimKiemGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemGVActionPerformed(evt);
            }
        });
        jPanelGV.add(jButtonTimKiemGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 96, 81, -1));
        jPanelGV.add(jTextFieldMaGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 25, 189, -1));

        jTextFieldNgayThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNgayThueActionPerformed(evt);
            }
        });
        jPanelGV.add(jTextFieldNgayThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 55, 189, -1));

        jTextFieldHoGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoGVActionPerformed(evt);
            }
        });
        jPanelGV.add(jTextFieldHoGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 25, 189, -1));

        jTableGiangVien.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã giảng viên", "Họ", "Tên", "Ngày thuê"
            }
        ));
        jTableGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGiangVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGiangVien);

        jPanelGV.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 131, 750, 250));

        jButtonThemGV.setText("Thêm");
        jButtonThemGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemGVActionPerformed(evt);
            }
        });
        jPanelGV.add(jButtonThemGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 96, -1, -1));

        jButtonSuaGV.setText("Sửa");
        jButtonSuaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaGVActionPerformed(evt);
            }
        });
        jPanelGV.add(jButtonSuaGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 96, -1, -1));

        jLabel9.setText("Ngày thuê");
        jPanelGV.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 58, 82, -1));

        jLabel10.setText("Tên: ");
        jPanelGV.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 54, -1, 24));

        jTabbedPane.addTab("Giảng viên", jPanelGV);

        getContentPane().add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, -1, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTimKiemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemSVActionPerformed
        // TODO add your handling code here:
        try {
            if("".equals(jTextFieldTimKiemSV.getText())) {

                    JOptionPane.showMessageDialog(null, "Please enter search information!");
                    loadToTableSV(studentBLL.readStudents());
            }
            else if(studentBLL.searchStudents(jTextFieldTimKiemSV.getText()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "No students found!");
                loadToTableSV(studentBLL.readStudents());
            }
            else {
                loadToTableSV(studentBLL.searchStudents(jTextFieldTimKiemSV.getText()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTimKiemSVActionPerformed

    private void jTextFieldHoSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoSVActionPerformed

    private void jButtonSuaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSuaSVActionPerformed

    private void jTextFieldTenSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenSVActionPerformed

    private void jTextFieldNgayThamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNgayThamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNgayThamGiaActionPerformed

    private void jTextFieldTenGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenGVActionPerformed

    private void jButtonTimKiemGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemGVActionPerformed
        // TODO add your handling code here:
        try {
            if("".equals(jTextFieldTimKiemGV.getText())) {

                    JOptionPane.showMessageDialog(null, "Please enter search information!");
                    loadToTableGV(lecturersBLL.readLecturers());
            }
            else if(lecturersBLL.searchLecturers(jTextFieldTimKiemGV.getText()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "No lecturers found!");
                loadToTableGV(lecturersBLL.readLecturers());
            }
            else {
                loadToTableGV(lecturersBLL.searchLecturers(jTextFieldTimKiemGV.getText()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTimKiemGVActionPerformed

    private void jTextFieldNgayThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNgayThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNgayThueActionPerformed

    private void jTextFieldHoGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoGVActionPerformed

    private void jButtonSuaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSuaGVActionPerformed

    private void jTableSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSinhVienMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTableSinhVien.getSelectedRow();
        jTextFieldMaSV.setText(""+jTableSinhVien.getValueAt(selectedRow, 0));
        jTextFieldHoSV.setText(""+jTableSinhVien.getValueAt(selectedRow, 1));
        jTextFieldTenSV.setText(""+jTableSinhVien.getValueAt(selectedRow, 2));
        jTextFieldNgayThamGia.setText(""+jTableSinhVien.getValueAt(selectedRow, 3));
    }//GEN-LAST:event_jTableSinhVienMouseClicked

    private void jTableGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGiangVienMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTableGiangVien.getSelectedRow();
        jTextFieldMaGV.setText(""+jTableGiangVien.getValueAt(selectedRow, 0));
        jTextFieldHoGV.setText(""+jTableGiangVien.getValueAt(selectedRow, 1));
        jTextFieldTenGV.setText(""+jTableGiangVien.getValueAt(selectedRow, 2));
        jTextFieldNgayThue.setText(""+jTableGiangVien.getValueAt(selectedRow, 3));
    }//GEN-LAST:event_jTableGiangVienMouseClicked

    private void jButtonThemGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonThemGVActionPerformed

    private void jButtonThemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonThemSVActionPerformed

    private void jButtonXoaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXoaGVActionPerformed

    private void jButtonXoaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXoaSVActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSuaGV;
    private javax.swing.JButton jButtonSuaSV;
    private javax.swing.JButton jButtonThemGV;
    private javax.swing.JButton jButtonThemSV;
    private javax.swing.JButton jButtonTimKiemGV;
    private javax.swing.JButton jButtonTimKiemSV;
    private javax.swing.JButton jButtonXoaGV;
    private javax.swing.JButton jButtonXoaSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelGV;
    private javax.swing.JPanel jPanelSV;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableGiangVien;
    private javax.swing.JTable jTableSinhVien;
    private javax.swing.JTextField jTextFieldHoGV;
    private javax.swing.JTextField jTextFieldHoSV;
    private javax.swing.JTextField jTextFieldMaGV;
    private javax.swing.JTextField jTextFieldMaSV;
    private javax.swing.JTextField jTextFieldNgayThamGia;
    private javax.swing.JTextField jTextFieldNgayThue;
    private javax.swing.JTextField jTextFieldTenGV;
    private javax.swing.JTextField jTextFieldTenSV;
    private javax.swing.JTextField jTextFieldTimKiemGV;
    private javax.swing.JTextField jTextFieldTimKiemSV;
    // End of variables declaration//GEN-END:variables
}
