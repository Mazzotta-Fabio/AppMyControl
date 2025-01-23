package testingApp;

import patterMVC.Model;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//questa classe � un test unit utilizzato per testare tutti i metodi della classe Model
public class ModelTest extends TestCase {
	
	private Model model;
	//invocato prima di eseguire i metodi che compongono la classe di testing
	public void setUp(){
		model=new Model();
	}
	//invocato dopo che sono stati eseguiti i metodi della classe di testing
	public void tearDown(){
		model=null;
	}
	
	//verificare se ha settato i valori
	public void testSettaValori(){
		model.settaValori("mouse 5 5 Click SINISTRO");
		assertEquals("mouse", model.getFunzionalita());
		assertEquals(5, model.getX1());
		assertEquals(5, model.getY1());
		assertEquals("Click", model.getAzione());
		assertEquals("SINISTRO", model.getOpzioneSelezione());
		model.settaValori("tastiera A Telecomando");
		assertEquals("tastiera", model.getFunzionalita());
		assertEquals('A', model.getCarattere());
		assertEquals("Telecomando", model.getOpzioneSelezione());
		model.settaValori("gestionePC SPEGNI");
		assertEquals("gestionePC", model.getFunzionalita());
		assertEquals("SPEGNI",model.getOpSistema());
		model.settaValori("gestioneMDP PAUSAESEGUI");
		assertEquals("gestioneMDP", model.getFunzionalita());
		assertEquals("PAUSAESEGUI", model.getOpMDP());
	}
	
	public static Test suite(){
		return new TestSuite(ModelTest.class);
	}
}
