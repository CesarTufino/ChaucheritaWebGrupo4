package modelo.entidades;

public enum Tipo {
	INGRESO(0,"Ingreso"),
	EGRESO(1,"Egreso"),
	TRANSFERENCIA(2,"Transferencia");
	
	private int id;
	private String descripcion;
	
	private Tipo(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
