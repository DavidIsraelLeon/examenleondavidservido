package ec.edu.ups.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;

public class VentanaCrearTicket {

	private JFrame frame;
	private JTextField texTicket;
	private JTextField txtFecha;
	private JTextField textMarcaVehiculo;
	private JTextField txtModelo;
	private JTextField txtPlaca;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearTicket window = new VentanaCrearTicket();
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
	public VentanaCrearTicket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setBounds(21, 41, 46, 14);
		frame.getContentPane().add(lblTicket);
		
		texTicket = new JTextField();
		texTicket.setBounds(77, 38, 86, 20);
		frame.getContentPane().add(texTicket);
		texTicket.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(21, 86, 46, 14);
		frame.getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(77, 83, 86, 20);
		frame.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblMarcaVehiculo = new JLabel("Marca");
		lblMarcaVehiculo.setBounds(21, 127, 46, 14);
		frame.getContentPane().add(lblMarcaVehiculo);
		
		textMarcaVehiculo = new JTextField();
		textMarcaVehiculo.setBounds(77, 124, 86, 20);
		frame.getContentPane().add(textMarcaVehiculo);
		textMarcaVehiculo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(198, 41, 46, 14);
		frame.getContentPane().add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(258, 38, 86, 20);
		frame.getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblPlacaVehiculo = new JLabel("Placa");
		lblPlacaVehiculo.setBounds(198, 86, 46, 14);
		frame.getContentPane().add(lblPlacaVehiculo);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(258, 83, 86, 20);
		frame.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(136, 203, 89, 23);
		frame.getContentPane().add(btnAceptar);
	}
}
