package patterMVC;

import java.net.Socket;

public interface OttieniDatiModel {
	public String getFunzionalita();
	public double getX1();
	public double getY1();
	public double getX2();
	public double getY2();
	public String getOpMDP();
	public String getAzione();
	public String getOpSistema();
	public char getCarattere();
	public String getOpzioneSelezione();
	public String getNomeFile();
	public Socket getSocket();
	public int getDimensioneFile();
}
