package patternFactory;

import patterMVC.OttieniDatiModel;

public class GestoreFactory {
	
	private OttieniDatiModel model;
	
	public GestoreFactory(OttieniDatiModel model){
		this.model=model;
	}
	
	public Attività getAttività(){
		Attività att=null;
		switch(model.getFunzionalità()){
			case "mouse":
				att=new AttivitaMouse(model.getAzione(), model.getOpzioneSelezione());
				break;
			case "mouseMuovi":
				att=new AttivitaMouse(model.getX(),model.getY(),model.getAzione());
				break;
			case "tastiera":
				att=new AttivitaTastiera(model.getCarattere(),model.getOpzioneSelezione());
				break;
			case "gestioneMDP":
				att=new AttivitaFunzionalita(model.getOpMDP());
				break;
			case "gestionePC":
				att=new AttivitaSistema(model.getOpSistema());
		}
		return att;
	}
}
