package gui;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import conversor.ConversorDeMoneda;


public class VentanaConversor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConversorDeMoneda conversor = new ConversorDeMoneda();
	private JPanel panelPrincipal;
	private JTextField textField;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConversor frame = new VentanaConversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaConversor() {
		String[] monedas = {"ARG", "DOLAR", "EURO", "GBP", "JPY", "KRW"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		textField = new JTextField();

		textField.setBounds(87, 112, 223, 40);
		panelPrincipal.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Moneda Origen : ");
		lblNewLabel.setBounds(87, 25, 66, 14);
		panelPrincipal.add(lblNewLabel);

		JLabel lblA = new JLabel("Moneda Destino  : ");
		lblA.setBounds(244, 25, 66, 14);
		panelPrincipal.add(lblA);
		
		JComboBox<String> monedaOrigenCombox = new JComboBox<String>(monedas);
		monedaOrigenCombox.setBounds(87, 50, 89, 40);
		panelPrincipal.add(monedaOrigenCombox);
		
		
		JComboBox<String> monedaDestinoComboBox  = new JComboBox<String>(monedas);
		monedaDestinoComboBox .setBounds(221, 50, 89, 40);
		panelPrincipal.add(monedaDestinoComboBox );
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				while (!isNumber(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Caracter invalido por favor inserte un numero");
					return;
				}
				String num = textField.getText();
				double cantidad = Double.parseDouble(num);
				if(cantidad > 0) {
					conversor.setMoneda(cantidad);
					double tasaCambio = conversor.convertido(monedaOrigenCombox.getSelectedItem().toString(), monedaDestinoComboBox.getSelectedItem().toString());
//				etiquetaCan.setText(getName());
					JOptionPane.showMessageDialog(btnNewButton,  monedaDestinoComboBox.getSelectedItem().toString() +  ": $" + tasaCambio );
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Inserte un monto que sea mayor a 0 porfavor");
				}

			};

			private boolean isNumber(String text) {
				try {
					Double.parseDouble(text);
					return true;
				} catch (NumberFormatException nfe) {
					return false;
				}

			}
		});

		btnNewButton.setBounds(87, 176, 89, 34);
		panelPrincipal.add(btnNewButton);


		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccione f = new VentanaSeleccione();
				setVisible(false);
				f.setVisible(true);
			
			}
		});
		btnNewButton_1.setBounds(226, 176, 89, 34);
		panelPrincipal.add(btnNewButton_1);

		
	}
}
