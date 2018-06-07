package projekthotel;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WindowLogged extends javax.swing.JFrame {

    public WindowLogged() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 300));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(220, 350, 190, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Zaloguj się");
        jButton1.setToolTipText("");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 350, 190, 40);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(220, 410, 190, 40);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(760, 307, 0, 0);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Nowa rezerwacja");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(460, 410, 190, 40);

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logowanie.png"))); // NOI18N
        getContentPane().add(BACKGROUND);
        BACKGROUND.setBounds(0, 0, 700, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String haslo = new String(jPasswordField1.getPassword());
        String login = jTextField1.getText();
        try {
            DownloadRezewationAndWorker bombel = new DownloadRezewationAndWorker(login, haslo);
            ServerConnection.getInstance().getOutputStream().writeObject(bombel);
            Object ob = (Object) ServerConnection.getInstance().getInputStream().readObject();

            if (ob == null) {
                JOptionPane.showMessageDialog(rootPane, "Podano bledne id lub haslo!!!", "Błąd", JOptionPane.ERROR_MESSAGE);
            } else {
                if (ob instanceof Rezerwacja) {

                    this.dispose();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new Gosc((Rezerwacja) ob).setVisible(true);
                        }
                    });
                } else if (ob instanceof Pracownik) {
                    String typ = ((Pracownik) ob).getTyp();
                    if ("recepcjonista".equals(typ)) {
                        this.dispose();
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new Recepcjonista((Pracownik) ob).setVisible(true);
                            }
                        });
                    } else if ("kucharz".equals(typ)) {
                        this.dispose();
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new Kucharz((Pracownik) ob).setVisible(true);
                            }
                        });
                    } 
                    else if ("pracownik".equals(typ)) {
                        this.dispose();
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new PracownikSystem((Pracownik) ob).setVisible(true);
                            }
                        });
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "Nie rozpozano!!!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }

                }

            }

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed

    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wyborpokoju().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowLogged().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
