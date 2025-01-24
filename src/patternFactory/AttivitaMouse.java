package patternFactory;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;


public class AttivitaMouse implements Attivita {
	
	private Robot robot;
	private float x;
	private float y;
	private String azione;
	private String tastoSelezionato;
	private Logger log=Logger.getLogger("mioLog");
	
	public AttivitaMouse(String azione,String tastoSelezionato){
		try{
			robot=new Robot();
		}
		catch(AWTException e){
			e.printStackTrace();
		}
		this.azione=azione;
		this.tastoSelezionato=tastoSelezionato;
	}
	
	public AttivitaMouse(float x, float y, String azione){
		try{
			robot=new Robot();
		}
		catch(AWTException e){
			e.printStackTrace();
		}
		this.azione=azione;
		this.x=x;
		this.y=y;
	}
	
	public void eseguiAttivita() {
		switch(azione){
		case "Muovi":
			muoviCursore();
			break;
		case "Click":
			premiTastoClick();
			break;
		case "Rotellina":
			premiRotellina();
			break;
		case "Premuto":
			tieniPremuto();
			break;
		case "Rilascia":
			rilasciaTasto();
		}
	}

	private void rilasciaTasto() {
		switch(tastoSelezionato){
		case "SINISTRO":
			int btn=InputEvent.BUTTON1_MASK;
			robot.mouseRelease(btn);
			break;
		case "DESTRO":
			int btn2=InputEvent.BUTTON3_MASK;
			robot.mouseRelease(btn2);
			break;
		}
	}
	
	private void tieniPremuto() {
		switch(tastoSelezionato){
		case "SINISTRO":
			int btn=InputEvent.BUTTON1_MASK;
			robot.mousePress(btn);
			break;
		case "DESTRO":
			int btn2=InputEvent.BUTTON3_MASK;
			robot.mousePress(btn2);
			break;
		}
	}

	private void premiRotellina() {
		switch(tastoSelezionato){
		case "ALTO":
			robot.mouseWheel(-1);
			break;
		case "BASSO":
			robot.mouseWheel(1);
		}
	}

	private void muoviCursore() {
		log.info("misure: "+x +" "+y);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		
		int x2=(int)(x*screenWidth)+40;
		int y2=(int)(y*screenHeight)+40;
        
		log.info("coordinate del mouse: "+x2+" "+y2);
        robot.mouseMove(x2,y2);
	}

	private void premiTastoClick() {
		switch(tastoSelezionato){
		case "SINISTRO":
			int sinistro=InputEvent.BUTTON1_MASK;
			robot.mousePress(sinistro);
			robot.mouseRelease(sinistro);
			break;
		case "DESTRO":
			int destro=InputEvent.BUTTON3_MASK;
			robot.mousePress(destro);
			robot.mouseRelease(destro);
			break;
		}
	}
	
}
