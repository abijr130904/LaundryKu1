package frame;

import frame.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader; 
import koneksi.koneksi;

public class panelKeuangan extends javax.swing.JPanel {
    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String t;
           
    public panelKeuangan() {
        koneksi();
        initComponents();
//        tambahBarisBaru();
        tabel();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
            (screenSize.width - frameSize.width) / 3,
            (screenSize.height -frameSize.height) / 4);   
    }    
    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
 
    private void koneksi() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_laundryku", "root", "");
        stat = con.createStatement();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal terhubung ke database: " + e.getMessage());
        e.printStackTrace(); // Cetak exception untuk debugging
        }
    }
    private void tabel(){
    
    // Set show grid untuk menampilkan garis pembatas
    tb_laporan.setShowGrid(true);

    // Set show horizontal lines dan show vertical lines
    tb_laporan.setShowHorizontalLines(true);
    tb_laporan.setShowVerticalLines(true);

     DefaultTableModel t = new DefaultTableModel() {
        // ... (kode yang ada sebelumnya)

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Membuat sel tidak dapat diedit langsung di tabel
        }
    };

    t.addColumn("Id Laporan");
    t.addColumn("Pemasukan Hari Ini");
    t.addColumn("Pengeluaran Hari Ini");
    t.addColumn("Total");
     t.addColumn("Tanggal");
    tb_laporan.setModel(t);

    try {
        res = stat.executeQuery("SELECT * from laporan_keuangan");
        int rowCount = 0;
        while (res.next()) {
            t.addRow(new Object[]{
                    res.getString("id_laporan"),
                    res.getString("pemasukan"),
                    res.getString("pengeluaran"),
                    res.getString("total"),
                    res.getString("tgl_laporan")
            });

            if (rowCount == 0) {
                tb_laporan.getColumnModel().getColumn(0).setCellRenderer(new CustomTableCellRenderer());
                tb_laporan.getColumnModel().getColumn(1).setCellRenderer(new CustomTableCellRenderer());
                tb_laporan.getColumnModel().getColumn(2).setCellRenderer(new CustomTableCellRenderer());
                tb_laporan.getColumnModel().getColumn(3).setCellRenderer(new CustomTableCellRenderer());
                tb_laporan.getColumnModel().getColumn(3).setCellRenderer(new CustomTableCellRenderer());
            }

            rowCount++;
        }
        // Menetapkan jumlah data ke JLabel
        jLabel1.setText("Jumlah Data: " + rowCount);
    } catch (Exception e) {
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, e);
    }

    // Set rata tengah (centered) untuk semua sel di tabel
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    for (int i = 0; i < tb_laporan.getColumnCount(); i++) {
        tb_laporan.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Set rata tengah (centered) untuk header kolom
    JTableHeader header = tb_laporan.getTableHeader();
    header.setDefaultRenderer(centerRenderer);
    header.setPreferredSize(new Dimension(100, 40)); // Sesuaikan dimensi header jika diperlukan
    header.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14)); // Sesuaikan font header jika diperlukan
}
 
