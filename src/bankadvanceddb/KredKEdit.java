/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankadvanceddb;

import static bankadvanceddb.AdminWindow.DB_URL;
import static bankadvanceddb.AdminWindow.DB_LOGIN;
import static bankadvanceddb.AdminWindow.DB_PASS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Anton
 */
public class KredKEdit extends javax.swing.JFrame {
private String kn = ""; 
private float defKl, defAtl, defProc;
    /**
     * Creates new form KredKEdit
     */
    public KredKEdit(String knum, float kLinija, float atl, float procenti) {
        initComponents();
        kn = knum;
        defKl = kLinija;
        defAtl = atl;
        defProc = procenti;
        kNumurs.setText(knum);

        jTextField1.setText(Float.toString(kLinija));//kredlinija
        jTextField2.setText(Float.toString(atl));//atli
        jTextField3.setText(Float.toString(procenti));//procenti
        
        jTextField4.setText(knum); //KNUM GENERET 
 
    }
    
    public KredKEdit(String knum,float kLinija, float atl, float procenti,String type){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KredKEdit(knum, kLinija, atl, procenti).setVisible(true);
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kNumurs = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        backButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Ģeneret");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);

        jLabel1.setText("Saģeneret jauno knumuru");

        jLabel2.setText("Kreditlinija");

        jLabel3.setText("KreditLinijas atlikums");

        jLabel4.setText("Procenti");

        kNumurs.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(kNumurs))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addComponent(jTextField3))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(49, 49, 49)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kNumurs)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Saglabat izm.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        backButt.setText("Back");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(backButt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jButton2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Random rd = new Random();
        String kNum = Integer.toString((rd.nextInt(899)+100))   +  Integer.toString(rd.nextInt(899)+100) + Integer.toString(rd.nextInt(899)+100) + Integer.toString(rd.nextInt(899)+100) + Integer.toString(rd.nextInt(10));
        jTextField4.setText(kNum);
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean checkForFloat(String str){
        
        try{
            Float.parseFloat(str);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        float kLine = Float.parseFloat(jTextField1.getText());
        float kAtl = Float.parseFloat(jTextField2.getText());
        float procenti = Float.parseFloat(jTextField3.getText());
        if(checkForFloat(Float.toString(kLine)) && checkForFloat(Float.toString(kAtl)) && checkForFloat(Float.toString(procenti))){
            if(kLine >= 0 && procenti > 0 && procenti < 50 && jTextField1.getText().length() != 0 && jTextField2.getText().length() != 0 && jTextField3.getText().length() != 0){
                if(defKl > kLine){
                 if(kAtl < kLine || defAtl < kLine)
                    JOptionPane.showMessageDialog(this, "Kreditliniju nevar samazinat, jo atlikums ir vairaks par jauno kr");
                    
                  
                }else{
                    try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(DB_URL,DB_LOGIN, DB_PASS);
                    
                    PreparedStatement st = con.prepareStatement("UPDATE KredKonti SET kNum = ?, kr = ?, krAtlikums = ?, procenti = ? WHERE kNum = ?");
                    st.setString(1, jTextField4.getText());
                    st.setFloat(2, kLine);
                    st.setFloat(3, kAtl);
                    st.setFloat(4, procenti);
                    st.setString(5, kn);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Izmaiņas tika saglabatas");
                    this.dispose();
                    
                
                    
                }catch(SQLException ex){
                    ex.printStackTrace();
                    
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    
                }
                } 
                
                
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Dati ir nekorekti");
            }
            
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void backButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel kNumurs;
    // End of variables declaration//GEN-END:variables
}