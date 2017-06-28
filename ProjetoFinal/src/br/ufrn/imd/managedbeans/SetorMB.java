package br.ufrn.imd.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.ufrn.imd.controle.SetorDAO;
import br.ufrn.imd.interfaces.SetorDAOLocal;
import br.ufrn.imd.modelo.Setor;


@RequestScoped
@ManagedBean
public class SetorMB {
	
	
	private Setor setor = new Setor();
	@EJB
	SetorDAOLocal sdao;

	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	
	public List<Setor> getSetores(){
		return sdao.listarSetor();
	}
	public List<Setor> getListaSetores(){
		return this.getSetores();
	}


	private void clearObjects() {
		this.setor = new Setor();

	}
	public void gravar(){

		sdao.salvar(setor);
		clearObjects();
		//listaMateriais = dao.findMaterias();
		//return "materialLista";
		
		
	}

}
