package modelo.jpa;

import javax.persistence.Query;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO{

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@Override
	public Persona autorizar(String usuario, String clave) {
		String sentecia = "SELECT p FROM Persona p WHERE p.usuario= :usuario AND p.clave= :clave";
		Query query = em.createQuery(sentecia);
		query.setParameter("usuario", usuario);
		query.setParameter("clave", clave);

		Persona usuarioAutorizado = (Persona) query.getSingleResult();
		return usuarioAutorizado;
	}

	
}
