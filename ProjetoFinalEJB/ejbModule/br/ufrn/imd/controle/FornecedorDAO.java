package br.ufrn.imd.controle;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.ufrn.imd.interfaces.FornecedorDAOLocal;
import br.ufrn.imd.modelo.Fornecedor;


@Stateless
public class FornecedorDAO implements FornecedorDAOLocal{
	
	
	@PersistenceContext//(unitName="ProjetoFinal") 
	private EntityManager em ;
	
	public Fornecedor salvar(Fornecedor fornecedor) {

		try {
			em.persist(fornecedor);
			System.out.println("Fornecedor Salvo com sucesso!");
		

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return fornecedor;
	}
	public List<Fornecedor> listarFornecedor() {

		TypedQuery<Fornecedor> query = em.createQuery("Select f from Fornecedor f", Fornecedor.class);
		List<Fornecedor> fornecedores = query.getResultList();

		return fornecedores;

	}
	
	public Fornecedor buscaPorId(Integer id) {
		Fornecedor fornecedor = em.find(Fornecedor.class, id);
		return fornecedor;
	}
	@Override
	public Fornecedor editar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Fornecedor remove(Fornecedor fornecedor) {
		em.remove(fornecedor);
		return fornecedor;
	}
	

}
