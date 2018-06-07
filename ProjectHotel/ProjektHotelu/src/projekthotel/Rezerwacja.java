/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author użytkownik
 */
public class Rezerwacja implements Serializable {

    

    public String toString() {
        return "Rezerwacja{" + "id=" + id + ", haslo=" + haslo + ", imie=" + imie + ", nazwisko=" + nazwisko + ", pesel=" + pesel + ", poczatekRezerwacji=" + getStringPoczatekRezerwacji() + ", koniecRezerwacji=" + getStringKoniecRezerwacji() + ", rachunek=" + rachunek + '}';
    }

    
    int id;

   
    
    String haslo;
    String imie;
    String nazwisko;
    String pesel;
    GregorianCalendar poczatekRezerwacji;
    GregorianCalendar koniecRezerwacji;
    int rachunek;

    public Rezerwacja(int id, GregorianCalendar poczatekRezerwacji, GregorianCalendar koniecRezerwacji) {
        this.id = id;
        this.poczatekRezerwacji = poczatekRezerwacji;
        this.koniecRezerwacji = koniecRezerwacji;
    }

    public GregorianCalendar getPoczatekRezerwacji() {
        return poczatekRezerwacji;
    }

    public GregorianCalendar getKoniecRezerwacji() {
        return koniecRezerwacji;
    }

    public int getRachunek() {
        return rachunek;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPoczatekRezerwacji(GregorianCalendar poczatekRezerwacji) {
        this.poczatekRezerwacji = poczatekRezerwacji;
    }

    public void setKoniecRezerwacji(GregorianCalendar koniecRezerwacji) {
        this.koniecRezerwacji = koniecRezerwacji;
    }

    public void setRachunek(int rachunek) {
        this.rachunek = rachunek;
    }

 public int getRachunek(int rachunek) {
        return rachunek;
    }


    public int getId() {
        return id;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
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
    
    public String getStringPoczatek() {
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

        return d+"-"+m+"-"+r;

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

        return r+"-"+m+"-"+d;

    }
    
    
    
    
    public String getStringKoniecRezerwacji() {

        String d;
        String m;
        String r;

        if (getDayKoniec() < 10) {
            d = "0" + getDayKoniec();
        } else {
            d = "" + getDayKoniec();
        }

        if (getMonthKoniec() < 10) {
            m = "0" + getMonthKoniec();
        } else {
            m = "" + getMonthKoniec();
        }

        if (getYearKoniec() < 1000) {
            r = "0" + getYearKoniec();
        } else {
            r = "" + getYearKoniec();
        }

        return "to_date('" + d + "/" + m + "/" + r + "','dd/mm/yyyy')";
    }
    
    public String getStringKoniec() {

        String d;
        String m;
        String r;

        if (getDayKoniec() < 10) {
            d = "0" + getDayKoniec();
        } else {
            d = "" + getDayKoniec();
        }

        if (getMonthKoniec() < 10) {
            m = "0" + getMonthKoniec();
        } else {
            m = "" + getMonthKoniec();
        }

        if (getYearKoniec() < 1000) {
            r = "0" + getYearKoniec();
        } else {
            r = "" + getYearKoniec();
        }

        return d+"-"+m+"-"+r;
    }

    
    public String getStringKoniecOdwrocony() {

        String d;
        String m;
        String r;

        if (getDayKoniec() < 10) {
            d = "0" + getDayKoniec();
        } else {
            d = "" + getDayKoniec();
        }

        if (getMonthKoniec() < 10) {
            m = "0" + getMonthKoniec();
        } else {
            m = "" + getMonthKoniec();
        }

        if (getYearKoniec() < 1000) {
            r = "0" + getYearKoniec();
        } else {
            r = "" + getYearKoniec();
        }

        return r+"-"+m+"-"+d;
    }
    
 
    public Rezerwacja(int id, String haslo, String imie, String nazwisko, String pesel, GregorianCalendar poczatekRezerwacji, GregorianCalendar koniecRezerwacji, int rachunek) {
        this.id = id;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.poczatekRezerwacji = poczatekRezerwacji;
        this.koniecRezerwacji = koniecRezerwacji;
        this.rachunek = rachunek;
    }

    int getDayPoczatek() {
        return poczatekRezerwacji.get(Calendar.DAY_OF_MONTH);
    }

    int getMonthPoczatek() {
        return poczatekRezerwacji.get(Calendar.MONTH);
    }

    int getYearPoczatek() {
        return poczatekRezerwacji.get(Calendar.YEAR);
    }
    
    
    
    
    int getDayKoniec() {
        return koniecRezerwacji.get(Calendar.DAY_OF_MONTH);
    }

    int getMonthKoniec() {
        return koniecRezerwacji.get(Calendar.MONTH);
    }

    int getYearKoniec() {
        return koniecRezerwacji.get(Calendar.YEAR);
    }
    

}
