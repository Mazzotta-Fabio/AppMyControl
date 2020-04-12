package patterMVC;

import interfacciaGrafica.NotificaInterfaccia;
import patternFactory.Attività;
import patternFactory.GestoreFactory;

public class View {
	private GestoreFactory factoryAttività;
	private NotificaInterfaccia notifica;
	
	public View(GestoreFactory factoryAttività){
		this.factoryAttività=factoryAttività;
		notifica=Launcher.getFrame();
	}
	
	public void aggiornaWindow(String text){
		notifica.setText(text);
	}
	
	public void aggiornaInterfaccia(){
		Attività attività=factoryAttività.getAttività();
		if(attività!=null){
			attività.eseguiAttività();
		}
	}
}
