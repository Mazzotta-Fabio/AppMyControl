package patternFactory;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class AttivitaFile implements Attivita{
	
	private Socket socket;
	private String path;
	private static Logger log=Logger.getLogger("mioLog");
	
	public AttivitaFile(Socket socket,String path) throws FileNotFoundException {
		this.socket=socket;
		this.path=path;
	}
	
	public void eseguiAttivita() {
		try {
			BufferedReader bufferRead=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			String nomeFile;
			//log.info(bufferRead.readLine());
			while((nomeFile=bufferRead.readLine())!=null) {
				File file=new File(path+File.separator+nomeFile);
				log.info(path+File.separator+nomeFile);
				FileOutputStream fos = new FileOutputStream(file);
				int  bytes;
				byte[] buffer = new byte[4*1024];
				while ((bytes = dataInputStream.read(buffer)) != -1) {
					fos.write(buffer,0,bytes);
		        //size -= bytes;      // read upto file size
				}
				/*
		        bytes=dataInputStream.read(buffer);
		        if(bytes!=-1) {
		        	 fos.write(buffer,0,bytes);
		        }
		        */
				fos.close();
			}
			dataInputStream.close();
			
			/*
			long size = dataInputStream.readLong();// read file size
	        log.info("DIMENSIONE FILE:" +size);
	        while (size > 0 && (bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
	            fos.write(buffer,0,bytes);
	            size -= bytes;      // read upto file size
	        }
	        /*
	        while ((bytes = dataInputStream.read(buffer)) != -1) {
	            fos.write(buffer,0,bytes);
	            //size -= bytes;      // read upto file size
	        }
	        //bytes=dataInputStream.read(buffer);
	        dataInputStream.close();
	        fos.close();
			/*
			//File file=new File(path+File.separator+nomeFile);
			//file.createNewFile();
			//FileOutputStream fos = new FileOutputStream(file);
			//DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
			int bytes=0;
			byte [] buffer=new byte[4*1024];
			//log.info("sono prima del ciclo");
			while((bytes=socket.getInputStream().read(buffer))!=1) {
	        	fos.write(buffer,0,bytes);
	        }
			log.info("Ho finito di leggere il file");
			fos.close();
			/*
			while ((bytes = dataInputStream.read(buffer)) != -1) {
				log.info("byte Letti"+bytes);
				fos.write(buffer,0,bytes);
	            dimensioneFile -= bytes;      // read upto file size
	        }
			fos.close();
			log.info("sono dopo del ciclo");
			/*
			byte[] bytes = new byte[(int)dimensioneFile];
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			InputStream is=socket.getInputStream();
			int byteRead=is.read(bytes);
			bos.write(bytes,0,dimensioneFile);
			bos.close();
			/*
			DataInputStream in2 = new DataInputStream(new BufferedInputStream(stream));
		   
		    int count,i=0;
		    while((count=in2.read(bytes))>0) {
		    	i=i+count;
		    	fos.write(bytes);
		    }
		    
		    fos.close();
		    in2.close();
			/*
			PrintStream os=new PrintStream(new BufferedOutputStream(fos));
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			while((line=br.readLine())!=null) {
				os.write(line.getBytes());
			}
			fos.close();
			/*
			byte dati[]=new byte[16*1024];
			int read,i=0;
			while ((read = in.read(dati)) > 0) {
				//log.info("sono nel ciclo");
				fos.write(dati, 0, read);
				i=i+read;
			}
			in.close();
			fos.close();
			bf.close();
			log.info("DIMENSIONE del file: "+i);
			*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
