package br.ufrn.imd.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.ufrn.imd.modelo.Funcionario;


@Local
public interface FuncionarioDAOLocal {

	public Funcionario salvar(Funcionario funcionario);
	public Funcionario editar(Funcionario funcionario);
	public List<Funcionario> listarFuncionario();
	public Funcionario remove(Funcionario funcionario);
	public Funcionario existe(String matricula, String senha);
	
}
