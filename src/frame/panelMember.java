
package frame;

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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader; 
import koneksi.koneksi;


public class panelMember extends javax.swing.JPanel {
    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String t;    
       
    public panelMember() {
        koneksi();
        initComponents();
        kosongkan();
        tabel();
        spinner_tanggal.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
  
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
            (screenSize.width - frameSize.width) / 3,
            (screenSize.height -frameSize.height) / 4);
        
        
        //
//        tambahTanggal();
        batasWaktuSetmember();
    }
   
    private void koneksi() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project_laundryku", "root", "");
        stat = con.createStatement();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal terhubung ke database: " + e.getMessage());
        e.printStackTrace(); // Cetak exception untuk debugging
        }
    }
     private void kosongkan(){ 
        txt_nama.setText("");
        txt_alamat.setText("");
        txt_nohp.setText("");     
        
    }
    
    private void tabel(){
    // Set show grid untuk menampilkan garis pembatas
    Tb_member.setShowGrid(true);

    // Set show horizontal lines dan show vertical lines
    Tb_member.setShowHorizontalLines(true);
    Tb_member.setShowVerticalLines(true);

     DefaultTableModel t = new DefaultTableModel() {
        // ... (kode yang ada sebelumnya)

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Membuat sel tidak dapat diedit langsung di tabel
        }
    };
    t.addColumn("Id Member");
    t.addColumn("Nama Member");
    t.addColumn("Alamat");
    t.addColumn("No HP");
    t.addColumn("Batas Waktu");
    t.addColumn("Status Member");
    Tb_member.setModel(t);
    try {
        res = stat.executeQuery("SELECT * from member");
        int rowCount = 0;
 
        while (res.next()) {
            int statusMember = res.getInt("statusMember");
            if (statusMember == 0) {
                 t.addRow(new Object[]{
                        res.getString("id_member"),
                        res.getString("nama"),
                        res.getString("alamat"),
                        res.getString("no_hp"),
                        res.getString("batas_waktu"),
                        "MASIH BERLAKU"
                });
            } else {
                 t.addRow(new Object[]{
                        res.getString("id_member"),
                        res.getString("nama"),
                        res.getString("alamat"),
                        res.getString("no_hp"),
                        res.getString("batas_waktu"),
                        "SUDAH KADULRASA"
                });
            }
               
            if (rowCount == 0) {
                Tb_member.getColumnModel().getColumn(0).setCellRenderer(new CustomTableCellRenderer());
                Tb_member.getColumnModel().getColumn(1).setCellRenderer(new CustomTableCellRenderer());
                Tb_member.getColumnModel().getColumn(2).setCellRenderer(new CustomTableCellRenderer());
                Tb_member.getColumnModel().getColumn(3).setCellRenderer(new CustomTableCellRenderer());
                Tb_member.getColumnModel().getColumn(4).setCellRenderer(new CustomTableCellRenderer());
            }
            rowCount++;
        }
        // Menetapkan jumlah data ke JLabel
        jLabel1member.setText("Jumlah Data: " + rowCount);
    } catch (Exception e) {
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, e);
    }
    // Set rata tengah (centered) untuk semua sel di tabel
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    for (int i = 0; i < Tb_member.getColumnCount(); i++) {
        Tb_member.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
    // Set rata tengah (centered) untuk header kolom
    JTableHeader header = Tb_member.getTableHeader();
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
   DefaultTableModel model = (DefaultTableModel) Tb_member.getModel();
model.setRowCount(0); // Bersihkan baris yang sudah ada

try {
    // Gunakan prepared statement untuk menghindari SQL injection
    String query = "SELECT * FROM member WHERE id_member LIKE ? OR nama LIKE ? OR alamat LIKE ? OR no_hp LIKE ? OR batas_waktu LIKE ?";
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        for (int i = 1; i <= 4; i++) {
            pstmt.setString(i, "%" + kataKunci + "%");
        }
        res = pstmt.executeQuery();

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_member"),
                res.getString("nama"),
                res.getString("alamat"),
                res.getString("no_hp"),
                res.getString("batas_waktu")
                // Tambahkan kolom lainnya sesuai kebutuhan
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
        Tb_member = new javax.swing.JTable();
        btn_simpan1 = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_hapus1 = new javax.swing.JButton();
        btn_clear1 = new javax.swing.JButton();
        jLabel4member = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel6member = new javax.swing.JLabel();
        jLabel7member = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JTextField();
        txt_nohp = new javax.swing.JTextField();
        btn_lihat1 = new javax.swing.JButton();
        txt_cari1 = new javax.swing.JTextField();
        jLabel1member = new javax.swing.JLabel();
        jPanel1member = new javax.swing.JPanel();
        jLabel2member = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3member = new javax.swing.JLabel();
        jLabel6member1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinner_tanggal = new javax.swing.JSpinner();
        ckbox_berlaku = new javax.swing.JCheckBox();
        ckbox_kadaluarsa = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tb_member.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Member", "Nama Member", "Alamat", "Ho HP", "Batas Waktu"
            }
        ));
        Tb_member.setRowHeight(30);
        Tb_member.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Tb_memberMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Tb_member);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 900, 260));

        btn_simpan1.setBackground(new java.awt.Color(51, 0, 153));
        btn_simpan1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_simpan1.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan1.setText("Simpan");
        btn_simpan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_simpan1MousePressed(evt);
            }
        });
        btn_simpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan1ActionPerformed(evt);
            }
        });
        add(btn_simpan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 184, 72, -1));

        btn_edit1.setBackground(new java.awt.Color(153, 102, 0));
        btn_edit1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_edit1.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit1.setText("Edit");
        btn_edit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_edit1MousePressed(evt);
            }
        });
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });
        add(btn_edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 261, 72, -1));

        btn_hapus1.setBackground(new java.awt.Color(204, 51, 0));
        btn_hapus1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_hapus1.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus1.setText("Hapus");
        btn_hapus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hapus1MousePressed(evt);
            }
        });
        btn_hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus1ActionPerformed(evt);
            }
        });
        add(btn_hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 261, 80, -1));

        btn_clear1.setBackground(new java.awt.Color(0, 102, 102));
        btn_clear1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_clear1.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear1.setText("Clear");
        btn_clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear1ActionPerformed(evt);
            }
        });
        add(btn_clear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 184, 72, -1));

        jLabel4member.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4member.setText("Nama Member");
        add(jLabel4member, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 51, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel10.setText(":");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 45, -1, -1));

        txt_nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 52, 271, -1));

        jLabel6member.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6member.setText("No HP");
        add(jLabel6member, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 123, -1, -1));

        jLabel7member.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7member.setText("Alamat");
        add(jLabel7member, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 87, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel11.setText(":");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 81, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel12.setText(":");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 117, -1, -1));

        txt_alamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 88, 271, -1));

        txt_nohp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(txt_nohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 124, 271, -1));

        btn_lihat1.setBackground(new java.awt.Color(0, 153, 204));
        btn_lihat1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_lihat1.setForeground(new java.awt.Color(255, 255, 255));
        btn_lihat1.setText("Lihat");
        btn_lihat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lihat1ActionPerformed(evt);
            }
        });
        add(btn_lihat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 261, 72, -1));

        txt_cari1.setToolTipText("");
        txt_cari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cari1ActionPerformed(evt);
            }
        });
        add(txt_cari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 264, 182, 29));

        jLabel1member.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1member.setText("jlabel1");
        add(jLabel1member, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 266, -1, -1));

        jPanel1member.setBackground(new java.awt.Color(39, 159, 136));

        jLabel2member.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2member.setText("Tambahkan Member");

        javax.swing.GroupLayout jPanel1memberLayout = new javax.swing.GroupLayout(jPanel1member);
        jPanel1member.setLayout(jPanel1memberLayout);
        jPanel1memberLayout.setHorizontalGroup(
            jPanel1memberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1memberLayout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(jLabel2member)
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel1memberLayout.setVerticalGroup(
            jPanel1memberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2member, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        add(jPanel1member, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 254, 1080, -1));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 298, 1080, -1));

        jLabel3member.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3member.setText("Cari");
        add(jLabel3member, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 268, -1, -1));

        jLabel6member1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6member1.setText("Tanggal");
        add(jLabel6member1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 153, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel13.setText(":");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 147, -1, -1));

        spinner_tanggal.setModel(new javax.swing.SpinnerDateModel());
        add(spinner_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 154, 114, -1));

        ckbox_berlaku.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ckbox_berlaku.setText("Masih Berlaku");
        ckbox_berlaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbox_berlakuActionPerformed(evt);
            }
        });
        add(ckbox_berlaku, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, 30));

        ckbox_kadaluarsa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ckbox_kadaluarsa.setText("Kadaluarsa");
        ckbox_kadaluarsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbox_kadaluarsaActionPerformed(evt);
            }
        });
        add(ckbox_kadaluarsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 260, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpan1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpan1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_simpan1MousePressed

    private void btn_simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan1ActionPerformed
   try {
        // Dapatkan nilai dari komponen GUI
        java.util.Date batas_waktu = (java.util.Date) spinner_tanggal.getValue();
        String nama = txt_nama.getText();
        String alamat = txt_alamat.getText();
        String no_hp = txt_nohp.getText();

        // Konversi nilai tanggal menjadi Timestamp
        Timestamp timestamp = new Timestamp(batas_waktu.getTime());

        if (t == null) {
            // Jika t == null, itu berarti operasi penyimpanan baru
            // Lakukan penyimpanan data ke database
            String query = "INSERT INTO member(nama, alamat, no_hp, tanggalDaftar, batas_waktu, statusMember) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, nama);
                pstmt.setString(2, alamat);
                pstmt.setString(3, no_hp);
                pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // Assuming you want to set the current timestamp for "tanggalDaftar"
                pstmt.setDate(5, new java.sql.Date(batas_waktu.getTime())); // Assuming batas_waktu is a java.util.Date object
                pstmt.setInt(6, 0);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Data baru berhasil disimpan");

                    // Lakukan refresh data atau tampilkan data baru di tabel jika diperlukan
                    // misalnya, panggil metode untuk memuat ulang data tabel
                    // reloadDataTabel();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menyimpan data baru");
                }
            }
        } else {
            // Jika t != null, itu berarti operasi pembaruan
            // Lakukan pembaruan data ke database berdasarkan ID yang tersimpan di t
            String query = "UPDATE member  SET nama=?, alamat=?, no_hp=? ,batas_waktu=?WHERE id_member=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                 pstmt.setString(1, nama);
                 pstmt.setString(2, alamat);
                 pstmt.setInt(3,Integer.parseInt(no_hp));
                 pstmt.setTimestamp(4, timestamp);
                 pstmt.setInt(5, Integer.parseInt(t));

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");

                    // Lakukan refresh data atau tampilkan data baru di tabel jika diperlukan
                    // misalnya, panggil metode untuk memuat ulang data tabel
//                     reloadDataTabel();
             
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal memperbarui data");
                }
            }
        }
        tabel();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
  
    }//GEN-LAST:event_btn_simpan1ActionPerformed
