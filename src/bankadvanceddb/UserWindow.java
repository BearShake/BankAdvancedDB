/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankadvanceddb;


import static bankadvanceddb.AdminWindow.DB_URL;
import static bankadvanceddb.AdminWindow.DB_LOGIN;
import static bankadvanceddb.AdminWindow.DB_PASS;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Anton
 */
public class UserWindow extends javax.swing.JFrame {

static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  

    private String izvKontaTips = "";

    private float kLinija;
    private float kAtlikums;
    private float kProcenti;
    
    private String knum;
    
    private float atlikums;
    
    private int userID;
    /**
     * Creates new form UserWindow
     */
    public UserWindow(int id) {
        initComponents();
        JsveiciensLabel.setText("Sveiciens, ");
        this.setUserID(id);
        init();
    }

    public UserWindow(int id, String ch){

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                new UserWindow(id).setVisible(true); 
            }
        });
        
    }
    
    
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public void init(){
        int rsCounter = 0;
        int rsCounter1 = 0;
        try{
            
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
                    
                    Statement st = con.createStatement();
                    System.out.print(" " + this.userID + "       IDDDDDDDD");
                    
                    ResultSet counter = st.executeQuery("SELECT count(*) from KredKonti");
                    counter.next();
                    rsCounter = counter.getInt("count(*)");
                    System.out.println(rsCounter + "   rs counter");
                    counter.close();

                    ResultSet rName = st.executeQuery("SELECT * from Users where id = " + this.getUserID());
                    rName.next();
                    JsveiciensLabel.setText("Sveiciens, " + rName.getString("userFirstname"));
                    rName.close();
                    
                    ResultSet rs = st.executeQuery("SELECT * from KredKonti where id = " + this.getUserID()  );
                    DefaultListModel model = new DefaultListModel();
                    
                    float[] krArray = new float[rsCounter];
                    rsCounter = 0;
                    
                    DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
                    
                    while(rs.next()){
                       
                       rsCounter += 1;
                       tb.addRow(new Object[]{rs.getString("kNum"), rs.getInt("kr"), rs.getFloat("procenti")});
                       krArray[rsCounter] = rs.getFloat("kr");
                       
                    }rs.close();
                    
                    
                    ResultSet counter1 = st.executeQuery("SELECT count(*) from KredKonti");
                    counter1.next();
                    rsCounter1 = counter1.getInt("count(*)");
                    System.out.println(rsCounter + "  rs1 counter");
                    counter1.close();
                    
                    ResultSet rs1 = st.executeQuery("SELECT * from NorekKonti where id = " + this.getUserID());

                    float[] nrArray = new float[rsCounter1];
                    
                    rsCounter = 0;
                    DefaultTableModel tb1 = (DefaultTableModel) jTable2.getModel();
                    while(rs1.next()){
                        rsCounter += 1;
                        model.addElement(" Konts (Noreķinu): " + rs1.getString("kNum") + "  Atlikums: " + rs1.getFloat("atlikums"));
                        
                        tb1.addRow(new Object[]{rs1.getString("kNum"), rs1.getFloat("atlikums")});
                        nrArray[rsCounter] = rs1.getFloat("atlikums");
                    }
                    
                    
                    //CLEANING
                    rs1.close();
                    st.close();
                    con.close();
                    
                    
                    
                    }catch(SQLException se){
                       se.printStackTrace();
                    }catch(Exception s){
                        s.printStackTrace();
                    }finally{
                        //FIN
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

        jTextField4 = new javax.swing.JTextField();
        jDialog1 = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        kIzvele = new javax.swing.JPopupMenu();
        izvKontu = new javax.swing.JMenuItem();
        nKontIzv = new javax.swing.JPopupMenu();
        izvNorKontu = new javax.swing.JMenuItem();
        JsveiciensLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nKont = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        kKont = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kLineLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JButtPiev = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jBilance = new javax.swing.JTextField();
        izvKonts = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jKredKontPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        izvLabel = new javax.swing.JLabel();
        izvKField = new javax.swing.JTextField();
        klLabel = new javax.swing.JLabel();
        prLabel = new javax.swing.JLabel();
        izvKLine = new javax.swing.JTextField();
        izvPr = new javax.swing.JTextField();
        backButt = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Jus nevarat pievienot naudu, jo jums ir negativa bilance");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        izvKontu.setText("Izveleties kontu");
        izvKontu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izvKontuActionPerformed(evt);
            }
        });
        kIzvele.add(izvKontu);

        izvNorKontu.setText("Izveleties kontu");
        izvNorKontu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izvNorKontuActionPerformed(evt);
            }
        });
        nKontIzv.add(izvNorKontu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HI");
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);
        setName("UserScreen"); // NOI18N

        JsveiciensLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JsveiciensLabel.setText("Sveiciens,");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("My Account");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));

        jButton3.setText("Jauns Konts");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Iesniegumi:");

        jButton4.setText("Parskaitijums");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        nKont.setText("0");
        nKont.setEnabled(false);

        jLabel3.setText("Norekinu konts");

        kKont.setText("0");
        kKont.setEnabled(false);

        jLabel4.setText("Kredit konts");

        jLabel6.setText("Jūsu izveleta konta bilance");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kKont, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nKont, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(kLineLabel)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(65, 65, 65))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kLineLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kKont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nKont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(42, 42, 42))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        JButtPiev.setText("Pievienot naudu");
        JButtPiev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtPievActionPerformed(evt);
            }
        });

        jButton2.setText("Noņemt naudu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBilance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBilanceMouseClicked(evt);
            }
        });

        jLabel7.setText("Naudas darījumi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(izvKonts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JButtPiev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBilance, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(izvKonts)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JButtPiev))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jBilance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(34, 34, 34))
        );

        jKredKontPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kredit Konti", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jKredKontPane.setComponentPopupMenu(kIzvele);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Konta numurs", "Kreditlinija", "Procenti"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(kIzvele);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jKredKontPane.setViewportView(jTable1);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Noreķinu konti", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Konta numurs", "Atlikums"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setComponentPopupMenu(nKontIzv);
        jScrollPane2.setViewportView(jTable2);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        izvLabel.setText("Izveletais konts");

        izvKField.setEditable(false);

        klLabel.setText("Kreditlinija");

        prLabel.setText("Procenti");

        izvKLine.setEditable(false);

        izvPr.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(izvLabel)
                    .addComponent(klLabel)
                    .addComponent(prLabel))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(izvKField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(izvPr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addComponent(izvKLine, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izvLabel)
                    .addComponent(izvKField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(klLabel)
                    .addComponent(izvKLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prLabel)
                    .addComponent(izvPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        backButt.setText("Back");
        backButt.setActionCommand("Back");
        backButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JsveiciensLabel)
                        .addComponent(jKredKontPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButt)
                        .addGap(256, 256, 256)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(backButt)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JsveiciensLabel)
                                .addGap(15, 15, 15)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jKredKontPane, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidValue(String str){
        
        try{
            Float.parseFloat(str);
            return true;
        }catch(Exception c){
            return false;
        }
        
    }
    
    
    private void JButtPievActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtPievActionPerformed
        System.out.println(izvKontaTips + "        KONTA TIPS");
        if((jBilance.getText().length()!= 0) && (isValidValue(jBilance.getText())) && (!izvKontaTips.isEmpty())){
            if(Float.parseFloat(jBilance.getText()) > 0.0)
            {
                try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
                   
                   
                   
                        switch(izvKontaTips)
                    {
                        case "Kred":
                            float add = Float.parseFloat(jBilance.getText().toString());
                        
                            int row = jTable1.getSelectedRow();
                            String kn = (String) jTable1.getModel().getValueAt(row, 0);
                            Statement sl = con.createStatement();
                            ResultSet rs = sl.executeQuery("SELECT * from KredKonti WHERE kNum = "+ "'" + kn + "'");
                            rs.next();
                            float ex = rs.getFloat("krAtlikums");
                            rs.close();
                            sl.close();
                            
                            PreparedStatement st = con.prepareStatement("UPDATE KredKonti SET krAtlikums = ? WHERE kNum = ?");
                            
                            float exPlusAdd = ex + add; 
                            System.out.println(exPlusAdd + "   SUM");
                            st.setFloat(1, exPlusAdd);
                            st.setString(2, kn);
                            st.executeUpdate();
                            
                            st.close();
                            con.close();
                            JOptionPane.showMessageDialog(this, "Nauda pievienota");
                            break;
                    
                        case "Norek":
                            if((jBilance.getText().length()!= 0) && (isValidValue(jBilance.getText())) && (!izvKontaTips.isEmpty())){
                                if(Float.parseFloat(jBilance.getText()) > 0.0){
                                    float add1 = Float.parseFloat(jBilance.getText().toString());
                        
                                    int roww = jTable2.getSelectedRow();
                                    String knn = (String) jTable2.getModel().getValueAt(roww, 0);
                                    Statement sll = con.createStatement();
                                    ResultSet rss = sll.executeQuery("SELECT * from NorekKonti WHERE kNum = "+ "'" + knn + "'");
                                    rss.next();
                                    float exx = rss.getFloat("atlikums");
                                    rss.close();
                                    sll.close();
                            
                                    PreparedStatement sts = con.prepareStatement("UPDATE NorekKonti SET atlikums = ? WHERE kNum = ?");
                            
                                    float exPlusAdd1 = exx + add1; 
                                    System.out.println(exPlusAdd1 + "   SUM");
                                    sts.setFloat(1, exPlusAdd1);
                                    sts.setString(2, knn);
                                    sts.executeUpdate();
                            
                                    sts.close();
                                    con.close();
                                    JOptionPane.showMessageDialog(this, "Nauda pievienota");
                               
                                }
                            }
                            break;
                    
                    }
                      
                   
                   
                   
                }catch(SQLException sq){
                    sq.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                    
                }finally{
                    
                }
                 
                
                
                
                jBilance.setEditable(true);
                //do
            }else
            {
                JOptionPane.showMessageDialog(this, "Nauda ne pievienota3");
                jBilance.setEditable(false);
                setVisible(true);
            }
            
            
        }
        JOptionPane.showMessageDialog(this, "Nauda ne pievienota4");
        
        
    }//GEN-LAST:event_JButtPievActionPerformed

    private void jBilanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBilanceMouseClicked
        //Jusu bilance ir negativa
    }//GEN-LAST:event_jBilanceMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
           
          String[] option = new String[2];
          option[0] = "Kredit";
          option[1] = "Noreķinu";
          
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
           Statement st = con.createStatement();
           
          int n = JOptionPane.showOptionDialog(this," Izveleties kuru konta tipu gribas izveidot  " , "Konta tips", 0, JOptionPane.QUESTION_MESSAGE, null, option, null);
                if(n == JOptionPane.YES_OPTION)
                {
                    
                    JOptionPane.showMessageDialog(null, "Tika izvelets kredit konts");
                    Random rd = new Random();
                    String iesnID = Integer.toString(rd.nextInt(9999)) + Integer.toString(rd.nextInt(9999));
                    System.out.print(iesnID + "   :RANDOM IESN ID");
                    st.executeUpdate("INSERT INTO Iesn (id, iesnId, tips) VALUES(" + this.getUserID() + ", '" + iesnID + "', " + 2 + ")");
                    st.close();
                    
                    
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Tika izvlets noreķinu konts ");
                     Random rd = new Random();
                     String iesnID = Integer.toString(rd.nextInt(9999)) + Integer.toString(rd.nextInt(9999));
                     System.out.print(iesnID + "   :RANDOM IESN ID");
                     st.executeUpdate("INSERT INTO Iesn (id, iesnId, tips) VALUES(" + this.getUserID() + ", '" + iesnID + "', " + 1 + ")");
                     st.close();
                }  
            
                con.close();
           
           
           
           
           
           
        }catch(SQLException s){
            s.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
        } 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void izvKontuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izvKontuActionPerformed
        
        izvKontaTips = "Kred";
        int row = jTable1.getSelectedRow();
        String kn = jTable1.getModel().getValueAt(row, 0).toString();
        float kr = Float.parseFloat(jTable1.getModel().getValueAt(row, 1).toString());
        float pr = Float.parseFloat(jTable1.getModel().getValueAt(row, 2).toString());
        
        initKrK(kn,kr,pr);
        
        
        
    }//GEN-LAST:event_izvKontuActionPerformed

    private void izvNorKontuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izvNorKontuActionPerformed
        
        izvKontaTips = "Norek";
        int row = jTable2.getSelectedRow();
        String kn = jTable2.getModel().getValueAt(row, 0).toString();
        float atl = Float.parseFloat(jTable2.getModel().getValueAt(row, 1).toString());
        initNorK(kn,atl);
        
        
    }//GEN-LAST:event_izvNorKontuActionPerformed

    private void backButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtActionPerformed
        this.dispose();
        LoginScreen lg = new LoginScreen();
    }//GEN-LAST:event_backButtActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
           Statement st = con.createStatement();
            
           Random rd = new Random();
           String iesnID = Integer.toString((rd.nextInt(899)+100))   +  Integer.toString(rd.nextInt(899)+100) + Integer.toString(rd.nextInt(89)+10);
           System.out.println( "RANDOM IESN ID: " + iesnID); 
                  
           String sqlInsert = "INSERT INTO Parskaitijumi" +
                                    "(id, iesnID) " +
                                    "VALUES" + "(" + userID + ", '" + iesnID + "')";
                            
           st.executeUpdate(sqlInsert);
           System.out.println("Success of insert iesn parsk");
            
            
        }catch(SQLException s){
            s.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            
        } 
                            
                            
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println(izvKontaTips + "        KONTA TIPS");
        if((jBilance.getText().length()!= 0) && (isValidValue(jBilance.getText())) && (!izvKontaTips.isEmpty())){
            if(Float.parseFloat(jBilance.getText()) > 0.0)
            {
                try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
                   
                   
                   
                        switch(izvKontaTips)
                    {
                        case "Kred":
                            float add = Float.parseFloat(jBilance.getText().toString());
                        
                            int row = jTable1.getSelectedRow();
                            String kn = (String) jTable1.getModel().getValueAt(row, 0);
                            Statement sl = con.createStatement();
                            ResultSet rs = sl.executeQuery("SELECT * from KredKonti WHERE kNum = " + "'" + kn + "'");
                            rs.next();
                            float ex = rs.getFloat("krAtlikums");
                            
                            float kredL = rs.getFloat("kr");
                            float procenti = rs.getFloat("procenti");
                                    
                            rs.close();
                            sl.close();
                            
                            PreparedStatement st = con.prepareStatement("UPDATE KredKonti SET krAtlikums = ? WHERE kNum = ?");
                            
                            if(add > ex){
                                JOptionPane.showMessageDialog(this, "Nepietiek kreditlinijas alitkuma");
                            }else{
                                if((ex - add * procenti) < 0 ){
                                    JOptionPane.showMessageDialog(this, "Jusu atlikums būs negativs un jus vairs nevaresiet ņemt naudu no kreditkonta");
                                }
                                float exPlusAdd = ex - add * procenti; 
                                System.out.println(exPlusAdd + "   SUM");
                                st.setFloat(1, exPlusAdd);
                                st.setString(2, kn);
                                st.executeUpdate();
                            
                                st.close();
                                con.close();
                                JOptionPane.showMessageDialog(this, "Nauda pievienota");
                                
                                
                            }
                            break;
                    
                        case "Norek":
                            if((jBilance.getText().length()!= 0) && (isValidValue(jBilance.getText())) && (!izvKontaTips.isEmpty())){
                                if(Float.parseFloat(jBilance.getText()) > 0.0){
                                    float add1 = Float.parseFloat(jBilance.getText().toString());
                        
                                    int roww = jTable2.getSelectedRow();
                                    String knn = (String) jTable2.getModel().getValueAt(roww, 0);
                                    Statement sll = con.createStatement();
                                    ResultSet rss = sll.executeQuery("SELECT * from NorekKonti WHERE kNum = "+ "'" + knn + "'");
                                    rss.next();
                                    float exx = rss.getFloat("atlikums");
                                    rss.close();
                                    sll.close();
                            
                                    PreparedStatement sts = con.prepareStatement("UPDATE NorekKonti SET atlikums = ? WHERE kNum = ?");
                                    
                                    float exPlusAdd1 = exx - add1;
                                    if(exPlusAdd1 < 0) JOptionPane.showMessageDialog(this, "Nepietiek naudu uz noreķ. konta");
                                    else{
                                        if(add1 > exx) JOptionPane.showMessageDialog(this, "Nepietiek naudu");
                                        else{
                                            
                                            sts.setFloat(1, exPlusAdd1);
                                            sts.setString(2, knn);
                                            sts.executeUpdate();
                            
                                            sts.close();
                                            con.close();
                                            JOptionPane.showMessageDialog(this, "Successfull"); 
                                                
                                                
                                        }
                                       
                                    }
                                    
                               
                                }
                            }
                            break;
                    
                    }
                }catch(SQLException sq){
                    sq.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                    
                }finally{
                    
                }
                 
                
                
                
                jBilance.setEditable(true);
                //do
            }else
            {
                
                jBilance.setEditable(false);
                setVisible(true);
            }
            
            
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void initKrK(String kn, float kr, float pr){
   
        setAllVisible();
        jLabel3.setVisible(false);
        nKont.setVisible(false);
                    
                    
                    izvKField.setText(kn);
                    izvKLine.setText(Float.toString(kr));
                    izvPr.setText(Float.toString(pr));
                    
                    try{
                    
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
                    
                        Statement st = con.createStatement();
                    
                        ResultSet rs = st.executeQuery("SELECT * from KredKonti where kNum = '" + kn + "'");
                        rs.next();
                        kKont.setText((Float.toString(rs.getFloat("krAtlikums"))));
                        
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{
                        
                    }
                    
           
    }
    
    private void initNorK(String kn, float atl){
        
        
        setVisibOnlN();
        
        try{
                    
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
                    
                        Statement st = con.createStatement();
                    
                        ResultSet rs = st.executeQuery("SELECT * from NorekKonti where kNum = '" + kn + "'");
                        rs.next();
                        float value = rs.getFloat("atlikums");
                        
                        nKont.setText(Float.toString(value));
                        int row = jTable2.getSelectedRow();
                        jTable2.getModel().setValueAt(value, row, 1);
                        
                        rs.close();
                        st.close();
                        st.close();
                        
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally{
                        
                    }
        
        
                    izvKLine.setText("");
                    izvPr.setText("");
        
                    izvKField.setText(kn);
                    
 
        
    }
    
    private void setAllVisible(){
        
            izvLabel.setVisible(true);
            izvKField.setVisible(true);
            klLabel.setVisible(true);
            izvKLine.setVisible(true);
            prLabel.setVisible(true);
            izvPr.setVisible(true);
            jLabel4.setVisible(true);
            kKont.setVisible(true);
        
    }
    
    private void setVisibOnlN(){
        
        jLabel4.setVisible(false);
        kKont.setVisible(false);
        izvKLine.setVisible(false);
        klLabel.setVisible(false);
        prLabel.setVisible(false);
        izvPr.setVisible(false);
        nKont.setVisible(true);
        jLabel3.setVisible(true);
        
    }
    
  
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtPiev;
    private javax.swing.JLabel JsveiciensLabel;
    private javax.swing.JButton backButt;
    private javax.swing.JTextField izvKField;
    private javax.swing.JTextField izvKLine;
    private javax.swing.JLabel izvKonts;
    private javax.swing.JMenuItem izvKontu;
    private javax.swing.JLabel izvLabel;
    private javax.swing.JMenuItem izvNorKontu;
    private javax.swing.JTextField izvPr;
    private javax.swing.JTextField jBilance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jKredKontPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPopupMenu kIzvele;
    private javax.swing.JTextField kKont;
    private javax.swing.JLabel kLineLabel;
    private javax.swing.JLabel klLabel;
    private javax.swing.JTextField nKont;
    private javax.swing.JPopupMenu nKontIzv;
    private javax.swing.JLabel prLabel;
    // End of variables declaration//GEN-END:variables
}
