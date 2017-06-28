package br.ufrn.imd.controle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.ufrn.imd.interfaces.FuncionarioDAOLocal;
import br.ufrn.imd.modelo.Funcionario;

@Stateless
public class FuncionarioDAO implements FuncionarioDAOLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public Funcionario salvar(Funcionario funcionario) {

		try {
			entityManager.persist(funcionario);

			System.out.println("Funcionario salvo com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionario;
	}

	public List<Funcionario> findEmployees() {
		TypedQuery<Funcionario> query = entityManager.createNamedQuery("findAllFuncionarios", Funcionario.class);

		return query.getResultList();
	}

	@Override
	public Funcionario editar(Funcionario funcionario) {
		entityManager.merge(funcionario);
		return funcionario;
	}

	@Override
	public List<Funcionario> listarFuncionario() {
		TypedQuery<Funcionario> query = entityManager.createQuery("Select f from Funcionario f", Funcionario.class);
		List<Funcionario> funcionarios = query.getResultList();

		return funcionarios;
	}

	@Override
	public Funcionario remove(Funcionario funcionario) {
		entityManager.remove(entityManager.merge(funcionario));
		return funcionario;
	}

	@Override
	public Funcionario existe(String matricula, String senha) {
		TypedQuery<Funcionario> query = entityManager.createQuery("Select f from "
				+ "Funcionario f where f.matricula= :pMat and f.senha= :pSenha", 
				Funcionario.class);
		query.setParameter("pMat",matricula);
		query.setParameter("pSenha", senha);
		
			Funcionario resultado = query.getSingleResult();

		
		return resultado;
	}

}