private void tampilkanDataBerdasarkanID(int idMember) {
  try {
        res = stat.executeQuery("SELECT * FROM member WHERE id_member='" + idMember + "'");
        while (res.next()) {
            // Assuming "tgl_pengeluaran" is a Date column in the database
            java.sql.Date sqlDate = res.getDate("batas_waktu");
            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
            // Assuming that spinner_tanggal is a JSpinner
            spinner_tanggal.setValue(utilDate);
            // Replace these column names with actual column names in your table
            txt_nama.setText(res.getString("nama"));
            txt_alamat.setText(res.getString("alamat"));
            txt_nohp.setText(String.valueOf(res.getInt("no_hp")));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void btn_edit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MousePressed

    }//GEN-LAST:event_btn_edit1MousePressed

    private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed
// Dapatkan baris yang dipilih
    int row = Tb_member.getSelectedRow(); 

    // Pastikan ada baris yang dipilih
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan diedit");
        return;
    }
    // Dapatkan ID Member dari kolom pertama (indeks 0)
    int idMember = Integer.parseInt(Tb_member.getValueAt(row, 0).toString());
    // Ambil nilai dari database dan tampilkan di JTextField
    tampilkanDataBerdasarkanID(idMember);

    // Simpan ID member yang akan diupdate (digunakan pada aksi btn_simpanActionPerformed)
    t = Integer.toString(idMember);
    }//GEN-LAST:event_btn_edit1ActionPerformed

    private void btn_clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear1ActionPerformed
      kosongkan();
      t = null;
    }//GEN-LAST:event_btn_clear1ActionPerformed

    private void btn_lihat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lihat1ActionPerformed
      // Dapatkan baris yang dipilih
    int barisTerpilih = Tb_member.getSelectedRow();

    // Pastikan ada baris yang dipilih
    if (barisTerpilih == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan dilihat");
        return;
    }
    // Dapatkan ID Bahan Baku dari kolom pertama (indeks 0)
    int idMember = Integer.parseInt(Tb_member.getValueAt(barisTerpilih, 0).toString());

    // Tampilkan detail data di sini, misalnya dengan menggunakan JOptionPane
    tampilkanDetailMember(idMember);
}
// Method untuk menampilkan detail Bahan Baku
private void tampilkanDetailMember(int idMember) {
     try {
        res = stat.executeQuery("SELECT * FROM pengeluaran WHERE id_pengeluaran='" + idMember + "'");
        while (res.next()) {
            // Assuming "tgl_pengeluaran" is a Date column in the database
            java.sql.Date sqlDate = res.getDate("batas_waktu");
            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

            // Assuming that spinner_tanggal is a JSpinner
            spinner_tanggal.setValue(utilDate);
            
            // Replace these column names with actual column names in your table
            txt_nama.setText(res.getString("nama"));
            txt_alamat.setText(res.getString("alamat"));
            txt_nohp.setText(res.getString("no_hp"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_btn_lihat1ActionPerformed

    private void Tb_memberMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_memberMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_memberMouseReleased

    private void btn_hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus1ActionPerformed
        // Dapatkan baris yang dipilih
        int row = Tb_member.getSelectedRow();

        // Pastikan ada baris yang dipilih
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
            return;
        }
        // Dapatkan ID member dari kolom pertama (indeks 0)
        int idMember = Integer.parseInt(Tb_member.getValueAt(row, 0).toString());

        // Hapus data dari database
        try {
            String query = "DELETE FROM member WHERE id_member = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idMember);
                pstmt.executeUpdate();
            }
            // Refresh tabel setelah penghapusan
            tabel();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapus1ActionPerformed

    private void btn_hapus1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapus1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapus1MousePressed

    private void txt_cari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cari1ActionPerformed
        String kataKunci = txt_cari1.getText();
        cariData(kataKunci);
    }//GEN-LAST:event_txt_cari1ActionPerformed

    private void ckbox_berlakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbox_berlakuActionPerformed
    DefaultTableModel model = (DefaultTableModel) Tb_member.getModel();
    model.setRowCount(0); // Clear existing rows

    try {
        res = stat.executeQuery("SELECT * FROM member");
        int rowCount = 0;

        while (res.next()) {
            int statusMember = res.getInt("statusMember");
            if (ckbox_berlaku.isSelected() && statusMember == 0) {
                model.addRow(new Object[]{
                        res.getString("id_member"),
                        res.getString("nama"),
                        res.getString("alamat"),
                        res.getString("no_hp"),
                        res.getString("batas_waktu"),
                        "MASIH BERLAKU"
                });
                rowCount++;
            } else if (!ckbox_berlaku.isSelected()) {
                model.addRow(new Object[]{
                        res.getString("id_member"),
                        res.getString("nama"),
                        res.getString("alamat"),
                        res.getString("no_hp"),
                        res.getString("batas_waktu"),
                        (statusMember == 0) ? "MASIH BERLAKU" : "SUDAH KADALUARSA"
                });
                rowCount++;
            }
        }

        jLabel1member.setText("Jumlah Data: " + rowCount);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_ckbox_berlakuActionPerformed

    private void ckbox_kadaluarsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbox_kadaluarsaActionPerformed
    DefaultTableModel model = (DefaultTableModel) Tb_member.getModel();
    model.setRowCount(0); // Clear existing rows

    try {
        res = stat.executeQuery("SELECT * FROM member");
        int rowCount = 0;

        while (res.next()) {
            int statusMember = res.getInt("statusMember");
            if (ckbox_kadaluarsa.isSelected() && statusMember == 1) {
                model.addRow(new Object[]{
                        res.getString("id_member"),
                        res.getString("nama"),
                        res.getString("alamat"),
                        res.getString("no_hp"),
                        res.getString("batas_waktu"),
                        "SUDAH KADALUARSA"
                });
                rowCount++;
            } else if (!ckbox_kadaluarsa.isSelected()) {
                model.addRow(new Object[]{
                        res.getString("id_member"),
                        res.getString("nama"),
                        res.getString("alamat"),
                        res.getString("no_hp"),
                        res.getString("batas_waktu"),
                        (statusMember == 0) ? "MASIH BERLAKU" : "SUDAH KADALUARSA"
                });
                rowCount++;
            }
        }

        jLabel1member.setText("Jumlah Data: " + rowCount);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_ckbox_kadaluarsaActionPerformed

    private void  batasWaktuSetmember() {
        try {
            String sql = "UPDATE member SET statusMember = 1 WHERE tanggalDaftar = batas_waktu";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            
        } catch(Exception e) {
         JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
           System.out.println("e: "+e);
       }
    }
    
   public static void tambahTanggalMember() {
            Timer timer = new Timer();
//            Schedule the task to run every day at 12 pm
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {                   
                        String sql = "UPDATE member SET tanggalDaftar = DATE_ADD(tanggalDaftar, INTERVAL 1 DAY)";
                        java.sql.Connection conn = (Connection) koneksi.configDB();
                        PreparedStatement pst = conn.prepareStatement(sql);

                        // Assuming currentDate is a java.sql.Date or java.util.Date object
                        pst.executeUpdate();        
                   } catch(Exception e) {
//                        JOptionPane.showMessageDialog(this, "gagal set tanggal baru" + e.getMessage());
                       System.out.println("e: "+e);
                   }
                    System.out.println("lol");
                }
            }, getDelay(), 24 * 60 * 60 * 1000);
   }
   
   private static long getDelay() {
        // Calculate the delay until the next 12 pm
        long currentTime = System.currentTimeMillis();
        long twelvePmMillis = getTwelvePmMillis(currentTime);
        
        if (currentTime > twelvePmMillis) {
            twelvePmMillis += 24 * 60 * 60 * 1000; // Move to the next day if it's already past 12 pm
        }
        return twelvePmMillis - currentTime;
    }

    private static long getTwelvePmMillis(long currentTime) {
        // Calculate the milliseconds since midnight and add the remaining time until 12 pm
        long midnightMillis = currentTime - (currentTime % (24 * 60 * 60 * 1000));
        return midnightMillis + (12 * 60 * 60 * 1000);
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tb_member;
    private javax.swing.JButton btn_clear1;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_hapus1;
    private javax.swing.JButton btn_lihat1;
    private javax.swing.JButton btn_simpan1;
    private javax.swing.JCheckBox ckbox_berlaku;
    private javax.swing.JCheckBox ckbox_kadaluarsa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel1member;
    private javax.swing.JLabel jLabel2member;
    private javax.swing.JLabel jLabel3member;
    private javax.swing.JLabel jLabel4member;
    private javax.swing.JLabel jLabel6member;
    private javax.swing.JLabel jLabel6member1;
    private javax.swing.JLabel jLabel7member;
    private javax.swing.JPanel jPanel1member;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner spinner_tanggal;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_cari1;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nohp;
    // End of variables declaration//GEN-END:variables
}
