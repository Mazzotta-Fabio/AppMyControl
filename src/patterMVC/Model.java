package patterMVC;

public class Model implements OttieniDatiModel{
	
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	private String opMDP;
	private String azione;
	private char carattere;
	private String opzioneSelezione;
	private String opSistema;
	private String funzionalita;
	private String nomeFile;
	private String codificaFile64;
	
	public Model(){
		x1=0;
		y1=0;
		x2=0;
		y2=0;
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
			x1=Double.parseDouble(parole[1]);
			x2=Double.parseDouble(parole[2]);
			y1=Double.parseDouble(parole[3]);
			y2=Double.parseDouble(parole[4]);
			azione=parole[5];
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
	public double getX1() {
		return x1;
	}

	@Override
	public double getY1() {
		return y1;
	}

	@Override
	public double getX2() {
		return x2;
	}

	@Override
	public double getY2() {
		return y2;
	}

	@Override
	public String getNomeFile() {
		return nomeFile;
	}
}
