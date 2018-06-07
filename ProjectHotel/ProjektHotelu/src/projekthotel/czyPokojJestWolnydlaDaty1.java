/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author sobie
 */
public class czyPokojJestWolnydlaDaty1 extends Action {
    private static final long serialVersionUID = 2L;
    List<Pokoj> pokoje2=new ArrayList<>(); 

    public GregorianCalendar getR1() {
        return r1;
    }

    public GregorianCalendar getR2() {
        return r2;
    }

    
    public void setR1(GregorianCalendar r1) {
        this.r1 = r1;
    }
 
    public czyPokojJestWolnydlaDaty1(GregorianCalendar r1, GregorianCalendar r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    
    GregorianCalendar r1;
    GregorianCalendar r2;
 
    @Override
   public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }
    
}
