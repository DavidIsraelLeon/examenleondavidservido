package ec.edu.ups.vista;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ec.edu.ups.modelo.Ticket;
import ec.edu.ups.negocio.GestionSistemRemoto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearTicket {

	private JFrame frame;
	private JTextField txtTicket;
	private JTextField txtFecha;
	private JTextField txtMarcaVehiculo;
	private JTextField txtModelo;
	private JTextField txtPlaca;

	/**
	 * Launch the application.
	 */
	private GestionSistemRemoto remoto;
	private int longitudByte;
	static VentanaCrearTicket window ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearTicket window = new VentanaCrearTicket();
					window.frame.setVisible(true);
					window.referenciarOnEmpleado();
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
		
		txtTicket = new JTextField();
		txtTicket.setBounds(77, 38, 86, 20);
		frame.getContentPane().add(txtTicket);
		txtTicket.setColumns(10);
		
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
		
		txtMarcaVehiculo = new JTextField();
		txtMarcaVehiculo.setBounds(77, 124, 86, 20);
		frame.getContentPane().add(txtMarcaVehiculo);
		txtMarcaVehiculo.setColumns(10);
		
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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCliente();
			}
		});
		btnAceptar.setBounds(136, 203, 89, 23);
		frame.getContentPane().add(btnAceptar);
	}
	private void guardarCliente() {
		Ticket ticket = new Ticket();
		ticket.setNumeroTick(txtTicket.getText());
		
		ticket.setMarca(txtMarcaVehiculo.getText());
		ticket.setModelo(txtModelo.getText());
		ticket.setPlaca(txtPlaca.getText());
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date fechaact = null;
        try {
            Calendar fecha = new GregorianCalendar();
            String anio = String.valueOf(fecha.get(Calendar.YEAR));
            String mes = String.valueOf(fecha.get(Calendar.MONTH) + 1);
            String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
            Date myDate = formatter.parse(txtFecha.getText());
            Date dateac = formatter.parse(anio + "-" + mes + "-" + dia);
            date = new java.sql.Date(myDate.getTime());
            fechaact = new java.sql.Date(dateac.getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ingrese una fecha valida : " + e);
        }
        ticket.setFechaRegistro(date);
        
		try {
			remoto.registarTicket(ticket);
			System.out.println("Ticket GUARDADO");
		}catch(Exception e) {
			
			System.out.println("ERROR GUARDAR TICKET :  ---->"+" "+ e.getMessage()+ "" );
			
		}
	}
	
	public void referenciarOnEmpleado() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "examenremoto");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "examenremoto");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/examenleondavidservidor/sistemaTransaccionaON!ec.edu.ups.negocio.GestionSistemRemoto";
            
            this.remoto = (GestionSistemRemoto) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
}
