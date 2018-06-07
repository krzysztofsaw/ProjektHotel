package projekthotel;

import java.util.ArrayList;
import java.util.List;


public class DownloadZamowienie extends Action {
    private static final long serialVersionUID = 2L;

    public DownloadZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
   
    Zamowienie zamowienie;
    
    
     
     
    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }   
}
