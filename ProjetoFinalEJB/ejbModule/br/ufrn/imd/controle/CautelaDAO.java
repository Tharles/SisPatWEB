package br.ufrn.imd.controle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.ufrn.imd.interfaces.CautelaDAOLocal;

import br.ufrn.imd.modelo.Cautela;

@Stateless
public class CautelaDAO implements CautelaDAOLocal{
	
	@PersistenceContext
	private EntityManager em ;
	
	
	public Cautela salvar(Cautela cautela) {

		try {
			em.persist(cautela);
			System.out.println("cautela Salva com sucesso!");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return cautela;
	}
	
	
	public List<Cautela> listarCautela() {

		TypedQuery<Cautela> query = em.createQuery("Select c from Cautela c", Cautela.class);
		List<Cautela> cautelas = query.getResultList();

		return cautelas;

	}

	public Cautela buscaPorId(Integer id) {
		Cautela cautela = em.find(Cautela.class, id);
		return cautela;
	}


	@Override
	public Cautela editar(Cautela cautela) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cautela remove(Cautela cautela) {

		em.remove(cautela);
		return cautela;
	}
	
	
	
	

}
