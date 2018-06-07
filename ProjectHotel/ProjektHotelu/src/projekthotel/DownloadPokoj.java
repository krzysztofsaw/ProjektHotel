package projekthotel;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class DownloadPokoj extends Action {
    private static final long serialVersionUID = 2L;
     
    List<Pokoj> pokoje=new ArrayList<>();  

    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }   
}
