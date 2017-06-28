package br.ufrn.imd.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.imd.interfaces.FornecedorDAOLocal;
import br.ufrn.imd.modelo.Fornecedor;
import br.ufrn.imd.modelo.Material;

@RequestScoped
@ManagedBean
public class FornecedorMB {
	
	private Fornecedor fornecedor = new Fornecedor();
	@EJB
	FornecedorDAOLocal dao;
	
	
	public List<Fornecedor> getFornecedores(){
		return dao.listarFornecedor();
	}
	public List<Fornecedor> getListaFornecedores(){
		return this.getFornecedores();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public Fornecedor getMateriaisDoFornecedor(){
		Material m = new Material();
		
		return m.getFornecedor();
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	private void clearObjects() {
		this.fornecedor = new Fornecedor();

	}
	
	public void remover(Fornecedor f){
		dao.remove(f);
		
	}

	public String gravar(){

		dao.salvar(fornecedor);
		clearObjects();
		return "fornecedorLista.xhtml";
		
	}
	
	public String alterar(Fornecedor f){
		this.fornecedor = f;
		return "fornecedor.xhtml";
		
	}


}
