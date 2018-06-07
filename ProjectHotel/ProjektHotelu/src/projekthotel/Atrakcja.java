package projekthotel;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Atrakcja extends javax.swing.JFrame {

    Rezerwacja rezerwacja;
    String wybrany;
    int cena, dzien, miesiac, rok, czas_trwania;
    JFrame cos;
    GregorianCalendar data;
    Zlecenia zlecenie;

    public Atrakcja(Rezerwacja g, JFrame frame) {
        rezerwacja = g;
        cos = frame;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dzien_pocz_pole = new javax.swing.JTextField();
        mies_pocz_pole = new javax.swing.JTextField();
        rok_pocz_pole = new javax.swing.JTextField();
        BACKGROUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Zamów");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 400, 150, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cena 20zł");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 290, 110, 22);

        jLabel2.setFont(new java.awt.Font("Wide Latin", 2, 14)); // NOI18N
        jLabel2.setText("Spa");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 30, 60, 21);

        jLabel3.setFont(new java.awt.Font("Wide Latin", 2, 14)); // NOI18N
        jLabel3.setText("Basen");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 30, 80, 21);

        jLabel4.setFont(new java.awt.Font("Wide Latin", 2, 14)); // NOI18N
        jLabel4.setText("Bilard");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(540, 30, 100, 21);

        jButton2.setText("Wyjście");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(520, 400, 150, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/spa.jpg"))); // NOI18N
        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 60, 220, 220);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basen.jpg"))); // NOI18N
        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(240, 60, 220, 220);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bilard.jpg"))); // NOI18N
        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(470, 60, 220, 220);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cena 12zł");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 290, 100, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Cena  10 zł");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(530, 290, 120, 22);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("data_rozpoczecia");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(80, 30, 120, 17);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("dzien");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(40, 50, 36, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("miesiac");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(120, 50, 49, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("rok:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(210, 50, 28, 17);

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Wybierz termin  rezerwacji :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 0, 250, 30);

        dzien_pocz_pole.setText("0");
        dzien_pocz_pole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dzien_pocz_poleActionPerformed(evt);
            }
        });
        jPanel2.add(dzien_pocz_pole);
        dzien_pocz_pole.setBounds(30, 70, 60, 25);

        mies_pocz_pole.setText("0");
        jPanel2.add(mies_pocz_pole);
        mies_pocz_pole.setBounds(120, 70, 60, 25);

        rok_pocz_pole.setText("0");
        jPanel2.add(rok_pocz_pole);
        rok_pocz_pole.setBounds(210, 70, 60, 25);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 340, 280, 110);

        BACKGROUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tlo.png"))); // NOI18N
        getContentPane().add(BACKGROUD);
        BACKGROUD.setBounds(0, 0, 700, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dodajZlecenie();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        wybrany = "BASEN";
        cena = 12;
        czas_trwania = 2;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        wybrany = "BILARD";
        cena = 10;
        czas_trwania = 2;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        wybrany = "SPA";
        cena = 20;
        czas_trwania = 1;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dzien_pocz_poleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dzien_pocz_poleActionPerformed

    }//GEN-LAST:event_dzien_pocz_poleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        cos.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Atrakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atrakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atrakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atrakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    void dodajZlecenie() {
        try {
            dzien = Integer.parseInt(dzien_pocz_pole.getText());
            miesiac = Integer.parseInt(mies_pocz_pole.getText());
            rok = Integer.parseInt(rok_pocz_pole.getText());
            data = new GregorianCalendar(rok, miesiac, dzien);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "           Błędne dane. \nDaty muszą być liczbami! ", "Błędne dane", JOptionPane.ERROR_MESSAGE);
        }

        if (sprawdz_pola()) {
            zlecenie = new Zlecenia(1, wybrany, "atrakcja", cena, data, czas_trwania, rezerwacja.getId(), ".");
            try {
                WpiszZlecenie bombel = new WpiszZlecenie(zlecenie);
                ServerConnection.getInstance().getOutputStream().writeObject(bombel);
            } catch (IOException ex) {
                Logger.getLogger(Gosc.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(rootPane, "          Zarezerwowano ", "Gratulacje!", JOptionPane.INFORMATION_MESSAGE);
        }else
            JOptionPane.showMessageDialog(rootPane, "                        Błędne dane. \nWpisz poprawne daty oraz wybierz klasę pokoju. ", "Błędne dane", JOptionPane.ERROR_MESSAGE);

    }

    public boolean sprawdz_pola() {
        if (dzien <= 0 || miesiac <= 0 || rok <= 0 || dzien > 31 || miesiac > 12 ) {
            return false;
        } else {
            return true;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUD;
    private javax.swing.JTextField dzien_pocz_pole;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mies_pocz_pole;
    private javax.swing.JTextField rok_pocz_pole;
    // End of variables declaration//GEN-END:variables

}
