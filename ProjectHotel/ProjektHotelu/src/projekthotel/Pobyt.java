
package projekthotel;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author sobie
 */
public class Pobyt extends Action {

    private static final long serialVersionUID = 2L;

   
    public Rezerwacja getRezerwacja() {
        return rezerwacja;
    }

    public Pokoj getPokoj() {
        return pokoj;
    }

    public void setRezerwacja(Rezerwacja rezerwacja) {
        this.rezerwacja = rezerwacja;
    }

    public void setPokoj(Pokoj pokoj) {
        this.pokoj = pokoj;
    }

    Rezerwacja rezerwacja;
    Pokoj pokoj;

    public Pobyt(Rezerwacja rezerwacja, Pokoj pokoj) {
        this.rezerwacja = rezerwacja;
        this.pokoj = pokoj;
    }

 
 
    @Override
    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }

}
