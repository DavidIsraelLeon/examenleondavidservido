package ec.edu.ups.negocio;

import java.sql.SQLException;
import java.util.List;

import ec.edu.ups.modelo.Ticket;

 public interface GestionSistemRemoto {
	public boolean registarTicket(Ticket ticket) throws Exception;
	
 }
 