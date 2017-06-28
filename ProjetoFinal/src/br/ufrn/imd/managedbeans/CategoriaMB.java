package br.ufrn.imd.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.ufrn.imd.interfaces.CategoriaDAOLocal;
import br.ufrn.imd.modelo.Categoria;

@RequestScoped
@ManagedBean
public class CategoriaMB implements Serializable{
	private static final long serialVersionUID = 1L;

	@EJB
	CategoriaDAOLocal dao;

	private Categoria categoria = new Categoria();

	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	private void clearObjects() {
		this.categoria = new Categoria();

	}
	
	
	public List<Categoria> getCategorias(){
		return dao.listarCategoria();
	}
	
	public List<Categoria> getListaCategorias(){
		return this.getCategorias();
	}
	public String carrega(Categoria c){
		this.categoria = c;
		return "categoria.xhtml";
	}
	
	public void remover(Categoria c){
		dao.remove(c);
		
	}

	public String gravar(){
		
		dao.salvar(categoria);
		clearObjects();
		return "categoriaLista.xhtml";
		
	}

}
