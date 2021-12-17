package patternFactory;

import java.io.IOException;

public class AttivitaSistema implements Attivita {

	private String operazione;
	
	public AttivitaSistema(String operazione){
		this.operazione=operazione;
	}
	
	public void eseguiAttivita(){
		String comando=null;
		//qui otteniamo informazioni sul SO
		String operatingSystem=System.getProperty("os.name");
		switch(operazione){
		case "SPEGNI":
			if((operatingSystem.contains("ux"))||(operatingSystem.contains("Mac"))){
				comando="shutdown -h now";
			}
			else{
				comando="shutdown.exe -s -t 0";
			}
			break;
		case "RIAVVIA":
			if((operatingSystem.contains("ux"))||(operatingSystem.contains("Mac"))){
				comando="shutdown -r";
			}
			else{
				comando="shutdown.exe -r -t 0";
			}
			break;
		case "DISCONNETTI":
			if((operatingSystem.contains("ux"))||(operatingSystem.contains("Mac"))){
				comando="shutdown -l -f";
			}
			else{
				comando="shutdown.exe -l -t 0";
			}
			break;
		case "IBERNA":
			if((operatingSystem.contains("ux"))||(operatingSystem.contains("Mac"))){
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
