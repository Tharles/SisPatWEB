package br.ufrn.imd.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.ufrn.imd.interfaces.FuncionarioDAOLocal;
import br.ufrn.imd.modelo.Funcionario;

@Named
@RequestScoped
public class FuncionarioMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Funcionario funcionario = new Funcionario();
	@EJB
	FuncionarioDAOLocal fDAOL;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	

	public void gravar() {
		fDAOL.salvar(this.funcionario);

	}

}
