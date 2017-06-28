package br.ufrn.imd.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "SEQ_MATERIAL", initialValue = 1, allocationSize = 1, sequenceName = "seq_material")
public class Material implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATERIAL")
	@Column(name = "id_material")
	private Integer id;
	private String nomenclatura;
	private String numSerie;
	private Double valor;
	private String estadoMaterial;

	public String getEstadoMaterial() {
		return estadoMaterial;
	}

	public void setEstadoMaterial(String estadoMaterial) {
		this.estadoMaterial = estadoMaterial;
	}

	@Temporal(TemporalType.DATE)
	private Date dataAquisicao;

	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	Fornecedor fornecedor;

	@OneToMany(mappedBy = "material")
	List<Cautela> cautelas;

	public List<Cautela> getCautelas() {
		return cautelas;
	}

	public void setCautelas(List<Cautela> cautelas) {
		this.cautelas = cautelas;
	}

	@ManyToOne
	@JoinColumn(name = "id_setor")
	Setor setor;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	Categoria categoria;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double d) {
		this.valor = d;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	@Override
	public String toString() {
		return getNomenclatura();
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Material)) {
			return false;
		}
		Material mat = (Material) object;

		if (this.id == null || mat.getId() == null) {
			return false;
		}
		return this == object || this.id.equals(mat.getId());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
