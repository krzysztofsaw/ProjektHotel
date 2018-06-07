/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;



/**
 *
 * @author przem
 */
public class UsunZamowienie extends Action {

 
    Zamowienie zamowienie;
    public UsunZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
 

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }

   
    
}
