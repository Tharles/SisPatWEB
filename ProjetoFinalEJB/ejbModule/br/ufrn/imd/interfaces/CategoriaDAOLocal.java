package br.ufrn.imd.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.ufrn.imd.modelo.Categoria;

@Local
public interface CategoriaDAOLocal {
	
	public Categoria salvar(Categoria categoria);
	public Categoria editar(Categoria categoria);
	public List<Categoria> listarCategoria();
	public Categoria remove(Categoria categoria);
	public Categoria buscaPorId(Integer id);

}
