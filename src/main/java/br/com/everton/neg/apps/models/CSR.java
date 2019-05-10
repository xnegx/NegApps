package br.com.everton.neg.apps.models;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CSR {

	private static BufferedInputStream entradaBuffer;
	
	public static String preparaCSR(String arquivo) throws IOException {	
		InputStream entrada = new FileInputStream(arquivo);
		entradaBuffer = new BufferedInputStream(entrada);
		ByteArrayOutputStream saidaBuffer = new ByteArrayOutputStream();
		int x;
		while((x = entradaBuffer.read()) != -1){
			saidaBuffer.write(x);
		}
		byte[] binariobuff = saidaBuffer.toByteArray();
	    StringBuilder sb = new StringBuilder();
	    for (byte b : binariobuff) {
	        sb.append(String.format("%02X", b));
	    }
		return sb.toString();
				
	}
	
	public static getDecoderCSR(String arquivo) {
		return;
		
	}
	
	
	

	
	

}
