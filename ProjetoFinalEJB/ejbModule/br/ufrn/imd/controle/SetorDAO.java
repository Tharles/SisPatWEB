package br.ufrn.imd.controle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.ufrn.imd.interfaces.SetorDAOLocal;
import br.ufrn.imd.modelo.Setor;


@Stateless
public class SetorDAO implements SetorDAOLocal{
	
	
	@PersistenceContext//(unitName="ProjetoFinal") 
	private EntityManager em ;
	
	public Setor salvar(Setor setor) {

		try {
			em.persist(setor);
			System.out.println("Setor Salvo com sucesso!");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return setor;
	}

	public List<Setor> listarSetor() {

		TypedQuery<Setor> query = em.createQuery("Select s from Setor s", Setor.class);
		List<Setor> setores = query.getResultList();

		return setores;

	}
	
	public List<Setor> findSetores() {

		
		TypedQuery<Setor> query = em.createNamedQuery("findAllSetores", Setor.class);

		return query.getResultList();
	}
	
	public Setor buscaPorId(Integer id) {
		Setor setor = em.find(Setor.class, id);
		return setor;
	}

	@Override
	public Setor editar(Setor setor) {
		em.merge(setor);
		return setor;
	}

	@Override
	public Setor remove(Setor setor) {
		em.remove(setor);
		return setor;
	}

}
