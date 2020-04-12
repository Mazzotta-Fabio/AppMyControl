package testingApp;

import patterMVC.Model;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//questa classe è un test unit utilizzato per testare tutti i metodi della classe Model
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
		assertEquals("mouse", model.getFunzionalità());
		assertEquals(5, model.getX());
		assertEquals(5, model.getY());
		assertEquals("Click", model.getAzione());
		assertEquals("SINISTRO", model.getOpzioneSelezione());
		model.settaValori("tastiera A Telecomando");
		assertEquals("tastiera", model.getFunzionalità());
		assertEquals('A', model.getCarattere());
		assertEquals("Telecomando", model.getOpzioneSelezione());
		model.settaValori("gestionePC SPEGNI");
		assertEquals("gestionePC", model.getFunzionalità());
		assertEquals("SPEGNI",model.getOpSistema());
		model.settaValori("gestioneMDP PAUSAESEGUI");
		assertEquals("gestioneMDP", model.getFunzionalità());
		assertEquals("PAUSAESEGUI", model.getOpMDP());
	}
	
	public static Test suite(){
		return new TestSuite(ModelTest.class);
	}
}
