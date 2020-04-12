package patternFactory;

import java.io.IOException;

public class AttivitaSistema implements Attività {

	private String operazione;
	
	public AttivitaSistema(String operazione){
		this.operazione=operazione;
	}
	
	public void eseguiAttività(){
		String comando=null;
		//qui otteniamo informazioni sul SO
		String operatingSystem=System.getProperty("os.name");
		switch(operazione){
		case "SPEGNI":
			if((operatingSystem.equals("Linux"))||(operatingSystem.equals("Mac-OS"))){
				comando="shutdown -h now";
			}
			else{
				comando="shutdown.exe -s -t 0";
			}
			break;
		case "RIAVVIA":
			if((operatingSystem.equals("Linux"))||(operatingSystem.equals("Mac-OS"))){
				comando="shutdown -r";
			}
			else{
				comando="shutdown.exe -r -t 0";
			}
			break;
		case "DISCONNETTI":
			if((operatingSystem.equals("Linux"))||(operatingSystem.equals("Mac-OS"))){
				comando="shutdown -l -f";
			}
			else{
				comando="shutdown.exe -l -t 0";
			}
			break;
		case "IBERNA":
			if((operatingSystem.equals("Linux"))||(operatingSystem.equals("Mac-OS"))){
				comando="sudo pm-hibernate";
			}
			else{
				comando="shutdown.exe -h -t 0";
			}
			break;
		}
		try {
			//permette di interagire con le altre applicazioni
			Runtime.getRuntime().exec(comando);
			System.exit(0);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
