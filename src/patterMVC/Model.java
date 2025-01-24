package patterMVC;

public class Model implements OttieniDatiModel{
	

	private float x;
	private float y;
	private String opMDP;
	private String azione;
	private char carattere;
	private String opzioneSelezione;
	private String opSistema;
	private String funzionalita;
	private String nomeFile;
	private String codificaFile64;
	
	public Model(){
		
	}
	
	public void settaValori(String cmd){
		String [] parole=cmd.split(" ");
		funzionalita=parole[0];
		switch(funzionalita){
		case "mouse":
			azione=parole[1];
			opzioneSelezione=parole[2];
			break;
		case "mouseMuovi":
			x=Float.parseFloat(parole[1]);
			y=Float.parseFloat(parole[2]);
			azione=parole[3];
			break;
		case "tastiera":
			carattere=parole[1].charAt(0);
			opzioneSelezione=parole[2];
			break;
		case "gestioneMDP":
			opMDP=parole[1];
			break;
		case "gestionePC":
			opSistema=parole[1];
			break;
		case "invioFile":
			nomeFile=parole[1];
			codificaFile64=parole[2];
		}
	}
	
	public String getCodificaFile() {
		return codificaFile64;
	}
	
	public String getFunzionalita(){
		return funzionalita;
	}
	
	public String getOpMDP() {
		return opMDP;
	}

	public String getAzione() {
		return azione;
	}

	public String getOpSistema() {
		return opSistema;
	}

	public char getCarattere() {
		return carattere;
	}
	
	public String getOpzioneSelezione(){
		return opzioneSelezione;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}



	@Override
	public String getNomeFile() {
		return nomeFile;
	}
}
