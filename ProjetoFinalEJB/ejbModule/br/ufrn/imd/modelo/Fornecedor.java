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
@SequenceGenerator(name = "SEQ_FORNECEDOR", initialValue = 1, allocationSize = 1, sequenceName = "seq_fornecedor")
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FORNECEDOR")
	private Integer id;
	private String razaoSocial;
	private String cnjp;
	private String telefone;
	private String email;
	
	@OneToMany(mappedBy = "fornecedor")
	private List<Material> material;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnjp() {
		return cnjp;
	}

	public void setCnjp(String cnjp) {
		this.cnjp = cnjp;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}
	
	@Override
	public String toString(){
		return getRazaoSocial();
	}
	

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Categoria)) {
			return false;
		}
		Fornecedor f = (Fornecedor) object;

		if (this.id == null || f.getId() == null) {
			return false;
		}
		return this == object || this.id.equals(f.getId());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
