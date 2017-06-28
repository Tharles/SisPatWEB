package br.ufrn.imd.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.ufrn.imd.modelo.Setor;

@Local
public interface SetorDAOLocal {

	public Setor salvar(Setor setor);

	public Setor editar(Setor setor);

	public List<Setor> listarSetor();

	public Setor remove(Setor setor);

	public Setor buscaPorId(Integer id);

}
