/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class wyborpokoju extends javax.swing.JFrame {

    int dzien_pocz = 0;
    int dzien_kon = 0;
    int miesiac_pocz = 0;
    int miesiac_kon = 0;
    int rok_pocz = 0;
    int rok_kon = 0;
    boolean a = false;
    boolean b = false;
    boolean c = false;
    boolean d = false;
    List<Pokoj> list = new ArrayList<>();
    List<Pokoj> lista1 = new ArrayList<>();
    DefaultListModel nazwa = new DefaultListModel();
    GregorianCalendar r1;
    GregorianCalendar r2;
    int index;
    public ListSelectionListener zmiana = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            index = Lista_pokoi.getSelectedIndex();
            if (nazwa.size() != 0) {
                metraz_pole.setText(lista1.get(index).getMetraz());
                stan_pole.setText(lista1.get(index).getStan());
                String pietro = lista1.get(index).getPietro() + "";
                pietro_pole.setText(pietro);
                String cena = lista1.get(index).getCena() + "";
                cena_pole.setText(cena);
                wyposazenie_pole.setText(lista1.get(index).getWyposazenie());
                panel_szczegoly.setVisible(true);
            }
        }
    };

    public wyborpokoju() {
        initComponents();
        Lista_pokoi.addListSelectionListener(zmiana);
        try {

            DownloadPokoj bombel = new DownloadPokoj();
            ServerConnection.getInstance().getOutputStream().writeObject(bombel);
            list = (List<Pokoj>) ServerConnection.getInstance().getInputStream().readObject();
        } catch (IOException | ClassNotFoundException ex) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        klasaAbutt = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        klasaCbutt = new javax.swing.JToggleButton();
        sprawdzBUTT = new javax.swing.JButton();
        klasaDbutt = new javax.swing.JToggleButton();
        klasaBbutt = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dzien_pocz_pole = new javax.swing.JTextField();
        mies_pocz_pole = new javax.swing.JTextField();
        rok_pocz_pole = new javax.swing.JTextField();
        dzien_kon_pole = new javax.swing.JTextField();
        mies_kon_pole = new javax.swing.JTextField();
        rok_kon_pole = new javax.swing.JTextField();
        panel_szczegoly = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        metraz = new javax.swing.JLabel();
        stan = new javax.swing.JLabel();
        pietro = new javax.swing.JLabel();
        cena = new javax.swing.JLabel();
        wyposazenie = new javax.swing.JLabel();
        metraz_pole = new javax.swing.JTextField();
        stan_pole = new javax.swing.JTextField();
        pietro_pole = new javax.swing.JTextField();
        cena_pole = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        wyposazenie_pole = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista_pokoi = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        dalejBUTTON = new javax.swing.JButton();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 300));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        klasaAbutt.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        klasaAbutt.setText("Klasa A");
        klasaAbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasaAbuttActionPerformed(evt);
            }
        });
        jPanel1.add(klasaAbutt);
        klasaAbutt.setBounds(30, 50, 130, 40);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Wybierz klase pokoju:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 10, 200, 25);

        klasaCbutt.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        klasaCbutt.setText("Klasa C");
        klasaCbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasaCbuttActionPerformed(evt);
            }
        });
        jPanel1.add(klasaCbutt);
        klasaCbutt.setBounds(30, 100, 130, 40);

        sprawdzBUTT.setText("Sprawdz pokoje");
        sprawdzBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sprawdzBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(sprawdzBUTT);
        sprawdzBUTT.setBounds(90, 150, 150, 30);

        klasaDbutt.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        klasaDbutt.setText("Klasa D");
        klasaDbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasaDbuttActionPerformed(evt);
            }
        });
        jPanel1.add(klasaDbutt);
        klasaDbutt.setBounds(170, 100, 130, 40);

        klasaBbutt.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        klasaBbutt.setText("Klasa B");
        klasaBbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasaBbuttActionPerformed(evt);
            }
        });
        jPanel1.add(klasaBbutt);
        klasaBbutt.setBounds(170, 50, 130, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 20, 350, 190);

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("data_zakonczenia");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(80, 100, 140, 17);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("dzien");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(50, 120, 36, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("miesiac");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(120, 120, 49, 17);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("rok:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(220, 120, 28, 17);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Wybierz termin  rezerwacji :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 0, 250, 30);

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

        dzien_kon_pole.setText("0");
        jPanel2.add(dzien_kon_pole);
        dzien_kon_pole.setBounds(30, 140, 60, 25);

        mies_kon_pole.setText("0");
        jPanel2.add(mies_kon_pole);
        mies_kon_pole.setBounds(120, 140, 60, 25);

        rok_kon_pole.setText("0");
        jPanel2.add(rok_kon_pole);
        rok_kon_pole.setBounds(210, 140, 60, 25);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(380, 30, 290, 180);

        panel_szczegoly.setVisible(false);
        panel_szczegoly.setOpaque(false);
        panel_szczegoly.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 255, 255));
        jLabel24.setText("Szczegóły :");
        panel_szczegoly.add(jLabel24);
        jLabel24.setBounds(0, 0, 210, 40);

        metraz.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        metraz.setForeground(new java.awt.Color(255, 255, 255));
        metraz.setText("Metraz :");
        panel_szczegoly.add(metraz);
        metraz.setBounds(0, 40, 90, 20);

        stan.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        stan.setForeground(new java.awt.Color(255, 255, 255));
        stan.setText("Stan: ");
        panel_szczegoly.add(stan);
        stan.setBounds(0, 70, 60, 20);

        pietro.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        pietro.setForeground(new java.awt.Color(255, 255, 255));
        pietro.setText("Pietro :");
        panel_szczegoly.add(pietro);
        pietro.setBounds(0, 100, 64, 20);

        cena.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        cena.setForeground(new java.awt.Color(255, 255, 255));
        cena.setText("Cena: ");
        panel_szczegoly.add(cena);
        cena.setBounds(0, 130, 70, 25);

        wyposazenie.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        wyposazenie.setForeground(new java.awt.Color(255, 255, 255));
        wyposazenie.setText("Wyposazenie :");
        panel_szczegoly.add(wyposazenie);
        wyposazenie.setBounds(0, 160, 140, 20);

        metraz_pole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metraz_poleActionPerformed(evt);
            }
        });
        panel_szczegoly.add(metraz_pole);
        metraz_pole.setBounds(140, 40, 100, 25);
        panel_szczegoly.add(stan_pole);
        stan_pole.setBounds(140, 70, 100, 25);
        panel_szczegoly.add(pietro_pole);
        pietro_pole.setBounds(140, 100, 100, 25);

        cena_pole.setBackground(new java.awt.Color(153, 153, 0));
        cena_pole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cena_poleActionPerformed(evt);
            }
        });
        panel_szczegoly.add(cena_pole);
        cena_pole.setBounds(140, 130, 100, 25);

        wyposazenie_pole.setLineWrap(true);
        wyposazenie_pole.setColumns(20);
        wyposazenie_pole.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        wyposazenie_pole.setRows(5);
        jScrollPane2.setViewportView(wyposazenie_pole);

        panel_szczegoly.add(jScrollPane2);
        jScrollPane2.setBounds(140, 160, 220, 70);

        getContentPane().add(panel_szczegoly);
        panel_szczegoly.setBounds(30, 230, 370, 260);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jScrollPane1.setViewportView(Lista_pokoi);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 240, 90);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  Lista Dostepnych pokoi :");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(10, 10, 240, 25);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(400, 210, 280, 160);

        dalejBUTTON.setText("Dalej");
        dalejBUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dalejBUTTONActionPerformed(evt);
            }
        });
        getContentPane().add(dalejBUTTON);
        dalejBUTTON.setBounds(520, 420, 150, 40);

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tlo.png"))); // NOI18N
        BACKGROUND.setText("jLabel25");
        getContentPane().add(BACKGROUND);
        BACKGROUND.setBounds(0, 0, 700, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void klasaAbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasaAbuttActionPerformed
        a = klasaAbutt.isSelected();
    }//GEN-LAST:event_klasaAbuttActionPerformed

    private void klasaBbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasaBbuttActionPerformed
        b = klasaBbutt.isSelected();
    }//GEN-LAST:event_klasaBbuttActionPerformed

    private void klasaCbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasaCbuttActionPerformed
        c = klasaCbutt.isSelected();
    }//GEN-LAST:event_klasaCbuttActionPerformed

    private void klasaDbuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasaDbuttActionPerformed
        d = klasaDbutt.isSelected();
    }//GEN-LAST:event_klasaDbuttActionPerformed

    private void sprawdzBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sprawdzBUTTActionPerformed

        try {
            dzien_pocz = Integer.parseInt(dzien_pocz_pole.getText());
            miesiac_pocz = Integer.parseInt(mies_pocz_pole.getText());
            rok_pocz = Integer.parseInt(rok_pocz_pole.getText());
            dzien_kon = Integer.parseInt(dzien_kon_pole.getText());
            miesiac_kon = Integer.parseInt(mies_kon_pole.getText());
            rok_kon = Integer.parseInt(rok_kon_pole.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "           Błędne dane. \nDaty muszą być liczbami! ", "Błędne dane", JOptionPane.ERROR_MESSAGE);
        }

        r1 = new GregorianCalendar(rok_pocz, miesiac_pocz, dzien_pocz);
        r2 = new GregorianCalendar(rok_kon, miesiac_kon, dzien_kon);

        if (sprawdz_pola()) {
            try {
                czyPokojJestWolnydlaDaty1 bombel = new czyPokojJestWolnydlaDaty1(r1, r2);
                ServerConnection.getInstance().getOutputStream().writeObject(bombel);
                lista1 = (List<Pokoj>) ServerConnection.getInstance().getInputStream().readObject();
            } catch (IOException ex) {
                Logger.getLogger(wyborpokoju.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(wyborpokoju.class.getName()).log(Level.SEVERE, null, ex);
            }

            nazwa.clear();
            for (int i = 0; i < lista1.size(); i++) {
                if (a) {
                    if ("A".equals(lista1.get(i).getKlasa())) {
                        nazwa.addElement("Pokoj nr. " + lista1.get(i).getId());
                    }
                }
                if (b) {
                    if ("B".equals(lista1.get(i).getKlasa())) {
                        nazwa.addElement("Pokoj nr. " + lista1.get(i).getId());
                    }
                }
                if (c) {
                    if ("C".equals(lista1.get(i).getKlasa())) {
                        nazwa.addElement("Pokoj nr. " + lista1.get(i).getId());
                    }
                }
                if (d) {
                    if ("D".equals(lista1.get(i).getKlasa())) {
                        nazwa.addElement("Pokoj nr. " + lista1.get(i).getId());
                    }
                }

                Lista_pokoi.setModel(nazwa);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "                        Błędne dane. \nWpisz poprawne daty oraz wybierz klasę pokoju. ", "Błędne dane", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sprawdzBUTTActionPerformed

    private void metraz_poleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metraz_poleActionPerformed

    }//GEN-LAST:event_metraz_poleActionPerformed

    private void dalejBUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dalejBUTTONActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewRezewation(lista1.get(index), lista1.get(index).getCena(), r1, r2).setVisible(true);
            }
        });
    }//GEN-LAST:event_dalejBUTTONActionPerformed

    private void dzien_pocz_poleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dzien_pocz_poleActionPerformed

    }//GEN-LAST:event_dzien_pocz_poleActionPerformed

    private void cena_poleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cena_poleActionPerformed

    }//GEN-LAST:event_cena_poleActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(wyborpokoju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wyborpokoju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wyborpokoju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wyborpokoju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wyborpokoju().setVisible(true);
            }
        });
    }

    public boolean sprawdz_pola() {
        if (dzien_pocz <= 0 || miesiac_pocz <= 0 || rok_pocz <= 0 || dzien_kon <= 0 || miesiac_kon <= 0 || rok_kon <= 0) {
            return false;
        } else {
            if (a || b || c || d) {
                return true;
            } else {
                return false;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JList<String> Lista_pokoi;
    private javax.swing.JLabel cena;
    private javax.swing.JTextField cena_pole;
    private javax.swing.JButton dalejBUTTON;
    private javax.swing.JTextField dzien_kon_pole;
    private javax.swing.JTextField dzien_pocz_pole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton klasaAbutt;
    private javax.swing.JToggleButton klasaBbutt;
    private javax.swing.JToggleButton klasaCbutt;
    private javax.swing.JToggleButton klasaDbutt;
    private javax.swing.JLabel metraz;
    private javax.swing.JTextField metraz_pole;
    private javax.swing.JTextField mies_kon_pole;
    private javax.swing.JTextField mies_pocz_pole;
    private javax.swing.JPanel panel_szczegoly;
    private javax.swing.JLabel pietro;
    private javax.swing.JTextField pietro_pole;
    private javax.swing.JTextField rok_kon_pole;
    private javax.swing.JTextField rok_pocz_pole;
    private javax.swing.JButton sprawdzBUTT;
    private javax.swing.JLabel stan;
    private javax.swing.JTextField stan_pole;
    private javax.swing.JLabel wyposazenie;
    private javax.swing.JTextArea wyposazenie_pole;
    // End of variables declaration//GEN-END:variables
}
