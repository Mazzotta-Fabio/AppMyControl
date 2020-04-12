package testingApp;

import patterMVC.Model;
import patternFactory.AttivitaFunzionalita;
import patternFactory.AttivitaMouse;
import patternFactory.AttivitaSistema;
import patternFactory.AttivitaTastiera;
import patternFactory.Attivit�;
import patternFactory.GestoreFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GestoreFactoryTest extends TestCase {
	
	private GestoreFactory factory;
	private Model model;
	
	public void setUp(){
		model=new Model();
		factory=new GestoreFactory(model);
	}
	
	public void tearDown(){
		factory=null;
		model=null;
	}
	
	public void testGetAttivit�(){
		Attivit� att;
		model.settaValori("mouse Click SINSITRO");
		att=factory.getAttivit�();
		AttivitaMouse mouse=new AttivitaMouse("Click","SINISTRO");
		assertEquals(mouse.getClass(),att.getClass());
		
		model.settaValori("tastiera A Telecomando");
		att=factory.getAttivit�();
		AttivitaTastiera tastiera=new AttivitaTastiera('A',"Telecomando");
		assertEquals(tastiera.getClass(),att.getClass());
		
		model.settaValori("gestioneMDP PAUSAESEGUI");
		att=factory.getAttivit�();
		AttivitaFunzionalita mdp=new AttivitaFunzionalita("PAUSAESEGUI");
		assertEquals(mdp.getClass(),att.getClass());
		
		model.settaValori("gestionePC SPEGNI");
		att=factory.getAttivit�();
		AttivitaSistema sistema=new AttivitaSistema("SPEGNI");
		assertEquals(sistema.getClass(),att.getClass());
	}
	
	public static Test suite(){
		return new TestSuite(GestoreFactoryTest.class);
	}
}
