package modelo.dao;

import java.util.List;

import modelo.dto.CategoriaTotalDTO;
import modelo.entidades.Movimiento;

public interface MovimientoDAO extends GenericDAO<Movimiento, Integer>{
	
	public List<CategoriaTotalDTO> getTotalByCategoria(int mes);
}
