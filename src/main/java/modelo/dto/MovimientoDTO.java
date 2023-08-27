package modelo.dto;

import java.io.Serializable;
import java.util.Date;
import modelo.entidades.Categoria;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;

public class MovimientoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String concepto;
	private double valor;
	private Date fecha;
	private Categoria categoria;
	private Cuenta cuenta;
	private Movimiento relacion;
	
	public MovimientoDTO(int id, String concepto, double valor, Date fecha, Categoria categoria, Cuenta cuenta,
			Movimiento relacion) {
		super();
		this.id = id;
		this.concepto = concepto;
		this.valor = valor;
		this.fecha = fecha;
		this.categoria = categoria;
		this.cuenta = cuenta;
		this.relacion = relacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Movimiento getRelacion() {
		return relacion;
	}

	public void setRelacion(Movimiento relacion) {
		this.relacion = relacion;
	}
	
	
	
	

}
