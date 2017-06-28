package br.ufrn.imd.converter;



import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufrn.imd.interfaces.MaterialDAOLocal;
import br.ufrn.imd.modelo.Material;

@Named
@SessionScoped
@FacesConverter(value = "materialConverter")
public class MaterialConverter implements Converter, Serializable{
	
	@Inject
	MaterialDAOLocal mdao;

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null) {
			System.out.println("Material DAO Nulo");
		}

		Object object = mdao.buscaPorId(Integer.parseInt(value));
		return object;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		Material material = (Material) object;
		return String.valueOf(material.getId());

	}


}
