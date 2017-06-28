package br.ufrn.imd.controle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.ufrn.imd.interfaces.MaterialDAOLocal;
import br.ufrn.imd.modelo.Material;

@Stateless
public class MaterialDAO implements MaterialDAOLocal {

	@PersistenceContext
	private EntityManager em;

	public Material salvar(Material material) {

		if (material.getId() == null) {

			em.persist(material);
			System.out.println("Material Salvo com sucesso!");

		} else {
			em.merge(material);
			System.out.println("Material atualizado com sucesso!");

		}

		return material;
	}

	public Material editar(Material material) {
		try {

			System.out.println("Material atualizado com sucesso!");
			em.merge(material);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return material;
	}

	public List<Material> listarMaterial() {

		TypedQuery<Material> query = em.createQuery("Select m from Material m", Material.class);
		System.out.println("listagem " + query);
		List<Material> materiais = query.getResultList();

		return materiais;

	}

	public List<Material> findMaterias() {

		TypedQuery<Material> query = em.createNamedQuery("findAllMateriais", Material.class);

		return query.getResultList();
	}

	public Material remove(Material material) {
		em.remove(em.merge(material));

		return material;

	}

	@Override
	public Material buscaPorId(Integer id) {
		Material material = em.find(Material.class, id);
		return material;
	}

}
