package patternFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
//funziona solo con media player di Windows
public class AttivitaFunzionalita implements Attivit‡{
	
	private String modalit‡Operazione;
	private Robot robot;
	
	public AttivitaFunzionalita(String modalit‡Operazione){
		this.modalit‡Operazione=modalit‡Operazione;
		try{
			robot=new Robot();
		}
		catch(AWTException e){
			e.printStackTrace();
		}	
	}
	
	public void eseguiAttivit‡(){
		switch(modalit‡Operazione){
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
		robot.keyPress(KeyEvent.VK_F7);
		robot.keyRelease(KeyEvent.VK_F7);
	}
	
	private void chiudiMDP() {
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_ALT);
	}

	private void mettiStop() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	private void mettiSchermoIntero() {
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ALT);
	}

	private void mettiPausa() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	private void mettiIndietro() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	private void mettiAvanti() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	private void mettiVolumeBasso() {
		robot.keyPress(KeyEvent.VK_F8);
		robot.keyRelease(KeyEvent.VK_F8);
	}

	private void mettiVolumeAlto() {
		robot.keyPress(KeyEvent.VK_F9);
		robot.keyRelease(KeyEvent.VK_F9);
	}
}