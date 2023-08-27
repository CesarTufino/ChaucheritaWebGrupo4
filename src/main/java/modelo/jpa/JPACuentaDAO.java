package modelo.jpa;

import java.util.List;

import modelo.dao.CuentaDAO;
import modelo.entidades.Cuenta;

public class JPACuentaDAO extends JPAGenericDAO<Cuenta, Integer> implements CuentaDAO{

	public JPACuentaDAO() {
		super(Cuenta.class);
	}

}
