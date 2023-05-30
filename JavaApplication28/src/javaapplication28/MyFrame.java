package javaapplication28;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
    Connection con;
    JPasswordField password, password2;
    JTextField ad, soyad, username, username2, TCNo, TelNo, Email, Adres;
    JRadioButton KullaniciTipi1, KullaniciTipi2;
    JLabel label_password, label_password2, label_username, label_username2, label_ad, label_soyad, label_TCNo,label_TelNo, label_Email, label_Adres, message, titleregister, titlelogin, label_KullaniciTipi;
    JButton btn, btn2, reset_btn;
    JCheckBox showPassword, showPassword2;

    MyFrame() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setTitle("Kullanıcı Giriş/Kayıt");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        titleregister = new JLabel("KAYIT OLMA FORMU");
        titleregister.setBounds(670, 00, 150, 30);

        titlelogin = new JLabel("GİRİŞ YAP");
        titlelogin.setBounds(200, 70, 200, 50);

        label_ad = new JLabel("Ad");
        label_ad.setBounds(480, 40, 100, 30);

        label_soyad = new JLabel("Soyad");
        label_soyad.setBounds(480, 80, 100, 30);

        label_username = new JLabel("Username");
        label_username.setBounds(480, 120, 100, 30);

        label_username2 = new JLabel("Username");
        label_username2.setBounds(30, 120, 100, 30);

        label_password = new JLabel("Password");
        label_password.setBounds(480, 160, 100, 30);

        label_password2 = new JLabel("Password");
        label_password2.setBounds(30, 160, 100, 30);

        label_TCNo = new JLabel("TC Kimlik Numarasi");
        label_TCNo.setBounds(480, 200, 120, 30);

        label_TelNo = new JLabel("Telefon Numarasi");
        label_TelNo.setBounds(480, 240, 100, 30);

        label_Email = new JLabel("E-Posta");
        label_Email.setBounds(480, 280, 100, 30);

        label_Adres = new JLabel("Adres");
        label_Adres.setBounds(480, 320, 250, 30);

        label_KullaniciTipi = new JLabel("Kullanici Tipi");
        label_KullaniciTipi.setBounds(480, 360, 250, 30);

        message = new JLabel("Kutum");
        message.setBounds(500, 500, 300, 30);

        ad = new JTextField();
        ad.setBounds(600, 40, 300, 30);

        soyad = new JTextField();
        soyad.setBounds(600, 80, 300, 30);

        username = new JTextField();
        username.setBounds(600, 120, 300, 30);

        username2 = new JTextField();
        username2.setBounds(100, 120, 300, 30);

        password = new JPasswordField();
        password.setBounds(600, 160, 300, 30);

        password2 = new JPasswordField();
        password2.setBounds(100, 160, 300, 30);

        TCNo = new JTextField();
        TCNo.setBounds(600, 200, 300, 30);

        TelNo = new JTextField();
        TelNo.setBounds(600, 240, 300, 30);

        Email = new JTextField();
        Email.setBounds(600, 280, 300, 30);

        Adres = new JTextField();
        Adres.setBounds(600, 320, 300, 30);

        KullaniciTipi1 = new JRadioButton("İsci");
        KullaniciTipi1.setBounds(600, 360, 100, 30);

        KullaniciTipi2 = new JRadioButton("Patron");
        KullaniciTipi2.setBounds(700, 360, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(KullaniciTipi1);
        bg.add(KullaniciTipi2);

        showPassword = new JCheckBox("Sifreyi Goster");
        showPassword.setBounds(600, 400, 140, 30);
        showPassword.addActionListener(this);

        showPassword2 = new JCheckBox("Sifreyi Goster");
        showPassword2.setBounds(100, 200, 140, 30);
        showPassword2.addActionListener(this);

        btn = new JButton("Kayıt Ol");
        btn.setBounds(600, 450, 100, 30);
        btn.addActionListener(this);

        btn2 = new JButton("Giriş Yap");
        btn2.setBounds(100, 250, 100, 30);
        btn2.addActionListener(this);

        reset_btn = new JButton("Herseyi Sil");
        reset_btn.setBounds(700, 450, 100, 30);
        reset_btn.addActionListener(this);

        this.add(titlelogin);
        this.add(titleregister);
        this.add(showPassword);
        this.add(showPassword2);
        this.add(reset_btn);
        this.add(message);
        this.add(label_username);
        this.add(label_username2);
        this.add(username);
        this.add(username2);
        this.add(btn);
        this.add(btn2);
        this.add(label_ad);
        this.add(label_soyad);
        this.add(label_TCNo);
        this.add(label_TelNo);
        this.add(label_Email);
        this.add(label_Adres);
        this.add(label_password);
        this.add(label_password2);
        this.add(label_KullaniciTipi);
        this.add(password);
        this.add(password2);
        this.add(ad);
        this.add(soyad);
        this.add(TCNo);
        this.add(TelNo);
        this.add(Adres);
        this.add(Email);
        this.add(KullaniciTipi1);
        this.add(KullaniciTipi2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            try {
                String adText = ad.getText();
                String soyadText = soyad.getText();
                String EmailText = Email.getText();
                String TCNoText = TCNo.getText();
                String TelNoText = TelNo.getText();
                String AdresText = Adres.getText();
                String usernameText = username.getText();
                String passwordText = String.valueOf(password.getPassword());
                String KullaniciTipi = "";
                if (KullaniciTipi1.isSelected()) {
                    KullaniciTipi = "İsci";
                } else if (KullaniciTipi2.isSelected()) {
                    KullaniciTipi = "Patron";
                }

                Statement stmt = con.createStatement();
                String query = "INSERT INTO kullanici (Kullanici_AD,Kullanici_SOYAD, Kullanici_TCNO,Kullanici_TELNO, Kullanici_EMAIL, Kullanici_ADRES,Kullanici_USERNAME,Kullanici_PASSWORD, Kullanici_KULLANICITIPI) VALUES ('"
                        + adText + "','" + soyadText + "','" + TCNoText + "','" + TelNoText + "','" + EmailText + "','"
                        + AdresText + "','" + usernameText + "','" + passwordText + "','" + KullaniciTipi + "')";

                stmt.executeUpdate(query);
                message.setText("Kayit Olma Basarili!");
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

         if (e.getSource() == btn2) {

        // Kullanıcı adı ve şifreyle sorgu oluşturulmalıdır.
        String sql = "SELECT * FROM kullanici WHERE Kullanici_USERNAME = ? AND Kullanici_PASSWORD = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, username2.getText());
            statement.setString(2, String.valueOf(password2.getPassword()));

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Kullanıcı doğrulandı, giriş yapabilir.
                    message.setText("Giriş Başarılı!");
                    this.dispose();
                    Takviminterface takvim = new Takviminterface();
                    takvim.setVisible(true);
                } else {
                    // Kullanıcı doğrulanamadı, hatalı giriş.
                    message.setText("Kullanıcı Bulunamadı veya Hatalı Şifre!");
                }
            }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    
        if (e.getSource() == reset_btn) {
            ad.setText("");
            soyad.setText("");
            Email.setText("");
            TCNo.setText("");
            TelNo.setText("");
            Adres.setText("");
            username.setText("");
            password.setText("");
            password2.setText("");
            username2.setText("");
            message.setText("");
            KullaniciTipi1.setSelected(false);
            KullaniciTipi2.setSelected(false);
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        }

        if (e.getSource() == showPassword2) {
            if (showPassword2.isSelected()) {
                password2.setEchoChar((char) 0);
            } else {
                password2.setEchoChar('*');
            }
        }
    }


}