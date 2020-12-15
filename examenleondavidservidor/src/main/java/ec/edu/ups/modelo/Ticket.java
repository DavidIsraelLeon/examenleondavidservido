package ec.edu.ups.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name= "ticket")
public class Ticket {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=10, nullable=false)
	private String numeroTick;
	
	@Column(length=10, nullable=false)
	private Date fechaRegistro;
	

	@Column(length=30, nullable=false)
	private String placa;

	@Column(length=30, nullable=false)
	private String marca;
	
	@Column(length=30, nullable=false)
	private String modelo ;

	public String getNumeroTick() {
		return numeroTick;
	}

	public void setNumeroTick(String numeroTick) {
		this.numeroTick = numeroTick;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
