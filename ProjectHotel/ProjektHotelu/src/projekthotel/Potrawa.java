/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.io.Serializable;


/**
 *
 * @author użytkownik
 */
public class Potrawa implements Serializable{

String nazwa;
int cena;
String rozmiar;

    Potrawa(String nazwa, int cena,String rozmiar) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.rozmiar = rozmiar;

    }
    
    public String toString() {
        return  nazwa + " " + cena + " " + "zl" + " " + rozmiar ;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }




 
    
    
}
