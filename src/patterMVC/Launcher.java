package patterMVC;

import interfacciaGrafica.WindowServerApp;
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
		    return address[2].getHostAddress();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static WindowServerApp getFrame(){
		return frame;
	}
}
