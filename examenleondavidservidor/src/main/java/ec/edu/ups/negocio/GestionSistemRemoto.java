package ec.edu.ups.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.modelo.Ticket;

@Remote
public interface GestionSistemRemoto {
	public boolean registarTicket(Ticket ticket) throws Exception;
	

}
