package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.CategoriaDAO;
import modelo.entidades.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriaDAO{

	public JPACategoriaDAO() {
		super(Categoria.class);
	}

	@Override
	public List<Categoria> getAllTipoIngreso() {
		String sql = "SELECT * FROM categoria WHERE tipo = 0;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		
		return (List<Categoria>) query.getResultList();
	}

	@Override
	public List<Categoria> getAllTipoEgreso() {
		String sql = "SELECT * FROM categoria WHERE tipo = 1;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		
		return (List<Categoria>) query.getResultList();
	}

	@Override
	public List<Categoria> getAllTipoTransferencia() {
		String sql = "SELECT * FROM categoria WHERE tipo = 2;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		
		return (List<Categoria>) query.getResultList();
	}

	@Override
	public List<Categoria> getAllByPersona(int idPersona) {
		String sql = "SELECT * FROM categoria WHERE propietario = ?;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		query.setParameter(1, idPersona);
		
		return (List<Categoria>) query.getResultList();
		
	}

}
