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
public class Pracownik implements Serializable {
    private String login;
    private String haslo;
    private String typ;
    
    Pracownik(String login,String haslo,String typ){
     this.login = login;
     this.haslo = haslo;
     this.typ=typ;
        
    }
       
    public String getLogin(){
        return login;
    }
    
     public String getHaslo(){
        return haslo;
    }
     
      public String getTyp(){
        return typ;
    }
}
