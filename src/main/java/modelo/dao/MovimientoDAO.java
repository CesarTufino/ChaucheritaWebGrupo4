package modelo.dao;

import java.util.List;

import modelo.dto.CategoriaTotalDTO;
import modelo.dto.CuentaTotalDTO;
import modelo.entidades.Movimiento;

public interface MovimientoDAO extends GenericDAO<Movimiento, Integer>{
	
	public List<CategoriaTotalDTO> getTotalPorCategorias(int mes);
	public List<CuentaTotalDTO> getTotalPorCuentas();
	public List<Movimiento> getAllByCuenta(int idCuenta);
	public List<Movimiento> getAllByMes(int mes);
	public List<Movimiento> getAllByCuentaByMes(int idCuenta, int mes);
}
