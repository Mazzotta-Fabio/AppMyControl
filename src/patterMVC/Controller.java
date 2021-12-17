package patterMVC;


import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

import patternFactory.GestoreFactory;

public class Controller implements Runnable{
	private Socket socket;
	private GestoreFactory factory;
	private BufferedReader bufferRead;
	private BufferedWriter bufferWrite;
	private PrintWriter print;
	private View view;
	private Model model;
	private static Logger log=Logger.getLogger("mioLog");
	
	public Controller(Socket socket) throws IOException{
		this.socket=socket;
		bufferWrite=new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		bufferRead=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		print=new PrintWriter(bufferWrite,true);
		model =new Model(socket);
		factory=new GestoreFactory(model);
		view=new View(factory);
	}
	
	public void run(){
		String nome=null;
		try{
			log.info("sono nel metodo");
			String cmd;
			nome=bufferRead.readLine();
			view.aggiornaWindow("Connesso con " + nome);
			print.println(Launcher.getLocalName());
			/*
			while(true) {
				cmd=bufferRead.readLine();
				log.info(cmd);
				if(cmd!=null) {
					if(cmd.equals("0")) {
						break;
					}
					else {
						model.settaValori(cmd);
						view.aggiornaInterfaccia();
					}
				}
				else {
					cmd="";
				}
			}
			*/
			while(!((cmd=bufferRead.readLine()).equals("0"))){
			cmd=bufferRead.readLine();
				log.info(cmd);
				model.settaValori(cmd);
				view.aggiornaInterfaccia();
			}
			view.aggiornaWindow("Rimuovi a " + nome);
		}
		catch(Exception e){
			log.info("Connessione Persa!!!");
			view.aggiornaWindow("Persa con "+nome);
			e.printStackTrace();
		}
		finally{
			try{
				socket.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
