package projekthotel;
 

public interface ActionMake {	
	public void Action(DownloadRezerwacja aService, ServerThread thread);  
        public void Action(DownloadPotrawa aService, ServerThread thread);     
        public void Action(DownloadPracownik aService, ServerThread thread); 
        public void Action(DownloadPokoj aService, ServerThread thread); 
        public void Action(DownloadRezewationAndWorker aService, ServerThread thread); 
	public void Action(czyPokojJestWolnydlaDaty1 aService, ServerThread thread);
        public void Action(DownloadWszystkoPobyty aService, ServerThread thread);
        public void Action(Pobyt aService, ServerThread thread);
        public void Action(DownloadZamowienie aService, ServerThread thread); 
        public void Action(OdwzorujListy aService, ServerThread thread); 
        public void Action(DownloadZlecenia aService, ServerThread thread); 
        public void Action(OdwzorujZlecenie aService, ServerThread thread); 
        public void Action(OtrzymajZamowienia aService, ServerThread thread);
        public void Action(UsunZamowienie aService, ServerThread thread);
        public void Action(WpiszZlecenie aService, ServerThread thread);
       

} 

