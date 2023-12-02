
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader; 



public class panelProduk extends javax.swing.JPanel {
    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String t;
    
       
    public panelProduk() {
        koneksi();
        initComponents();
        kosongkan();
        tabel();
        
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
            (screenSize.width - frameSize.width) / 3,
            (screenSize.height -frameSize.height) / 4);
    }
    
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
     private void kosongkan(){
     
        txt_namaproduk.setText("");
        txt_hargaproduk.setText("");
    }
    private void tabel(){
      
    // Set show grid untuk menampilkan garis pembatas
    tb_produk.setShowGrid(true);

    // Set show horizontal lines dan show vertical lines
    tb_produk.setShowHorizontalLines(true);
    tb_produk.setShowVerticalLines(true);
    
     DefaultTableModel t = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Membuat sel tidak dapat diedit langsung di tabel
        }
    };
  t.addColumn("Id Produk");
t.addColumn("Nama Produk");
t.addColumn("Harga Produk");
t.addColumn("Jenis Produk");
tb_produk.setModel(t);

try {
    // Use COUNT query to get the total number of rows
    res = stat.executeQuery("SELECT COUNT(*) as total_rows FROM produk");
    int rowCount = 0;

    if (res.next()) {
        rowCount = res.getInt("total_rows");
    }

    res = stat.executeQuery("SELECT * FROM produk");
    while (res.next()) {
        t.addRow(new Object[]{
            res.getString("id_produk"),
            res.getString("nama_produk"),
            res.getString("harga_produk"),
            res.getString("jenis_produk"),
        });

        // Your existing code to set cell renderer for the first row
        if (rowCount == 0) {
            tb_produk.getColumnModel().getColumn(0).setCellRenderer(new CustomTableCellRenderer());
            tb_produk.getColumnModel().getColumn(1).setCellRenderer(new CustomTableCellRenderer());
            tb_produk.getColumnModel().getColumn(2).setCellRenderer(new CustomTableCellRenderer());
            tb_produk.getColumnModel().getColumn(3).setCellRenderer(new CustomTableCellRenderer());
        }
        rowCount++;
    }

    // Modify JLabel to display row count
    jLabel1.setText("Jumlah Data: " + rowCount);
    } catch (Exception e) {
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, e);
    }

    // Set rata tengah (centered) untuk semua sel di tabel
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    for (int i = 0; i < tb_produk.getColumnCount(); i++) {
        tb_produk.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Set rata tengah (centered) untuk header kolom
    JTableHeader header = tb_produk.getTableHeader();
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
    DefaultTableModel model = (DefaultTableModel) tb_produk.getModel();
    model.setRowCount(0); // Bersihkan baris yang sudah ada

    try {
        // Gunakan prepared statement untuk menghindari SQL injection
        String query = "SELECT * FROM produk WHERE id_produk LIKE ? OR nama_produk LIKE ? OR harga_produk LIKE ? OR jenis_produk LIKE ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 1; i <= 4; i++) {
                pstmt.setString(i, "%" + kataKunci + "%");
            }
            res = pstmt.executeQuery();

            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString("id_produk"),
                    res.getString("nama_produk"),
                    res.getString("harga_produk"),
                    res.getString("jenis_produk")
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
        tb_produk = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_namaproduk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_hargaproduk = new javax.swing.JTextField();
        btn_lihat = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        combobox_jenis = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        tb_produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Produk", "Nama Produk", "Harga Produk", "Jenis Produk"
            }
        ));
        tb_produk.setRowHeight(30);
        tb_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_produkMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tb_produk);

        btn_simpan.setBackground(new java.awt.Color(51, 0, 153));
        btn_simpan.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_simpanMousePressed(evt);
            }
        });
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(153, 102, 0));
        btn_edit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_editMousePressed(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

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

        btn_clear.setBackground(new java.awt.Color(0, 102, 102));
        btn_clear.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Nama Produk");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel10.setText(":");

        txt_namaproduk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Jenis Produk");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Harga Produk");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel11.setText(":");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel12.setText(":");

        txt_hargaproduk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jLabel1.setText("jlabel1");

        jPanel1.setBackground(new java.awt.Color(39, 159, 136));
        jPanel1.setPreferredSize(new java.awt.Dimension(1082, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Tambahkan Produk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(jLabel2)
                .addContainerGap(478, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Cari");

        combobox_jenis.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        combobox_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogram", "Satuan" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addComponent(txt_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_lihat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(combobox_jenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addComponent(txt_hargaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txt_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txt_hargaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(combobox_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_simpan)
                    .addComponent(btn_clear))
                .addGap(46, 46, 46)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_hapus)
                    .addComponent(btn_edit)
                    .addComponent(btn_lihat)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_simpanMousePressed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
 try {
        if (t == null) {
            // Jika t == null, berarti ini adalah aksi untuk menambahkan data baru
            String query = "INSERT INTO produk(nama_produk, harga_produk, jenis_produk) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, txt_namaproduk.getText());
                pstmt.setString(2, txt_hargaproduk.getText());
                pstmt.setString(3, combobox_jenis.getSelectedItem().toString());

                int affectedRows = pstmt.executeUpdate(); 
                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int idProduk = generatedKeys.getInt(1);
                            // Gunakan ID yang baru dibuat jika perlu
                            System.out.println("ID Produk: " + idProduk);
                            // Tambahkan data baru ke tabel tanpa perlu me-refresh
                            DefaultTableModel model = (DefaultTableModel) tb_produk.getModel();
                            model.addRow(new Object[]{
                                idProduk,
                                txt_namaproduk.getText(),
                                txt_hargaproduk.getText(),
                                combobox_jenis.getSelectedItem().toString()
                            });

                            // Update jumlah data
                            jLabel1.setText("Jumlah Data: " + model.getRowCount());
                        }
                    }
                }
            }

            kosongkan();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
        } else {
            // Jika t != null, berarti ini adalah aksi untuk mengupdate data yang sudah ada
            String query = "UPDATE produk SET nama_produk=?, harga_produk=?, jenis_produk=? WHERE id_produk=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, txt_namaproduk.getText());
                pstmt.setString(2, txt_hargaproduk.getText());
                pstmt.setString(3, combobox_jenis.getSelectedItem().toString());
                pstmt.setInt(4, Integer.parseInt(t));

                pstmt.executeUpdate();
            }
        
            // Refresh tabel setelah update
            tabel();

            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

            // Reset nilai t agar kembali ke mode penambahan data baru
            t = null;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Perintah SALAH ! " + e);
    }

    }//GEN-LAST:event_btn_simpanActionPerformed
