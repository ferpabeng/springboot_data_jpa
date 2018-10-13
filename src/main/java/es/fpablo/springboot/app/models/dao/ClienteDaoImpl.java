package es.fpablo.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.fpablo.springboot.app.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		// TypedQuery
		return em.createQuery("from Cliente", Cliente.class).getResultList();
	}

	@Transactional
	@Override
	public void save(Cliente cliente) {
		em.persist(cliente);
	}

}
