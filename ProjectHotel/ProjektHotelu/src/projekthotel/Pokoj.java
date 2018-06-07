package projekthotel;

import java.io.Serializable;


public class Pokoj implements Serializable{

    public Pokoj(int id, String ilosc_pokoi, String metraz, int cena, String klasa, int pietro, String wyposazenie, String stan) {
        this.id = id;
        this.ilosc_pokoi = ilosc_pokoi;
        this.metraz = metraz;
        this.cena = cena;
        this.klasa = klasa;
        this.pietro = pietro;
        this.wyposazenie = wyposazenie;
        this.stan = stan;
    }
    
    int id;
    String ilosc_pokoi;
    String metraz;
    int cena;
    String klasa;
    int pietro;
    String wyposazenie;
    String stan;

    public Pokoj(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setIlosc_pokoi(String ilosc_pokoi) {
        this.ilosc_pokoi = ilosc_pokoi;
    }

    public void setMetraz(String metraz) {
        this.metraz = metraz;
    }
    
    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public void setPietro(int pietro) {
        this.pietro = pietro;
    }

    public void setWyposazenie(String wyposazenie) {
        this.wyposazenie = wyposazenie;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public int getId() {
        return id;
    }

    public String getIlosc_pokoi() {
        return ilosc_pokoi;
    }

    public String getMetraz() {
        return metraz;
    }

    public String getKlasa() {
        return klasa;
    }

    public int getPietro() {
        return pietro;
    }

    public String getWyposazenie() {
        return wyposazenie;
    }

    public String getStan() {
        return stan;
    }    
}
