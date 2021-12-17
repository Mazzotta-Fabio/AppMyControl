package patternFactory;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;


public class AttivitaMouse implements Attivita {
	
	private Robot robot;
	private int x1, y1, x2, y2, t, n;
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
	
	public AttivitaMouse(double x1, double x2, double y1, double y2/*, int t, int n*/,String azione){
		try{
			robot=new Robot();
		}
		catch(AWTException e){
			e.printStackTrace();
		}
		this.x1=(int)x1; 
		this.x2=(int)x2; 
		this.y1=(int)y1; 
		this.y2=(int)y2;
		this.t=700;
		this.n=700;
		/*
		this.t=t;  
		this.n=n;
		*/ 
		this.azione=azione;
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
		log.info("misure: "+x1 +" "+x2+" "+y1+" "+y2);
		/*
		//get the current position of the mouse cursor
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    double width = screen.getWidth();
		double height = screen.getHeight();
		//move the mouse relative to the current position
		//x=x/width;
		//y=y/height;
		//x = x*1000;
		//y = y*1000;
		int newX = (int)x;
		int newY = (int)(y);
		robot.mouseMove(newX+30,newY);
		*/
		
		//rappresenta la differenza tra gli assi x ogni volta che muovi il mouse mentre si muove
        double dx = (x2 - x1) / ((double) n);
        //rappresenta la differenza tra gli assi x ogni volta che muovi il mouse mentre si muove
        double dy = (y2 - y1) / ((double) n);
        //è il moto rettilineo uniforme diviso in n passaggi
        double dt = t / ((double) n);
        /*
         * Costruiamo un ciclo che esegue, per n volte, ogni movimento del mouse fino a giungere alla locazione finale.
         * Per rendere lineare il movimento si crea un Thread per dt millisecondi durante ogni esecuzione.
         * Più grande è n più lineare lo vedrai
         */
		/*
        for (int step = 1; step <= n; step++) {
            try {
				Thread.sleep((int) dt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            robot.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
        }
        */
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
