package br.ufrn.imd.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.ufrn.imd.interfaces.CautelaDAOLocal;
import br.ufrn.imd.interfaces.MaterialDAOLocal;
import br.ufrn.imd.modelo.Cautela;
import br.ufrn.imd.modelo.Fornecedor;
import br.ufrn.imd.modelo.Funcionario;
import br.ufrn.imd.modelo.Material;

@Named
@SessionScoped
public class EmprestimoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	CautelaDAOLocal cdao;
	@EJB
	MaterialDAOLocal mdao;

	Cautela cautela = new Cautela();
	Material mat = new Material();
	List<Cautela> listaCautela = new ArrayList<>();

	public List<Cautela> getListaCautela() {
		return listaCautela;
	}

	public void setListaCautela(List<Cautela> listaCautela) {
		this.listaCautela = listaCautela;
	}

	public List<Cautela> getCautelas() {
		return cdao.listarCautela();
	}

	public List<Cautela> getListaCautelas() {
		return this.getCautelas();
	}

	List<Material> listaMaterial = new ArrayList<>();

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

	public List<Material> getMateriais() {
		return mdao.listarMaterial();
	}

	public List<Material> getListaMateriais() {
		return this.getMateriais();
	}

	public Material getMat() {
		return mat;
	}

	public void setMat(Material mat) {
		this.mat = mat;
	}

	public Cautela getCautela() {
		return cautela;
	}

	public void setCautela(Cautela cautela) {
		this.cautela = cautela;
	}

	public Funcionario UsuarioLogado() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		Funcionario funcionarioLogado = (Funcionario) session.getAttribute("usuarioLogado");
		return funcionarioLogado;
	}

	public String emprestarMaterial() {

		this.cautela.setFuncionario(UsuarioLogado());
		this.cautela.setMaterial(mdao.buscaPorId(this.mat.getId()));
		// this.mat.setCautela(cautela);
		// this.cautela.setMateriais(new ArrayList<Material>());
		// this.cautela.getMateriais().add(this.mat);

		cdao.salvar(this.cautela);
		return "Aguardando autorização";
	}

	public void recusar() {

	}

	public void autorizar() {

	}

}
