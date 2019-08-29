package com.bolsadeideas.spring.boot.app.controllers;

import java.io.Serializable;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.spring.boot.app.models.dao.IClienteDao;
import com.bolsadeideas.spring.boot.app.models.entity.Cliente;

@SuppressWarnings("serial")
@Controller
public class ClienteController implements Serializable {

	@Autowired
	@Qualifier("clienteDaoJPA")
	private IClienteDao clienteDao;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de Clientes");
		model.addAttribute("clientes", clienteDao.listaClientes());
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario del Cliente");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardarCliente(@Valid Cliente cliente, BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Cliente");
			return "form";
		}
		clienteDao.guardarCliente(cliente);
		return "redirect:listar";

	}

	@RequestMapping(value = "/listar", method = RequestMethod.POST)
	public String editarCliente(Cliente cliente) {
		clienteDao.editarCliente(cliente);
		return "redirect:form";

	}

}
