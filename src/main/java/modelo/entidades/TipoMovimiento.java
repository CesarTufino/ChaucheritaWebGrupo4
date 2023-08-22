package modelo.entidades;

public enum TipoMovimiento {
	INGRESO(1,"Ingreso"),
	EGRESO(2,"Egreso");
	//TRANSFERENCIA(3,"Transferencia"),
	
	private int id;
	private String descripcion;
	
	private TipoMovimiento(int id, String descripcion) {
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
