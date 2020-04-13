package patternFactory;

import java.awt.*;
import java.awt.event.*;


public class AttivitaMouse implements Attivit� {
	
	private Robot robot;
	private double x;
	private double y;
	private String azione;
	private String tastoSelezionato;
	
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
	
	public AttivitaMouse(double x,double y,String azione){
		try{
			robot=new Robot();
		}
		catch(AWTException e){
			e.printStackTrace();
		}
		this.x=x;
		this.y=y;
		this.azione=azione;
	}
	public void eseguiAttivit�() {
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
		//get the current position of the mouse cursor
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    double width = screen.getWidth();
		double height = screen.getHeight();
		//move the mouse relative to the current position
		//x=x/width;
		//y=y/height;
		x = x*1000;
		y = y*1000;
		int newX = (int)x;
		int newY = (int)(y);
		robot.mouseMove(newX+30,newY);
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
