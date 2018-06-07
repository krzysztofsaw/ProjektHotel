package projekthotel;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class DownloadZlecenia extends Action {
    private static final long serialVersionUID = 2L;
     
    List<Zlecenia> zlecenie=new ArrayList<>();  

    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }   
}
