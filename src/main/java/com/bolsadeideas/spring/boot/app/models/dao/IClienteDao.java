package com.bolsadeideas.spring.boot.app.models.dao;

import java.util.List;

import com.bolsadeideas.spring.boot.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> listaClientes();

	public void guardarCliente(Cliente cliente);

	public void editarCliente(Cliente cliente);

}
