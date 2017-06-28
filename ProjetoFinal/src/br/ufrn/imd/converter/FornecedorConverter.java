package br.ufrn.imd.converter;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufrn.imd.interfaces.FornecedorDAOLocal;
import br.ufrn.imd.modelo.Fornecedor;

@Named
@SessionScoped
@FacesConverter(value = "fornecedorConverter")
public class FornecedorConverter implements Converter, Serializable {

	@Inject
	FornecedorDAOLocal fdao;

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null) {
			System.out.println("Fornecedor DAO Nulo");
		}

		Object object = fdao.buscaPorId(Integer.parseInt(value));
		return object;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		Fornecedor fornecedor = (Fornecedor) object;
		return String.valueOf(fornecedor.getId());

	}

}
