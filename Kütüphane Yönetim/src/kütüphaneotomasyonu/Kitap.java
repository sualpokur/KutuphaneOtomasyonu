/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kütüphaneotomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author sualp
 */
public class Kitap extends javax.swing.JFrame {

    /**
     * Creates new form Kategori
     */
    public Kitap() {
        initComponents();
        Connect ();
        Kategori();
        Yazıcı();
        Yayımcı();
        Kitap_Yükle();
    }
    
      public class KategoriItem{
        int id;
        String isim;
        
        
        public KategoriItem(int id,String isim)
        {
            this.id = id;
                this.isim = isim;
            
        }
        public String toString()
        {
            return isim; 
        }
        
    }
       public class YazıcıItem{
        int id;
        String isim;
        
        
        public YazıcıItem(int id,String isim)
        {
            this.id = id;
                this.isim = isim;
            
        }
        public String toString()
        {
            return isim; 
        }
        
    }
      public class YayımcıItem{
        int id;
        String isim;
        
        
        public YayımcıItem(int id,String isim)
        {
            this.id = id;
                this.isim = isim;
            
        }
        public String toString()
        {
            return isim; 
        }
        
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void Connect ()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/kutuphaneotomasyonu?useSSL=false","root","sualpemre123");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public void Kategori()
    {
        try {
            pst = con.prepareStatement("select * from kategori");
             rs = pst.executeQuery();
             txtkategori.removeAllItems();
             
             while(rs.next())
             {
                 txtkategori.addItem(new KategoriItem (rs.getInt(1),rs.getString(2)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
       public void Yazıcı()
    {
        try {
            pst = con.prepareStatement("select * from yazar");
             rs = pst.executeQuery();
             txtyazıcı.removeAllItems();
             
             while(rs.next())
             {
                 txtyazıcı.addItem(new YazıcıItem (rs.getInt(1),rs.getString(2)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
       public void Yayımcı()
    {
        try {
            pst = con.prepareStatement("select * from yayımcı");
             rs = pst.executeQuery();
             txtyayımcı.removeAllItems();
             
             while(rs.next())
             {
                 txtyayımcı.addItem(new YayımcıItem (rs.getInt(1),rs.getString(2)));
             }
        } catch (SQLException ex) {
            Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void Kitap_Yükle()
    {
        
        int c;
        
        try {
            pst = con.prepareStatement("select b.id,b.kitapismi,c.kategoriismi,a.isim,p.isim,b.içerik,b.sayfalar,b.baskı from kitap b JOIN kategori c On b.kategori = c.id JOIN yazar a On b.yazar = a.id JOIN yayımcı p On b.yayımcı = p.id ");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for (int i = 1; i <= c; i++) 
                {
                    v2.add(rs.getString("b.id"));
                    v2.add(rs.getString("b.kitapismi"));
                    v2.add(rs.getString("c.kategoriismi"));
                    v2.add(rs.getString("a.isim"));
                    v2.add(rs.getString("p.isim"));
                    v2.add(rs.getString("b.içerik"));
                    v2.add(rs.getString("b.sayfalar"));
                    v2.add(rs.getString("b.baskı"));
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtisim = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txticerik = new javax.swing.JTextField();
        txtkategori = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtyazıcı = new javax.swing.JComboBox();
        txtyayımcı = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtbaskı = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kitap ID", "Kitap İsmi", "Kategori", "Yazar", "Yayımcı", "İçerik", "Sayfa Sayısı", "Baskı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Kitap");

        a.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        a.setText("Kitap İsmi");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Kategori");

        txtisim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtisimActionPerformed(evt);
            }
        });

        jButton1.setText("Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Düzenle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Vazgeç");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("İçerik");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Yazar");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Yayımcı");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Sayfa Sayısı");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Baskı");

        txtbaskı.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbaskıActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(a)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtisim)
                            .addComponent(txtkategori, 0, 221, Short.MAX_VALUE)
                            .addComponent(txtyazıcı, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtyayımcı, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txticerik)
                            .addComponent(txtno)
                            .addComponent(txtbaskı)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a)
                    .addComponent(txtisim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtyazıcı, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtyayımcı, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txticerik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtbaskı, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String kitapismi = txtisim.getText(); 
        KategoriItem citem = (KategoriItem)txtkategori.getSelectedItem();
        YazıcıItem aitem = (YazıcıItem)txtyazıcı.getSelectedItem();
        YayımcıItem pitem = (YayımcıItem)txtyayımcı.getSelectedItem();
          
        String içerik = txticerik.getText();
        String sayfalar = txtno.getText();
        String baskı = txtbaskı.getText();
          

        
        
        
        
        try {
            
            pst = con.prepareStatement("insert into kitap(id,kitapismi,kategori,yazar,yayımcı,içerik,sayfalar,baskı)values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setString(2, kitapismi);
            pst.setInt(3, citem.id);//kate
            pst.setInt(4, aitem.id);//yazar
            pst.setInt(5, pitem.id);
            pst.setString(6, içerik);
            pst.setInt(7, Integer.valueOf(sayfalar));
            pst.setInt(8, Integer.valueOf(baskı));

            int k = pst.executeUpdate();
            if(k== 1)
            {
                JOptionPane.showMessageDialog(this, "Kitap Oluşturuldu");
                txtisim.setText("");
                txtkategori.setSelectedIndex(-1);
                txtyazıcı.setSelectedIndex(-1);
                txtyayımcı.setSelectedIndex(-1);
                txticerik.setText("");
                txtno.setText("");
                txtbaskı.setText("");
                Kitap_Yükle();
               
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eror!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        txtisim.setText(d1.getValueAt(selectIndex, 1).toString());
        txtkategori.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        txtyazıcı.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
        txtyayımcı.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
        txticerik.setText(d1.getValueAt(selectIndex, 5).toString());
        txtno.setText(d1.getValueAt(selectIndex, 6).toString());
        txtbaskı.setText(d1.getValueAt(selectIndex, 7).toString());
        jButton1.setEnabled(false);
        
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        String kitapismi = txtisim.getText(); 
        KategoriItem citem = (KategoriItem)txtkategori.getSelectedItem();
        YazıcıItem aitem = (YazıcıItem)txtyazıcı.getSelectedItem();
        YayımcıItem pitem = (YayımcıItem)txtyayımcı.getSelectedItem();
          
        String içerik = txticerik.getText();
        String sayfalar = txtno.getText();
        String baskı = txtbaskı.getText();
        
        try {
            
            pst = con.prepareStatement("update kitap set kitapismi = ?, kategori = ? , yazar = ? , yayımcı = ? , içerik = ? , sayfalar = ? , baskı = ? where id = ?");
            pst.setString(1, kitapismi);
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, içerik);
            pst.setInt(6, Integer.valueOf(sayfalar));
            pst.setInt(7, Integer.valueOf(baskı));
            pst.setInt(8, id);
            int k = pst.executeUpdate();
            
            if(k== 1)
            {
                JOptionPane.showMessageDialog(this, "Kitap Başarıyla Düzeltildi.");
                
                txtisim.setText("");
                txtkategori.setSelectedIndex(-1);
                txtyazıcı.setSelectedIndex(-1);
                txtyayımcı.setSelectedIndex(-1);
                txticerik.setText("");
                txtno.setText("");
                txtbaskı.setText("");
                txtisim.requestFocus();
                jButton2.setEnabled(true);
                Kitap_Yükle();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eror!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Yazar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        
        
        try {
            
            pst = con.prepareStatement("delete from kitap where id = ?");
            
            pst.setInt(1, id);
            
            int k = pst.executeUpdate();
            
            if(k== 1)
            {
                JOptionPane.showMessageDialog(this, "Kitap Silindi");
                txtisim.setText("");
                txtkategori.setSelectedIndex(1);
                txtyazıcı.setSelectedIndex(1);
                txtyazıcı.setSelectedIndex(1);
                txticerik.setText("");
                txtno.setText("");
                txtbaskı.setText("");
                txtisim.requestFocus();
                jButton3.setEnabled(true);
                Kitap_Yükle();
         
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Eror!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Yazar.class.getName()).log(Level.SEVERE, null, ex);
        }
   
                    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtisimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtisimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtisimActionPerformed

    private void txtbaskıActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbaskıActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbaskıActionPerformed

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
            java.util.logging.Logger.getLogger(Kitap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kitap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kitap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kitap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kitap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtbaskı;
    private javax.swing.JTextField txticerik;
    private javax.swing.JTextField txtisim;
    private javax.swing.JComboBox txtkategori;
    private javax.swing.JTextField txtno;
    private javax.swing.JComboBox txtyayımcı;
    private javax.swing.JComboBox txtyazıcı;
    // End of variables declaration//GEN-END:variables
}
