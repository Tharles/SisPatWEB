package br.ufrn.imd.controle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.ufrn.imd.interfaces.CategoriaDAOLocal;
import br.ufrn.imd.modelo.Categoria;

//@Named
//@RequestScoped
@Stateless
public class CategoriaDAO implements CategoriaDAOLocal {

	@PersistenceContext//(unitName="ProjetoFinal") 
	private EntityManager em ;
	
	
	public Categoria salvar(Categoria categoria) {

		if(categoria == null){
			em.persist(categoria);
			
		}else{
			em.merge(categoria);
		}
			
			return categoria;
	}
	
	
	public List<Categoria> listarCategoria() {

		TypedQuery<Categoria> query = em.createQuery("Select c from Categoria c", Categoria.class);
		List<Categoria> categorias = query.getResultList();

		return categorias;

	}

	public Categoria buscaPorId(Integer id) {
		Categoria categoria = em.find(Categoria.class, id);
		return categoria;
	}


	@Override
	public Categoria editar(Categoria categoria) {
		em.merge(categoria);
		return categoria;
	}


	@Override
	public Categoria remove(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/*
	public List<Categoria> findEmployees() {
		TypedQuery<Categoria> query = entityManager.createNamedQuery("findAllCategorias", Categoria.class);

		return query.getResultList();
	
		
	}
		
	public void remover(Categoria categoria){
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.remove(em.merge(categoria));
		em.getTransaction().commit();
		//em.close();

		//return permanente;
	}
	
	public void atualizar(Categoria categoria){
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.merge(categoria);
		em.getTransaction().commit();
		//em.close();
		
	}
	
	public Categoria findById(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();

		return em.find(Categoria.class, id);
}*/


}
