package interfacciaGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;
import patterMVC.Launcher;

public class WindowServerApp extends JFrame implements NotificaInterfaccia{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblBenvenuto;
	private JLabel lblIndirizzo;
	private JLabel lblStatus;
	private ArrayList <String> utentiCollegati;
	
	public WindowServerApp(){
		JPanel panel1=creaPanel();
		JPanel panel2=creaPanel2();
		JPanel panel4=creaPanel4();
		utentiCollegati=new ArrayList<String>();
		setLayout(new GridLayout(3,1));
		add(panel1);
		add(panel2);
		add(panel4);
		setSize(700,400);
		setTitle("Server MyControl");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\fabio\\Documents\\GitHub\\ServerAppMyControl\\logo.png"));
	}

	private JPanel creaPanel(){
		JPanel panel=new JPanel();
		Font f=new Font("Calibri",Font.BOLD,28);
		lblBenvenuto=new JLabel("Benvenuto nel Server che gestisce l'app MyControl");
		lblBenvenuto.setFont(f);
		panel.add(lblBenvenuto);
		return panel;
	}
	
	private JPanel creaPanel2(){
		JPanel panel=new JPanel();
		Font f=new Font("Calibri",Font.BOLD,20);
		lblIndirizzo=new JLabel("Inserisci l'indirizzo IP [" + Launcher.getLocalName() + "] in \"Impostazioni\" per connetterti al PC.");
		lblIndirizzo.setFont(f);
		lblIndirizzo.setForeground(Color.RED);
		panel.add(lblIndirizzo);
		return panel;
	}
	
	private JPanel creaPanel4(){
		JPanel panel=new JPanel();
		Font f=new Font("Calibri",Font.BOLD,18);
		lblStatus=new JLabel("In attesa di connessioni...");
		lblStatus.setFont(f);
		lblStatus.setForeground(Color.BLUE);
		panel.add(lblStatus);
		return panel;
	}
	
	public void setText(String text){
		String [] parole=text.split(" ");
		//rimuovi
		if(parole[0].equals("Rimuovi")){
			for(int i=0;i<utentiCollegati.size();i++){
				String ut=utentiCollegati.get(i);
				if(ut.equals(parole[2])){
					utentiCollegati.remove(i);
					lblStatus.setText(" ");
					break;
				}
			}
			if(utentiCollegati.size()==0){
				lblStatus.setText("In attesa di Connessioni...");
			}
			else{
				for(String ut :utentiCollegati){
					lblStatus.setText(lblStatus.getText() + " \n Connesso con " + ut);
				}
			}
		}
		
		//connesione persa
		if(parole[0].equals("Persa")){
			for(int i=0;i<utentiCollegati.size();i++){
				String ut=utentiCollegati.get(i);
				if(ut.equals(parole[2])){
					utentiCollegati.remove(i);
					lblStatus.setText(" ");
					break;
				}
			}
			for(String ut :utentiCollegati){
				lblStatus.setText(lblStatus.getText() + " \n Connesso con " + ut);
			}
			if(utentiCollegati.size()==0){
				lblStatus.setText("In attesa di connessioni..." + "\n (Connessione " + text +")");
			}
			else{
				lblStatus.setText(lblStatus.getText() + "\n (Connessione " + text + ")");
			}
		}
		//connessione 
		if(parole[0].equals("Connesso")){
			if(utentiCollegati.size()==0){
				lblStatus.setText(text);
			}
			else{
				lblStatus.setText(lblStatus.getText() +" \n "+text);
			}
			utentiCollegati.add(parole[2]);
		}
	}
}

