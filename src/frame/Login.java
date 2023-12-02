package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import koneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends javax.swing.JFrame {
    private Timer t;
    public static String nameUser;
    public static int userId;

    public Login() {
        initComponents();
        startTimer();
    }

    private void startTimer() {
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        t.start();
    }

    private void updateTime() {
  
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Date dt = new Date();
                SimpleDateFormat st = new SimpleDateFormat("HH:mm");
                String tt = st.format(dt);
                Time.setText(tt);
            }
        });
    }
    public void stopTimer() {
        t.stop();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_username = new javax.swing.JTextField();
        registerasi = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        ckbox = new javax.swing.JCheckBox();
        txt_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setBackground(new java.awt.Color(237, 245, 224));
        txt_username.setBorder(null);
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, 320, -1));

        registerasi.setForeground(new java.awt.Color(10, 86, 56));
        registerasi.setText("Mendaftar");
        registerasi.setBorderPainted(false);
        registerasi.setContentAreaFilled(false);
        registerasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerasiActionPerformed(evt);
            }
        });
        getContentPane().add(registerasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 620, 100, 20));

        login.setBackground(new java.awt.Color(10, 86, 56));
        login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGIN");
        login.setBorder(null);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 580, 120, 30));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, -1, -1));

        Time.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setText("_");
        getContentPane().add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        ckbox.setText("Show Password");
        ckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckboxActionPerformed(evt);
            }
        });
        getContentPane().add(ckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 540, -1, -1));

        txt_password.setBackground(new java.awt.Color(237, 245, 224));
        txt_password.setBorder(null);
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passwordFocusLost(evt);
            }
        });
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, 320, -1));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_componen/LoginPage (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void registerasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerasiActionPerformed
        Register frameRegister = new Register();
        frameRegister.setVisible(true);
    }//GEN-LAST:event_registerasiActionPerformed
    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
    }//GEN-LAST:event_txt_usernameActionPerformed
    private void txt_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusGained
        if(txt_username.getText().equals("Isi Username")) {
            txt_username.setText("");
            txt_username.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txt_usernameFocusGained
    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
       if(txt_username.getText().equals("")) {
            txt_username.setText("Isi Username");
            txt_username.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txt_usernameFocusLost
    private void ckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckboxActionPerformed
            if(ckbox.isSelected()){
                txt_password.setEchoChar((char)0);
            } else if (txt_password.getText().isEmpty()) {
                    txt_password.setEchoChar((char)0);    
            } else {
                txt_password.setEchoChar('*');
            }  
    }//GEN-LAST:event_ckboxActionPerformed
    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
    }//GEN-LAST:event_txt_passwordActionPerformed
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        try {
            String loginQuery = "SELECT * FROM user WHERE username=? AND password=?";
            try (Connection connLogin = koneksi.configDB();
                 PreparedStatement pstLogin = connLogin.prepareStatement(loginQuery)) {

                pstLogin.setString(1, txt_username.getText());
                pstLogin.setString(2, new String(txt_password.getPassword())); // Use getPassword() for password field

                try (ResultSet rsLogin = pstLogin.executeQuery()) {
                    if (rsLogin.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        this.setVisible(false);
                        nameUser = txt_username.getText();
                        String jabatan = rsLogin.getString("jabatan");
                        userId = rsLogin.getInt("id_pegawai"); 

                        if (!"Owner".equals(jabatan)) {
                            insertAbsensiData();
                        }

                        new MenuUtama().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void insertAbsensiData() {
        try {
            String absensiQuery = "INSERT INTO absensi (username, waktu_absensi, status_absensi) VALUES (?, ?, ?)";
            try (Connection connAbsensi = koneksi.configDB();
                 PreparedStatement pstAbsensi = connAbsensi.prepareStatement(absensiQuery)) {

                pstAbsensi.setString(1, txt_username.getText());

                Date currentTime = new Date();
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                String labelText = timeFormat.format(currentTime);

                pstAbsensi.setString(2, labelText);

                pstAbsensi.setString(3, labelText.compareTo("07:00") > 0 ? "Terlambat" : "Tepat Waktu");

                pstAbsensi.executeUpdate();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_loginActionPerformed
    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained
        if(txt_password.getText().equals("Isi Password")) {
            txt_password.setText("");
            txt_password.setEchoChar('*');
            txt_password.setForeground(new Color(0,0,0));
        } 
    }//GEN-LAST:event_txt_passwordFocusGained
    private void txt_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusLost
        if(txt_password.getText().equals("")) {
            txt_password.setText("Isi Password");
            txt_password.setEchoChar((char) 0);
            txt_password.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txt_passwordFocusLost
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Time;
    private javax.swing.JCheckBox ckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login;
    private javax.swing.JButton registerasi;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}