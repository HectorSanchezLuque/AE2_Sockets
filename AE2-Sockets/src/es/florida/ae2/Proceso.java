package es.florida.ae2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Proceso implements Runnable {
	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	public Proceso(Socket socket) {
		this.socket = socket;

	}

	static boolean parImpar(int resp) {
		int num = (int) (Math.random() * 10 + 1);
		int result;

		if (num % 2 == 0) {

			result = 0;
		} else {
			result = 1;
		}

		if (result == resp) {

			return (true);

		} else {
			return false;
		}

	}

	// comprueba el ganador indicando si son la 'X' o 'O' y si no devuelve
	// 'continue'
	static String compGanador(String[] board) {
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			// For X winner
			if (line.equals("XXX")) {
				return "X";
			}

			// For O winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		return "continue";
	}

	static String insert_O(String[] tabla) {

		boolean loop = true;
		int pos = 0;
	

		while (loop) {
			pos = (int) (Math.random() * 8);

			if (tabla[pos].equals(" ")) {
				
				tabla[pos] = "O";
				loop = false;

			}

		}
		
		return(tabla[0]+tabla[1]+tabla[2]+tabla[3]+tabla[4]+tabla[5]+tabla[6]+tabla[7]+tabla[8]);
	}

	public void run() {
		// TODO Auto-generated method stub
		String client;
		boolean acierto = false;
		String[] tabla = new String[] {" "," "," "," "," "," "," "," "," "};
		try {
			InputStream is = socket.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);

			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);

			client = bfr.readLine();
			System.err.println("Servidor>> Recivido Info cliente: " + client);

			if (client.length() == 1) {

				acierto = parImpar(Integer.parseInt(client));

				System.out.println("SERVIDOR >> turno del cliente es: " + acierto);

				if (acierto) {

					pw.print("true\n");
					pw.flush();

				} else {
					pw.print(insert_O(tabla)+"\n");
					pw.flush();
				}
				System.err.println("SERVIDOR >> ESPERA DE TABLA");
				client = bfr.readLine();

			}
			// Ver el tema de la tabla si se espera que le envies la tabla o realiza el el
			// primer turno

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> Error.");
		}

	}
}
