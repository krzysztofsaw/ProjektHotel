package projekthotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Gosc extends javax.swing.JFrame {

    JFrame obiektJFrame;
    DefaultTableModel model_zlecenia;
    List<Zlecenia> listaZlecen = null;
    List<Potrawa> p = null;
    List<Potrawa> p1 = null;
    int zaplata = 0;
    int index;
    int index1;
    DefaultListModel nazwa = new DefaultListModel();
    DefaultListModel nazwa2 = new DefaultListModel();
    Zamowienie zamowienie;
    Rezerwacja sprawdzenie_rezerwacji;

    public ListSelectionListener zmiana = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            index = Lista_Potraw.getSelectedIndex();
        }
    };
    public ListSelectionListener zmiana1 = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            index1 = Lista_Wyb_Potraw.getSelectedIndex();
        }
    };

    public Gosc(Rezerwacja r) {
        initComponents();
        obiektJFrame = this;
        model_zlecenia = (DefaultTableModel) tabela_zlecenia.getModel();
        Lista_Potraw.addListSelectionListener(zmiana);
        Lista_Wyb_Potraw.addListSelectionListener(zmiana1);
        p1 = new ArrayList<>();

        sprawdzenie_rezerwacji = r;
        try {

            DownloadPotrawa rezerwacja = new DownloadPotrawa();
            ServerConnection.getInstance().getOutputStream().writeObject(rezerwacja);
            p = (List<Potrawa>) ServerConnection.getInstance().getInputStream().readObject();

        } catch (IOException | ClassNotFoundException ex) {
        }

        for (int i = 0; i < p.size(); i++) {
            nazwa.addElement(p.get(i).getNazwa());
        }

        Lista_Potraw.setModel(nazwa);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sprawdzBUTT = new javax.swing.JButton();
        lista_zlecenBUTT = new javax.swing.JButton();
        udogodnieniaBUTT = new javax.swing.JButton();
        sytuacjaBUTT = new javax.swing.JButton();
        wylogujBUTT = new javax.swing.JButton();
        witaj = new javax.swing.JLabel();
        Panel_Jedzenie = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Lista_Wyb_Potraw = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista_Potraw = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        złóżZamowienieBUTT = new javax.swing.JButton();
        Koszt_Pole = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DodPotraweBUTT = new javax.swing.JButton();
        UsuńPotraweBUTT = new javax.swing.JButton();
        panel_sprawdz = new javax.swing.JPanel();
        ID = new javax.swing.JLabel();
        pesel = new javax.swing.JLabel();
        data_rozp = new javax.swing.JLabel();
        data_zak = new javax.swing.JLabel();
        rachunek = new javax.swing.JLabel();
        id_wyswietl = new javax.swing.JTextField();
        pesel_wyswietl = new javax.swing.JTextField();
        data_rozp_wyswietl = new javax.swing.JTextField();
        data_zak_wyswietl = new javax.swing.JTextField();
        rachunek_wyswietl = new javax.swing.JTextField();
        panel_zlecenia = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_zlecenia = new javax.swing.JTable();
        panel_udogodnienia = new javax.swing.JPanel();
        atrakcjaBUTT = new javax.swing.JButton();
        uslugaBUTT = new javax.swing.JButton();
        jedzenieBUTT = new javax.swing.JButton();
        panel_sytuacja = new javax.swing.JPanel();
        pozarBUTT = new javax.swing.JButton();
        kradziezBUTT = new javax.swing.JButton();
        karetkaBUTT = new javax.swing.JButton();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 300));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel1.setLayout(null);

        sprawdzBUTT.setText("Sprawdz rezerwację");
        sprawdzBUTT.setName(""); // NOI18N
        sprawdzBUTT.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                sprawdzBUTTComponentHidden(evt);
            }
        });
        sprawdzBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sprawdzBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(sprawdzBUTT);
        sprawdzBUTT.setBounds(21, 60, 150, 40);

        lista_zlecenBUTT.setText("Lista zlecen usług");
        lista_zlecenBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista_zlecenBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(lista_zlecenBUTT);
        lista_zlecenBUTT.setBounds(20, 120, 150, 40);

        udogodnieniaBUTT.setText("Dostępne udogodnienia");
        udogodnieniaBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udogodnieniaBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(udogodnieniaBUTT);
        udogodnieniaBUTT.setBounds(20, 180, 150, 40);

        sytuacjaBUTT.setText("Zgłoś sytuację wyjątkową");
        sytuacjaBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sytuacjaBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(sytuacjaBUTT);
        sytuacjaBUTT.setBounds(20, 370, 170, 40);

        wylogujBUTT.setText("Wyloguj");
        wylogujBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wylogujBUTTActionPerformed(evt);
            }
        });
        jPanel1.add(wylogujBUTT);
        wylogujBUTT.setBounds(21, 420, 170, 40);

        witaj.setFont(new java.awt.Font("Cooper Std Black", 0, 24)); // NOI18N
        witaj.setForeground(new java.awt.Color(255, 255, 255));
        witaj.setText("Witaj Gosciu! :) ");
        jPanel1.add(witaj);
        witaj.setBounds(230, 10, 290, 40);

        Panel_Jedzenie.setVisible(false);
        Panel_Jedzenie.setOpaque(false);
        Panel_Jedzenie.setLayout(null);

        jScrollPane2.setViewportView(Lista_Wyb_Potraw);

        Panel_Jedzenie.add(jScrollPane2);
        jScrollPane2.setBounds(20, 220, 350, 150);

        jScrollPane1.setOpaque(false);
        jScrollPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseMoved(evt);
            }
        });

        Lista_Potraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lista_PotrawMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Lista_Potraw);

        Panel_Jedzenie.add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 450, 160);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista Wybranych Potraw");
        Panel_Jedzenie.add(jLabel1);
        jLabel1.setBounds(20, 200, 190, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista Potraw");
        Panel_Jedzenie.add(jLabel2);
        jLabel2.setBounds(20, 10, 200, 17);

        złóżZamowienieBUTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        złóżZamowienieBUTT.setText("Złóż Zamowienie");
        złóżZamowienieBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                złóżZamowienieBUTTActionPerformed(evt);
            }
        });
        Panel_Jedzenie.add(złóżZamowienieBUTT);
        złóżZamowienieBUTT.setBounds(340, 380, 150, 40);

        Koszt_Pole.setEditable(false);
        Koszt_Pole.setBackground(new java.awt.Color(153, 153, 255));
        Koszt_Pole.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Koszt_Pole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Koszt_PoleActionPerformed(evt);
            }
        });
        Panel_Jedzenie.add(Koszt_Pole);
        Koszt_Pole.setBounds(380, 330, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Koszt :");
        Panel_Jedzenie.add(jLabel3);
        jLabel3.setBounds(400, 310, 50, 14);

        DodPotraweBUTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DodPotraweBUTT.setText("Dodaj Potrawe");
        DodPotraweBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DodPotraweBUTTActionPerformed(evt);
            }
        });
        Panel_Jedzenie.add(DodPotraweBUTT);
        DodPotraweBUTT.setBounds(20, 380, 150, 40);

        UsuńPotraweBUTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UsuńPotraweBUTT.setText("Usuń Potrawe");
        UsuńPotraweBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuńPotraweBUTTActionPerformed(evt);
            }
        });
        Panel_Jedzenie.add(UsuńPotraweBUTT);
        UsuńPotraweBUTT.setBounds(180, 380, 150, 40);

        jPanel1.add(Panel_Jedzenie);
        Panel_Jedzenie.setBounds(190, 50, 490, 420);

        panel_sprawdz.setVisible(false);
        panel_sprawdz.setOpaque(false);
        panel_sprawdz.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                panel_sprawdzComponentHidden(evt);
            }
        });
        panel_sprawdz.setLayout(null);

        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setText("ID:");
        panel_sprawdz.add(ID);
        ID.setBounds(10, 20, 120, 14);

        pesel.setForeground(new java.awt.Color(255, 255, 255));
        pesel.setText("Pesel:");
        panel_sprawdz.add(pesel);
        pesel.setBounds(10, 60, 110, 14);

        data_rozp.setForeground(new java.awt.Color(255, 255, 255));
        data_rozp.setText("Data rozpoczęcia:");
        panel_sprawdz.add(data_rozp);
        data_rozp.setBounds(10, 100, 130, 14);

        data_zak.setForeground(new java.awt.Color(255, 255, 255));
        data_zak.setText("Data zakończenia:");
        panel_sprawdz.add(data_zak);
        data_zak.setBounds(10, 140, 140, 14);

        rachunek.setForeground(new java.awt.Color(255, 255, 255));
        rachunek.setText("Rachunek");
        panel_sprawdz.add(rachunek);
        rachunek.setBounds(10, 180, 120, 14);

        id_wyswietl.setEditable(false);
        id_wyswietl.setText("8484");
        id_wyswietl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_wyswietlActionPerformed(evt);
            }
        });
        panel_sprawdz.add(id_wyswietl);
        id_wyswietl.setBounds(160, 10, 90, 30);

        pesel_wyswietl.setEditable(false);
        pesel_wyswietl.setText("VIP");
        panel_sprawdz.add(pesel_wyswietl);
        pesel_wyswietl.setBounds(160, 50, 90, 30);

        data_rozp_wyswietl.setEditable(false);
        data_rozp_wyswietl.setText("13.06.2017");
        panel_sprawdz.add(data_rozp_wyswietl);
        data_rozp_wyswietl.setBounds(160, 90, 90, 30);

        data_zak_wyswietl.setEditable(false);
        data_zak_wyswietl.setText("16.06.2017");
        panel_sprawdz.add(data_zak_wyswietl);
        data_zak_wyswietl.setBounds(160, 130, 90, 30);

        rachunek_wyswietl.setEditable(false);
        rachunek_wyswietl.setText("270 zł");
        rachunek_wyswietl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rachunek_wyswietlActionPerformed(evt);
            }
        });
        panel_sprawdz.add(rachunek_wyswietl);
        rachunek_wyswietl.setBounds(160, 170, 90, 30);

        jPanel1.add(panel_sprawdz);
        panel_sprawdz.setBounds(200, 60, 250, 210);

        panel_zlecenia.setVisible(false);
        panel_zlecenia.setOpaque(false);

        tabela_zlecenia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numer zlecenia", "Typ", "Data", "Czas trwania", "Cena", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_zlecenia.setOpaque(false);
        jScrollPane4.setViewportView(tabela_zlecenia);
        if (tabela_zlecenia.getColumnModel().getColumnCount() > 0) {
            tabela_zlecenia.getColumnModel().getColumn(0).setResizable(false);
            tabela_zlecenia.getColumnModel().getColumn(1).setResizable(false);
            tabela_zlecenia.getColumnModel().getColumn(2).setResizable(false);
            tabela_zlecenia.getColumnModel().getColumn(3).setResizable(false);
            tabela_zlecenia.getColumnModel().getColumn(4).setResizable(false);
            tabela_zlecenia.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout panel_zleceniaLayout = new javax.swing.GroupLayout(panel_zlecenia);
        panel_zlecenia.setLayout(panel_zleceniaLayout);
        panel_zleceniaLayout.setHorizontalGroup(
            panel_zleceniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_zleceniaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_zleceniaLayout.setVerticalGroup(
            panel_zleceniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_zleceniaLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        jPanel1.add(panel_zlecenia);
        panel_zlecenia.setBounds(200, 60, 490, 210);

        panel_udogodnienia.setVisible(false);
        panel_udogodnienia.setOpaque(false);
        panel_udogodnienia.setLayout(null);

        atrakcjaBUTT.setText("Zamów atrakcję");
        atrakcjaBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrakcjaBUTTActionPerformed(evt);
            }
        });
        panel_udogodnienia.add(atrakcjaBUTT);
        atrakcjaBUTT.setBounds(32, 62, 150, 40);

        uslugaBUTT.setText("Zamów usługę");
        uslugaBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uslugaBUTTActionPerformed(evt);
            }
        });
        panel_udogodnienia.add(uslugaBUTT);
        uslugaBUTT.setBounds(32, 113, 150, 40);

        jedzenieBUTT.setText("Zamów jedzenie");
        jedzenieBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jedzenieBUTTActionPerformed(evt);
            }
        });
        panel_udogodnienia.add(jedzenieBUTT);
        jedzenieBUTT.setBounds(30, 10, 150, 40);

        jPanel1.add(panel_udogodnienia);
        panel_udogodnienia.setBounds(200, 60, 210, 170);

        panel_sytuacja.setVisible(false);
        panel_sytuacja.setOpaque(false);
        panel_sytuacja.setLayout(null);

        pozarBUTT.setText("Wezwij straż pożarną");
        pozarBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pozarBUTTActionPerformed(evt);
            }
        });
        panel_sytuacja.add(pozarBUTT);
        pozarBUTT.setBounds(24, 11, 150, 40);

        kradziezBUTT.setText("Wezwij policję");
        kradziezBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kradziezBUTTActionPerformed(evt);
            }
        });
        panel_sytuacja.add(kradziezBUTT);
        kradziezBUTT.setBounds(24, 62, 150, 40);

        karetkaBUTT.setText("Wezwij karetkę");
        karetkaBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karetkaBUTTActionPerformed(evt);
            }
        });
        panel_sytuacja.add(karetkaBUTT);
        karetkaBUTT.setBounds(24, 113, 150, 40);

        jPanel1.add(panel_sytuacja);
        panel_sytuacja.setBounds(200, 60, 190, 180);

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tlo.png"))); // NOI18N
        BACKGROUND.setText("Tabela informacje");
        jPanel1.add(BACKGROUND);
        BACKGROUND.setBounds(0, 0, 700, 500);

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

    private void jedzenieBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jedzenieBUTTActionPerformed
        Panel_Jedzenie.setVisible(true);
        panel_sprawdz.setVisible(false);
        panel_sytuacja.setVisible(false);
        panel_udogodnienia.setVisible(false);
    }//GEN-LAST:event_jedzenieBUTTActionPerformed

    private void kradziezBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kradziezBUTTActionPerformed
        JOptionPane.showMessageDialog(rootPane, "              Wezwano policję .\n Proszę nie opuszczać pokoju.", "Sytuacja wyjątkowa.", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_kradziezBUTTActionPerformed

    private void pozarBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pozarBUTTActionPerformed
        JOptionPane.showMessageDialog(rootPane, "          Wezwano straż pożarną.\n Proszę pośpiesznie opuścić budynek.", "Sytuacja wyjątkowa.", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_pozarBUTTActionPerformed

    private void panel_sprawdzComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel_sprawdzComponentHidden

    }//GEN-LAST:event_panel_sprawdzComponentHidden

    private void rachunek_wyswietlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rachunek_wyswietlActionPerformed

    }//GEN-LAST:event_rachunek_wyswietlActionPerformed

    private void id_wyswietlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_wyswietlActionPerformed

    }//GEN-LAST:event_id_wyswietlActionPerformed

    private void uslugaBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uslugaBUTTActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Usluga(sprawdzenie_rezerwacji, obiektJFrame).setVisible(true);
            }
        });
    }//GEN-LAST:event_uslugaBUTTActionPerformed

    private void złóżZamowienieBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_złóżZamowienieBUTTActionPerformed
        String szczegoly = "";

        if (p1.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nie wybrano ProduktÄ‚Ĺ‚w", "BÄąâ€šĂ„â€¦d", JOptionPane.ERROR_MESSAGE);

        } else {
            for (int i = 0; i < p1.size(); i++) {
                szczegoly += p1.get(i).getNazwa() + " Waga:" + p1.get(i).getRozmiar() + "\n";
            }

            zamowienie = new Zamowienie(zaplata, szczegoly);
            try {
                DownloadZamowienie bombel = new DownloadZamowienie(zamowienie);
                ServerConnection.getInstance().getOutputStream().writeObject(bombel);

            } catch (IOException ex) {
                Logger.getLogger(Gosc.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(rootPane, "Zamowienie Zostało Wysłane", "Zamowienie", JOptionPane.INFORMATION_MESSAGE);

            nazwa2.clear();
            p1.removeAll(p1);
            zaplata = 0;
            String koszty = zaplata + "zł";
            Koszt_Pole.setText(koszty);

        }
    }//GEN-LAST:event_złóżZamowienieBUTTActionPerformed

    private void DodPotraweBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DodPotraweBUTTActionPerformed

        p1.add(p.get(index));
        zaplata = 0;
        nazwa2.clear();
        for (int i = 0; i < p1.size(); i++) {
            nazwa2.addElement(p1.get(i).getNazwa());
            zaplata = zaplata + p1.get(i).getCena();
            String koszt = zaplata + "zł";
            Koszt_Pole.setText(koszt);
            //System.out.println(p1.get(i).getNazwa());

        }
        Lista_Wyb_Potraw.setModel(nazwa2);
    }//GEN-LAST:event_DodPotraweBUTTActionPerformed

    private void jScrollPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseMoved

    private void Lista_PotrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lista_PotrawMouseClicked

    }//GEN-LAST:event_Lista_PotrawMouseClicked

    private void wylogujBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wylogujBUTTActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowLogged().setVisible(true);
            }
        });
    }//GEN-LAST:event_wylogujBUTTActionPerformed

    private void sytuacjaBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sytuacjaBUTTActionPerformed
        panel_sytuacja.setVisible(true);
        panel_sprawdz.setVisible(false);
        Panel_Jedzenie.setVisible(false);
        panel_zlecenia.setVisible(false);
        panel_udogodnienia.setVisible(false);
    }//GEN-LAST:event_sytuacjaBUTTActionPerformed

    private void sprawdzBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sprawdzBUTTActionPerformed
        try {

            int id = sprawdzenie_rezerwacji.getId();
            String haslo = sprawdzenie_rezerwacji.getHaslo();
            DownloadRezerwacja rezerwacja = new DownloadRezerwacja("" + id, haslo);
            ServerConnection.getInstance().getOutputStream().writeObject(rezerwacja);
            Rezerwacja r = (Rezerwacja) ServerConnection.getInstance().getInputStream().readObject();

            id_wyswietl.setText(r.getId() + "");
            String pesel_konwert = r.getPesel() + "";
            pesel_wyswietl.setText(pesel_konwert);
            data_rozp_wyswietl.setText(r.getStringPoczatek());
            data_zak_wyswietl.setText(r.getStringKoniec());
            String rachunek_konwert = r.getRachunek() + " zł";
            rachunek_wyswietl.setText(rachunek_konwert);

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }

        panel_sprawdz.setVisible(true);
        panel_sytuacja.setVisible(false);
        Panel_Jedzenie.setVisible(false);
        panel_udogodnienia.setVisible(false);
        panel_zlecenia.setVisible(false);
    }//GEN-LAST:event_sprawdzBUTTActionPerformed

    private void sprawdzBUTTComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_sprawdzBUTTComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_sprawdzBUTTComponentHidden

    private void UsuńPotraweBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuńPotraweBUTTActionPerformed
        zaplata = zaplata - p1.get(index1).getCena();
        String koszt = zaplata + "zł";
        Koszt_Pole.setText(koszt);

        p1.remove(p1.get(index1));
        nazwa2.clear();
        for (int i = 0; i < p1.size(); i++) {
            nazwa2.addElement(p1.get(i).getNazwa());

        }

        if (p1.isEmpty()) {
            Koszt_Pole.setText("0zł");
            zaplata = 0;
        }
        Lista_Wyb_Potraw.setModel(nazwa2);
    }//GEN-LAST:event_UsuńPotraweBUTTActionPerformed

    private void Koszt_PoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Koszt_PoleActionPerformed

    }//GEN-LAST:event_Koszt_PoleActionPerformed

    private void karetkaBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karetkaBUTTActionPerformed
        JOptionPane.showMessageDialog(rootPane, "               Wezwano pogotowie.\n Proszę zająć się poszkodowanym.", "Sytuacja wyjątkowa.", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_karetkaBUTTActionPerformed

    private void lista_zlecenBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista_zlecenBUTTActionPerformed
        panel_zlecenia.setVisible(true);
        try {

            DownloadZlecenia zlecenia = new DownloadZlecenia();
            ServerConnection.getInstance().getOutputStream().writeObject(zlecenia);
            listaZlecen = (List<Zlecenia>) ServerConnection.getInstance().getInputStream().readObject();

        } catch (IOException | ClassNotFoundException ex) {
        }
        usunWszystko();
        wypisz();
        panel_udogodnienia.setVisible(false);
        panel_sprawdz.setVisible(false);
        panel_sytuacja.setVisible(false);
        Panel_Jedzenie.setVisible(false);

    }//GEN-LAST:event_lista_zlecenBUTTActionPerformed

    private void atrakcjaBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrakcjaBUTTActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Atrakcja(sprawdzenie_rezerwacji, obiektJFrame).setVisible(true);
            }
        });
    }//GEN-LAST:event_atrakcjaBUTTActionPerformed

    private void udogodnieniaBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udogodnieniaBUTTActionPerformed
        panel_udogodnienia.setVisible(true);
        panel_sprawdz.setVisible(false);
        panel_sytuacja.setVisible(false);
        Panel_Jedzenie.setVisible(false);
        panel_zlecenia.setVisible(false);
    }//GEN-LAST:event_udogodnieniaBUTTActionPerformed

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
            java.util.logging.Logger.getLogger(Gosc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gosc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gosc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gosc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JButton DodPotraweBUTT;
    private javax.swing.JLabel ID;
    private javax.swing.JTextField Koszt_Pole;
    private javax.swing.JList<String> Lista_Potraw;
    private javax.swing.JList<String> Lista_Wyb_Potraw;
    private javax.swing.JPanel Panel_Jedzenie;
    private javax.swing.JButton UsuńPotraweBUTT;
    private javax.swing.JButton atrakcjaBUTT;
    private javax.swing.JLabel data_rozp;
    private javax.swing.JTextField data_rozp_wyswietl;
    private javax.swing.JLabel data_zak;
    private javax.swing.JTextField data_zak_wyswietl;
    private javax.swing.JTextField id_wyswietl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jedzenieBUTT;
    private javax.swing.JButton karetkaBUTT;
    private javax.swing.JButton kradziezBUTT;
    private javax.swing.JButton lista_zlecenBUTT;
    private javax.swing.JPanel panel_sprawdz;
    private javax.swing.JPanel panel_sytuacja;
    private javax.swing.JPanel panel_udogodnienia;
    private javax.swing.JPanel panel_zlecenia;
    private javax.swing.JLabel pesel;
    private javax.swing.JTextField pesel_wyswietl;
    private javax.swing.JButton pozarBUTT;
    private javax.swing.JLabel rachunek;
    private javax.swing.JTextField rachunek_wyswietl;
    private javax.swing.JButton sprawdzBUTT;
    private javax.swing.JButton sytuacjaBUTT;
    private javax.swing.JTable tabela_zlecenia;
    private javax.swing.JButton udogodnieniaBUTT;
    private javax.swing.JButton uslugaBUTT;
    private javax.swing.JLabel witaj;
    private javax.swing.JButton wylogujBUTT;
    private javax.swing.JButton złóżZamowienieBUTT;
    // End of variables declaration//GEN-END:variables

    public void wypisz() {
        Object rowData[] = new Object[6];

        for (int i = 0; i < listaZlecen.size(); i++) {
            if (sprawdzenie_rezerwacji.getId() == listaZlecen.get(i).getId_gosc()) {

                rowData[0] = "Zlecenie nr. " + listaZlecen.get(i).getId();
                rowData[1] = listaZlecen.get(i).getTyp();
                rowData[2] = listaZlecen.get(i).getStringPoczatekOdwrocony();
                rowData[3] = listaZlecen.get(i).getCzasTrwania() + "h";
                rowData[4] = listaZlecen.get(i).getCena() + " zł";
                if (".".equals(listaZlecen.get(i).getId_pracownik())) {
                    rowData[5] = "Oczekiwanie";
                } else {
                    rowData[5] = "Gotowe";
                }

                model_zlecenia.addRow(rowData);
            }

        }
    }

    void usunWszystko() {
        int ilosc = model_zlecenia.getRowCount();
        for (int i = 0; i < ilosc; i++) {
            model_zlecenia.removeRow(0);
        }

    }

}
