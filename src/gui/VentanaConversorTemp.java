package gui;

import java.awt.EventQueue;
import java.util.function.DoubleUnaryOperator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversor.ConversorDeTemp;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.function.DoubleUnaryOperator;

public class VentanaConversorTemp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConversorTemp frame = new VentanaConversorTemp();
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
	public VentanaConversorTemp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox temperaturaOrigen = new JComboBox();
		temperaturaOrigen.setFont(new Font("Tahoma", Font.BOLD, 11));
		temperaturaOrigen.setModel(new DefaultComboBoxModel(new String[] { "Celsius", "Fahrenheit", "Kelvin" }));
		temperaturaOrigen.setBackground(Color.LIGHT_GRAY);
		temperaturaOrigen.setBounds(75, 75, 82, 44);
		contentPane.add(temperaturaOrigen);

		JComboBox temperaturaDestino = new JComboBox();
		temperaturaDestino.setFont(new Font("Tahoma", Font.BOLD, 11));
		temperaturaDestino.setModel(new DefaultComboBoxModel(new String[] { "Celsius", "Fahrenheit", "Kelvin" }));
		temperaturaDestino.setBackground(Color.LIGHT_GRAY);
		temperaturaDestino.setBounds(262, 75, 82, 44);
		contentPane.add(temperaturaDestino);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(234, 192, 110, 38);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(e -> {
			VentanaSeleccione f = new VentanaSeleccione();
			setVisible(false);
			f.setVisible(true);
		});

		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(64, 192, 110, 38);
		contentPane.add(btnConvertir);
		btnConvertir.addActionListener(e -> {
			ConversorDeTemp conversorTemp = new ConversorDeTemp();
			String mensajeError = "";
			if (textField.getText().isEmpty()) {
				mensajeError = "El campo esta vacio porfavor ingrese una cantidad";
			} 
			if(!isNumber(textField.getText())) {
				mensajeError = "Porfavor ingrese un numero";
			}
			
			if(!mensajeError.isEmpty()) {
				JOptionPane.showMessageDialog(btnConvertir, mensajeError);
				return;
			}
			
			double cant = Double.parseDouble(textField.getText());
			String destino = (String) temperaturaDestino.getSelectedItem();
			String origen = (String) temperaturaOrigen.getSelectedItem();
				if(temperaturaOrigen.getSelectedItem().equals(temperaturaDestino.getSelectedItem())){
					JOptionPane.showMessageDialog(btnConvertir, cant + " " + temperaturaOrigen.getSelectedItem());
				} else {
					double temperaturaConvertida = 0;
					switch (origen) {
					case "Celsius" : 
						 if (destino.equals("Fahrenheit")) {
				                temperaturaConvertida = conversorTemp.conversorTemp("CtoF", cant);
				            } else if (destino.equals("Kelvin")) {
				                temperaturaConvertida = conversorTemp.conversorTemp("CtoK", cant);
				            }
				            break;
						
					case "Fahrenheit":
						 if (destino.equals("Celsius")) {
				                temperaturaConvertida = conversorTemp.conversorTemp("FtoC", cant);
				            } else if (destino.equals("Kelvin")) {
				            	System.out.println(cant);
				                temperaturaConvertida = conversorTemp.conversorTemp("FtoK", cant);
				            }
				            break;
						
					case "Kelvin":
						 if (destino.equals("Fahrenheit")) {
				                temperaturaConvertida = conversorTemp.conversorTemp("KtoF", cant);
				            } else if (destino.equals("Celsius")) {
				                temperaturaConvertida = conversorTemp.conversorTemp("KtoC", cant);
				            }
				            break;
					}
					 JOptionPane.showMessageDialog(btnConvertir, temperaturaConvertida + " " + destino);
				
				}
				
				
		});

		textField = new JTextField();
		textField.setToolTipText("Temperatura");
		textField.setBounds(75, 156, 269, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Temperatura");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(75, 131, 82, 14);
		contentPane.add(lblNewLabel);

	}

	private boolean isNumber(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}

	};
}
