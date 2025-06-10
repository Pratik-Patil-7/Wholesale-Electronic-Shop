package manufacturer;


import application.Home;
import customer.Customer;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Manufacturer extends javax.swing.JFrame {

    public static boolean isValid(String email) {
        String emailFormate = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."
                + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern p = Pattern.compile(emailFormate);
        if (email == null) {
            return false;
        }
        return p.matcher(email).matches();
    }
    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public Manufacturer() {
        initComponents();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from manufacturer");
            rs = pst.executeQuery();
            while (rs.next()) {
                String mid1 = String.valueOf(rs.getInt("manufacturerid"));
                String mname1 = rs.getString("manufacturername");
                String alternateno1 = rs.getString("alternateno");
                String address1 = rs.getString("address");
                String mobileno1 = rs.getString("mobileno");
                String gstin1 = rs.getString("gstin");
                String email1 = rs.getString("email");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String mtable1[] = {mid1, mname1, alternateno1, date1, address1, mobileno1, gstin1, email1,};
                DefaultTableModel tblModel = (DefaultTableModel) mtable.getModel();
                tblModel.addRow(mtable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT manufacturerid FROM manufacturer ORDER BY manufacturerid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                mid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
        mid.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        mid = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        mname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        alternateno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        gstin = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        mobileno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        mtable = new javax.swing.JTable();
        date = new com.toedter.calendar.JDateChooser();
        Refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(102, 255, 102));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Manufacturer");

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mid.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        mid.setToolTipText("");

        address.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        address.setToolTipText("");

        email.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        email.setToolTipText("");
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });

        mname.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        mname.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setText("Manufacturer ID");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel9.setText("Manufacturer Name");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel12.setText("Email ID");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel13.setText("Mobile No");

        alternateno.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        alternateno.setToolTipText("");
        alternateno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alternatenoKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel14.setText("Alternate No");

        gstin.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        gstin.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel15.setText("Address ");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                saveKeyTyped(evt);
            }
        });

        delete.setBackground(new java.awt.Color(102, 255, 102));
        delete.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel16.setText("Date");

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel17.setText("GSTIN No");

        mobileno.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        mobileno.setToolTipText("");
        mobileno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobilenoActionPerformed(evt);
            }
        });
        mobileno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobilenoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobilenoKeyTyped(evt);
            }
        });

        mtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "manufacturerid", "manufacturername", "alternateno", "date", "address", "mobileno", "GSTIN ", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mtableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mtable);

        date.setDateFormatString("yyyy-MM-dd");

        Refresh.setBackground(new java.awt.Color(102, 255, 102));
        Refresh.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(446, 446, 446)
                                .addComponent(jLabel10))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(mid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel13))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(alternateno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel17))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel16)
                                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(mobileno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alternateno)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(498, 498, 498))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gstin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobileno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(update)
                            .addComponent(save)
                            .addComponent(Refresh))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)))
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mobileno.getAccessibleContext().setAccessibleName("mobileno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 765, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int i = 0;
        if (mname.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Enter manufacturer Name ", "Error", JOptionPane.ERROR_MESSAGE);
            mname.requestFocus();
        } else {
            i++;
        }
        if (address.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Enter Address", "Error", JOptionPane.ERROR_MESSAGE);
            address.requestFocus();
        } else {
            i++;
        }
        boolean check = Customer.isValid(email.getText());
        if (check == false) {
            JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Mail ", "Error", JOptionPane.ERROR_MESSAGE);
            email.requestFocus();
        } else {
            i++;
        }
        String phno = mobileno.getText();
        if (phno.isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Fill Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
            mobileno.requestFocus();
        } else {
            int length = phno.length();
            if (length < 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                mobileno.requestFocus();
            } else if (length > 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                mobileno.requestFocus();
            } else {
                i++;
            }
        }
        String phno1 = alternateno.getText();
        if (phno1.isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Fill Alternate Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
            alternateno.requestFocus();
        } else {
            int length = phno.length();
            if (length < 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Alternate Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                alternateno.requestFocus();
            } else if (length > 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Alternate Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                alternateno.requestFocus();
            } else {
                i++;
            }
        }
        if (i == 5) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("update manufacturer set manufacturername=?,date=?,alternateno=?,mobileno=?,address=?,GSTIN=?,email=? where manufacturerid = ?");
                pst.setString(8, mid.getText());
                pst.setString(1, mname.getText());
                pst.setString(4, mobileno.getText());
                pst.setString(3, alternateno.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(date.getDate());
                pst.setString(2, date1);
                pst.setString(5, address.getText());
                pst.setString(6, gstin.getText());
                pst.setString(7, email.getText());
                pst.executeUpdate();
                mname.setText("");
                address.setText("");
                mobileno.setText("");
                alternateno.setText("");
                gstin.setText("");
                email.setText("");
                JOptionPane.showMessageDialog(jPanel5, "Updated....! ");
            } catch (SQLException e) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
            }
            mname.setText("");
            address.setText("");
            mobileno.setText("");
            alternateno.setText("");
            gstin.setText("");
            email.setText("");
            mtable.setModel(new DefaultTableModel(null, new String[]{"manufacturerid", "manufacturername", "alternateno", "date", "address", "mobileno", "gstin", "email"}));
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT * from manufacturer");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String mid1 = String.valueOf(rs.getInt("manufacturerid"));
                    String mname1 = rs.getString("manufacturername");
                    String alternateno1 = rs.getString("alternateno");
                    String address1 = rs.getString("address");
                    String mobileno1 = rs.getString("mobileno");
                    String gstin1 = rs.getString("gstin");
                    String email1 = rs.getString("email");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    String date1 = dateFormat.format(rs.getDate("date"));
                    String mtable1[] = {mid1, mname1, alternateno1, date1, address1, mobileno1, gstin1, email1,};
                    DefaultTableModel tblModel = (DefaultTableModel) mtable.getModel();
                    tblModel.addRow(mtable1);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT manufacturerid FROM manufacturer ORDER BY manufacturerid DESC LIMIT 1");
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = Integer.parseInt(rs.getString(1)) + 1;
                    String cal = String.valueOf(id);
                    mid.setText(cal);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        int i = 0;
        if (mname.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Enter manufacturer Name ", "Error", JOptionPane.ERROR_MESSAGE);
            mname.requestFocus();
        } else {
            i++;
        }
        if (address.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Enter Address", "Error", JOptionPane.ERROR_MESSAGE);
            address.requestFocus();
        } else {
            i++;
        }

        boolean check = Customer.isValid(email.getText());
        if (check == false) {
            JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Mail ", "Error", JOptionPane.ERROR_MESSAGE);
            email.requestFocus();
        } else {
            i++;
        }
        String phno = mobileno.getText();
        if (phno.isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Fill Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
            mobileno.requestFocus();
        } else {
            int length = phno.length();
            if (length < 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                mobileno.requestFocus();
            } else if (length > 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                mobileno.requestFocus();
            } else {
                i++;
            }
        }
        String phno1 = alternateno.getText();
        if (phno1.isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Fill Alternate Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
            alternateno.requestFocus();
        } else {
            int length = phno.length();
            if (length < 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Alternate Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                alternateno.requestFocus();
            } else if (length > 10) {
                JOptionPane.showMessageDialog(jPanel5, "Enter Vaild Alternate Phone Number ", "Error", JOptionPane.ERROR_MESSAGE);
                alternateno.requestFocus();
            } else {
                i++;
            }
        }
        if (i == 5) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("insert into manufacturer( manufacturerid, manufacturername,mobileno,alternateno,date,address,gstin,email)values(?,?,?,?,?,?,?,?)");
                pst.setString(1, mid.getText());
                pst.setString(2, mname.getText());
                pst.setString(3, mobileno.getText());
                pst.setString(4, alternateno.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(date.getDate());
                pst.setString(5, date1);
                pst.setString(6, address.getText());
                pst.setString(7, gstin.getText());
                pst.setString(8, email.getText());
                pst.executeUpdate();
                mname.setText("");
                address.setText("");
                mobileno.setText("");
                alternateno.setText("");
                gstin.setText("");
                email.setText("");
                JOptionPane.showMessageDialog(jPanel5, "Saved....! ");
            } catch (SQLException e) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
            }
            mname.setText("");
            address.setText("");
            mobileno.setText("");
            alternateno.setText("");
            gstin.setText("");
            email.setText("");
            mtable.setModel(new DefaultTableModel(null, new String[]{"manufacturerid", "manufacturername", "alternateno", "date", "address", "mobileno", "gstin", "email"}));
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT * from manufacturer");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String mid1 = String.valueOf(rs.getInt("manufacturerid"));
                    String mname1 = rs.getString("manufacturername");
                    String alternateno1 = rs.getString("alternateno");
                    String address1 = rs.getString("address");
                    String mobileno1 = rs.getString("mobileno");
                    String gstin1 = rs.getString("gstin");
                    String email1 = rs.getString("email");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    String date1 = dateFormat.format(rs.getDate("date"));
                    String mtable1[] = {mid1, mname1, alternateno1, date1, address1, mobileno1, gstin1, email1,};
                    DefaultTableModel tblModel = (DefaultTableModel) mtable.getModel();
                    tblModel.addRow(mtable1);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT manufacturerid FROM manufacturer ORDER BY manufacturerid DESC LIMIT 1");
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = Integer.parseInt(rs.getString(1)) + 1;
                    String cal = String.valueOf(id);
                    mid.setText(cal);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            pst = con.prepareStatement("delete from manufacturer where manufacturerid =?");
            pst.setString(1, mid.getText());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
        JOptionPane.showMessageDialog(jPanel5, "Deleted....! ");
        mname.setText("");
        address.setText("");
        mobileno.setText("");
        alternateno.setText("");
        gstin.setText("");
        email.setText("");
        mtable.setModel(new DefaultTableModel(null, new String[]{"manufacturerid", "manufacturername", "alternateno", "date", "address", "mobileno", "gstin", "email"}));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from manufacturer");
            rs = pst.executeQuery();
            while (rs.next()) {
                String mid1 = String.valueOf(rs.getInt("manufacturerid"));
                String mname1 = rs.getString("manufacturername");
                String alternateno1 = rs.getString("alternateno");
                String address1 = rs.getString("address");
                String mobileno1 = rs.getString("mobileno");
                String gstin1 = rs.getString("gstin");
                String email1 = rs.getString("email");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String mtable1[] = {mid1, mname1, alternateno1, date1, address1, mobileno1, gstin1, email1,};
                DefaultTableModel tblModel = (DefaultTableModel) mtable.getModel();
                tblModel.addRow(mtable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT manufacturerid FROM manufacturer ORDER BY manufacturerid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                mid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void mobilenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobilenoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_mobilenoKeyTyped

    private void mobilenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobilenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobilenoActionPerformed

    private void mobilenoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobilenoKeyPressed
        String mobno = mobileno.getText();
        int length = mobno.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {

                mobileno.setEditable(true);
            } else {

                mobileno.setEditable(false);
            }

        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                mobileno.setEditable(true);
            } else {
                mobileno.setEditable(false);
            }

        }
    }//GEN-LAST:event_mobilenoKeyPressed

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased


    }//GEN-LAST:event_emailKeyReleased

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped

    }//GEN-LAST:event_emailKeyTyped

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed

    }//GEN-LAST:event_emailKeyPressed

    private void alternatenoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alternatenoKeyPressed
        String j = alternateno.getText();
        int length = j.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {
                alternateno.setEditable(true);
            } else {
                alternateno.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                alternateno.setEditable(true);

            } else {
                alternateno.setEditable(false);
            }
        }
    }//GEN-LAST:event_alternatenoKeyPressed

    private void saveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveKeyTyped

    }//GEN-LAST:event_saveKeyTyped

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        mname.setText("");
        address.setText("");
        mobileno.setText("");
        alternateno.setText("");
        gstin.setText("");
        email.setText("");
        mtable.setModel(new DefaultTableModel(null, new String[]{"manufacturerid", "manufacturername", "alternateno", "date", "address", "mobileno", "gstin", "email"}));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from manufacturer");
            rs = pst.executeQuery();
            while (rs.next()) {
                String manufacturerid1 = String.valueOf(rs.getInt("manufacturerid"));
                String manufacturername1 = rs.getString("manufacturername");
                String alternateno1 = rs.getString("alternateno");
                String address1 = rs.getString("address");
                String mobileno1 = rs.getString("mobileno");
                String gstin1 = rs.getString("gstin");
                String email1 = rs.getString("email");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String mtable1[] = {manufacturerid1, manufacturername1, alternateno1, date1, address1, mobileno1, gstin1, email1,};
                DefaultTableModel tblModel = (DefaultTableModel) mtable.getModel();
                tblModel.addRow(mtable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT manufacturerid FROM manufacturer ORDER BY manufacturerid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                mid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_RefreshActionPerformed

    private void mtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mtableMouseClicked
        int row = mtable.getSelectedRow();
        String tblclick = (mtable.getModel().getValueAt(row, 0).toString());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from manufacturer where manufacturerid = " + tblclick + "");
            rs = pst.executeQuery();
            while (rs.next()) {
                String manufacturerrid1 = String.valueOf(rs.getInt("manufacturerid"));
                String manufacturername1 = rs.getString("manufacturername");
                String alternateno1 = rs.getString("alternateno");
                String address1 = rs.getString("address");
                String mobileno1 = rs.getString("mobileno");
                String gstin1 = rs.getString("gstin");
                String email1 = rs.getString("email");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                mid.setText(manufacturerrid1);
                mname.setText(manufacturername1);
                alternateno.setText(alternateno1);
                address.setText(address1);
                mobileno.setText(mobileno1);
                gstin.setText(gstin1);
                email.setText(email1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_mtableMouseClicked

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
            java.util.logging.Logger.getLogger(Manufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manufacturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manufacturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JTextField address;
    private javax.swing.JTextField alternateno;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delete;
    private javax.swing.JTextField email;
    private javax.swing.JTextField gstin;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mid;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField mobileno;
    private javax.swing.JTable mtable;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
