package com.bolsadeideas.spring.boot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spring.boot.app.models.entity.Cliente;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> listaClientes() {
		return em.createQuery("FROM Cliente").getResultList();
	}

	@Override
	@Transactional
	public void guardarCliente(Cliente cliente) {
		em.persist(cliente);
	}

	@Override
	@Transactional
	public void editarCliente(Cliente cliente) {
		em.merge(cliente);

	}

}
