package modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "valor")
	private double valor;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cuenta")
	private Cuenta cuenta;
	private TipoMovimiento tipo;

	public Movimiento() {

	}
	
	public Movimiento(int id, String descripcion, double valor, Categoria categoria, TipoMovimiento tipo,
			Cuenta cuenta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valor = valor;
		this.categoria = categoria;
		this.tipo = tipo;
		this.cuenta = cuenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
