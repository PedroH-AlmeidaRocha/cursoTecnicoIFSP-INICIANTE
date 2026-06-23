package jogodavelha;

import javax.swing.*;
import java.awt.event.*;

public class Tela extends JFrame {
	int numero = 0;
	int jogadas = 0;

	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

	public Tela() {
		setSize(500, 500);
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		init();
		setVisible(true);
	}

	private void init() {
		btn1 = new JButton();
		btn1.setBounds(100, 150, 70, 70);
		add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn1.setText("X");
					numero = 1;
				} else {
					btn1.setText("O");
					numero = 0;
				}
				btn1.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn2 = new JButton();
		btn2.setBounds(200, 150, 70, 70);
		add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn2.setText("X");
					numero = 1;
				} else {
					btn2.setText("O");
					numero = 0;
				}
				btn2.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn3 = new JButton();
		btn3.setBounds(300, 150, 70, 70);
		add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn3.setText("X");
					numero = 1;
				} else {
					btn3.setText("O");
					numero = 0;
				}
				btn3.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn4 = new JButton();
		btn4.setBounds(100, 250, 70, 70);
		add(btn4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn4.setText("X");
					numero = 1;
				} else {
					btn4.setText("O");
					numero = 0;
				}
				btn4.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn5 = new JButton();
		btn5.setBounds(200, 250, 70, 70);
		add(btn5);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn5.setText("X");
					numero = 1;
				} else {
					btn5.setText("O");
					numero = 0;
				}
				btn5.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn6 = new JButton();
		btn6.setBounds(300, 250, 70, 70);
		add(btn6);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn6.setText("X");
					numero = 1;
				} else {
					btn6.setText("O");
					numero = 0;
				}
				btn6.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn7 = new JButton();
		btn7.setBounds(100, 350, 70, 70);
		add(btn7);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn7.setText("X");
					numero = 1;
				} else {
					btn7.setText("O");
					numero = 0;
				}
				btn7.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn8 = new JButton();
		btn8.setBounds(200, 350, 70, 70);
		add(btn8);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn8.setText("X");
					numero = 1;
				} else {
					btn8.setText("O");
					numero = 0;
				}
				btn8.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});

		btn9 = new JButton();
		btn9.setBounds(300, 350, 70, 70);
		add(btn9);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numero == 0) {
					btn9.setText("X");
					numero = 1;
				} else {
					btn9.setText("O");
					numero = 0;
				}
				btn9.setEnabled(false);
				jogadas++;
				verificarGanhador();
			}
		});
	}

	private void verificarGanhador() {
		// LINHAS
		if ((btn1.getText().equals("X") || btn1.getText().equals("O")) &&
		    btn1.getText().equals(btn2.getText()) &&
		    btn2.getText().equals(btn3.getText())) {
			mostrarGanhador(btn1.getText());
			return;
		}

		if ((btn4.getText().equals("X") || btn4.getText().equals("O")) &&
		    btn4.getText().equals(btn5.getText()) &&
		    btn5.getText().equals(btn6.getText())) {
			mostrarGanhador(btn4.getText());
			return;
		}

		if ((btn7.getText().equals("X") || btn7.getText().equals("O")) &&
		    btn7.getText().equals(btn8.getText()) &&
		    btn8.getText().equals(btn9.getText())) {
			mostrarGanhador(btn7.getText());
			return;
		}

		// COLUNAS
		if ((btn1.getText().equals("X") || btn1.getText().equals("O")) &&
		    btn1.getText().equals(btn4.getText()) &&
		    btn4.getText().equals(btn7.getText())) {
			mostrarGanhador(btn1.getText());
			return;
		}

		if ((btn2.getText().equals("X") || btn2.getText().equals("O")) &&
		    btn2.getText().equals(btn5.getText()) &&
		    btn5.getText().equals(btn8.getText())) {
			mostrarGanhador(btn2.getText());
			return;
		}

		if ((btn3.getText().equals("X") || btn3.getText().equals("O")) &&
		    btn3.getText().equals(btn6.getText()) &&
		    btn6.getText().equals(btn9.getText())) {
			mostrarGanhador(btn3.getText());
			return;
		}

		// DIAGONAIS
		if ((btn1.getText().equals("X") || btn1.getText().equals("O")) &&
		    btn1.getText().equals(btn5.getText()) &&
		    btn5.getText().equals(btn9.getText())) {
			mostrarGanhador(btn1.getText());
			return;
		}

		if ((btn3.getText().equals("X") || btn3.getText().equals("O")) &&
		    btn3.getText().equals(btn5.getText()) &&
		    btn5.getText().equals(btn7.getText())) {
			mostrarGanhador(btn3.getText());
			return;
		}

		// EMPATE
		if (jogadas == 9) {
			mostrarEmpate();
		}
	}

	private void mostrarGanhador(String vencedor) {
		JOptionPane.showMessageDialog(this, "O vencedor é: " + vencedor);
		desabilitarTodos();
	}

	private void mostrarEmpate() {
		JOptionPane.showMessageDialog(this, "Empate!");
		desabilitarTodos();
	}

	private void desabilitarTodos() {
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
	}
}
