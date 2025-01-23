package patternFactory;

import java.io.*;
import java.util.Base64;
import java.util.logging.Logger;

import patterMVC.Launcher;

public class AttivitaFile implements Attivita{
	
	private String nomeFile;
	private String codificaBase64;
	private static Logger log=Logger.getLogger("mioLog");
	
	public AttivitaFile(String nomeFile,String codificaBase64)  {
		this.nomeFile=nomeFile;
		this.codificaBase64=codificaBase64;
	}
	
	public void eseguiAttivita() {
		log.info("Sto gestendo il file");
		try {
			String nomeFileDecodificato=new String(Base64.getDecoder().decode(nomeFile));
			File file=new File(Launcher.getPathFile()+"\\"+nomeFileDecodificato);
			log.info("Salvo il file "+file.getName());
			FileOutputStream fos = new FileOutputStream(file);
			OutputStream outputStream=new BufferedOutputStream((fos));
			byte  bytes[]=Base64.getDecoder().decode(codificaBase64);
			outputStream.write(bytes);
			outputStream.close();
		}
		catch(Exception e) {
			log.severe("errore durante il salvataggio del file"+e);
		}
	}
}
