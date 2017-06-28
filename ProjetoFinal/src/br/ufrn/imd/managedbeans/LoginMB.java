package br.ufrn.imd.managedbeans;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.ufrn.imd.interfaces.FuncionarioDAOLocal;
import br.ufrn.imd.modelo.Funcionario;

@Named
@SessionScoped
public class LoginMB implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private Funcionario funcionarioLogado = new Funcionario();
	private String matricula;
	private String senha;
	
	
	
	public String getMatricula() {
		return matricula;
	}




	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	@EJB
	FuncionarioDAOLocal fdao;
	
	
	
	
	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}




	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}




	public String logar(){
		funcionarioLogado = fdao.existe(this.matricula, this.senha);
		
		FacesContext fc = FacesContext.getCurrentInstance();
		 HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		
		if(funcionarioLogado != null){
			 session.setAttribute("usuarioLogado", funcionarioLogado);
			 return "material.xhtml";//mudar para index
		}
		
		return null;//senão msg de erro
	}
	
	 public String sair() {
	        FacesContext.getCurrentInstance().getExternalContext()
	                .invalidateSession();
	        System.out.println("Saindo...");
	        return "login.xhtml";
	}
	
	

}
