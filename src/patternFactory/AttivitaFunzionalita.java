package patternFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
//funziona solo con media player di Windows
public class AttivitaFunzionalita implements Attivita{
	
	private String modalitaOperazione;
	private Robot robot;
	
	public AttivitaFunzionalita(String modalitaOperazione){
		this.modalitaOperazione=modalitaOperazione;
		try{
			robot=new Robot();
		}
		catch(AWTException e){
			e.printStackTrace();
		}	
	}
	
	public void eseguiAttivita(){
		switch(modalitaOperazione){
		case "METTIMUTO":
			mettiMuto();
			break;
		case "PAUSAESEGUI":
			mettiPausa();
			break;
		case "VOLUMEALTO":
			mettiVolumeAlto();
			break;
		case "VOLUMEBASSO":
			mettiVolumeBasso();
			break;
		case "VAIAVANTI":
			mettiAvanti();
			break;
		case "VAIINDIETRO":
			mettiIndietro();
			break;
		case "SCHERMOINTERO":
			mettiSchermoIntero();
			break;
		case "STOP":
			mettiStop();
			break;
		case "CHIUDIMDP":
			chiudiMDP();
			break;
		}
	}
	
	private void mettiMuto(){
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
	}
	
	private void chiudiMDP() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_W);
	}
	
	//SALTA INTRO
	private void mettiStop() {
		//robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		//robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	private void mettiSchermoIntero() {
		robot.keyPress(KeyEvent.VK_F);
		//robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_F);
		//robot.keyRelease(KeyEvent.VK_ALT);
	}

	private void mettiPausa() {
		robot.keyPress(KeyEvent.VK_SPACE);
		//robot.keyPress(KeyEvent.VK_P);
		//robot.keyRelease(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_SPACE);
	}

	private void mettiIndietro() {
		robot.keyPress(KeyEvent.VK_LEFT);
		//robot.keyPress(KeyEvent.VK_B);
		//robot.keyRelease(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}
	
	private void mettiAvanti() {
		robot.keyPress(KeyEvent.VK_RIGHT);
		//robot.keyPress(KeyEvent.VK_F);
		//robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}

	private void mettiVolumeBasso() {
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	private void mettiVolumeAlto() {
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}
}