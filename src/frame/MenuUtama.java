package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import koneksi.koneksi;

public class MenuUtama extends javax.swing.JFrame {

    public MenuUtama() {
        initComponents();
        jLabel2.setText("Selamat Datang");
        Home panel = new Home();
        jTabbedPane1.add("Home", panel);
        panel.setVisible(true);
        jTabbedPane1.revalidate();
        jTabbedPane1.repaint();
        lbl_username.setText(Login.nameUser);
        setButtonVisibility();              
    }

private void setButtonVisibility() {
    String jaba = getJabatanFromDatabase(Login.nameUser);
    System.out.println("jaba: " + jaba);

    if ("Owner".equals(jaba)) {
        // If jabatan is "Owner", display all buttons
        btn_karyawan.setVisible(true);
        btn_transaksi.setVisible(true);
        btn_master.setVisible(true);
        btn_keuangan.setVisible(true);
        btn_home.setVisible(true);
    } else {
        // If jabatan is not "Owner", hide the btn_karyawan button
        btn_karyawan.setVisible(false);
        // Always show these buttons
        btn_transaksi.setVisible(true);
        btn_master.setVisible(true);
        btn_keuangan.setVisible(true);
        btn_home.setVisible(true);
    }
}

private String getJabatanFromDatabase(String Jabatan) {
    try {
        if (Jabatan != null) {
            String sql = "SELECT jabatan FROM user WHERE username = ?";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Jabatan);

            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("jabatan");
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Print the exception details for debugging
        // Handle the exception appropriately (e.g., log it, show an error message)
    }
    return null;
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_master = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_karyawan = new javax.swing.JButton();
        btn_keuangan = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        SignOut = new javax.swing.JButton();
        SignOut1 = new javax.swing.JButton();
        lbl_username = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(39, 159, 136));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/Rectangle 264 (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        btn_master.setBackground(new java.awt.Color(39, 159, 136));
        btn_master.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_master.setForeground(new java.awt.Color(255, 255, 255));
        btn_master.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/icon master.png"))); // NOI18N
        btn_master.setText(" Master");
        btn_master.setActionCommand("Transaksi");
        btn_master.setBorder(null);
        btn_master.setBorderPainted(false);
        btn_master.setContentAreaFilled(false);
        btn_master.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masterActionPerformed(evt);
            }
        });
        jPanel1.add(btn_master, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        btn_transaksi.setBackground(new java.awt.Color(39, 159, 136));
        btn_transaksi.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/icon kasir.png"))); // NOI18N
        btn_transaksi.setText("Transaksi");
        btn_transaksi.setBorder(new javax.swing.border.MatteBorder(null));
        btn_transaksi.setBorderPainted(false);
        btn_transaksi.setContentAreaFilled(false);
        btn_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_transaksiMousePressed(evt);
            }
        });
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 291, -1, -1));

        btn_karyawan.setBackground(new java.awt.Color(39, 159, 136));
        btn_karyawan.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        btn_karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/Member.png"))); // NOI18N
        btn_karyawan.setText(" Absen");
        btn_karyawan.setBorder(null);
        btn_karyawan.setBorderPainted(false);
        btn_karyawan.setContentAreaFilled(false);
        btn_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_karyawanActionPerformed(evt);
            }
        });
        jPanel1.add(btn_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        btn_keuangan.setBackground(new java.awt.Color(39, 159, 136));
        btn_keuangan.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_keuangan.setForeground(new java.awt.Color(255, 255, 255));
        btn_keuangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/add_card.png"))); // NOI18N
        btn_keuangan.setText(" Keuangan");
        btn_keuangan.setBorder(null);
        btn_keuangan.setBorderPainted(false);
        btn_keuangan.setContentAreaFilled(false);
        btn_keuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keuanganActionPerformed(evt);
            }
        });
        jPanel1.add(btn_keuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        btn_home.setBackground(new java.awt.Color(39, 159, 136));
        btn_home.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/add_home.png"))); // NOI18N
        btn_home.setText(" Home");
        btn_home.setBorder(null);
        btn_home.setBorderPainted(false);
        btn_home.setContentAreaFilled(false);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        SignOut.setBackground(new java.awt.Color(39, 159, 136));
        SignOut.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        SignOut.setForeground(new java.awt.Color(255, 255, 255));
        SignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/Sign Out.png"))); // NOI18N
        SignOut.setText(" Sign Out");
        SignOut.setActionCommand("Transaksi");
        SignOut.setBorder(null);
        SignOut.setBorderPainted(false);
        SignOut.setContentAreaFilled(false);
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SignOutMousePressed(evt);
            }
        });
        SignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutActionPerformed(evt);
            }
        });
        jPanel1.add(SignOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 722, -1, -1));

        SignOut1.setBackground(new java.awt.Color(39, 159, 136));
        SignOut1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        SignOut1.setForeground(new java.awt.Color(255, 255, 255));
        SignOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/USer.png"))); // NOI18N
        SignOut1.setActionCommand("Transaksi");
        SignOut1.setBorder(null);
        SignOut1.setBorderPainted(false);
        SignOut1.setContentAreaFilled(false);
        SignOut1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SignOut1MousePressed(evt);
            }
        });
        SignOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOut1ActionPerformed(evt);
            }
        });
        jPanel1.add(SignOut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, -1, -1));

        lbl_username.setBackground(new java.awt.Color(39, 159, 136));
        lbl_username.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("-");
        lbl_username.setActionCommand("Transaksi");
        lbl_username.setBorder(null);
        lbl_username.setBorderPainted(false);
        lbl_username.setContentAreaFilled(false);
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_usernameMousePressed(evt);
            }
        });
        lbl_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_usernameActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 768));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 1100, 30));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 1070, 640));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(545, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 1070, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btn_masterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masterActionPerformed
    MenuMaster master = new MenuMaster();
            master.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btn_masterActionPerformed

    private void btn_transaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transaksiMousePressed
    }//GEN-LAST:event_btn_transaksiMousePressed
    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
            jLabel2.setText("Form Tambah Transaksi"); 
            jTabbedPane1.removeAll();
            panelTransaksi panel = new panelTransaksi();
            jTabbedPane1.add(panel);
            panel.setVisible(true);
            jTabbedPane1.revalidate();
            jTabbedPane1.repaint();
            jPanel5.setVisible(true);
    }//GEN-LAST:event_btn_transaksiActionPerformed
    private void btn_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_karyawanActionPerformed
            jLabel2.setText("Dashboard > Absnensi"); 
            jTabbedPane1.removeAll();
            panelAbsen panel= new panelAbsen();
            jTabbedPane1.add(panel);
            panel.setVisible(true);
            jTabbedPane1.revalidate();
            jTabbedPane1.repaint();
            jPanel5.setVisible(true);
    }//GEN-LAST:event_btn_karyawanActionPerformed

    private void btn_keuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keuanganActionPerformed
        jLabel2.setText("Laporan Keuangan"); 
            jTabbedPane1.removeAll();
            panelKeuangan panel = new panelKeuangan();
            jTabbedPane1.add(panel);
            panel.setVisible(true);
            jTabbedPane1.revalidate();
            jTabbedPane1.repaint();
            jPanel5.setVisible(true);
    }//GEN-LAST:event_btn_keuanganActionPerformed
    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
       jTabbedPane1.removeAll();
       jLabel2.setText("Selamat Datang");
       Home panel = new Home();
       jTabbedPane1.add(panel);
       panel.setVisible(true); 
       jTabbedPane1.revalidate();
       jTabbedPane1.repaint();
       jPanel5.setVisible(false);
    }//GEN-LAST:event_btn_homeActionPerformed
    private void SignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOutActionPerformed
    }//GEN-LAST:event_SignOutActionPerformed
    private void SignOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOutMousePressed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_SignOutMousePressed

    private void SignOut1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOut1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignOut1MousePressed

    private void SignOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOut1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignOut1ActionPerformed

    private void lbl_usernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_usernameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_usernameMousePressed

    private void lbl_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_usernameActionPerformed
    public static void main(String args[]) {
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignOut;
    private javax.swing.JButton SignOut1;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_karyawan;
    private javax.swing.JButton btn_keuangan;
    private javax.swing.JButton btn_master;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lbl_username;
    // End of variables declaration//GEN-END:variables
}