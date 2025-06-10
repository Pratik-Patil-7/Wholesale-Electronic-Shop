package retailer;


import application.Home;
import products.Product;
import customer.Customerbill;
import customer.Customer;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Retailerorder extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public Retailerorder() {
        initComponents();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT billno FROM customerbill ORDER BY billno DESC LIMIT 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1)) + 1;
                String cal = String.valueOf(id);
                billno.setText(cal);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException e) {
            Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from retailer");
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("retailername");
                retailername.addItem(cat);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException e) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
        billno.setEditable(false);
        totaltax.setEditable(false);
        actualtotal.setEditable(false);
        retailername.setEditable(false);
        productprice.setEditable(false);
        quantity.setEditable(false);
    }

    public void fun() {

        try {
            String productname1 = productname.getSelectedItem().toString();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT * from products where productname = '" + productname1 + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                String price = String.valueOf(rs.getInt("sellingprice"));
                String quantity1 = String.valueOf(rs.getInt("stockquanitiy"));
                quantity.setText(quantity1);
                productprice.setText(price);
            } else {
                JOptionPane.showMessageDialog(jPanel5, "Product Price Not Found", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException e) {
            Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        billno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        retailername = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        billdate = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        category = new javax.swing.JComboBox<>();
        subcategory = new javax.swing.JComboBox<>();
        productname = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        productprice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        actualtotal = new javax.swing.JTextField();
        cgst = new javax.swing.JTextField();
        sgst = new javax.swing.JTextField();
        totaltax = new javax.swing.JTextField();
        igst = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pquantity = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Retailer Bill");

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        billno.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        billno.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setText("Retailer : ");

        retailername.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel9.setText("Bill Date :");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel7.setText("Bill No :");

        billdate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(billno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billdate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retailername, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(retailername, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(billno, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(billdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Price", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bill);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
        });

        category.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryMouseClicked(evt);
            }
        });

        subcategory.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        subcategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subcategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subcategoryMouseEntered(evt);
            }
        });
        subcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subcategoryActionPerformed(evt);
            }
        });

        productname.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        productname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productnameMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setText("Category :");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel10.setText("Product Name :");

        productprice.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        productprice.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel11.setText("Product Price : ");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setText("Quantity :");

        quantity.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        quantity.setToolTipText("");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel12.setText("SGST :");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel14.setText("CGST :");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel15.setText("Total With Tax : ");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel16.setText("IGST :");

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel17.setText("Actual Total : ");

        actualtotal.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        actualtotal.setToolTipText("");
        actualtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                actualtotalKeyPressed(evt);
            }
        });

        cgst.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cgst.setToolTipText("");
        cgst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cgstKeyPressed(evt);
            }
        });

        sgst.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        sgst.setToolTipText("");
        sgst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sgstKeyPressed(evt);
            }
        });

        totaltax.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        totaltax.setToolTipText("");

        igst.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        igst.setToolTipText("");
        igst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                igstKeyPressed(evt);
            }
        });

        jButton5.setText("Calculate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualtotal))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cgst))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sgst)
                            .addComponent(igst)
                            .addComponent(totaltax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(actualtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cgst, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igst, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sgst, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(totaltax, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel13.setText("Subcategory :");

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jButton2.setText("Save ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        pquantity.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        pquantity.setToolTipText("");
        pquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pquantityActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel19.setText("Purchase Quantity :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(category, 0, 210, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(productname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantity))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productprice, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(pquantity)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productprice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = bill.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) bill.getModel();
        int i;
        for (i = 0; i < bill.getRowCount(); i++) {
            String pname = (bill.getModel().getValueAt(i, 0).toString());
            String pquantity1 = model.getValueAt(i, 2).toString();
            String oquantity = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT * from products where productname = '" + pname + "'");
                rs = pst.executeQuery();
                if (rs.next()) {
                    oquantity = String.valueOf(rs.getInt("stockquanitiy"));
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.sql.SQLException e) {
                Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, e);
            }
            int a = Integer.parseInt(pquantity1.toString());
            int b = Integer.parseInt(oquantity.toString());
            int c = a + b;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("update products set stockquanitiy=? where productname = ?");
                pst.setString(1, String.valueOf(c));
                pst.setString(2, pname);
                pst.executeUpdate();
            } catch (java.sql.SQLException e) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        actualtotal.setText("");
        sgst.setText("");
        igst.setText("");
        sgst.setText("");
        totaltax.setText("");
        bill.setModel(new DefaultTableModel(null, new String[]{"Product Name", "Product Price", "Quantity", "Total"}));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) bill.getModel();
        int i;
        if (igst.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Enter CGST");

        } else if (sgst.getText().isEmpty() == true || sgst.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(jPanel5, "Enter IGST or SGST");
        } else {
            for (i = 0; i < bill.getRowCount(); i++) {
                String pname = model.getValueAt(i, 0).toString();
                String pprice = model.getValueAt(i, 1).toString();
                String pquantity1 = model.getValueAt(i, 2).toString();
                String ptotal = model.getValueAt(i, 3).toString();
                try {
                    pst = con.prepareStatement("insert into retailerbill(billno,productname,retailername,productprice,date,quantity,total)values(?,?,?,?,?,?,?)");
                    pst.setString(1, billno.getText());
                    pst.setString(2, pname);
                    pst.setString(3, retailername.getSelectedItem().toString());
                    pst.setString(4, pprice);
                    pst.setString(6, pquantity1);
                    pst.setString(7, ptotal);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date11 = sdf.format(billdate.getDate());
                    pst.setString(5, date11);
                    pst.executeUpdate();
                } catch (java.sql.SQLException e) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            try {
                pst = con.prepareStatement("insert into retailerbilltotal(billno,cgst,igst,sgst,actualtotal,totalwithtax)values(?,?,?,?,?,?)");
                pst.setString(1, billno.getText());
                pst.setString(2, cgst.getText());
                pst.setString(3, igst.getText());
                pst.setString(4, sgst.getText());
                pst.setString(5, actualtotal.getText());
                pst.setString(6, totaltax.getText());
                pst.executeUpdate();
            } catch (java.sql.SQLException e) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
            }
            bill.setModel(new DefaultTableModel(null, new String[]{"productname", "productprice", "quantity", "totalprice"}));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT billno FROM retailerbill ORDER BY billno DESC LIMIT 1");
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = Integer.parseInt(rs.getString(1)) + 1;
                    String cal = String.valueOf(id);
                    billno.setText(cal);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.sql.SQLException e) {
                Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        JOptionPane.showMessageDialog(jPanel1, "Bill Saved...!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (retailername.getItemCount() == 0) {
            JOptionPane.showMessageDialog(jPanel5, "Select Retailer Name");
        } else if (category.getItemCount() == 0) {
            JOptionPane.showMessageDialog(jPanel5, "Select Category");
        } else if (subcategory.getItemCount() == 0) {
            JOptionPane.showMessageDialog(jPanel5, "Select Subcategory");
        } else if (productname.getItemCount() == 0) {
            JOptionPane.showMessageDialog(jPanel5, "Select ProductName");
        } else {
            int rquantity = Integer.parseInt(quantity.getText());
            int squantity = Integer.parseInt(pquantity.getText());

            if (rquantity >= squantity) {

                String pname = productname.getSelectedItem().toString();
                String pquantity1 = pquantity.getText();
                String oprice = productprice.getText();
                int total = Integer.parseInt(oprice) * Integer.parseInt(pquantity1);
                String stotal = String.valueOf(total);
                String billtable1[] = {pname, oprice, pquantity1, stotal};
                DefaultTableModel tblModel = (DefaultTableModel) bill.getModel();
                tblModel.addRow(billtable1);
                String atotal = actualtotal.getText();
                int caltotal;
                if (atotal.equals("")) {
                    atotal = "0";
                }
                caltotal = Integer.parseInt(atotal) + total;
                actualtotal.setText(String.valueOf(caltotal));
                int a = Integer.parseInt(quantity.getText());
                int b = Integer.parseInt(pquantity.getText());
                int c;
                if (a > b) {
                    c = a - b;
                } else {
                    c = b - a;
                }
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                    pst = con.prepareStatement("update products set stockquanitiy=? where productname = ?");
                    pst.setString(1, String.valueOf(c));
                    pst.setString(2, pname);
                    pst.executeUpdate();

                } catch (java.sql.SQLException e) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }
                category.setSelectedIndex(0);

            } else {
                JOptionPane.showMessageDialog(jPanel5, "Less Quantity ");

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cgstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cgstKeyPressed
        String s = cgst.getText();
        int length = s.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 2) {

            } else {
                JOptionPane.showMessageDialog(jPanel5, "enter only 2 digit number");
                cgst.setText("");
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                cgst.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(jPanel5, "Enter number only", "Error", JOptionPane.ERROR_MESSAGE);
                cgst.setText("");
                cgst.setFocusable(true);
            }
        }
    }//GEN-LAST:event_cgstKeyPressed

    private void actualtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actualtotalKeyPressed

    }//GEN-LAST:event_actualtotalKeyPressed

    private void sgstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sgstKeyPressed
        String s = sgst.getText();
        int length = s.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 2) {
                igst.setEditable(false);
                igst.setText("0");
            } else {
                JOptionPane.showMessageDialog(jPanel5, "enter only 2 digit number");
                sgst.setText("");
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                sgst.setEditable(true);
                igst.setEditable(true);
                igst.setText("");
            } else {
                JOptionPane.showMessageDialog(jPanel5, "Enter number only", "Error", JOptionPane.ERROR_MESSAGE);
                sgst.setText("");
                sgst.setFocusable(true);
            }
        }
    }//GEN-LAST:event_sgstKeyPressed

    private void igstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igstKeyPressed
        String s = igst.getText();
        int length = s.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 2) {
                sgst.setEditable(false);
                sgst.setText("0");
            } else {
                JOptionPane.showMessageDialog(jPanel5, "enter only 2 digit number");
                igst.setText("");
                sgst.setEditable(true);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                igst.setEditable(true);
                sgst.setEditable(true);
                sgst.setText("");
            } else {
                JOptionPane.showMessageDialog(jPanel5, "Enter number only", "Error", JOptionPane.ERROR_MESSAGE);
                igst.setText("");
                igst.setFocusable(true);
            }
        }
    }//GEN-LAST:event_igstKeyPressed

    private void pquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pquantityActionPerformed

    }//GEN-LAST:event_pquantityActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (cgst.getText().isEmpty() == true) {

        } else if (actualtotal.getText().isEmpty() == true) {

        } else if (igst.getText().isEmpty() == true || sgst.getText().isEmpty() == true) {

        } else {
            int acttotal = Integer.parseInt(actualtotal.getText());
            if ("0".equals(sgst.getText()) || "".equals(sgst.getText())) {
                int s = Integer.parseInt(igst.getText());
                int sresult = ((acttotal * s) / 100);
                int c = Integer.parseInt(cgst.getText());
                int fresult = ((acttotal * c) / 100);
                // JOptionPane.showConfirmDialog(jPanel6, fresult);
                int tot = sresult + fresult + acttotal;
                totaltax.setText(String.valueOf(tot));
            } else {
                int s = Integer.parseInt(sgst.getText());
                int sresult = ((acttotal * s) / 100);
                // JOptionPane.showConfirmDialog(jPanel1, sresult);
                int c = Integer.parseInt(cgst.getText());
                int fresult = ((acttotal * c) / 100);
                // JOptionPane.showConfirmDialog(jPanel6, fresult);
                int tot = sresult + fresult + acttotal;
                totaltax.setText(String.valueOf(tot));
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered

        if (productname.getSelectedItem() != null) {
            fun();
        }
    }//GEN-LAST:event_jPanel5MouseEntered

    private void categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryMouseClicked
        category.removeAllItems();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT DISTINCT categoryname from category");
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("categoryname");
                category.addItem(cat);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException e) {
//            Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_categoryMouseClicked

    private void subcategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subcategoryMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_subcategoryMouseEntered

    private void subcategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subcategoryMouseClicked
        subcategory.removeAllItems();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT DISTINCT subcategoryname from subcategory where categoryname = '" + category.getSelectedItem().toString() + "'");
            rs = pst.executeQuery();
            if (rs.next() == false) {
                subcategory.removeAllItems();
            } else {
                while (rs.next()) {
                    String cat = rs.getString("subcategoryname");
                    subcategory.addItem(cat);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException e) {
//            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_subcategoryMouseClicked

    private void productnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productnameMouseClicked
        productname.removeAllItems();
        productprice.setText("");
        String productname1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
            pst = con.prepareStatement("SELECT DISTINCT productname from products where subcategory = '" + subcategory.getSelectedItem().toString() + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                String cat = rs.getString("productname");
                productname.addItem(cat);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException e) {
//            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_productnameMouseClicked

    private void billMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billMouseClicked
        int row = bill.getSelectedRow();
        int answer = JOptionPane.showConfirmDialog(jPanel1, "Do you Want ot Delete This Item ?");
        if (answer == JOptionPane.YES_OPTION) {
            String pname = (bill.getModel().getValueAt(row, 0).toString());
            String tquantity = (bill.getModel().getValueAt(row, 2).toString());
            String oquantity = "";
            String total12 = (bill.getModel().getValueAt(row, 3).toString());
            int total13 = Integer.parseInt(total12);
            int atotal = Integer.parseInt(actualtotal.getText());
            int finaltotal;
            if (total13 > atotal) {
                finaltotal = total13 - atotal;
            } else {
                finaltotal = atotal - total13;
            }
            actualtotal.setText(String.valueOf(finaltotal));
            try {
                String productname1 = productname.getSelectedItem().toString();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("SELECT * from products where productname = '" + productname1 + "'");
                rs = pst.executeQuery();
                if (rs.next()) {

                    oquantity = String.valueOf(rs.getInt("stockquanitiy"));

                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.sql.SQLException e) {
//                Logger.getLogger(Customerbill.class.getName()).log(Level.SEVERE, null, e);
            }

            int a = Integer.parseInt(tquantity.toString());
            int b = Integer.parseInt(oquantity.toString());
            int c = a + b;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicshop", "root", "12345");
                pst = con.prepareStatement("update products set stockquanitiy=? where productname = ?");
                pst.setString(1, String.valueOf(c));
                pst.setString(2, pname);
                pst.executeUpdate();

            } catch (java.sql.SQLException e) {
//                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel model = (DefaultTableModel) bill.getModel();
            model.removeRow(row);
        }
    }//GEN-LAST:event_billMouseClicked

    private void subcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subcategoryActionPerformed

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
            java.util.logging.Logger.getLogger(Retailerorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retailerorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retailerorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retailerorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retailerorder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualtotal;
    private javax.swing.JTable bill;
    private com.toedter.calendar.JDateChooser billdate;
    private javax.swing.JTextField billno;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JTextField cgst;
    private javax.swing.JTextField igst;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pquantity;
    private javax.swing.JComboBox<String> productname;
    private javax.swing.JTextField productprice;
    private javax.swing.JTextField quantity;
    private javax.swing.JComboBox<String> retailername;
    private javax.swing.JTextField sgst;
    private javax.swing.JComboBox<String> subcategory;
    private javax.swing.JTextField totaltax;
    // End of variables declaration//GEN-END:variables
}
