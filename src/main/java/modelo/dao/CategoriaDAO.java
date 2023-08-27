package modelo.dao;

import java.util.List;

import modelo.entidades.Categoria;

public interface CategoriaDAO extends GenericDAO<Categoria, Integer>{
	
	public List<Categoria> getAllTipoIngreso();
	public List<Categoria> getAllTipoEgreso();
	public List<Categoria> getAllTipoTransferencia();
	public List<Categoria> getAllByPersona(int idPersona);

}
