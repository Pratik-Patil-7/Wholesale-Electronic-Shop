package employee;


import customer.Customer;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Pratik
 */
public class empolyeeadd extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public static boolean isValid(String email) {
        String emailFormate = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."
                + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern p = Pattern.compile(emailFormate);
        if (email == null) {
            return false;
        }
        return p.matcher(email).matches();
    }

    public empolyeeadd() {
        initComponents();
        employeetable.setModel(new DefaultTableModel(null, new String[]{"employeeID", "employeeName", "Address", "PhoneNumber", "Email", "Date"}));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from employee");
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("employeeid"));
                String name = rs.getString("employeename");
                String address = rs.getString("address");
                String phoneno = rs.getString("phoneno");
                String email = rs.getString("email");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String customertable1[] = {id, name, address, phoneno, email, date1};
                DefaultTableModel tblModel = (DefaultTableModel) employeetable.getModel();
                tblModel.addRow(customertable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {

            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                employeeid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        employeeid.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        employeeid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        employeename = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        phoneno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeetable = new javax.swing.JTable();
        Refresh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add New Employee ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(208, 208, 208)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel9.setText("Employee ID ");

        employeeid.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        employeeid.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setText("Employee Name ");

        employeename.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        employeename.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel12.setText("Employee Address  ");

        address.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        address.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel13.setText("Phone Number");

        phoneno.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        phoneno.setToolTipText("");
        phoneno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phonenoKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel14.setText("E-mail ID ");

        email.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        email.setToolTipText("");
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(102, 255, 102));
        Delete.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        Delete.setText("Layoff");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(102, 255, 102));
        update.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(102, 255, 102));
        save.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveKeyPressed(evt);
            }
        });

        employeetable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        employeetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeID", "EmployeeName", "Address", "PhoneNumber", "Email ", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeetable);

        Refresh.setBackground(new java.awt.Color(102, 255, 102));
        Refresh.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        Refresh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RefreshKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel15.setText("Date ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(employeename, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeename, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(address)
                    .addComponent(employeeid))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(update)
                    .addComponent(Refresh)
                    .addComponent(save))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new employee().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void phonenoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phonenoKeyPressed
        String j = phoneno.getText();
        int length = j.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {
                phoneno.setEditable(true);
            } else {
                phoneno.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                phoneno.setEditable(true);

            } else {
                phoneno.setEditable(false);
            }
        }
    }//GEN-LAST:event_phonenoKeyPressed

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped

    }//GEN-LAST:event_emailKeyTyped

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from employee where employeeid = ?");
            pst.setString(1, employeeid.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                try {
                    try {
                        pst = con.prepareStatement("insert into employeelayoff(employeeid,employeename,address,email,phoneno,layoffdate)values(?,?,?,?,?,?)");
                        pst.setString(1, employeeid.getText());
                        pst.setString(2, employeename.getText());
                        pst.setString(3, address.getText());
                        pst.setString(4, email.getText());
                        pst.setString(5, phoneno.getText());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date11 = sdf.format(date.getDate());
                        pst.setString(6, date11);
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                    }
                    pst = con.prepareStatement("delete from employee where employeeid =?");
                    pst.setString(1, employeeid.getText());
                    pst.executeUpdate();
                } catch (SQLException e) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                }
                employeename.setText("");
                address.setText("");
                phoneno.setText("");
                email.setText("");
                JOptionPane.showMessageDialog(jPanel1, "Deleted....! ");

                employeetable.setModel(new DefaultTableModel(null, new String[]{"employeeID", "employeeName", "Address", "PhoneNumber", "Email", "Date"}));
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                    pst = con.prepareStatement("SELECT * from employee");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        String id = String.valueOf(rs.getInt("employeeid"));
                        String name = rs.getString("employeename");
                        String address = rs.getString("address");
                        String phoneno = rs.getString("phoneno");
                        String email = rs.getString("email");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                        String date1 = dateFormat.format(rs.getDate("date"));
                        String customertable1[] = {id, name, address, phoneno, email, date1};
                        DefaultTableModel tblModel = (DefaultTableModel) employeetable.getModel();
                        tblModel.addRow(customertable1);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException e) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                }
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                    pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        int id = Integer.parseInt(rs.getString(1)) + 1;
                        String cal = String.valueOf(id);
                        employeeid.setText(cal);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException e) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Employee Information not found ");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_DeleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int i = 0;
        String idf = employeeid.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from employee where employeeid = " + idf + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                if (employeename.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(jPanel1, "Enter employee Name ", "Error", JOptionPane.ERROR_MESSAGE);
                    phoneno.requestFocus();
                } else {
                    i++;
                }
                if (address.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(jPanel1, "Enter Address", "Error", JOptionPane.ERROR_MESSAGE);
                    address.requestFocus();
                } else {
                    i++;
                }
                boolean check = Customer.isValid(email.getText());
                if (check == false) {
                    JOptionPane.showMessageDialog(jPanel1, "Enter Vaild Mail ", "Error", JOptionPane.ERROR_MESSAGE);
                    phoneno.requestFocus();
                } else {
                    i++;
                }
                String phno = phoneno.getText();
                if (phno.isEmpty() == true) {
                    JOptionPane.showMessageDialog(jPanel1, "Fill Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                    phoneno.requestFocus();
                } else {
                    int length = phno.length();
                    if (length < 10) {
                        JOptionPane.showMessageDialog(jPanel1, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                        phoneno.requestFocus();
                    } else if (length > 10) {
                        JOptionPane.showMessageDialog(jPanel1, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                        phoneno.requestFocus();
                    } else {
                        i++;
                    }
                }
                if (i == 4) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                        pst = con.prepareStatement("update employee set employeename=?,address=?,email=?,phoneno=?,date=? where employeeid = ?");
                        pst.setString(1, employeename.getText());
                        pst.setString(2, address.getText());
                        pst.setString(3, email.getText());
                        pst.setString(4, phoneno.getText());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                        String date1 = dateFormat.format(date.getDate());
                        pst.setString(5, date1);
                        pst.setString(6, employeeid.getText());
                        pst.executeUpdate();
                        employeename.setText("");
                        address.setText("");
                        phoneno.setText("");
                        email.setText("");
                        JOptionPane.showMessageDialog(jPanel1, "Updated....! ");
                    } catch (SQLException e) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                        pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            int id = Integer.parseInt(rs.getString(1)) + 1;
                            String cal = String.valueOf(id);
                            employeeid.setText(cal);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException e) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                    }
                    employeetable.setModel(new DefaultTableModel(null, new String[]{"employeeID", "employeeName", "Address", "PhoneNumber", "Email", "Date"}));
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                        pst = con.prepareStatement("SELECT * from employee");
                        rs = pst.executeQuery();
                        while (rs.next()) {
                            String id = String.valueOf(rs.getInt("employeeid"));
                            String name = rs.getString("employeename");
                            String address = rs.getString("address");
                            String phoneno = rs.getString("phoneno");
                            String email = rs.getString("email");
                            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                            String date1 = dateFormat.format(rs.getDate("date"));
                            String customertable1[] = {id, name, address, phoneno, email, date1};
                            DefaultTableModel tblModel = (DefaultTableModel) employeetable.getModel();
                            tblModel.addRow(customertable1);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException e) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                    pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        int id = Integer.parseInt(rs.getString(1)) + 1;
                        String cal = String.valueOf(id);
                        employeeid.setText(cal);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException e) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                JOptionPane.showMessageDialog(jPanel1, "employee ID Not Registered", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT employeeid FROM employeeo ORDER BY employeeid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                employeeid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                employeeid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        int i = 0;
        String idf = employeeid.getText();
        if (employeeid.getText().isEmpty() == false) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT * from employee where employeeid = " + idf + "");
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(jPanel1, "employee ID Already Registered");
                    employeename.setText("");
                    address.setText("");
                    phoneno.setText("");
                    email.setText("");
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                        pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
                        rs = pst.executeQuery();
                        if (rs.next()) {
                            int id = Integer.parseInt(rs.getString(1)) + 1;
                            String cal = String.valueOf(id);
                            employeeid.setText(cal);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException e) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                    }
                } else {
                    if (employeename.getText().isEmpty() == true) {
                        JOptionPane.showMessageDialog(jPanel1, "Enter employee Name ", "Error", JOptionPane.ERROR_MESSAGE);
                        phoneno.requestFocus();
                    } else {
                        i++;
                    }
                    if (address.getText().isEmpty() == true) {
                        JOptionPane.showMessageDialog(jPanel1, "Enter Address", "Error", JOptionPane.ERROR_MESSAGE);
                        address.requestFocus();
                    } else {
                        i++;
                    }
                    boolean check = Customer.isValid(email.getText());
                    if (check == false) {
                        JOptionPane.showMessageDialog(jPanel1, "Enter Vaild Mail ", "Error", JOptionPane.ERROR_MESSAGE);
                        phoneno.requestFocus();
                    } else {
                        i++;
                    }
                    String phno = phoneno.getText();
                    if (phno.isEmpty() == true) {
                        JOptionPane.showMessageDialog(jPanel1, "Fill Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                        phoneno.requestFocus();
                    } else {
                        int length = phno.length();
                        if (length < 10) {
                            JOptionPane.showMessageDialog(jPanel1, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                            phoneno.requestFocus();
                        } else if (length > 10) {
                            JOptionPane.showMessageDialog(jPanel1, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                            phoneno.requestFocus();
                        } else {
                            i++;
                        }
                    }
                    if (i == 4) {
                        try {
                            pst = con.prepareStatement("insert into employee(employeeid,employeename,address,email,phoneno,date)values(?,?,?,?,?,?)");
                            pst.setString(1, employeeid.getText());
                            pst.setString(2, employeename.getText());
                            pst.setString(3, address.getText());
                            pst.setString(4, email.getText());
                            pst.setString(5, phoneno.getText());
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String date11 = sdf.format(date.getDate());
                            pst.setString(6, date11);
                            pst.executeUpdate();
                        } catch (SQLException e) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                        }
                        employeename.setText("");
                        address.setText("");
                        phoneno.setText("");
                        email.setText("");
                        JOptionPane.showMessageDialog(jPanel1, "Saved....! ");
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                            pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
                            rs = pst.executeQuery();
                            if (rs.next()) {
                                int id = Integer.parseInt(rs.getString(1)) + 1;
                                String cal = String.valueOf(id);
                                employeeid.setText(cal);
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException e) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                        }
                        employeetable.setModel(new DefaultTableModel(null, new String[]{"employeeID", "employeeName", "Address", "PhoneNumber", "Email", "Date"}));
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                            pst = con.prepareStatement("SELECT * from employee");
                            rs = pst.executeQuery();
                            while (rs.next()) {
                                String id = String.valueOf(rs.getInt("employeeid"));
                                String name = rs.getString("employeename");
                                String address = rs.getString("address");
                                String phoneno = rs.getString("phoneno");
                                String email = rs.getString("email");
                                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                                String date1 = dateFormat.format(rs.getDate("date"));
                                String customertable1[] = {id, name, address, phoneno, email, date1};
                                DefaultTableModel tblModel = (DefaultTableModel) employeetable.getModel();
                                tblModel.addRow(customertable1);
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException e) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }//GEN-LAST:event_saveActionPerformed

    private void saveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveKeyPressed

    }//GEN-LAST:event_saveKeyPressed

    private void employeetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeetableMouseClicked
        int row = employeetable.getSelectedRow();
        String tblclick = (employeetable.getModel().getValueAt(row, 0).toString());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from employee where employeeid = " + tblclick + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                String id = String.valueOf(rs.getInt("employeeid"));
                String name = rs.getString("employeename");
                String address1 = rs.getString("address");
                String phoneno1 = rs.getString("phoneno");
                String email1 = rs.getString("email");
                // String date1 = rs.getString("date");
                employeeid.setText(id);
                employeename.setText(name);
                address.setText(address1);
                phoneno.setText(phoneno1);
                email.setText(email1);
                //date.setDateFormatString(date1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_employeetableMouseClicked

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        employeetable.setModel(new DefaultTableModel(null, new String[]{"employeeID", "employeeName", "Address", "PhoneNumber", "Email", "Date"}));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from employee");
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("employeeid"));
                String name = rs.getString("employeename");
                String address = rs.getString("address");
                String phoneno = rs.getString("phoneno");
                String email = rs.getString("email");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String customertable1[] = {id, name, address, phoneno, email, date1};
                DefaultTableModel tblModel = (DefaultTableModel) employeetable.getModel();
                tblModel.addRow(customertable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        employeename.setText("");
        address.setText("");
        phoneno.setText("");
        email.setText("");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT employeeid FROM employee ORDER BY employeeid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                employeeid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_RefreshActionPerformed

    private void RefreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefreshKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshKeyPressed

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
            java.util.logging.Logger.getLogger(empolyeeadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(empolyeeadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(empolyeeadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(empolyeeadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new empolyeeadd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Refresh;
    private javax.swing.JTextField address;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField email;
    private javax.swing.JTextField employeeid;
    private javax.swing.JTextField employeename;
    private javax.swing.JTable employeetable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField phoneno;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
