package frame;

import com.raven.chart.ModelChart;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import koneksi.koneksi;

public class Home extends javax.swing.JPanel {

    public Home() {
        initComponents();
        jumlahMenu();
//        setChart();
    }
//    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
//        chart.start();
//    }
//    private void setChart() {
//        chart.addLegend("Income", new Color(245, 189, 135));
//        chart.addLegend("Expense", new Color(135, 189, 245));
//        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));
//        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
//        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        // Your custom painting code, if needed
//    }
//    public javax.swing.JPanel getContentPane() {
//        return this;
//    }
//
//    public com.raven.chart.Chart getChart() {
//        return chart;
//    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        search4 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TepatWaktu2 = new javax.swing.JTable();
        SearchB4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblMember = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        search3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TepatWaktu1 = new javax.swing.JTable();
        SearchB3 = new javax.swing.JButton();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 665));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Jumlah User");

        lblUser.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblUser)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(45, 45, 45)
                .addComponent(lblUser)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 240, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel15.setPreferredSize(new java.awt.Dimension(493, 284));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(217, 217, 217));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel16.setPreferredSize(new java.awt.Dimension(493, 48));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Pengiriman");
        jPanel16.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel15.add(search4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 120, -1));

        TepatWaktu2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Jam Masuk", "Nama Pegawai", "Status"
            }
        ));
        TepatWaktu2.setRowHeight(30);
        jScrollPane6.setViewportView(TepatWaktu2);

        jPanel15.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 430, 170));

        SearchB4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SearchB4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/ic_baseline-search.png"))); // NOI18N
        SearchB4.setText("Search");
        SearchB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchB4ActionPerformed(evt);
            }
        });
        jPanel15.add(SearchB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, 20));

        add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Jumlah Member");

        lblMember.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMember)
                        .addGap(93, 93, 93))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(50, 50, 50)
                .addComponent(lblMember)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 240, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel12.setPreferredSize(new java.awt.Dimension(493, 284));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(217, 217, 217));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel14.setPreferredSize(new java.awt.Dimension(493, 48));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Status Laundry");
        jPanel14.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel12.add(search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 120, -1));

        TepatWaktu1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Jam Masuk", "Nama Pegawai", "Status"
            }
        ));
        TepatWaktu1.setRowHeight(30);
        jScrollPane5.setViewportView(TepatWaktu1);

        jPanel12.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 430, 170));

        SearchB3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SearchB3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/ic_baseline-search.png"))); // NOI18N
        SearchB3.setText("Search");
        SearchB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchB3ActionPerformed(evt);
            }
        });
        jPanel12.add(SearchB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, 20));

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void SearchB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchB3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchB3ActionPerformed

    private void SearchB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchB4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchB4ActionPerformed
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
}


private void jumlahMenu() {
    jumlahMember();
}


public int jumlahMember() {
        try {
                String sql = "SELECT COUNT(id_member) AS id_member FROM `member` ";
                java.sql.Connection conn = (Connection) koneksi.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);

                java.sql.ResultSet rs = pst.executeQuery();

                if (rs.next()) {
//                    return rs.getString("id_member");
                   int jumlah = rs.getInt("id_member");
                   lblMember.setText(String.valueOf(jumlah));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return 0;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchB3;
    private javax.swing.JButton SearchB4;
    private javax.swing.JTable TepatWaktu1;
    private javax.swing.JTable TepatWaktu2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblMember;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField search3;
    private javax.swing.JTextField search4;
    // End of variables declaration//GEN-END:variables
}