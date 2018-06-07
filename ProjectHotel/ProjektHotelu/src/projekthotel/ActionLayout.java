package projekthotel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ActionLayout implements ActionMake {

    public ActionLayout(Action aService, ServerThread thread) {
        aService.acceptAction(this, thread);
    }

    @Override
    public void Action(DownloadRezerwacja aService, ServerThread thread) {

        try {

            Rezerwacja dane = Server.baza.pobierzDane(aService.getLogin(), aService.getPassword());

            thread.getOutputStream().writeObject(dane);
            ////
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void Action(NewRezerwationOperation aService, ServerThread thread) {
    //   try {
    //       thread.getOutputStream().writeObject(aService.getRezerwacja());
    ////
    //   } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //  }
    public void Action(DownloadPotrawa aService, ServerThread thread) {

        try {
            List<Potrawa> t = Server.baza.pobierzPotrawe();

            thread.getOutputStream().writeObject(t);
            ////
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Action(DownloadPokoj aService, ServerThread thread) {

        try {
            List<Pokoj> p = Server.baza.pobierzPokoj();

            thread.getOutputStream().writeObject(p);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Action(DownloadPracownik aService, ServerThread thread) {
        try {
            // System.out.println("zarzadca"+aService.getLogin());
            //  System.out.println("zarzadca"+aService.getPassword());
            Pracownik dane = Server.baza.pobierzDanePracownik(aService.getLogin(), aService.getPassword());

            thread.getOutputStream().writeObject(dane);
            ////
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Action(DownloadRezewationAndWorker aService, ServerThread thread) {
        try {
            Object dane = Server.baza.pobierzDane(aService.getLogin(), aService.getPassword());
            if (dane == null) {
                dane = Server.baza.pobierzDanePracownik(aService.getLogin(), aService.getPassword());
            }

            thread.getOutputStream().writeObject(dane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Action(czyPokojJestWolnydlaDaty1 aService, ServerThread thread) {
        try {

            List<Pokoj> t = Server.baza.czyPokojJestWolnydlaDaty1(aService.getR1(), aService.getR2());

            thread.getOutputStream().writeObject(t);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Action(DownloadWszystkoPobyty aService, ServerThread thread) {

        try {
            List<Rezerwacja> listaRezerwacji = null;
            List<PokojRezerwacja> listaPokoiRezerwacji = null;
            
            Pracownik zabezpieczenie = null;
            zabezpieczenie = Server.baza.pobierzDanePracownik(aService.getLogin(), aService.getPassword());
            if (zabezpieczenie != null) {
                listaRezerwacji = Server.baza.pobierzListeRezerwacji();
                listaPokoiRezerwacji = Server.baza.pobierzListePokojRezerwacje();
               
            }

            thread.getOutputStream().writeObject(listaRezerwacji);
            thread.getOutputStream().writeObject(listaPokoiRezerwacji);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Action(Pobyt aService, ServerThread thread) {
        try {
            int stan = -1;
            int id = -1;
            Rezerwacja rez = aService.getRezerwacja();
            Pokoj pok = aService.getPokoj();

            id = Server.baza.dodajRezerwacje(rez);

            if (id != -1) {
                rez.setId(id);
                stan = Server.baza.przypiszPokojDoRezerwacji(rez, pok);
                if (stan == -2) {
                    thread.getOutputStream().writeObject(id);
                    return;
                } else {
                    thread.getOutputStream().writeObject(stan);
                }
            }

            thread.getOutputStream().writeObject(id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Action(WpiszZlecenie aService, ServerThread thread) {
        Zlecenia zlecenie=aService.getZlecenie();
        
        Server.baza.DodajJednoZlecenie(zlecenie);

    }
    
    public void Action(DownloadZamowienie aService, ServerThread thread) {
        Server.baza.dodajZamowienie(aService.getZamowienie());
    }

    @Override
    public void Action(OdwzorujListy aService, ServerThread thread) {
        int stan = Server.baza.odwzorujListyWBazie(aService.getPokojrezerwacja(), aService.getRezerwacja());
        System.out.println("(wnetrze)zawartosc test:"+aService.getRezerwacja());
        try {
            thread.getOutputStream().writeObject(stan);
            
        } catch (IOException ex) {
            
        }
    }
   
    @Override
    public void Action(DownloadZlecenia aService, ServerThread thread) {

        try {
            List<Zlecenia> z = Server.baza.pobierzZlecenia();

            thread.getOutputStream().writeObject(z);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void Action(OdwzorujZlecenie aService, ServerThread thread) {
         int stan = Server.baza.odwzorujListeZlecenie(aService.getListaZlecen());
                     
         
        try {
            thread.getOutputStream().writeObject(stan);
            
        } catch (IOException ex) {
            
        }
        
        
    }
    
 
    public void Action(OtrzymajZamowienia aService, ServerThread thread) {

        try {

            List<Zamowienie> t = Server.baza.pobierzZamowienie();
            thread.getOutputStream().writeObject(t);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    public void Action(UsunZamowienie aService, ServerThread thread) {
        Server.baza.UsunZamowienie(aService.getZamowienie());
    }

    
    
}
