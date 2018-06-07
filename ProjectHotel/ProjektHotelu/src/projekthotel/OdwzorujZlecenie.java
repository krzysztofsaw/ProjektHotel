/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.util.List;

/**
 *
 * @author użytkownik
 */
class OdwzorujZlecenie extends Action {

    List<Zlecenia> listaZlecen;
    List<Rezerwacja> rezerwacja;
    

    public List<Zlecenia> getListaZlecen() {
        return listaZlecen;
    }

    public List<Rezerwacja> getRezerwacja() {
        return rezerwacja;
    }

    public OdwzorujZlecenie(List<Zlecenia> listaZlecen) {
        this.listaZlecen = listaZlecen;
        this.rezerwacja = rezerwacja;
    }

    @Override
    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }

}
