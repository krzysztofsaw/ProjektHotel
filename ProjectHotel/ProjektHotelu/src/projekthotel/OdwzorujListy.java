/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author użytkownik
 */
class OdwzorujListy extends Action{
   List<PokojRezerwacja> pokojrezerwacja;
   List<Rezerwacja> rezerwacja;

    public List<PokojRezerwacja> getPokojrezerwacja() {
        return pokojrezerwacja;
    }

    public List<Rezerwacja> getRezerwacja() {
        return rezerwacja;
    }

    public OdwzorujListy(List<PokojRezerwacja> pokojrezerwacja, List<Rezerwacja> rezerwacja) {
        this.pokojrezerwacja = pokojrezerwacja;
        this.rezerwacja = rezerwacja;
    }

    @Override
    public void acceptAction(ActionMake make, ServerThread thread) {
       make.Action(this, thread);
    }
    
    
}
