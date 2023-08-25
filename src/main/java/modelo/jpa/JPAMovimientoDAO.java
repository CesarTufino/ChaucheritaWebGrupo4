package modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import modelo.dao.MovimientoDAO;
import modelo.dto.CategoriaTotalDTO;
import modelo.dto.CuentaTotalDTO;
import modelo.entidades.Movimiento;
import modelo.entidades.Tipo;

public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO{

	public JPAMovimientoDAO() {
		super(Movimiento.class);
	}

	@Override
	public List<CategoriaTotalDTO> getTotalPorCategorias(int mes) {
		String sql = "Select c.id, nombre, tipo, sum(valor) as 'total' from movimiento m JOIN categoria c on m.categoria = c.id where month(fecha) = ? GROUP BY c.id, nombre, tipo;";
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, mes);
		List<Object[]> resultados = query.getResultList();
		List<CategoriaTotalDTO> categoriasTotalDTO = new ArrayList<>();
	    
		for (Object[] resultado : resultados) {
		    CategoriaTotalDTO dto = new CategoriaTotalDTO();
		    dto.setId((int) resultado[0]);
		    dto.setNombre((String) resultado[1]);
		    dto.setTipo((int) resultado[2]);
		    dto.setTotal((double) resultado[3]);
		    categoriasTotalDTO.add(dto);
		}
		return categoriasTotalDTO;
	}

	@Override
	public List<CuentaTotalDTO> getTotalPorCuenta() {
		String sql = "Select c.id, nombre, propietario, sum(valor) as 'total' from movimiento m JOIN cuenta c on m.cuenta = c.ID GROUP BY c.id, nombre, propietario;";
		Query query = em.createNativeQuery(sql);
		
		List<CuentaTotalDTO> cuentasTotalesDTO = new ArrayList<>();
		List<Object[]> resultados = query.getResultList();
	    for (Object[] resultado : resultados) {
	        CuentaTotalDTO cuentaTotalDTO = new CuentaTotalDTO();
	        cuentaTotalDTO.setId((int) resultado[0]);
	        cuentaTotalDTO.setNombre((String) resultado[1]);
	        cuentaTotalDTO.setPropietario((int) resultado[2]);
	        cuentaTotalDTO.setTotal((double) resultado[3]);
	        cuentasTotalesDTO.add(cuentaTotalDTO);
	    }
	    return cuentasTotalesDTO;
	}

	@Override
	public List<Movimiento> getAllByCuenta(int idCuenta) {
		String sql = "SELECT * FROM movimiento WHERE cuenta = ?;";
		Query query = em.createNativeQuery(sql, Movimiento.class);
		query.setParameter(1, idCuenta);
		
		return (List<Movimiento>)query.getResultList();
	}

	@Override
	public List<Movimiento> getAllByMes(int mes) {
		String sql = "SELECT * FROM movimiento WHERE month(fecha) = ?;";
		Query query = em.createNativeQuery(sql, Movimiento.class);
		query.setParameter(1, mes);
		
		return (List<Movimiento>)query.getResultList();
	}

	@Override
	public List<Movimiento> getAllByCuentaByMes(int idCuenta, int mes) {
		String sql = "SELECT * FROM movimiento WHERE month(fecha) = ? and cuenta = ?;";
		Query query = em.createNativeQuery(sql, Movimiento.class);
		query.setParameter(1, mes);
		query.setParameter(2, idCuenta);
		
		return (List<Movimiento>) query.getResultList();
	}

}
