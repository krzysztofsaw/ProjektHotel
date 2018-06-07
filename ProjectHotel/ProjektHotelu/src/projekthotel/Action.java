package projekthotel;

import java.io.Serializable;

public abstract class Action implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	public abstract void acceptAction(ActionMake make, ServerThread thread);
		
	
	
}