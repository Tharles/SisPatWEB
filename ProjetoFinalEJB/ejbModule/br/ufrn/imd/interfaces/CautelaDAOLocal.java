package br.ufrn.imd.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.ufrn.imd.modelo.Cautela;


@Local
public interface CautelaDAOLocal {

	public Cautela salvar(Cautela cautela);
	public Cautela editar(Cautela cautela);
	public List<Cautela> listarCautela();
	public Cautela remove(Cautela cautela);
	
	
}
