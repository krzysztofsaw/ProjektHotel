package projekthotel;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Zlecenia implements Serializable {  

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public int getCena() {
        return cena;
    }

    public GregorianCalendar getData_rozp() {
        return data_rozp;
    }

    public int getId_gosc() {
        return id_gosc;
    }

    public String getId_pracownik() {
        return id_pracownik;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setData_rozp(GregorianCalendar data_rozp) {
        this.data_rozp = data_rozp;
    }

    public void setId_gosc(int id_gosc) {
        this.id_gosc = id_gosc;
    }

    public void setId_pracownik(String id_pracownik) {
        this.id_pracownik = id_pracownik;
    }

    public Zlecenia(int id, String nazwa, String typ, int cena, GregorianCalendar data_rozp, int czasTrwania,int id_gosc, String id_pracownik) {
        this.id = id;
        this.nazwa = nazwa;
        this.typ = typ;
        this.cena = cena;
        this.data_rozp = data_rozp;
        this.czasTrwania = czasTrwania;
        this.id_gosc = id_gosc;
        this.id_pracownik = id_pracownik;

    }

    public String getStringPoczatekOdwrocony() {
        String d;
        String m;
        String r;

        if (getDayPoczatek() < 10) {
            d = "0" + getDayPoczatek();
        } else {
            d = "" + getDayPoczatek();
        }

        if (getMonthPoczatek() < 10) {
            m = "0" + getMonthPoczatek();
        } else {
            m = "" + getMonthPoczatek();
        }

        if (getYearPoczatek() < 1000) {
            r = "0" + getYearPoczatek();
        } else {
            r = "" + getYearPoczatek();
        }

        return r + "-" + m + "-" + d;

    }

    
     public String getStringPoczatekRezerwacji() {
        String d;
        String m;
        String r;

        if (getDayPoczatek() < 10) {
            d = "0" + getDayPoczatek();
        } else {
            d = "" + getDayPoczatek();
        }

        if (getMonthPoczatek() < 10) {
            m = "0" + getMonthPoczatek();
        } else {
            m = "" + getMonthPoczatek();
        }

        if (getYearPoczatek() < 1000) {
            r = "0" + getYearPoczatek();
        } else {
            r = "" + getYearPoczatek();
        }

        return "to_date('" + d + "/" + m + "/" + r + "','dd/mm/yyyy')";

    }
    
    
    
    
    
    
    
    
    int getDayPoczatek() {
        return data_rozp.get(Calendar.DAY_OF_MONTH);
    }

    int getMonthPoczatek() {
        return data_rozp.get(Calendar.MONTH);
    }

    int getYearPoczatek() {
        return data_rozp.get(Calendar.YEAR);
    }

    int id;
    String nazwa;
    String typ;
    int cena;
    GregorianCalendar data_rozp;
    int id_gosc;
    String id_pracownik;
    int czasTrwania;


    public void setCzasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public int getCzasTrwania() {
        return czasTrwania;
    }

}
