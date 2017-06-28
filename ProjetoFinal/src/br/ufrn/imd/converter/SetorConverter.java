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

import br.ufrn.imd.interfaces.SetorDAOLocal;
import br.ufrn.imd.modelo.Setor;

@Named
@SessionScoped
@FacesConverter(value = "setorConverter")
public class SetorConverter implements Converter, Serializable {

	private static HashMap<String, Setor> setores;

	@Inject
	SetorDAOLocal sdao;

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null) {
			System.out.println("Setor DAO Nulo");
		}

		Object object = sdao.buscaPorId(Integer.parseInt(value));
		return object;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		Setor setor = (Setor) object;
		return String.valueOf(setor.getId());

	}

}
