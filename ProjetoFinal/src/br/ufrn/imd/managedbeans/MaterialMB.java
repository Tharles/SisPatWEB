package br.ufrn.imd.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.enterprise.context.SessionScoped;

import br.ufrn.imd.interfaces.CategoriaDAOLocal;
import br.ufrn.imd.interfaces.FornecedorDAOLocal;
import br.ufrn.imd.interfaces.MaterialDAOLocal;
import br.ufrn.imd.interfaces.SetorDAOLocal;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Fornecedor;
import br.ufrn.imd.modelo.Funcionario;
import br.ufrn.imd.modelo.Material;
import br.ufrn.imd.modelo.Setor;

@Named
@SessionScoped
public class MaterialMB implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	MaterialDAOLocal mdao;
	@EJB
	CategoriaDAOLocal cdao;
	@EJB
	FornecedorDAOLocal fdao;
	@EJB
	SetorDAOLocal sdao;

	private Integer fornecedorId;
	private Integer categoriaId;
	private Integer setorId;
	Material material = new Material();
	private List<Material> materialList = new ArrayList<>();

	private Fornecedor fornecedor = new Fornecedor();
	private Setor setor = new Setor();
	private Categoria categoria = new Categoria();

	public Integer getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getSetorId() {
		return setorId;
	}

	public void setSetorId(Integer setorId) {
		this.setorId = setorId;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	/** Lista de Categorias **/

	public Categoria getCategoriaDoMaterial() {
		categoria = this.material.getCategoria();
		return categoria;
	}

	public List<Categoria> getCategorias() {
		List<Categoria> listaDeCategorias = cdao.listarCategoria();
		return listaDeCategorias;
	}

	/** Lista de Fornecedores **/

	public List<Fornecedor> getFornecedores() {
		return fdao.listarFornecedor();
	}

	public Fornecedor getFornecedorDoMaterial() {
		return this.material.getFornecedor();
	}

	/** Lista de Setores **/

	public List<Setor> getSetores() {
		return sdao.listarSetor();
	}

	public Setor getSetorDoMaterial() {
		setor = this.material.getSetor();
		return setor;
	}

	public List<Material> getMateriais() {
		return mdao.listarMaterial();
	}

	public List<Material> getListaMateriais() {
		return this.getMateriais();
	}

	public void remover(Material material) {
		mdao.remove(material);
	}

	public String carregar(Material material) {

		this.material = material;
		return "material.xhtml";
	}

	private void clearObjetos() {
		this.material = new Material();
	}

	/** Refatorar todos os métodos e jogar para os SessionsBeans **/

	/** Método para associar fornecedor a um material **/
	public void adicionarFornecedor() {
		this.fornecedor = fdao.buscaPorId(fornecedorId);
		System.out.println("Id do fornecedor: " + fornecedorId);
		this.material.setFornecedor(fornecedor);
	}

	/** Método para associar uma categoria a uma material **/
	public void adicionarCategoria() {
		categoria = cdao.buscaPorId(categoriaId);
		this.material.setCategoria(categoria);
	}

	/** Método para associar um material a um setor **/
	public void adicionarSetor() {
		setor = sdao.buscaPorId(setorId);
		this.material.setSetor(setor);
	}

	public String gravar() {
		adicionarFornecedor();
		adicionarCategoria();
		adicionarSetor();
		mdao.salvar(material);
		clearObjetos();
		return "materialLista.xhtml";
	}

}
