package br.ufrn.imd.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.imd.interfaces.CautelaDAOLocal;
import br.ufrn.imd.modelo.Cautela;
import br.ufrn.imd.modelo.Funcionario;
import br.ufrn.imd.modelo.Material;

@RequestScoped
@ManagedBean
public class CautelaMB {
	
	/*@EJB
	CautelaDAOLocal cdao;
	@EJB
	EmprestimoLocal cautelaService;
	
	private Cautela cautela = new Cautela();

	
	
	public Cautela getCautela() {
		return cautela;
	}

	public void setCautela(Cautela cautela) {
		this.cautela = cautela;
	}
	
	public void emprestarMaterial(Material m, Funcionario f){
		cautelaService.criarCautela(m, f);
	}
	
	public void gravar(){
		if(cautela.getFuncionarios().isEmpty()){
			throw new RuntimeException("Cautela deve ter um funcionário.");
		}
		
		//cautela.getMateriais().isEmpty();
	}
*/

}
