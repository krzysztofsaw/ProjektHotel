
package projekthotel;

/**
 *
 * @author użytkownik
 */
class DownloadRezewationAndWorker extends Action {
     private static final long serialVersionUID = 2L;

    protected String login;
	protected String password;	
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
    
    public DownloadRezewationAndWorker(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void acceptAction(ActionMake make, ServerThread thread) {
        make.Action(this, thread);
    }
    
    
    
}