// Kelas renderer khusus untuk baris pertama
class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Mengubah warna latar belakang untuk baris pertama
        if (row == 0) {
            cellComponent.setBackground(new java.awt.Color(23, 233, 184)); // Ganti warna sesuai kebutuhan
        } else {
            cellComponent.setBackground(table.getBackground());
        }

        return cellComponent;
    }
}
    private void cariData(String kataKunci) {
    DefaultTableModel model = (DefaultTableModel) tb_laporan.getModel();
    model.setRowCount(0); // Bersihkan baris yang sudah ada

    try {
        // Gunakan prepared statement untuk menghindari SQL injection
        String query = "SELECT * FROM laporan_keuangan WHERE id_laporan LIKE ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, "%" + kataKunci + "%");
            res = pstmt.executeQuery();

            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString("id_laporan"),
                    res.getString("pemasukan"),
                    res.getString("pengeluaran"),
                    res.getString("total"),
                    res.getString("tgl_laporan")
                });
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tb_laporan = new javax.swing.JTable();
        btn_hapus = new javax.swing.JButton();
        btn_lihat = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tb_laporan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tb_laporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Laporan", "Tanggal Laporan", "Pemasukan Hari Ini", "Pengeluaran Hari Ini", "Total"
            }
        ));
        tb_laporan.setRowHeight(50);
        tb_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_laporanMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_laporan);

        btn_hapus.setBackground(new java.awt.Color(204, 51, 0));
        btn_hapus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hapusMousePressed(evt);
            }
        });
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_lihat.setBackground(new java.awt.Color(0, 153, 204));
        btn_lihat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_lihat.setForeground(new java.awt.Color(255, 255, 255));
        btn_lihat.setText("Lihat");
        btn_lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lihatActionPerformed(evt);
            }
        });

        txt_cari.setToolTipText("");
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("-\\");

            jPanel1.setBackground(new java.awt.Color(0, 255, 204));
            jPanel1.setPreferredSize(new java.awt.Dimension(1082, 30));

            jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel2.setText("Tambahkan Laporan Keuangan");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(432, 432, 432)
                    .addComponent(jLabel2)
                    .addContainerGap(380, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            );

            jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel3.setText("Cari");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_lihat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addGap(3, 3, 3)
                            .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_hapus)
                                .addComponent(btn_lihat))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(8, 8, 8)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(315, 315, 315))
            );
        }// </editor-fold>//GEN-END:initComponents

    private void btn_lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lihatActionPerformed
      int barisTerpilih = tb_laporan.getSelectedRow();
      if (barisTerpilih == -1) {
          JOptionPane.showMessageDialog(this, "Pilih baris yang akan dilihat");
          return;
      }
            int idLaporan = Integer.parseInt(tb_laporan.getValueAt(barisTerpilih, 0).toString());
      tampilkanDetailLaporan(idLaporan);
  }

  // Method untuk menampilkan detail Bahan Baku
  private void tampilkanDetailLaporan(int idLaporan) {
      try {
          String query = "SELECT * FROM laporan_keuangan WHERE id_laporan = ?";
          try (PreparedStatement pstmt = con.prepareStatement(query)) {
              pstmt.setInt(1, idLaporan);
              res = pstmt.executeQuery();

              // Tampilkan hasil query
              if (res.next()) {
                  String detail = "Id Laporan: " + res.getString("id_laporan") + "\n"
                          + "Tanggal Laporan: " + res.getString("tgl_laporan") + "\n"
                          + "Pemasukan: " + res.getString("pemasukan") + "\n"
                          + "Pengeluaran: " + res.getString("pengeluaran") + "\n"
                          + "Total: " + res.getString("total"); 

                  // Tampilkan detail menggunakan JOptionPane
                  JOptionPane.showMessageDialog(this, detail, "Detail Laporan", JOptionPane.INFORMATION_MESSAGE);
              }
          }
      } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "Gagal menampilkan detail: " + e.getMessage());
      }
    }//GEN-LAST:event_btn_lihatActionPerformed

    private void tb_laporanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_laporanMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_laporanMouseReleased

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int row = tb_laporan.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
            return;
        }
        int idLaporan = Integer.parseInt(tb_laporan.getValueAt(row, 0).toString());

        // Hapus data dari database
        try {
            String query = "DELETE FROM laporan_keuangan WHERE id_laporan = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idLaporan);
                pstmt.executeUpdate();
            }

            // Refresh tabel setelah penghapusan
            tabel();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_hapusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusMousePressed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        String kataKunci = txt_cari.getText();
        cariData(kataKunci);
    }//GEN-LAST:event_txt_cariActionPerformed
    private static final long MILLIS_IN_DAY = 24 * 60 * 60 * 1000;
    
    public static void tambahBarisBaru() {
        try {
            Connection conn = koneksi.configDB();

            // Retrieve total pengeluaran for the given date
            int totalPengeluaran = getTotalPengeluaran(conn);

            // Retrieve total pemasukan for the given date
            int totalPemasukan = getTotalPemasukan(conn);

            // Calculate the total
            int total = totalPemasukan - totalPengeluaran;

            // Do something with the total, for example, print it
            System.out.println("Total: " + total);
//            insertLaporanKeuangan(conn, totalPengeluaran, totalPemasukan, total);

//             Schedule the task to run every day at 12 pm using ScheduledExecutorService
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            long delay = getDelay();
            scheduler.scheduleAtFixedRate(() -> insertLaporanKeuangan(conn, totalPengeluaran, totalPemasukan, total),
                    delay, MILLIS_IN_DAY, TimeUnit.MILLISECONDS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static long getDelay() {
        // Calculate the delay until the next 12 pm
        long currentTime = System.currentTimeMillis();
        long twelvePmMillis = getTwelvePmMillis(currentTime);

        if (currentTime > twelvePmMillis) {
            twelvePmMillis += MILLIS_IN_DAY; // Move to the next day if it's already past 12 pm
        }

        return twelvePmMillis - currentTime;
    }

    private static long getTwelvePmMillis(long currentTime) {
        // Calculate the milliseconds since midnight and add the remaining time until 12 pm
        long midnightMillis = currentTime - (currentTime % MILLIS_IN_DAY);
        return midnightMillis + (12 * 60 * 60 * 1000);
    }

    private static int getTotalPengeluaran(Connection conn) throws SQLException {
        String pengeluaranQuery = "SELECT COALESCE(SUM(total_pengeluaran), 0) AS pengeluaran " +
                "FROM pengeluaran WHERE tgl_pengeluaran = ?;";

        try (java.sql.PreparedStatement pengeluaranPst = conn.prepareStatement(pengeluaranQuery)) {
            pengeluaranPst.setDate(1, new java.sql.Date(System.currentTimeMillis()));

            try (ResultSet pengeluaranResultSet = pengeluaranPst.executeQuery()) {
                return pengeluaranResultSet.next() ? pengeluaranResultSet.getInt("pengeluaran") : 0;
            }
        }
    }

    private static int getTotalPemasukan(Connection conn) throws SQLException {
        String pemasukanQuery = "SELECT COALESCE(SUM(totalPembayaran), 0) AS pemasukan " +
                "FROM transaksi WHERE tgl_transaksi = ?;";

        try (java.sql.PreparedStatement pemasukanPst = conn.prepareStatement(pemasukanQuery)) {
            pemasukanPst.setDate(1, new java.sql.Date(System.currentTimeMillis()));

            try (ResultSet pemasukanResultSet = pemasukanPst.executeQuery()) {
                return pemasukanResultSet.next() ? pemasukanResultSet.getInt("pemasukan") : 0;
            }
        }
    }

    private static void insertLaporanKeuangan(Connection conn, int totalPengeluaran, int totalPemasukan, int total) {
        String insertQuery = "INSERT INTO laporan_keuangan (pengeluaran, pemasukan, total, tgl_laporan) VALUES (?, ?, ?, ?)";
        try (java.sql.PreparedStatement insertPst = conn.prepareStatement(insertQuery)) {
            insertPst.setInt(1, totalPengeluaran);
            insertPst.setInt(2, totalPemasukan);
            insertPst.setInt(3, total);
            insertPst.setDate(4, new java.sql.Date(System.currentTimeMillis()));

            int rowsAffected = insertPst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("Insert failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_lihat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tb_laporan;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
