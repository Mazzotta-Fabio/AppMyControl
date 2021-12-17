package patterMVC;

import interfacciaGrafica.WindowServerApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

public class Launcher {
	
	private static Logger log=Logger.getLogger("mioLog");
	private static ServerSocket serversocket;
	private static WindowServerApp frame;
	
	
	public static void main(String [] args){
		frame=new WindowServerApp();
		try{
			serversocket = new ServerSocket(8004);
			while(true){
				Socket s=serversocket.accept();
				Controller c= new Controller(s);
				Thread threadStart=new Thread(c);
				log.info("sono in lancio thread");
				threadStart.start();
			}
		}
		
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getLocalName(){
		try{
			InetAddress host = InetAddress.getLocalHost();
			InetAddress [] address = InetAddress.getAllByName(host.getHostName());
			for(int i=0;i<address.length;i++) {
				if((!(address[i].toString().contains("127.0.0.1")))&&(!(address[i].toString().contains(":")))) {
					return (address[i].toString().split("/").length==2 ? address[i].toString().split("/")[1] : address[0].toString()) ;
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "Non sei connesso!!";
	}
	
	public static String getPathFile() throws IOException {
		BufferedReader bf;
		if(System.getProperty("os.name").contains("Mac")) {
			bf=new BufferedReader(new FileReader(new File("src/path.txt")));
		}
		else {
			bf=new BufferedReader(new FileReader(new File("C:'\'path.txt")));
		}
		String path=bf.readLine();
		String [] elements=path.split("/");
		path="";
		for(int i=0;i<elements.length;i++) {
			path=path+elements[i]+(i==elements.length-1 ? "":File.separator);
		}
		bf.close();
		log.info(path);
		return path;
	}
	
	public static WindowServerApp getFrame(){
		return frame;
	}
}
