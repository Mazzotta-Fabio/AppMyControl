package testingApp;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class ProvaSuiteTests {
 
	public static void main(String[] args) {
		//qui lanciamo le nostre classi di test
		Test test=ProvaSuiteTests.suite();
		TestRunner.run(test);
	}
	
	public static Test suite(){
		//i testSuite permettono di eseguire automaticamente tutti i metodi delle classi di test
		TestSuite suite=new TestSuite();
		suite.addTest(GestoreFactoryTest.suite());
		suite.addTest(ModelTest.suite());
		return suite;
	}
}
