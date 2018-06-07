/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import static projekthotel.data.login;

/**
 *
 * @author użytkownik
 */
public class NewRezewation extends javax.swing.JFrame {

    Pokoj pokoj;
    Rezerwacja rezerwacja;
    GregorianCalendar start;
    GregorianCalendar koniec;
    int rachunek;
    
    public NewRezewation(Pokoj pokoj, int rachunek, GregorianCalendar start, GregorianCalendar koniec) {
        this.koniec = koniec;
        this.start = start;
        this.rachunek=rachunek;
        this.pokoj = pokoj;
        initComponents(); 
        rachunek_POLE.setText(rachunek*dni_pomiedzy(start, koniec)+" zł");
    }
          
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rachunek_POLE = new javax.swing.JTextField();
        ID_pole = new javax.swing.JTextField();
        pesel_POLE = new javax.swing.JTextField();
        nazwisko_POLE = new javax.swing.JTextField();
        imie_POLE = new javax.swing.JTextField();
        password_POLE = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 300));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(150, 80, 50, 20);

        jLabel2.setFont(new java.awt.Font("Vivaldi", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("Wypelnij ankiete rezerwacji");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(200, 30, 210, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Zarezerwuj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(180, 390, 240, 60);

        jButton2.setText("Anuluj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(490, 410, 150, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pesel");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(150, 270, 90, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Imie");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 190, 50, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Do zaplaty");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(150, 330, 100, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Haslo");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(150, 150, 60, 20);

        rachunek_POLE.setBackground(new java.awt.Color(153, 153, 0));
        rachunek_POLE.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rachunek_POLE.setRequestFocusEnabled(false);
        rachunek_POLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rachunek_POLEActionPerformed(evt);
            }
        });
        jPanel2.add(rachunek_POLE);
        rachunek_POLE.setBounds(260, 320, 180, 30);

        ID_pole.setBackground(new java.awt.Color(153, 153, 0));
        ID_pole.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ID_pole.setEnabled(false);
        ID_pole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_poleActionPerformed(evt);
            }
        });
        jPanel2.add(ID_pole);
        ID_pole.setBounds(260, 80, 180, 30);
        jPanel2.add(pesel_POLE);
        pesel_POLE.setBounds(260, 260, 180, 30);
        jPanel2.add(nazwisko_POLE);
        nazwisko_POLE.setBounds(260, 220, 180, 30);
        jPanel2.add(imie_POLE);
        imie_POLE.setBounds(260, 180, 180, 30);

        password_POLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_POLEActionPerformed(evt);
            }
        });
        jPanel2.add(password_POLE);
        password_POLE.setBounds(260, 140, 180, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nazwisko");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(150, 230, 100, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 10, 650, 480);

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tlo.png"))); // NOI18N
        jPanel1.add(BACKGROUND);
        BACKGROUND.setBounds(0, 0, 700, 500);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        zatwierdzenie();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void password_POLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_POLEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_POLEActionPerformed

    private void ID_poleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_poleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_poleActionPerformed

    private void rachunek_POLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rachunek_POLEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rachunek_POLEActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowLogged().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NewRezewation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewRezewation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewRezewation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewRezewation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    void zatwierdzenie() {

        String haslo = new String(password_POLE.getPassword());
        String imie = imie_POLE.getText();
        String nazwisko = nazwisko_POLE.getText();
        String pesel = pesel_POLE.getText(); 
        
        int rech_rez=(int) (rachunek*dni_pomiedzy(start, koniec));
        
        rezerwacja = new Rezerwacja(0, haslo, imie, nazwisko, pesel, start, koniec, rech_rez);

        try {
            Pobyt bombel = new Pobyt(rezerwacja, pokoj);
            ServerConnection.getInstance().getOutputStream().writeObject(bombel);
            int stan = (int) ServerConnection.getInstance().getInputStream().readObject();

            switch (stan) {
                case -1:
                    JOptionPane.showMessageDialog(rootPane, "Blad tworzenie Rezerwacji", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                case -2:
                    JOptionPane.showMessageDialog(rootPane, "Blad tworzenie RezerwacjaPokoi", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                default:
                    int gen_id = (int) ServerConnection.getInstance().getInputStream().readObject();
                    ID_pole.setText(gen_id + "");
                    jButton1.setVisible(false);
                    jButton2.setText("Zakoncz");
                    JOptionPane.showMessageDialog(rootPane, "Zarezerwowano pobyt Twoj id: " + gen_id, "Błąd", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        } catch (IOException | ClassNotFoundException ex) {
        }

        
        
    }
public static long dni_pomiedzy(GregorianCalendar startDate, GregorianCalendar endDate) {
        long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
 
        return (diff / (1000 * 60 * 60 * 24)); // 1000 milisekund w sekundzie * 60 sekund w minucie * 60 minut w godzinie * 24 godziny w dniu
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JTextField ID_pole;
    private javax.swing.JTextField imie_POLE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField nazwisko_POLE;
    private javax.swing.JPasswordField password_POLE;
    private javax.swing.JTextField pesel_POLE;
    private javax.swing.JTextField rachunek_POLE;
    // End of variables declaration//GEN-END:variables
}
