package br.ufrn.imd.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.ufrn.imd.modelo.Material;

@Local
public interface MaterialDAOLocal {
	
	public Material salvar(Material material);
	public Material editar(Material material);
	public List<Material> listarMaterial();
	public Material remove(Material material);
	public Material buscaPorId(Integer id);
}
