package patterMVC;

import interfacciaGrafica.NotificaInterfaccia;
import patternFactory.Attivit�;
import patternFactory.GestoreFactory;

public class View {
	private GestoreFactory factoryAttivit�;
	private NotificaInterfaccia notifica;
	
	public View(GestoreFactory factoryAttivit�){
		this.factoryAttivit�=factoryAttivit�;
		notifica=Launcher.getFrame();
	}
	
	public void aggiornaWindow(String text){
		notifica.setText(text);
	}
	
	public void aggiornaInterfaccia(){
		Attivit� attivit�=factoryAttivit�.getAttivit�();
		if(attivit�!=null){
			attivit�.eseguiAttivit�();
		}
	}
}
