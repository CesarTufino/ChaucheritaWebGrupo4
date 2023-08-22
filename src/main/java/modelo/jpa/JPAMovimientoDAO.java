package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.MovimientoDAO;
import modelo.dto.CategoriaTotalDTO;
import modelo.entidades.Movimiento;

public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO{

	public JPAMovimientoDAO() {
		super(Movimiento.class);
	}

	@Override
	public List<CategoriaTotalDTO> getTotalByCategoria(int mes) {
		String sql = "Select categoria.id, categoria.nombre, categoria.tipo, sum(valor) as 'total' from movimiento where fecha.mes = mes groupby categoria";
		Query query = em.createQuery(sql);
		query.setParameter("mes", mes);
		
		return (List<CategoriaTotalDTO>) query.getResultList();
	}
	

}
