package modelo.dto;

import java.io.Serializable;
import modelo.entidades.Usuario;

public class CuentaTotalDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private int propietario;
	private double total;

	public CuentaTotalDTO() {

	}

	public CuentaTotalDTO(int id, String nombre, int propietario, double total) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.propietario = propietario;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPropietario() {
		return propietario;
	}

	public void setPropietario(int propietario) {
		this.propietario = propietario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
