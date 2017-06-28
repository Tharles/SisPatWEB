package br.ufrn.imd.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.ufrn.imd.modelo.Fornecedor;


@Local
public interface FornecedorDAOLocal {
	
	public Fornecedor salvar(Fornecedor fornecedor);
	public Fornecedor editar(Fornecedor fornecedor);
	public List<Fornecedor> listarFornecedor();
	public Fornecedor remove(Fornecedor fornecedor);
	public Fornecedor buscaPorId(Integer id);

}
