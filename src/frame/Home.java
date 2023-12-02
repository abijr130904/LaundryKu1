package frame;

import com.raven.chart.ModelChart;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JPanel {

    public Home() {
        initComponents();
        dataMenu();
        
        panelMember.tambahTanggalMember();
        panelKeuangan.tambahBarisBaru();
        panelTransaksi.changeStatus();
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
        lblPegawai = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        search4 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        SearchB4 = new javax.swing.JButton();
        show2 = new javax.swing.JButton();
        btnSelesai2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblTransaksi1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblMember = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        search3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        SearchB3 = new javax.swing.JButton();
        Show1 = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 665));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Jumlah Pegawai");

        lblPegawai.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblPegawai.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPegawai)
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(lblPegawai)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel15.setPreferredSize(new java.awt.Dimension(493, 284));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(217, 217, 217));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel16.setPreferredSize(new java.awt.Dimension(493, 48));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Jadwal Laundry Pengiriman Hari ini");
        jPanel16.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel15.add(search4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 120, -1));

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NO", "Jam Masuk", "Nama Pegawai", "Status"
            }
        ));
        tbl2.setRowHeight(30);
        jScrollPane6.setViewportView(tbl2);

        jPanel15.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 440, 130));

        SearchB4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SearchB4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/ic_baseline-search.png"))); // NOI18N
        SearchB4.setText("Search");
        SearchB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchB4ActionPerformed(evt);
            }
        });
        jPanel15.add(SearchB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, 20));

        show2.setText("Show");
        show2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show2ActionPerformed(evt);
            }
        });
        jPanel15.add(show2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        btnSelesai2.setText("Update Selesai");
        btnSelesai2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesai2ActionPerformed(evt);
            }
        });
        jPanel15.add(btnSelesai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Penghasilan hari ini");

        lblTransaksi1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblTransaksi1.setText("jLabel5");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblTransaksi1))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addComponent(lblTransaksi1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Jumlah Member Aktif");

        lblMember.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblMember.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMember)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addComponent(lblMember)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Jumlah Transaksi Hari Ini");

        lblTransaksi.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblTransaksi.setText("jLabel5");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblTransaksi))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addComponent(lblTransaksi)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel12.setPreferredSize(new java.awt.Dimension(493, 284));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(217, 217, 217));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel14.setPreferredSize(new java.awt.Dimension(493, 48));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Jadwal laundry Ambil Hari Ini");
        jPanel14.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel12.add(search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 120, -1));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NO", "Jam Masuk", "Nama Pegawai", "Status"
            }
        ));
        tbl1.setRowHeight(30);
        jScrollPane5.setViewportView(tbl1);

        jPanel12.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 440, 130));

        SearchB3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SearchB3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/ic_baseline-search.png"))); // NOI18N
        SearchB3.setText("Search");
        SearchB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchB3ActionPerformed(evt);
            }
        });
        jPanel12.add(SearchB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, 20));

        Show1.setText("Show");
        Show1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Show1ActionPerformed(evt);
            }
        });
        jPanel12.add(Show1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        btnSelesai.setText("Update Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });
        jPanel12.add(btnSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchB3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchB3ActionPerformed

    private void SearchB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchB4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchB4ActionPerformed

    private void btnSelesai2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesai2ActionPerformed
        // TODO add your handling code here:
        setSelesai2();
    }//GEN-LAST:event_btnSelesai2ActionPerformed

    private void show2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show2ActionPerformed
        // TODO add your handling code here:
        showTableDetail2();
    }//GEN-LAST:event_show2ActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        // TODO add your handling code here:
        setSelesai();
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void Show1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Show1ActionPerformed
        // TODO add your handling code here:
        showTableDetail1();
    }//GEN-LAST:event_Show1ActionPerformed
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
}


    private void dataMenu() {
        jumlahMember();
        jumlahTransaksi();
        jumlahPegawai();
        jumlahPenghasilan();
        tblStatusLaundryAmbil();
        tblStatusLaundryKirim();        
    }

    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

    public int jumlahMember() {
        try {
//            LocalDate currentDate = LocalDate.now();
            String sql = "SELECT COUNT(id_member) AS memberCount FROM member WHERE statusMember = 0";
            
            // Assuming koneksi.configDB() returns a valid connection
            Connection conn = koneksi.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            // Set the parameter with the current date
//            pst.setDate(1, java.sql.Date.valueOf(currentDate));

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Update your UI or return the count as needed
                int jumlah = rs.getInt("memberCount");
                lblMember.setText(String.valueOf(jumlah));
                return jumlah;  // Return the count if needed in your application logic
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception for debugging purposes
            JOptionPane.showMessageDialog(this, "Error in jumlahMember: " + e.getMessage());
        }
        return 0;
    }

    public int jumlahTransaksi() {
            try {
                    LocalDate currentDate = LocalDate.now();

                    String sql = "SELECT COUNT(no_transaksi) AS jum_transaksi FROM `transaksi` where tgl_transaksi =?";
                    java.sql.Connection conn = (Connection) koneksi.configDB();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);

                    pst.setDate(1, java.sql.Date.valueOf(currentDate));

                    java.sql.ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                       int jumlah = rs.getInt("jum_transaksi");
                       lblTransaksi.setText(String.valueOf(jumlah));
                    }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            return 0;
    }     
    public int jumlahPegawai() {
        try {
            LocalDate currentDate = LocalDate.now();

            // Assuming your table name is "pegawai" and the column name is "jabatan"
            String sql = "SELECT COUNT(id_pegawai) AS jum_pegawai FROM user WHERE jabatan = 'pegawai'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int jumlah = rs.getInt("jum_pegawai");
                lblPegawai.setText(String.valueOf(jumlah));
                return jumlah;  // Return the count if needed in your application logic
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception for debugging purposes
            JOptionPane.showMessageDialog(this, "Error in jumlahPegawai: " + e.getMessage());
        }
        return 0;
    }
    
    public int jumlahPenghasilan() {
        try {
            LocalDate currentDate = LocalDate.now();

            String sql = "SELECT SUM(totalPembayaran) AS jum_transaksi FROM `transaksi` where tgl_transaksi =?";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setDate(1, java.sql.Date.valueOf(currentDate));

            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int jumlah = rs.getInt("jum_transaksi");
                lblTransaksi1.setText(String.valueOf(jumlah));
                return jumlah;  // Return the count if needed in your application logic
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception for debugging purposes
            JOptionPane.showMessageDialog(this, "Error in jumlahPegawai: " + e.getMessage());
        }
        return 0;
    }
    
    public void tblStatusLaundryAmbil() {
        DefaultTableModel tbl = new DefaultTableModel();

        tbl.setColumnCount(0);
        tbl.addColumn("No Transaksi");
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Batas Waktu");
        tbl.addColumn("Status");

        tbl1.setModel(tbl);

        try {
            String sql = "SELECT * FROM transaksi where statusPengiriman = 0";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            java.sql.ResultSet res = pst.executeQuery();

            while (res.next()) {
                // Retrieve the names for id_pelanggan and id_pegawai
                String namaPelanggan = getNamaPelanggan(res.getString("id_pelanggan"));
                System.out.println("Nama Pelanggan: " + namaPelanggan);

                int statusLaundry = res.getInt("status_laundry");
                System.out.println("Status Laundry: " + statusLaundry);

                tbl.addRow(new Object[]{
                        res.getString("no_transaksi"),
                        namaPelanggan,
                        res.getString("batas_waktu"),
                        (statusLaundry == 2) ? "DIAMBIL" : "SELESAI"
                });
            }
            
            res.close();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();  // Log the exception for debugging purposes
            JOptionPane.showMessageDialog(this, "Error in tblStatusLaundry: " + e.getMessage());
        }
    }
    
    public void tblStatusLaundryKirim() {
        DefaultTableModel tbl = new DefaultTableModel();

        tbl.setColumnCount(0);
        tbl.addColumn("No Transaksi");
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Alamat");
        tbl.addColumn("Batas Waktu");
        tbl.addColumn("Status");

        tbl2.setModel(tbl);

        try {
            String sql = "SELECT * FROM transaksi where statusPengiriman = 1";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            java.sql.ResultSet res = pst.executeQuery();

            while (res.next()) {
                // Retrieve the names for id_pelanggan and id_pegawai
                String namaPelanggan = getNamaPelanggan(res.getString("id_pelanggan"));
                System.out.println("Nama Pelanggan: " + namaPelanggan);

                int statusLaundry = res.getInt("status_laundry");
                System.out.println("Status Laundry: " + statusLaundry);

                tbl.addRow(new Object[]{
                        res.getString("no_transaksi"),
                        namaPelanggan,
                        res.getString("alamat_pengiriman"),
                        res.getString("batas_waktu"),
                        (statusLaundry == 2) ? "DIKIRIM" : "SELESAI"
                });
            }
            
            res.close();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();  // Log the exception for debugging purposes
            JOptionPane.showMessageDialog(this, "Error in tblStatusLaundry: " + e.getMessage());
        }
    }

     
     // Method to get the name of pelanggan based on id_pelanggan
    private String getNamaPelanggan(String idPelanggan) {
        // Execute a query to fetch the name based on id_pelanggan
        // Replace 'pelanggan' with your actual table name
        String query = "SELECT nama FROM pelanggan WHERE id_pelanggan = ?";
        try {
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, idPelanggan);
            java.sql.ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getString("nama");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching pelanggan name: " + e.getMessage());
        }
        return "";
    }
    
    private void setSelesai() {
        try {
            int selectedRow = tbl1.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Mohon pilih barisan yang di table ingin dihapus");
                return;  
            }
            
            String update = "UPDATE transaksi SET status_laundry = 3 where no_transaksi = ?";
            
            int idTransaksi = Integer.parseInt((String) tbl1.getValueAt(selectedRow, tbl1.getColumn("No Transaksi").getModelIndex()));

            java.sql.Connection conn = (java.sql.Connection) koneksi.configDB();

            java.sql.PreparedStatement pstTransaksi = conn.prepareStatement(update);
            pstTransaksi.setInt(1, idTransaksi);
            
            pstTransaksi.executeUpdate();
            
            pstTransaksi.close();
            conn.setAutoCommit(true);  // Restore auto-commit mode
            conn.close();
            
            tblStatusLaundryAmbil();
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void setSelesai2() {
        try {
            int selectedRow = tbl2.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Mohon pilih barisan yang di table ingin dihapus");
                return;  
            }
            
            String update = "UPDATE transaksi SET status_laundry = 3 where no_transaksi = ?";
            
            int idTransaksi = Integer.parseInt((String) tbl2.getValueAt(selectedRow, tbl2.getColumn("No Transaksi").getModelIndex()));

            java.sql.Connection conn = (java.sql.Connection) koneksi.configDB();

            java.sql.PreparedStatement pstTransaksi = conn.prepareStatement(update);
            pstTransaksi.setInt(1, idTransaksi);
            
            pstTransaksi.executeUpdate();
            
            
            pstTransaksi.close();
            conn.setAutoCommit(true);  // Restore auto-commit mode
            conn.close();
            
            tblStatusLaundryKirim();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void showTableDetail1() {
        SwingUtilities.invokeLater(() -> {
            int selectedRow = tbl1.getSelectedRow();

            int idShow;
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Mohon Pilih Barisan Yang di Table Ingin Diubah");
                idShow = 0;
            } else {
                idShow = Integer.parseInt((String) tbl1.getValueAt(selectedRow, tbl1.getColumn("No Transaksi").getModelIndex()));
            }
            // System.out.println("idEdit: " + idEdit);
            if (idShow != 0) {
                showTransaksi panel = new showTransaksi(idShow);
                panel.setVisible(true);
            }
            System.out.println("idshow: "+idShow);
        });
    }
    
    private void showTableDetail2() {
        SwingUtilities.invokeLater(() -> {
            int selectedRow = tbl2.getSelectedRow();

            int idShow;
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Mohon Pilih Barisan Yang di Table Ingin Diubah");
                idShow = 0;
            } else {
                idShow = Integer.parseInt((String) tbl2.getValueAt(selectedRow, tbl2.getColumn("No Transaksi").getModelIndex()));
            }
            // System.out.println("idEdit: " + idEdit);
            if (idShow != 0) {
                showTransaksi panel = new showTransaksi(idShow);
                panel.setVisible(true);
            }
            System.out.println("idshow: "+idShow);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchB3;
    private javax.swing.JButton SearchB4;
    private javax.swing.JButton Show1;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnSelesai2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel lblPegawai;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JLabel lblTransaksi1;
    private javax.swing.JTextField search3;
    private javax.swing.JTextField search4;
    private javax.swing.JButton show2;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    // End of variables declaration//GEN-END:variables
}