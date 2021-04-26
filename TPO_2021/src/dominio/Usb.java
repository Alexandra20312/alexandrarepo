package dominio;

import java.io.*;

public class Usb {
	
	//Directorio de trabajo temporal
	File dir = new File("C:\\Temp\\");

	public boolean tieneTxt() {
		return revisarExtension(".txt");
	}
	
	
	public boolean tieneJpg() {
		return revisarExtension(".jpg");
	}
	
	public int espacioOcupado() {
		return (int) revisarEspacioOcupado(dir);
	}	

	public void copiar(Archivo archivo) {
		try {
			RandomAccessFile file = new RandomAccessFile((dir.toString()+"\\") + (archivo.nombre()!=""?archivo.nombre():"prueba.txt"), "rw");
			file.setLength((archivo.tamanio()>0?archivo.tamanio():0));
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private boolean revisarExtension(String tipoArchivo) {
		boolean res = false;
		String[] listaArchivos = dir.list();
		for (int x=0;x<listaArchivos.length;x++) {
			if(listaArchivos[x].contains(tipoArchivo))
				res = true;
		}
		return res;
	}
	
	private long revisarEspacioOcupado(File directorio) { 
		long length = 0; 
		for (File file : directorio.listFiles()) { 
			if (file.isFile()) 
				length += file.length(); 
			else length += revisarEspacioOcupado(file); 
		} 
		return length; 
	}
	
}
