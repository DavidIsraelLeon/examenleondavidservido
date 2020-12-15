package ec.edu.ups.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.datos.TicketDao;
import ec.edu.ups.modelo.Ticket;


@Stateless
public class sistemaTransaccionaON implements GestionSistemRemoto{
	@Inject
	private TicketDao daoTicket;
	
	public boolean registarTicket(Ticket ticket) throws Exception {
		if(ticket.getNumeroTick().length()!=3)
			throw new Exception("Ticket ");
		try {
				daoTicket.insert(ticket);
				System.out.println("Empleado creado");

		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro al insertar");
		}
		return true;
		
	}
	public Ticket buscarTicket(String numeroTicket ) throws Exception {
		Ticket ticket = daoTicket.read(numeroTicket);
		System.out.println("BUSQUEDAD Ticket CORRECTA");
		return ticket;
		
	}
	
	public List<Ticket> getTicketT(){
		return daoTicket.getTicket();
		
		
	}
	
}
