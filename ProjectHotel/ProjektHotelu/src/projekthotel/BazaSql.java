package projekthotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uzytkownik
 */
public class BazaSql {

    private final static String USERNAME = "bd2";
    private final static String PASSWORD = "pingwin1";
    private static Connection aConnection;
    private static Statement aStatement;
    private static Pracownik zalogowany;

    BazaSql() {
        StartConnectBase();
    }

    void startowesql() {
        GregorianCalendar r1 = new GregorianCalendar(2018, 5, 21);
        GregorianCalendar r2 = new GregorianCalendar(2018, 4, 15);
        GregorianCalendar r3 = new GregorianCalendar(2018, 2, 19);
        GregorianCalendar r4 = new GregorianCalendar(2018, 11, 22);
        GregorianCalendar r5 = new GregorianCalendar(2018, 9, 26);
        GregorianCalendar r6 = new GregorianCalendar(2018, 3, 30);

        Rezerwacja testowaOsoba1 = new Rezerwacja(0, "o1123", "Przemek", "Skrzyniarz", "96150101037", r3, r2, 500);
        Rezerwacja testowaOsoba2 = new Rezerwacja(1, "o2123", "Piotr", "Skowron", "93051510355", r6, r5, 600);
        Rezerwacja testowaOsoba3 = new Rezerwacja(2, "o3123", "Krzysztof", "Sawicki", "96051510355", r3, r4, 800);
        Rezerwacja testowaOsoba4 = new Rezerwacja(3, "o4123", "Barrek", "Sobierasjki", "98051510355", r2, r1, 900);
        dodajRezerwacje(testowaOsoba1);
        dodajRezerwacje(testowaOsoba2);
        dodajRezerwacje(testowaOsoba3);
        dodajRezerwacje(testowaOsoba4);

    }

    static void StartConnectBase() {
        try {
            //laczenie z baza
            aConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", USERNAME, PASSWORD);
            aStatement = aConnection.createStatement();
        } catch (SQLException ex) {

            System.out.println("Blad polaczenia z baza!!!");
            System.out.println("BLAD SQL: " + ex.getMessage());
        }
    }

    static void test() {
        String polecenie = "SELECT * from Client";
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);

            wynik.next();

