package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String numeroTick;
	
	private Date fechaRegistro;
	

	private String placa;


	private String marca;
	

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
