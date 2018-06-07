/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author przem
 */
public class Kucharz extends javax.swing.JFrame {

    int index1;
    int index2;
    DefaultListModel nazwa = new DefaultListModel();
    List<Potrawa> potrawy = null;
    List<Zamowienie> zamowienia = null;

    Pracownik pracownik;

    public ListSelectionListener zmiana_zamowienia = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (nazwa.size() != 0) {
                index1 = lista_zamowienia.getSelectedIndex();
                lista_szczegoly.setText(zamowienia.get(index1).getSzczegoly());
            }
        }
    };

    public Kucharz(Pracownik pracownik) {
        initComponents();
        lista_zamowienia.addListSelectionListener(zmiana_zamowienia);
        this.pracownik = pracownik;

        try {

            DownloadPotrawa bombel = new DownloadPotrawa();
            ServerConnection.getInstance().getOutputStream().writeObject(bombel);
            potrawy = (List<Potrawa>) ServerConnection.getInstance().getInputStream().readObject();

        } catch (IOException | ClassNotFoundException ex) {
        }

        try {
            OtrzymajZamowienia bombelek = new OtrzymajZamowienia();
            ServerConnection.getInstance().getOutputStream().writeObject(bombelek);
            zamowienia = (List<Zamowienie>) ServerConnection.getInstance().getInputStream().readObject();

        } catch (IOException | ClassNotFoundException ex) {
        }

        nazwa = new DefaultListModel();
        for (int i = 0; i < zamowienia.size(); i++) {
            nazwa.addElement("Zamowienie nr. " + zamowienia.get(i).getId());

        }
        lista_zamowienia.setModel(nazwa);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_szczegoly = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_zamowienia = new javax.swing.JList<>();
        UsunZamBUTT = new javax.swing.JButton();
        AktualizujBUTT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 300));
        setResizable(false);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(null);

        lista_szczegoly.setLineWrap(true);
        lista_szczegoly.setColumns(20);
        lista_szczegoly.setRows(5);
        jScrollPane3.setViewportView(lista_szczegoly);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(340, 70, 240, 260);

        jScrollPane1.setViewportView(lista_zamowienia);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 230, 260);

        UsunZamBUTT.setText("Zamowienie wydane. Usun.");
        UsunZamBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsunZamBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(UsunZamBUTT);
        UsunZamBUTT.setBounds(50, 390, 200, 40);

        AktualizujBUTT.setText("Aktualizuj");
        AktualizujBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AktualizujBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(AktualizujBUTT);
        AktualizujBUTT.setBounds(80, 340, 150, 40);

        jButton1.setText("Wyloguj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(490, 420, 150, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Szczegóły zamowienia");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(350, 40, 190, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lista zamówień");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 40, 130, 20);

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tlo.png"))); // NOI18N
        BACKGROUND.setToolTipText("");
        jPanel1.add(BACKGROUND);
        BACKGROUND.setBounds(0, 0, 702, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AktualizujBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AktualizujBUTTActionPerformed
        aktualizuj();

    }//GEN-LAST:event_AktualizujBUTTActionPerformed

    private void UsunZamBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsunZamBUTTActionPerformed
        if (nazwa.size() != 0) {
            try {
                UsunZamowienie bombel2 = new UsunZamowienie(zamowienia.get(index1));
                ServerConnection.getInstance().getOutputStream().writeObject(bombel2);
            } catch (IOException ex) {
                Logger.getLogger(Gosc.class.getName()).log(Level.SEVERE, null, ex);
            }
            zamowienia.remove(zamowienia.get(index1));

            aktualizuj();
        }

    }//GEN-LAST:event_UsunZamBUTTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowLogged().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Kucharz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kucharz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kucharz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kucharz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kucharz(null).setVisible(true);
            }
        });
    }

    void aktualizuj() {
        zamowienia.removeAll(zamowienia);
        nazwa.clear();
        try {
            OtrzymajZamowienia bombelek = new OtrzymajZamowienia();
            ServerConnection.getInstance().getOutputStream().writeObject(bombelek);
            zamowienia = (List<Zamowienie>) ServerConnection.getInstance().getInputStream().readObject();

        } catch (IOException | ClassNotFoundException ex) {
        }
        nazwa = new DefaultListModel();
        for (int i = 0; i < zamowienia.size(); i++) {
            nazwa.addElement("Zamowienie nr. " + zamowienia.get(i).getId());

        }
        lista_zamowienia.setModel(nazwa);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AktualizujBUTT;
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JButton UsunZamBUTT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lista_szczegoly;
    private javax.swing.JList<String> lista_zamowienia;
    // End of variables declaration//GEN-END:variables
}
