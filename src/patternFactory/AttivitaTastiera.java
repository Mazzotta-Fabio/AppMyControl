package patternFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AttivitaTastiera implements Attivita{
	
	private Robot robot;
	private char carattere;
	private String operazione;
	public AttivitaTastiera(char carattere,String operazione){
		try{
			robot=new Robot();
		}
		catch(AWTException e){
			e.printStackTrace();
		}
		this.carattere=carattere;
		this.operazione=operazione;
	}
	
	public void eseguiAttivita(){
		switch(operazione){
		case "SelezioneTasto":
			premiTasto();
			break;
		case "Telecomando":
			gestisciTelecomando();
			break;
		}
	}
	private void premiTasto() {
		int character=0;
		int shift=0;
		switch(carattere){
		case '$': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_4;break;
		case 'a':character=KeyEvent.VK_A;break;
		case 'b':character=KeyEvent.VK_B;break;
		case 'c':character=KeyEvent.VK_C;break;
		case 'd':character=KeyEvent.VK_D;break;
		case 'e':character=KeyEvent.VK_E;break;
		case 'f':character=KeyEvent.VK_F;break;
		case 'g':character=KeyEvent.VK_G;break;
		case 'h':character=KeyEvent.VK_H;break;
		case 'i':character=KeyEvent.VK_I;break;
		case 'l':character=KeyEvent.VK_L;break;
		case 'm':character=KeyEvent.VK_M;break;
		case 'n':character=KeyEvent.VK_N;break;
		case 'o':character=KeyEvent.VK_O;break;
		case 'p':character=KeyEvent.VK_P;break;
		case 'q':character=KeyEvent.VK_Q;break;
		case 'r':character=KeyEvent.VK_R;break;
		case 's':character=KeyEvent.VK_S;break;
		case 't':character=KeyEvent.VK_T;break;
		case 'u':character=KeyEvent.VK_U;break;
		case 'v':character=KeyEvent.VK_V;break;
		case 'z':character=KeyEvent.VK_Z;break;
		case 'k':character=KeyEvent.VK_K;break;
		case 'w':character=KeyEvent.VK_W;break;
		case 'y':character=KeyEvent.VK_Y;break;
		case 'j':character=KeyEvent.VK_J;break;
		case 'x':character=KeyEvent.VK_X;break;
		case '0':character=KeyEvent.VK_0;break;
		case '1':character=KeyEvent.VK_1;break;
		case '2':character=KeyEvent.VK_2;break;
		case '3':character=KeyEvent.VK_3;break;
		case '4':character=KeyEvent.VK_4;break;
		case '5':character=KeyEvent.VK_5;break;
		case '6':character=KeyEvent.VK_6;break;
		case '7':character=KeyEvent.VK_7;break;
		case '8':character=KeyEvent.VK_8;break;
		case '9':character=KeyEvent.VK_9;break;
		case '(':shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_8;break;
		case ')':shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_9;break;
		case '*':shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_PLUS;break;
		case '-':character=KeyEvent.VK_MINUS;break;
		case '+':character=KeyEvent.VK_PLUS;break;
		case '=':shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_0;break;
		case '!':shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_1;break;
		case ';':shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_COMMA;break;
		case '.':character=KeyEvent.VK_PERIOD;break;
		case ',':character=KeyEvent.VK_COMMA;break;
		case '^':character=KeyEvent.VK_SPACE;break;
		case '>':character=KeyEvent.VK_ENTER;break;
		case '<':character=KeyEvent.VK_TAB;break;
		case '\\':shift=KeyEvent.VK_BACK_SLASH;break;
		case '\'':character=KeyEvent.VK_QUOTE;break;
		case '/':shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_7;break;
		case 'A': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_A;break;
        case 'B': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_B;break;
        case 'C': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_C;break;
        case 'D': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_D;break;
        case 'E': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_E;break;
        case 'F': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_F;break;
        case 'G': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_G;break;
        case 'H': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_H;break;
        case 'I': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_I;break;
        case 'J': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_J;break;
        case 'K': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_K;break;
        case 'L': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_L;break;
        case 'M': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_M;break;
        case 'N': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_N;break;
        case 'O': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_O;break;
        case 'P': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_P;break;
        case 'Q': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_Q;break;
        case 'R': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_R;break;
        case 'S': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_S;break;
        case 'T': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_T;break;
        case 'U': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_U;break;
        case 'V': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_V;break;
        case 'W': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_W;break;
        case 'X': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_X;break;
        case 'Y': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_Y;break;
        case 'Z': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_Z;break;
        case '_': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_UNDERSCORE;break;
        case '|': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_BACK_SLASH;break;
        case '?': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_QUOTE;break;
        case ':': shift=KeyEvent.VK_SHIFT;character=KeyEvent.VK_PERIOD;break;
        case '#': shift=KeyEvent.VK_LEFT;character=KeyEvent.VK_DELETE;break;
		}
		if(shift>0){
			robot.keyPress(shift);
			robot.keyPress(character);
			robot.keyRelease(character);
			robot.keyRelease(shift);
		}
		else{
			robot.keyPress(character);
			robot.keyRelease(character);
		}
	}
	
	private void gestisciTelecomando(){
		int btn=0;
		switch(carattere){
		case 'A':
			btn=KeyEvent.VK_UP;
			break;
		case 'I':
			btn=KeyEvent.VK_DOWN;
			break;
		case 'D':
			btn=KeyEvent.VK_RIGHT;
			break;
		case 'S':
			btn=KeyEvent.VK_LEFT;
			break;
		}
		robot.keyPress(btn);
		robot.keyRelease(btn);
	}
}