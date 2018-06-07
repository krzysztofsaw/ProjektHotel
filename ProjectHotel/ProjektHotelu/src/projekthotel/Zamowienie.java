/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.io.Serializable;

/**
 *
 * @author przem
 */
public class Zamowienie implements Serializable {
   int id;

   
   int koszt;
   String szczegoly;

        Zamowienie(int id, int koszt, String szczegoly) {
        this.id = id;
        this.koszt = koszt;
        this.szczegoly = szczegoly;
    }
    
     public int getId() {
        return id;
    }


    public int getKoszt() {
        return koszt;
    }

    public String getSzczegoly() {
        return szczegoly;
    }




 

    public void setKoszt(int koszt) {
        this.koszt = koszt;
    }

    public void setSzczegoly(String szczegoly) {
        this.szczegoly = szczegoly;
    }

    public Zamowienie(int koszt, String szczegoly) {
        this.koszt = koszt;
        this.szczegoly = szczegoly;
    }
   

    
}
