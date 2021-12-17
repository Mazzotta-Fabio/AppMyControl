package interfacciaGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;

import patterMVC.Launcher;

public class WindowServerApp extends JFrame implements NotificaInterfaccia,ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblBenvenuto;
	private JLabel lblIndirizzo;
	private JLabel lblStatus;
	private JTextField txtFile;
	private ArrayList <String> utentiCollegati;
	
	public WindowServerApp(){
		JPanel panel1=creaPanel();
		JPanel panel2=creaPanel2();
		JPanel panel5=creaPanel5();
		JPanel panel4=creaPanel4();
		utentiCollegati=new ArrayList<String>();
		setLayout(new GridLayout(4,1));
		add(panel1);
		add(panel2);
		add(panel5);
		add(panel4);
		setSize(1000,700);
		setTitle("Server MyControl");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
	}
	
	private JPanel creaPanel5() {
		JPanel panel=new JPanel();
		//mettiamo un etichetta
		Font f=new Font("Calibri",Font.BOLD,16);
		JLabel lblEtichetta=new JLabel("Inserisci il percorso dove salvare i tuoi file");
		lblEtichetta.setFont(f);
		//mettiamo text view
		txtFile=new JTextField(25);
		//mettiamo button
		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(this);
		panel.add(lblEtichetta);
		panel.add(txtFile);
		panel.add(btnSalva);
		return panel;
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
			for(int i=0;i<utentiCollegati.size();i++){
				if(i==0) {
					lblStatus.setText(lblStatus.getText() + " \n Connesso con " + utentiCollegati.get(i));
				}
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(!(txtFile.getText().equals(""))) {
				File f;
				if(System.getProperty("os.name").contains("Mac")) {
					f=new File("src/path.txt");
				}
				else {
					f=new File("C:'\'path.txt");
				}
				PrintWriter out=new PrintWriter(new FileWriter(f));
				out.write("");
				out.write(txtFile.getText());
				txtFile.setText("");
				out.close();
			}
			else {
				JOptionPane.showMessageDialog(this, "Non hai inserito nessun valore!\nInserisci un percorso valido","Errore",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
}

