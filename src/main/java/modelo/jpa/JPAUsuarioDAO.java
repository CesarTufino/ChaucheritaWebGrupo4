package modelo.jpa;

import javax.persistence.Query;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario autorizar(String username, String clave) {
		String sentecia = "SELECT u FROM Usuario u WHERE u.username= :username AND u.clave= :clave";
		Query query = em.createQuery(sentecia);
		query.setParameter("username", username);
		query.setParameter("clave", clave);

		Usuario usuarioAutorizado = (Usuario) query.getSingleResult();
		return usuarioAutorizado;
	}

	
}
