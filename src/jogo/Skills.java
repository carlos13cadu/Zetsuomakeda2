package jogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Skills {
	/*private int vida = 0;
	private int usedpt = 0;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					skills window = new skills();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public skills() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSkills = new JLabel("Skills:");
		lblSkills.setBounds(179, 11, 46, 14);
		frame.getContentPane().add(lblSkills);
		
		JLabel label = new JLabel(usedpt + " de " + Jogador.ptskill + "");
		label.setBounds(214, 11, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblVida = new JLabel("Vida: ");
		lblVida.setBounds(20, 66, 36, 14);
		frame.getContentPane().add(lblVida);
		
		JLabel labelvida = new JLabel("0");
		labelvida.setBounds(56, 66, 16, 14);
		frame.getContentPane().add(labelvida);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(usedpt < Jogador.ptskill) {
					vida++;
					usedpt++;
					labelvida.setText(vida+"");
				}
			}
		});
		button.setBounds(82, 62, 41, 23);
		frame.getContentPane().add(button);
		
	}*/
}
