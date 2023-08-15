package modelo.jpa;

import javax.persistence.Query;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario autorizar(String nombre, String clave) {
		String sentecia = "SELECT u FROM Usuario u WHERE u.nombre= :nombre AND u.clave= :clave";
		Query query = em.createQuery(sentecia);
		query.setParameter("nombre", "Carlos");
		query.setParameter("clave", "carlos456");

		Usuario personasAutorizada = (Usuario) query.getSingleResult();
		return personasAutorizada;
	}

	
}
