/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author przem
 */
public class DownloadPotrawa extends Action {
     private static final long serialVersionUID = 2L;
  List<Potrawa> potrawy=new ArrayList<>();  

    public void addPotrawy(Potrawa potrawa) {

        potrawy.add(potrawa);
    }

   

   
    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }   
}
