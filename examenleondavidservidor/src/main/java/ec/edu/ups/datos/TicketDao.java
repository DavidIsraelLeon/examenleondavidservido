package ec.edu.ups.datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Ticket;
@Stateless
public class TicketDao {
	
	
	@Inject
	private Connection con;
	
	@Inject
	private EntityManager em;

	public  TicketDao() {
		// TODO Auto-generated constructor stub
	}
	public boolean insert (Ticket ticket) throws SQLException {
		em.persist(ticket);
		return true;
	}
	public Ticket read(String numeroTicket) {
		Ticket ticket = new Ticket();
		ticket = em.find(Ticket.class, ticket);
		return ticket;
	}
	public boolean update (Ticket ticket) {
		em.merge(ticket);
		return true;
	}
	public boolean delete (String numeroTicket) {
		Ticket ticket = this.read(numeroTicket);
		em.remove(ticket);
		return true;
	}
	public List<Ticket> getTicket(){
		String jpql = "SELECT c FROM ticket c";
		Query q = em.createQuery(jpql, Ticket.class);
		List<Ticket> listado = q.getResultList();
		return listado;
	}


}
