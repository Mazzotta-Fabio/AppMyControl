package patterMVC;

import interfacciaGrafica.NotificaInterfaccia;
import patternFactory.Attivita;
import patternFactory.GestoreFactory;

public class View {
	private GestoreFactory factoryAttivita;
	private NotificaInterfaccia notifica;
	
	public View(GestoreFactory factoryAttivita){
		this.factoryAttivita=factoryAttivita;
		notifica=Launcher.getFrame();
	}
	
	public void aggiornaWindow(String text){
		notifica.setText(text);
	}
	
	public void aggiornaInterfaccia(){
		Attivita attivita=factoryAttivita.getAttivita();
		if(attivita!=null){
			attivita.eseguiAttivita();
		}
	}
}
