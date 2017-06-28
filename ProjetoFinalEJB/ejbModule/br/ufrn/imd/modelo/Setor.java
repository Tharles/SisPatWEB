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
@SequenceGenerator(name = "SEQ_SETOR", initialValue = 1, allocationSize = 1, sequenceName = "seq_setor")
public class Setor implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SETOR")
	private Integer id;
	private String nomeSetor;
	private String sigla;
	
	@OneToMany(mappedBy = "setor")
	private List<Funcionario> funcionarios;	
	
	@OneToMany(mappedBy = "setor")
	private List<Material> materiais;	
	
	
	
	public List<Material> getMateriais() {
		return materiais;
	}
	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeSetor() {
		return nomeSetor;
	}
	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public String toString(){
		return this.getNomeSetor();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Categoria)) {
			return false;
		}
		Setor set = (Setor) object;

		if (this.id == null || set.getId() == null) {
			return false;
		}
		return this == object || this.id.equals(set.getId());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	
}
