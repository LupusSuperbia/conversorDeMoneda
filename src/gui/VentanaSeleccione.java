package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class VentanaSeleccione extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSeleccione f = new VentanaSeleccione();
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSeleccione() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Conversor de moneda", "Conversor de tempratura"}));
		comboBox.setBounds(71, 81, 287, 36);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(71, 194, 97, 36);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(e -> {
			int opcionesWindow =  comboBox.getSelectedIndex();
				
				switch (opcionesWindow) {
				case 0:
					VentanaConversor conversor = new VentanaConversor();
					setVisible(false);
					conversor.setVisible(true);
					break;
				case 1 : 
					VentanaConversorTemp conversorTem = new VentanaConversorTemp();
					setVisible(false);
					conversorTem.setVisible(true);
					break;
				default:
					break;
				}
		});
		
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(e -> {
			setVisible(false);
		});
		btnNewButton_1.setBounds(261, 194, 97, 36);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(e -> {
			setVisible(false);
		});
		
		JLabel lblNewLabel = new JLabel("Selecione una opcion de conversión");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(71, 63, 278, 14);
		contentPane.add(lblNewLabel);
	}
}
