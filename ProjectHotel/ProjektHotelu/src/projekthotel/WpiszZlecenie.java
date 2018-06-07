
package projekthotel;

import java.util.GregorianCalendar;
import java.util.List;

class WpiszZlecenie extends Action {

    public Zlecenia getZlecenie() {
        return zlecenie;
    }

    public void setZlecenie(Zlecenia zlecenie) {
        this.zlecenie = zlecenie;
    }

    public WpiszZlecenie(Zlecenia zlecenie) {
        this.zlecenie = zlecenie;
    }

    Zlecenia zlecenie;

    @Override
    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }

}