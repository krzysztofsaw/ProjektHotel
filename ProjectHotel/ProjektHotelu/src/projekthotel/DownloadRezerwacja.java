/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthotel;

/**
 *
 * @author użytkownik
 */
class DownloadRezerwacja extends Action {

    private static final long serialVersionUID = 2L;

    protected String login;
	protected String password;	
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
    
    public DownloadRezerwacja(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }

}
