package modelo.dao;

import java.util.List;

import modelo.dto.CategoriaTotalDTO;
import modelo.dto.MovimientoDTO;
import modelo.entidades.Movimiento;

public interface MovimientoDAO extends GenericDAO<Movimiento, Integer>{
	
	public List<CategoriaTotalDTO> getCategoriasConTotalByMesByPersona(int mes, int idPropietario);
	public List<Movimiento> getAllByCuenta(int idCuenta);
	public List<Movimiento> getAllByMes(int mes);
	public List<Movimiento> getAllByCuentaByMes(int idCuenta, int mes);
	public List<MovimientoDTO> getAllByPesonaByMes(int idPersona, int mes);
	public List<MovimientoDTO> getAllByPersona(int idPersona);
}
