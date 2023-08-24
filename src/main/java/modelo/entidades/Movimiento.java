package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "concepto")
	private String concepto;
	@Column(name = "valor")
	private double valor;
	@Column(name = "fecha")
	private Date fecha;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cuenta")
	private Cuenta cuenta;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "relacion")
	private Movimiento relacion;


	public Movimiento() {

	}
	
	public Movimiento(int id, String descripcion, double valor, Categoria categoria, TipoMovimiento tipo,
			Cuenta cuenta) {
		this.id = id;
		this.concepto = descripcion;
		this.valor = valor;
		this.categoria = categoria;
		this.cuenta = cuenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return concepto;
	}

	public void setDescripcion(String descripcion) {
		this.concepto = descripcion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cuenta getCuentaOrigen() {
		return cuenta;
	}

	public void setCuentaOrigen(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}
