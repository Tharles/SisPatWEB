package br.ufrn.imd.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "SEQ_CATEGORIA", initialValue = 1, allocationSize = 1, sequenceName = "seq_categoria")
public class Categoria implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
	private Integer id;
	private String nomeCategoria;
	
	@OneToMany(mappedBy="categoria")
	private List<Material> materiais;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public List<Material> getMateriais() {
		return materiais;
	}
	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override

	public String toString(){
		return this.getNomeCategoria();
	}
	

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Categoria)) {
			return false;
		}
		Categoria cat = (Categoria) object;

		if (this.id == null || cat.getId() == null) {
			return false;
		}
		return this == object || this.id.equals(cat.getId());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
