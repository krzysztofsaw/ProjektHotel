package projekthotel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PokojRezerwacja implements Serializable {

    int idRezerwacjaPokoj;
    int idGosc;
    int idPokoj;
    GregorianCalendar poczatekRezerwacji;
    GregorianCalendar koniecRezerwacji;

    public PokojRezerwacja(int idRezerwacjaPokoj, int idGosc, int idPokoj, GregorianCalendar poczatekRezerwacji, GregorianCalendar koniecRezerwacji) {
        this.idRezerwacjaPokoj = idRezerwacjaPokoj;
        this.idGosc = idGosc;
        this.idPokoj = idPokoj;
        this.poczatekRezerwacji = poczatekRezerwacji;
        this.koniecRezerwacji = koniecRezerwacji;
    }

    public int getIdRezerwacjaPokoj() {
        return idRezerwacjaPokoj;
    }

    public int getIdGosc() {
        return idGosc;
    }

    public int getIdPokoj() {
        return idPokoj;
    }

    public GregorianCalendar getPoczatekRezerwacji() {
        return poczatekRezerwacji;
    }

    public GregorianCalendar getKoniecRezerwacji() {
        return koniecRezerwacji;
    }

    public void setIdRezerwacjaPokoj(int idRezerwacjaPokoj) {
        this.idRezerwacjaPokoj = idRezerwacjaPokoj;
    }

    public void setIdGosc(int idGosc) {
        this.idGosc = idGosc;
    }

    public void setIdPokoj(int idPokoj) {
        this.idPokoj = idPokoj;
    }

    public void setPoczatekRezerwacji(GregorianCalendar poczatekRezerwacji) {
        this.poczatekRezerwacji = poczatekRezerwacji;
    }

    public void setKoniecRezerwacji(GregorianCalendar koniecRezerwacji) {
        this.koniecRezerwacji = koniecRezerwacji;
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
