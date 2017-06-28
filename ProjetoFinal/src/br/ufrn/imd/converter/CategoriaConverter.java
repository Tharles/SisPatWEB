package br.ufrn.imd.converter;

import java.io.Serializable;
import java.util.HashMap;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufrn.imd.interfaces.CategoriaDAOLocal;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Setor;

@Named
@SessionScoped
@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter, Serializable {
	
	private static HashMap<String, Setor> setores;

	@Inject
	CategoriaDAOLocal cdao;

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null) {
			System.out.println("Categoria DAO Nulo");
		}

		Object object = cdao.buscaPorId(Integer.parseInt(value));
		return object;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		Categoria cat = (Categoria) object;
		return String.valueOf(cat.getId());

	}
}
