package es.florida.ae2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Proceso implements Runnable {
	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;
	static Boolean turno;

	public Boolean getPrimerTurno() {
		return turno;
	}

	public static void setTurno(Boolean primerTurno) {
		turno = primerTurno;
	}

	public Proceso(Socket socket) {
		this.socket = socket;
		turno = false;
	}

	static void parImpar(Socket socket, BufferedReader bfr, PrintWriter pw, String resp) {
		int num = (int) (Math.random() * 10 + 1);
		String result;
		
		if(num % 2 == 0) {
			
			result ="par";
		}else {
			result="impar";
		}
		
		if(result.equals(resp.toLowerCase())) {
			
			setTurno(true);
			
		}
	
		
		
	}

	public void run() {
		// TODO Auto-generated method stub
		String[] tabla;
		try {
			InputStream is = socket.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);

			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);

			tabla = bfr.readLine().split("");

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> Error.");
		}

	}
}
