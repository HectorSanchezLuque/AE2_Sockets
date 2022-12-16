package es.florida.ae2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Cliente extends JFrame {

	private boolean primero;
	private static int x;
	private JPanel contentPane;
	private static JButton btn1;
	private static JButton btn2;
	private static JButton btn3;
	private static JButton btn4;
	private static JButton btn5;
	private static JButton btn6;
	private static JButton btn7;
	private static JButton btn8;
	private static JButton btn9;

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public void setBtn6(JButton btn6) {
		this.btn6 = btn6;
	}

	public JButton getBtn7() {
		return btn7;
	}

	public void setBtn7(JButton btn7) {
		this.btn7 = btn7;
	}

	public JButton getBtn8() {
		return btn8;
	}

	public void setBtn8(JButton btn8) {
		this.btn8 = btn8;
	}

	public JButton getBtn9() {
		return btn9;
	}

	public void setBtn9(JButton btn9) {
		this.btn9 = btn9;
	}

	public String espaciosTablero() {
		String espacios = btn1.getText() + btn2.getText() + btn3.getText() + btn4.getText() + btn5.getText() + btn6.getText() + btn7.getText() + btn8.getText() + btn9.getText();
		return espacios;
	}
	
	public static void setBotones(String posiciones) {
		
		String[] pos = posiciones.split("");
		
		for (int i = 0; i < pos.length; i++) {
			if(i == 0) {
				btn1.setText(pos[i]);
			}
			if(i == 1) {
				btn2.setText(pos[i]);
			}
			if(i == 2) {
				btn3.setText(pos[i]);
			}
			if(i == 3) {
				btn4.setText(pos[i]);
			}
			if(i == 4) {
				btn5.setText(pos[i]);
			}
			if(i == 5) {
				btn6.setText(pos[i]);
			}
			if(i == 7) {
				btn8.setText(pos[i]);
			}
			if(i == 8) {
				btn9.setText(pos[i]);
			}
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		boolean login = true;
		try {

			String[] options = {"par", "impar"};

	        x = JOptionPane.showOptionDialog(null, "Seleccione si es par o impar","Comienzo de la partida",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Cliente frame = new Cliente();
				frame.setVisible(true);
				try {
					System.out.println("CLIENTE >>> Arranca cliente");
					System.out.println("CLIENTE >>> Conexion con el servidor");
					InetSocketAddress direccion = new InetSocketAddress("localhost", 1234);
					Socket socket = new Socket();
					socket.connect(direccion);
					InputStream is = socket.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader bfr = new BufferedReader(isr);
					System.out.println("CLIENTE >>> Envío de la elección");
					PrintWriter pw = new PrintWriter(socket.getOutputStream());
					pw.print(x + "\n");
					pw.flush();
					System.out.println("CLIENTE >>> Recibe resultado del servidor");
					String resultado = bfr.readLine();
					if (resultado.length() == 9) {
						setBotones(resultado);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 498, 369);
		contentPane.add(panel);
		panel.setLayout(null);

		btn1 = new JButton(" ");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn1.getText().equals(" ")) {
					btn1.setText("X");
				}
			}
		});
		btn1.setBounds(0, 0, 166, 113);
		panel.add(btn1);

		btn2 = new JButton(" ");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn2.getText().equals(" ")) {
					btn2.setText("X");
				}
			}
		});
		btn2.setBounds(166, 0, 166, 113);
		panel.add(btn2);

		btn3 = new JButton(" ");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn3.getText().equals(" ")) {
					btn3.setText("X");
				}
			}
		});
		btn3.setBounds(332, 0, 166, 113);
		panel.add(btn3);

		btn4 = new JButton(" ");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn4.getText().equals(" ")) {
					btn4.setText("X");
				}
			}
		});
		btn4.setBounds(0, 129, 166, 113);
		panel.add(btn4);

		btn5 = new JButton(" ");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn5.getText().equals(" ")) {
					btn5.setText("X");
				}
			}
		});
		btn5.setBounds(166, 129, 166, 113);
		panel.add(btn5);

		btn6 = new JButton(" ");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn6.getText().equals(" ")) {
					btn6.setText("X");
				}
			}
		});
		btn6.setBounds(332, 129, 166, 113);
		panel.add(btn6);

		btn7 = new JButton(" ");
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn7.getText().equals(" ")) {
					btn7.setText("X");
				}
			}
		});
		btn7.setBounds(0, 258, 166, 113);
		panel.add(btn7);

		btn8 = new JButton(" ");
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn8.getText().equals(" ")) {
					btn8.setText("X");
				}
			}
		});
		btn8.setBounds(166, 258, 166, 113);
		panel.add(btn8);

		btn9 = new JButton(" ");
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn9.getText().equals(" ")) {
					btn9.setText("X");
				}
			}
		});
		btn9.setBounds(332, 258, 166, 113);
		panel.add(btn9);
	}
}
