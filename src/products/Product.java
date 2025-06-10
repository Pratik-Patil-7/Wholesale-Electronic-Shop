package products;


import stockandcategory.addcategory;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Product extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public Product() {
        initComponents();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from category");
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("categoryname");
                category.addItem(cat);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from products");
            rs = pst.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt("productid"));
                String productname = rs.getString("productname");
                String description = rs.getString("description");
                String originalprice = rs.getString("originalprice");
                String sellingprice = rs.getString("sellingprice");
                String category1 = rs.getString("category");
                String subcategory1 = rs.getString("subcategory");

                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String producttable1[] = {productid, productname, description, date1, originalprice, sellingprice, category1, subcategory1,};
                DefaultTableModel tblModel = (DefaultTableModel) producttable.getModel();
                tblModel.addRow(producttable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT productid FROM products ORDER BY productid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                productid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        productid.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        productid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        productname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        originalprice = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        sellingprice = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        subcategory = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        Refresh = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBackground(new java.awt.Color(102, 255, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product");

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setText("Product ID");

        productid.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        productid.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel7.setText("Product Name");

        productname.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        productname.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel11.setText("Description");

        description.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        description.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel13.setText("Date ");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel12.setText("Original Price");

        originalprice.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        originalprice.setToolTipText("");
        originalprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                originalpriceKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel16.setText("Selling Price");

        sellingprice.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        sellingprice.setToolTipText("");
        sellingprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sellingpriceKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel15.setText("Category");

        category.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryItemStateChanged(evt);
            }
        });
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        category.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                categoryPropertyChange(evt);
            }
        });
        category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoryKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel17.setText("Subcategory");

        subcategory.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        subcategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subcategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subcategoryMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subcategoryMousePressed(evt);
            }
        });
        subcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subcategoryActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 255, 102));
        jButton6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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

        producttable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        producttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productid", "productname", "description", "date", "originalprice", "sellingprice", "category", "sbucategory"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        producttable.setToolTipText("");
        producttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                producttableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(producttable);

        Refresh.setBackground(new java.awt.Color(102, 255, 102));
        Refresh.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");
        date.setMaxSelectableDate(new java.util.Date(253370748708000L));
        date.setMinSelectableDate(new java.util.Date(-62135785692000L));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(productid, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(originalprice, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(sellingprice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addComponent(productname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel16)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11)
                        .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addComponent(category, 0, 182, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subcategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 105, Short.MAX_VALUE))
                            .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originalprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sellingprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(subcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(update)
                    .addComponent(save)
                    .addComponent(Refresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new addcategory().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            pst = con.prepareStatement("delete from products where productid =?");
            pst.setString(1, productid.getText());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        productname.setText("");
        description.setText("");
        originalprice.setText("");
        sellingprice.setText("");
        JOptionPane.showMessageDialog(jPanel1, "Deleted....! ");
        producttable.setModel(new DefaultTableModel(null, new String[]{"productid", "productname", "description", "date", "originalprice", "sellingprice", "category", "subcategory"}));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from products");
            rs = pst.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt("productid"));
                String productname = rs.getString("productname");
                String description = rs.getString("description");
                String originalprice = rs.getString("originalprice");
                String sellingprice = rs.getString("sellingprice");
                String category = rs.getString("category");
                String subcategory = rs.getString("subcategory");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String customertable1[] = {productid, productname, description, date1, originalprice, sellingprice, category, subcategory,};
                DefaultTableModel tblModel = (DefaultTableModel) producttable.getModel();
                tblModel.addRow(customertable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT productid FROM products ORDER BY productid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                productid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        productid.setEditable(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int i = 0;
        if (productname.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter Product Name ", "Error", JOptionPane.ERROR_MESSAGE);
            productname.requestFocus();
        } else {
            i++;
        }
        if (description.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter Description", "Error", JOptionPane.ERROR_MESSAGE);
            description.requestFocus();
        } else {
            i++;
        }

        if (originalprice.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter Originalprice", "Error", JOptionPane.ERROR_MESSAGE);
            originalprice.requestFocus();
        } else {
            String op = originalprice.getText();
            i++;

        }
        if (sellingprice.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter selling price", "Error", JOptionPane.ERROR_MESSAGE);
            sellingprice.requestFocus();
        } else {
            i++;

        }
        if (i == 4) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("update products set productname=?,description=?,date=?,originalprice=?,sellingprice=?,category=?,subcategory=? where productid = ?");
                pst.setString(1, productname.getText());
                pst.setString(2, description.getText());
                pst.setString(5, sellingprice.getText());
                pst.setString(4, originalprice.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(date.getDate());
                pst.setString(3, date1);
                pst.setString(6, category.getSelectedItem().toString());
                pst.setString(7, subcategory.getSelectedItem().toString());
                pst.setString(8, productid.getText());
                pst.executeUpdate();
                productname.setText("");
                description.setText("");
                sellingprice.setText("");
                originalprice.setText("");
                JOptionPane.showMessageDialog(jPanel1, "Updated....! ");
            } catch (SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(jPanel1, "Saved");
            productname.setText("");
            description.setText("");
            originalprice.setText("");
            sellingprice.setText("");
            producttable.setModel(new DefaultTableModel(null, new String[]{"productid", "productname", "description", "date", "originalprice", "sellingprice", "category", "subcategory"}));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT * from products");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String productid = String.valueOf(rs.getInt("productid"));
                    String productname = rs.getString("productname");
                    String description = rs.getString("description");
                    String originalprice = rs.getString("originalprice");
                    String sellingprice = rs.getString("sellingprice");
                    String category1 = rs.getString("category");
                    String subcategory1 = rs.getString("subcategory");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    String date1 = dateFormat.format(rs.getDate("date"));
                    String customertable1[] = {productid, productname, description, date1, originalprice, sellingprice, category1, subcategory1,};
                    DefaultTableModel tblModel = (DefaultTableModel) producttable.getModel();
                    tblModel.addRow(customertable1);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT productid FROM products ORDER BY productid DESC LIMIT 1");
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = Integer.parseInt(rs.getString(1)) + 1;
                    String cal = String.valueOf(id);
                    productid.setText(cal);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            }

        }
    }//GEN-LAST:event_updateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        int i = 0;
        if (productname.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter Product Name ", "Error", JOptionPane.ERROR_MESSAGE);
            productname.requestFocus();
        } else {
            i++;
        }
        if (description.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter Description", "Error", JOptionPane.ERROR_MESSAGE);
            description.requestFocus();
        } else {
            i++;
        }

        if (originalprice.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter Originalprice", "Error", JOptionPane.ERROR_MESSAGE);
            originalprice.requestFocus();
        } else {
            String op = originalprice.getText();
            i++;

        }
        if (sellingprice.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel1, "Enter selling price", "Error", JOptionPane.ERROR_MESSAGE);
            sellingprice.requestFocus();
        } else {
            i++;
        }
        if (i == 4) {
            try {
                pst = con.prepareStatement("insert into products(productid,productname,description,date,originalprice,sellingprice,category,subcategory)values(?,?,?,?,?,?,?,?)");
                pst.setString(1, productid.getText());
                pst.setString(2, productname.getText());
                pst.setString(3, description.getText());
                pst.setString(5, originalprice.getText());
                pst.setString(6, sellingprice.getText());
                pst.setString(7, category.getSelectedItem().toString());
                pst.setString(8, subcategory.getSelectedItem().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date11 = sdf.format(date.getDate());
                pst.setString(4, date11);
                pst.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            }
            JOptionPane.showMessageDialog(jPanel1, "Saved......!");
            productname.setText("");
            description.setText("");
            originalprice.setText("");
            sellingprice.setText("");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT productid FROM products ORDER BY productid DESC LIMIT 1");
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = Integer.parseInt(rs.getString(1)) + 1;
                    String cal = String.valueOf(id);
                    productid.setText(cal);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            }
            producttable.setModel(new DefaultTableModel(null, new String[]{"productid", "productname", "description", "date", "originalprice", "sellingprice", "category", "subcategory"}));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT * from products");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String productid = String.valueOf(rs.getInt("productid"));
                    String productname = rs.getString("productname");
                    String description = rs.getString("description");
                    String originalprice = rs.getString("originalprice");
                    String sellingprice = rs.getString("sellingprice");
                    String category1 = rs.getString("category");
                    String subcategory1 = rs.getString("subcategory");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    String date1 = dateFormat.format(rs.getDate("date"));
                    String customertable1[] = {productid, productname, description, date1, originalprice, sellingprice, category1, subcategory1,};
                    DefaultTableModel tblModel = (DefaultTableModel) producttable.getModel();
                    tblModel.addRow(customertable1);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT productid FROM products ORDER BY productid DESC LIMIT 1");
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = Integer.parseInt(rs.getString(1)) + 1;
                    String cal = String.valueOf(id);
                    productid.setText(cal);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            }

        }

    }//GEN-LAST:event_saveActionPerformed

    private void originalpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_originalpriceKeyPressed
        String s = originalprice.getText();
        int length = s.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 9) {

            } else {

                originalprice.setText("");
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                originalprice.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Enter number only", "Error", JOptionPane.ERROR_MESSAGE);
                originalprice.setText("");
                originalprice.setFocusable(true);
            }
        }
    }//GEN-LAST:event_originalpriceKeyPressed

    private void sellingpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellingpriceKeyPressed
        String s = sellingprice.getText();
        int length = s.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 9) {

            } else {

                sellingprice.setText("");
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                sellingprice.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Enter number only", "Error", JOptionPane.ERROR_MESSAGE);
                sellingprice.setText("");
                sellingprice.setFocusable(true);
            }
        }
    }//GEN-LAST:event_sellingpriceKeyPressed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed

        productname.setText("");
        description.setText("");
        sellingprice.setText("");
        originalprice.setText("");
        producttable.setModel(new DefaultTableModel(null, new String[]{"productid", "productname", "description", "date", "originalprice", "sellingprice", "category", "subcategory"}));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from products");
            rs = pst.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt("productid"));
                String productname = rs.getString("productname");
                String description = rs.getString("description");
                String originalprice = rs.getString("originalprice");
                String sellingprice = rs.getString("sellingprice");
                String category1 = rs.getString("category");
                String subcategory1 = rs.getString("subcategory");
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String date1 = dateFormat.format(rs.getDate("date"));
                String customertable1[] = {productid, productname, description, date1, originalprice, sellingprice, category1, subcategory1,};
                DefaultTableModel tblModel = (DefaultTableModel) producttable.getModel();
                tblModel.addRow(customertable1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT productid FROM products ORDER BY productid DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                productid.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_RefreshActionPerformed

    private void producttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_producttableMouseClicked
        int row = producttable.getSelectedRow();
        String tblclick = (producttable.getModel().getValueAt(row, 0).toString());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from products where productid = " + tblclick + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                String productid1 = rs.getString("productid");
                String productname1 = rs.getString("productname");
                String description1 = rs.getString("description");
                String originalprice1 = rs.getString("originalprice");
                String sellingprice1 = rs.getString("sellingprice");
                productid.setText(productid1);
                productname.setText(productname1);
                description.setText(description1);
                originalprice.setText(originalprice1);
                sellingprice.setText(sellingprice1);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_producttableMouseClicked

    private void categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryItemStateChanged

    }//GEN-LAST:event_categoryItemStateChanged

    private void categoryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_categoryPropertyChange

    }//GEN-LAST:event_categoryPropertyChange

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed

    }//GEN-LAST:event_categoryActionPerformed

    private void categoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryKeyPressed

    }//GEN-LAST:event_categoryKeyPressed

    private void subcategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subcategoryMouseClicked
        subcategory.removeAllItems();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT subcategoryname from subcategory where categoryname = '" + category.getSelectedItem().toString() + "'");
            rs = pst.executeQuery();
          
                while (rs.next()) {
                    String cat = rs.getString("subcategoryname");
                    subcategory.addItem(cat);
                }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_subcategoryMouseClicked

    private void subcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subcategoryActionPerformed

    }//GEN-LAST:event_subcategoryActionPerformed

    private void subcategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subcategoryMouseEntered


    }//GEN-LAST:event_subcategoryMouseEntered

    private void subcategoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subcategoryMousePressed

    }//GEN-LAST:event_subcategoryMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JComboBox<String> category;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField originalprice;
    private javax.swing.JTextField productid;
    private javax.swing.JTextField productname;
    private javax.swing.JTable producttable;
    private javax.swing.JButton save;
    private javax.swing.JTextField sellingprice;
    private javax.swing.JComboBox<String> subcategory;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