            System.out.print(wynik.getInt(1) + " ");
            System.out.print(wynik.getString(2) + " ");
            System.out.print(wynik.getString(3) + " ");
            System.out.println(wynik.getInt(4) + " ");

        } catch (SQLException ex) {
            System.out.println();
            System.out.println("BLAD SQL: " + ex.getMessage());
        }
    }

    public Rezerwacja pobierzDane(String login, String haslo) {
        Rezerwacja wynikowa = null;
        String polecenie = "SELECT * from Rezerwacja Where Rezerwacja.id= '" + login + "' AND Rezerwacja.haslo='" + haslo + "'";
        String typ = null;
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            if (wynik.isFirst()) {
                GregorianCalendar d1 = new GregorianCalendar();
                GregorianCalendar d2 = new GregorianCalendar();

                LocalDate ld1 = wynik.getDate(6).toLocalDate();
                LocalDate ld2 = wynik.getDate(7).toLocalDate();

                d1.set(ld1.getYear(), ld1.getMonthValue(), ld1.getDayOfMonth());
                d2.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());

                wynikowa = new Rezerwacja(wynik.getInt(1), wynik.getString(2), wynik.getString(3), wynik.getString(4), wynik.getString(5), d1, d2, wynik.getInt(8));
            } else {

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return wynikowa;
    }

    public int dodajRezerwacje(Rezerwacja nowa) {
        int nr = 0;
        try {
            System.out.println(nowa.toString());

            nr = kolejnyNrRezerwacji();
            String wzor2 = "INSERT INTO Rezerwacja VALUES ('" + nr + "','" + nowa.getHaslo() + "','" + nowa.getImie() + "','" + nowa.getNazwisko() + "','" + nowa.getPesel() + "'," + nowa.getStringPoczatekRezerwacji() + "," + nowa.getStringKoniecRezerwacji() + ",'" + nowa.getRachunek() + "')";
            ResultSet wynik = aStatement.executeQuery(wzor2);
        } catch (SQLException ex) {
            System.err.println("blad sql: " + ex.getMessage());
            System.err.println("blad sql: " + ex.getErrorCode());
            return -1;
        }
        return nr;
    }

    public void dodajPokoj(Pokoj pokoj) {

        try {
            String polecenie = "INSERT INTO Pokoj VALUES ('" + pokoj.getId() + "','" + pokoj.getIlosc_pokoi() + "','" + pokoj.getMetraz() + "','" + pokoj.getCena() + "','" + pokoj.getKlasa() + "','" + pokoj.getPietro() + "','" + pokoj.getWyposazenie() + "','" + pokoj.getStan() + "')";

            ResultSet wynik = aStatement.executeQuery(polecenie);

        } catch (SQLException ex) {
            System.out.println("blad sql: " + ex.getMessage());
            System.out.println("blad sql: " + ex.getErrorCode());
        }

    }

    public int przypiszPokojDoRezerwacji(Rezerwacja nowa, Pokoj pokoj) {

        System.out.println("pobrane id: " + nowa.getId());

        if (czyIstniejePokoj(pokoj.getId()) == false) {
            return -2;
        }

        if (czyPokojJestWolnydlaDaty(pokoj, nowa.getPoczatekRezerwacji(), nowa.getKoniecRezerwacji()) == false) {
            return -2;
        }
        int nr = kolejnyNrRezerwacjiPokoju();
        try {

            String polecenie = "INSERT INTO RezerwacjaPokoi VALUES ('" + nr + "','" + nowa.getId() + "','" + pokoj.getId() + "'," + nowa.getStringPoczatekRezerwacji() + "," + nowa.getStringKoniecRezerwacji() + ")";
            ResultSet wynik = aStatement.executeQuery(polecenie);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public int DodajPokojRezerwacjiJezeliToMozliwe(PokojRezerwacja pr) {
        //System.out.println("pobrane id: " + pr.getId());

        if (czyIstniejePokoj(pr.getIdPokoj()) == false) {
            return -2;
        }

        if (czyPokojJestWolnydlaDaty(pr.getIdPokoj(), pr.getPoczatekRezerwacji(), pr.getKoniecRezerwacji()) == false) {
            System.out.println("blok ten wykonany");
            return -2;
        }
        int nr = kolejnyNrRezerwacjiPokoju();
        try {

            String polecenie = "INSERT INTO RezerwacjaPokoi VALUES ('" + nr + "','" + pr.getIdGosc() + "','" + pr.getIdPokoj() + "'," + pr.getStringPoczatekRezerwacji() + "," + pr.getStringKoniecRezerwacji() + ")";
            ResultSet wynik = aStatement.executeQuery(polecenie);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public boolean CzyIstniejePokojoId(int id) {

        String polecenie = "SELECT id  from Pokoj WHERE id='" + id + "'";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean czyIstniejeRezerwacjaoId(String id) {
        String polecenie = "SELECT id  from Rezerwacja WHERE id='" + id + "'";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean czyIstniejeRezerwacjPokojuoId(String id) {
        String polecenie = "SELECT id_rezerwacjaPokoj from RezerwacjaPokoi WHERE id_rezerwacjaPokoj='" + id + "'";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    public boolean czyIstniejeAkokolwiekRezerwacjaPokoju() {
        String polecenie = "SELECT id_rezerwacjaPokoj from RezerwacjaPokoi";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean czyIstniejeAkokolwiekRezerwacja() {
        String polecenie = "SELECT id from Rezerwacja";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean czyIstniejeAkokolwiekZlecenie() {
        String polecenie = "SELECT id from Zlecenie";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean czyIstniejePokoj(int id) {
        String polecenie = "SELECT * from Pokoj1 WHERE id=" + id;
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            System.out.println(wynik.isFirst());
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean czyPokojJestWolnydlaDaty(Pokoj pok, GregorianCalendar start, GregorianCalendar koniec) {

        String polecenie = "SELECT * from RezerwacjaPokoi where id_pokoju='" + pok.getId() + "'";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            GregorianCalendar start_rp = new GregorianCalendar();
            GregorianCalendar koniec_rp = new GregorianCalendar();

            while (wynik.next()) {
                LocalDate ld1 = wynik.getDate(4).toLocalDate();
                LocalDate ld2 = wynik.getDate(5).toLocalDate();

                start_rp.set(ld1.getYear(), ld1.getMonthValue(), ld1.getDayOfMonth());
                koniec_rp.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());

                if (testGregorianCalendar(start, koniec_rp) == 1) {

                } else if (testGregorianCalendar(koniec, start_rp) == -1) {

                } else {
                    return false;
                }
 
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean czyPokojJestWolnydlaDaty(int pok, GregorianCalendar start, GregorianCalendar koniec) {

        String polecenie = "SELECT * from RezerwacjaPokoi where id_pokoju='" + pok + "'";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            GregorianCalendar start_rp = new GregorianCalendar();
            GregorianCalendar koniec_rp = new GregorianCalendar();

            while (wynik.next()) {
                LocalDate ld1 = wynik.getDate(4).toLocalDate();
                LocalDate ld2 = wynik.getDate(5).toLocalDate();

                start_rp.set(ld1.getYear(), ld1.getMonthValue(), ld1.getDayOfMonth());
                koniec_rp.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());

                if (testGregorianCalendar(start, koniec_rp) == 1) {

                } else if (testGregorianCalendar(koniec, start_rp) == -1) {

                } else {
                    return false;
                }

            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<Potrawa> pobierzPotrawe() {
        List<Potrawa> lista = new ArrayList<Potrawa>();
        Potrawa wynikowa = null;
        String polecenie = "SELECT * from Potrawa ";
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);

            while (wynik.next()) {
                lista.add(new Potrawa(wynik.getString(1), wynik.getInt(2), wynik.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (List<Potrawa>) lista;

    }

    public List<Rezerwacja> pobierzListeRezerwacji() {
        List<Rezerwacja> lista = new ArrayList<Rezerwacja>();
        Potrawa wynikowa = null;
        String polecenie = "SELECT * from Rezerwacja ";
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);

            while (wynik.next()) {
                GregorianCalendar start_rp = new GregorianCalendar();
                GregorianCalendar koniec_rp = new GregorianCalendar();

                LocalDate ld1 = wynik.getDate(6).toLocalDate();
                LocalDate ld2 = wynik.getDate(7).toLocalDate();

                start_rp.set(ld1.getYear(), ld1.getMonthValue(), ld1.getDayOfMonth());
                koniec_rp.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());
                lista.add(new Rezerwacja(wynik.getInt(1), wynik.getString(2), wynik.getString(3), wynik.getString(4), wynik.getString(5), start_rp, koniec_rp, wynik.getInt(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (List<Rezerwacja>) lista;

    }

    void showDate(GregorianCalendar x, String nazwa) {
        System.out.println(nazwa + " " + getDay(x) + " " + getMonth(x) + " " + getYear(x));
    }

    int getDay(GregorianCalendar d) {
        return d.get(Calendar.DAY_OF_MONTH);
    }

    int getMonth(GregorianCalendar d) {
        return d.get(Calendar.MONTH);
    }

    int getYear(GregorianCalendar d) {
        return d.get(Calendar.YEAR);
    }

    public int testGregorianCalendar(GregorianCalendar x1, GregorianCalendar x2) {
        if (getYear(x1) > getYear(x2)) {
            return 1;
        } else if (getYear(x1) < getYear(x2)) {
            return -1;
        } else if (getMonth(x1) > getMonth(x2)) {
            return 1;
        } else if (getMonth(x1) < getMonth(x2)) {
            return -1;
        } else if (getDay(x1) > getDay(x2)) {
            return 1;
        } else if (getDay(x1) < getDay(x2)) {
            return -1;
        } else {
            return 0;
        }


    }

    public int kolejnyNrRezerwacjiPokoju() {
        int nr = -1;
        try {

            if (!czyIstniejeAkokolwiekRezerwacjaPokoju()) {
                return 0;
            }
            String polecenie = "SELECT max(id_rezerwacjaPokoj) from RezerwacjaPokoi";
            ResultSet wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            nr = wynik.getInt(1);
            nr = nr + 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nr;
    }

    public int kolejnyNrRezerwacji() {
        int nr = -1;
        try {

            if (!czyIstniejeAkokolwiekRezerwacja()) {
                return 0;
            }
            String polecenie = "SELECT max(id) from Rezerwacja";
            ResultSet wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            nr = wynik.getInt(1);
            nr = nr + 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nr;
    }

    public void wyloguj() {
        zalogowany = null;
    }

    public Pracownik getZalogowany() {
        return zalogowany;
    }

    public List<Pokoj> pobierzPokoj() {
        List<Pokoj> lista = new ArrayList<Pokoj>();
        String polecenie = "SELECT * from Pokoj1 ";
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);

            while (wynik.next()) {
                lista.add(new Pokoj(wynik.getInt(1), wynik.getString(2), wynik.getString(3), wynik.getInt(4), wynik.getString(5), wynik.getInt(6), wynik.getString(7), wynik.getString(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (List<Pokoj>) lista;

    }

    Pracownik pobierzDanePracownik(String login, String password) {
        Pracownik wynikowa = null;
        String polecenie = "SELECT * from Pracownik Where login= '" + login + "' AND haslo='" + password + "'";
        String typ = null;
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            if (wynik.isFirst()) {

                wynikowa = new Pracownik(wynik.getString(1), wynik.getString(2), wynik.getString(3));
            } else {

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return wynikowa;
    }

    public List<Pokoj> czyPokojJestWolnydlaDaty1(GregorianCalendar start, GregorianCalendar koniec) {
        List<Pokoj> lista = new ArrayList<Pokoj>();
        List<Pokoj> lista_got = new ArrayList<Pokoj>();
        String polecenie = "SELECT * from Pokoj1 ";

        ResultSet wynik;
        ResultSet wynik2;
        try {
            wynik = aStatement.executeQuery(polecenie);

            while (wynik.next()) {
                lista.add(new Pokoj(wynik.getInt(1), wynik.getString(2), wynik.getString(3), wynik.getInt(4), wynik.getString(5), wynik.getInt(6), wynik.getString(7), wynik.getString(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        boolean sprawdz;
        for (int i = 0; i < lista.size(); i++) {
            sprawdz = false;

            String polecenie1 = "SELECT * from RezerwacjaPokoi where id_pokoju='" + lista.get(i).getId() + "'";

            try {
                wynik2 = aStatement.executeQuery(polecenie1);
                GregorianCalendar start_rp = new GregorianCalendar();
                GregorianCalendar koniec_rp = new GregorianCalendar();

                while (wynik2.next()) {
                    LocalDate ld1 = wynik2.getDate(4).toLocalDate();
                    LocalDate ld2 = wynik2.getDate(5).toLocalDate();

                    start_rp.set(ld1.getYear(), ld1.getMonthValue(), ld1.getDayOfMonth());
                    koniec_rp.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());

                    if (testGregorianCalendar(start, koniec_rp) == 1) {

                    } else if (testGregorianCalendar(koniec, start_rp) == -1) {

                    } else {
                        sprawdz = true;

                    }

                }
                if (sprawdz) {
                    lista.remove(lista.get(i));
                    i--;
                }
            } catch (SQLException ex) {

            }
        }
        return (List<Pokoj>) lista;
    }

    PokojRezerwacja pobierzPokojRezerwacje(Rezerwacja r) {
        PokojRezerwacja wynikowa = null;
        String polecenie = "SELECT * from REZERWACJAPOKOI WHERE ID_GOSCIA='" + r.getId() + "'";
        String typ = null;
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            if (wynik.isFirst()) {

                GregorianCalendar start_rp = new GregorianCalendar();
                GregorianCalendar koniec_rp = new GregorianCalendar();

                LocalDate ld1 = wynik.getDate(4).toLocalDate();
                LocalDate ld2 = wynik.getDate(5).toLocalDate();

                start_rp.set(ld1.getYear(), ld1.getMonthValue(), ld1.getDayOfMonth());
                koniec_rp.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());

                wynikowa = new PokojRezerwacja(wynik.getInt(1), wynik.getInt(2), wynik.getInt(3), start_rp, koniec_rp);
            } else {

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return wynikowa;
    }

    List<PokojRezerwacja> pobierzListePokojRezerwacje() {
        List<PokojRezerwacja> lista = new ArrayList<PokojRezerwacja>();
        Potrawa wynikowa = null;
        String polecenie = "SELECT * from RezerwacjaPokoi";
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);

            while (wynik.next()) {
                GregorianCalendar start_rp = new GregorianCalendar();
                GregorianCalendar koniec_rp = new GregorianCalendar();

                LocalDate ld1 = wynik.getDate(4).toLocalDate();
                LocalDate ld2 = wynik.getDate(5).toLocalDate();

                start_rp.set(ld1.getYear(), ld1.getMonthValue(), ld1.getDayOfMonth());
                koniec_rp.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());
                lista.add(new PokojRezerwacja(wynik.getInt(1), wynik.getInt(2), wynik.getInt(3), start_rp, koniec_rp));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
//

    public int dodajZamowienie(Zamowienie nowa) {
        int nr = kolejnyNrZamowienia();
        try {

            String wzor2 = "INSERT INTO Zamowienie VALUES (" + nr + "," + nowa.getKoszt() + ",'" + nowa.getSzczegoly() + "')";

            ResultSet wynik = aStatement.executeQuery(wzor2);
        } catch (SQLException ex) {
            System.out.println("blad sql: " + ex.getMessage());
            System.out.println("blad sql: " + ex.getErrorCode());
        }

        return 0;
    }

    public int odwzorujListyWBazie(List<PokojRezerwacja> listapokojrezerwacji, List<Rezerwacja> listaRezerwacji) {
        int stan = 0;
        try {
            String p1 = "Delete Rezerwacja";
            ResultSet wynik1 = aStatement.executeQuery(p1);
            String p2 = "Delete RezerwacjaPokoi";
            ResultSet wynik2 = aStatement.executeQuery(p2);

            for (int i = 0; i < listaRezerwacji.size(); i++) {
                System.out.println("licznik::" + i);
                Rezerwacja rez = listaRezerwacji.get(i);
                if (dodajRezerwacje(rez) == -1) {
                    stan = -1;
                    return stan;
                }
            }

            for (int i = 0; i < listapokojrezerwacji.size(); i++) {
                PokojRezerwacja pr = listapokojrezerwacji.get(i);
                if (DodajPokojRezerwacjiJezeliToMozliwe(pr) == -2) {
                    stan = -2;
                }
            }
            System.out.println("stan== " + stan);
            return stan;
        } catch (SQLException ex) {
            System.out.println("Blad SQL");
            System.out.println("Blad odwzorujListyWBazie");
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
            stan = -3;
            return stan;
        }

    }

    public int odwzorujListeZlecenie(List<Zlecenia> lista) {
        int stan = 0;
        try {
            String p1 = "Delete Zlecenie";
            ResultSet wynik1 = aStatement.executeQuery(p1);

            for (int i = 0; i < lista.size(); i++) {
                Zlecenia zl = lista.get(i);
                if (DodajZlecenia(zl) == -1) {
                    stan = -1;
                    return stan;
                }
            }

            return stan;
        } catch (SQLException ex) {
            System.out.println("Blad SQL");
            System.out.println("Blad odwzorujListyWBazie");
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
            stan = -2;
            return stan;
        }

    }

    public List<Zlecenia> pobierzZlecenia() {
        List<Zlecenia> zlecenie = new ArrayList<Zlecenia>();;
        String polecenie = "SELECT * from Zlecenie";
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);

            while (wynik.next()) {

                GregorianCalendar start_rp = new GregorianCalendar();

                LocalDate ld2 = wynik.getDate(5).toLocalDate();
                start_rp.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());

                zlecenie.add(new Zlecenia(wynik.getInt(1), wynik.getString(2), wynik.getString(3), wynik.getInt(4), start_rp, wynik.getInt(6), wynik.getInt(7),wynik.getString(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (List<Zlecenia>) zlecenie;

    }

    public boolean czyIstniejeJakiekolwiekZamowienie() {
        String polecenie = "SELECT id from Zamowienie";
        ResultSet wynik = null;
        try {
            wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            return wynik.isFirst();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BazaSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public int kolejnyNrZlecenia() {
        int nr = -1;
        try {
            if (!czyIstniejeAkokolwiekZlecenie()) {
                return 0;
            }
            String polecenie = "SELECT max(id) from Zlecenie";
            ResultSet wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            nr = wynik.getInt(1);
            nr = nr + 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nr;
    }

    public int DodajZlecenia(Zlecenia zl) {
        int nr = 0;
        try {
            nr = kolejnyNrZlecenia();
            String wzor2 = "INSERT INTO Zlecenie VALUES ('" + nr + "','" + zl.getNazwa() + "','" + zl.getTyp() + "','" + zl.getCena() + "'," + zl.getStringPoczatekRezerwacji() + ",'" + zl.getCzasTrwania() + "','" + zl.getId_gosc() + "','" + zl.getId_pracownik() + "')";
            ResultSet wynik = aStatement.executeQuery(wzor2);
        } catch (SQLException ex) {
            System.err.println("blad sql: " + ex.getMessage());
            System.err.println("blad sql: " + ex.getErrorCode());
            return -1;
        }
        return nr;
    }

    public int kolejnyNrZamowienia() {
        int nr = -1;
        try {

            if (!czyIstniejeJakiekolwiekZamowienie()) {
                return 0;
            }
            String polecenie = "SELECT max(id) from Zamowienie";
            ResultSet wynik = aStatement.executeQuery(polecenie);
            wynik.next();
            nr = wynik.getInt(1);
            nr = nr + 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return nr;
    }

    List<Zamowienie> pobierzZamowienie() {
        List<Zamowienie> lista = new ArrayList<Zamowienie>();
        Zamowienie wynikowa = null;
        String polecenie = "SELECT * from Zamowienie ";
        try {
            ResultSet wynik = aStatement.executeQuery(polecenie);

            while (wynik.next()) {
                lista.add(new Zamowienie(wynik.getInt(1), wynik.getInt(2), wynik.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (List<Zamowienie>) lista;

    }

    public int UsunZamowienie(Zamowienie z) {
        try {
            String polecenie = "Delete from Zamowienie WHERE ID=" + z.getId() + "";
            ResultSet wynik = aStatement.executeQuery(polecenie);

        } catch (SQLException ex) {
            System.out.println("blad sql: " + ex.getMessage());
            System.out.println("blad sql: " + ex.getErrorCode());
        }
        return 0;
    }

    public void DodajJednoZlecenie(Zlecenia zl) {
        int nr = 0;
        try {
            nr = kolejnyNrZlecenia();
            String wzor2 = "INSERT INTO Zlecenie VALUES (" + nr + ",'" + zl.getNazwa() + "','" + zl.getTyp() + "'," + zl.getCena() + "," + zl.getStringPoczatekRezerwacji()+ "," + zl.getCzasTrwania() + "," + zl.getId_gosc() + ",'" + zl.getId_pracownik() + "')";
            ResultSet wynik = aStatement.executeQuery(wzor2);
        } catch (SQLException ex) {
            System.err.println("blad sql: " + ex.getMessage());
            System.err.println("blad sql: " + ex.getErrorCode());
        }
    }


}