private void tampilkanDataBerdasarkanID(int idProduk) {
    try {
        res = stat.executeQuery("SELECT * FROM produk WHERE id_produk='" + idProduk + "'");
        while (res.next()) {
            txt_namaproduk.setText(res.getString("nama_produk"));
            txt_hargaproduk.setText(res.getString("harga_produk"));
            combobox_jenis.setSelectedItem(res.getString("jenis_produk"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void btn_editMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMousePressed

    }//GEN-LAST:event_btn_editMousePressed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
// Dapatkan baris yang dipilih
    int row = tb_produk.getSelectedRow(); 
    // Pastikan ada baris yang dipilih
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan diedit");
        return;
    }
    // Dapatkan ID Bahan Baku dari kolom pertama (indeks 0)
    int idProduk = Integer.parseInt(tb_produk.getValueAt(row, 0).toString());
    // Ambil nilai dari database dan tampilkan di JTextField
    tampilkanDataBerdasarkanID(idProduk);
    // Simpan ID Bahan Baku yang akan diupdate (digunakan pada aksi btn_simpanActionPerformed)
    t = Integer.toString(idProduk);

  
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
      kosongkan();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lihatActionPerformed
      // Dapatkan baris yang dipilih
    int barisTerpilih = tb_produk.getSelectedRow();

    // Pastikan ada baris yang dipilih
    if (barisTerpilih == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan dilihat");
        return;
    }

    // Dapatkan ID produk dari kolom pertama (indeks 0)
    int idProduk = Integer.parseInt(tb_produk.getValueAt(barisTerpilih, 0).toString());

    // Tampilkan detail data di sini, misalnya dengan menggunakan JOptionPane
    tampilkanDetailProduk(idProduk);
}

// Method untuk menampilkan detail produk
private void tampilkanDetailProduk(int idProduk) {
    try {
        // Query database untuk mendapatkan detail Bahan Baku berdasarkan ID
        String query = "SELECT * FROM produk WHERE id_produk = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idProduk);
            res = pstmt.executeQuery();

            // Tampilkan hasil query
            if (res.next()) {
                String detail = "ID Produk: " + res.getString("id_produk") + "\n"
                        + "Nama Produk: " + res.getString("nama_produk") + "\n"
                        + "Harga Produk: " + res.getString("harga_produk") + "\n"
                        + "Jenis Produk: " + res.getString("harga_produk");

                // Tampilkan detail menggunakan JOptionPane
                JOptionPane.showMessageDialog(this, detail, "Detail Produk", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan detail: " + e.getMessage());
    }
 
    }//GEN-LAST:event_btn_lihatActionPerformed

    private void tb_produkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_produkMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_produkMouseReleased

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // Dapatkan baris yang dipilih
        int row = tb_produk.getSelectedRow();

        // Pastikan ada baris yang dipilih
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
            return;
        }

        // Dapatkan ID Bahan Baku dari kolom pertama (indeks 0)
        int idProduk = Integer.parseInt(tb_produk.getValueAt(row, 0).toString());

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        // Hapus data dari database
        try {
            String query = "DELETE FROM produk WHERE id_produk = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idProduk);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_lihat;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> combobox_jenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tb_produk;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_hargaproduk;
    private javax.swing.JTextField txt_namaproduk;
    // End of variables declaration//GEN-END:variables
}
