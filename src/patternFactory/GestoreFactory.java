package patternFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import patterMVC.Launcher;
import patterMVC.OttieniDatiModel;

public class GestoreFactory {
	
	private OttieniDatiModel model;
	
	public GestoreFactory(OttieniDatiModel model){
		this.model=model;
	}
	
	public Attivita getAttivita(){
		Attivita att=null;
		switch(model.getFunzionalita()){
			case "mouse":
				att=new AttivitaMouse(model.getAzione(), model.getOpzioneSelezione());
				break;
			case "mouseMuovi":
				att=new AttivitaMouse(model.getX1(),model.getX2(),model.getY1(),model.getY2(),model.getAzione());
				break;
			case "tastiera":
				att=new AttivitaTastiera(model.getCarattere(),model.getOpzioneSelezione());
				break;
			case "gestioneMDP":
				att=new AttivitaFunzionalita(model.getOpMDP());
				break;
			case "gestionePC":
				att=new AttivitaSistema(model.getOpSistema());
				break;
			case "invioFile":
				try {
					att=new AttivitaFile(model.getSocket(),Launcher.getPathFile());
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
		}
		return att;
	}
}
