package br.com.fateczl.lipe.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import br.com.fateczl.lipe.model.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class FuncionarioDAO implements IGenericDAO<Funcionario>{
	
	private SessionFactory sf;
	
	public FuncionarioDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void cadastrar(Funcionario entity) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
	}

	@Override
	public void atualizar(Funcionario entity) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(entity);
		transaction.commit();
	}

	@Override
	public void deletar(Funcionario entity) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(entity);
		transaction.commit();
	}
	
	@Override
	public Funcionario consultar(Funcionario entity) {
		EntityManager entityManager = sf.createEntityManager();
		entity = entityManager.find(Funcionario.class, entity.getId());
		
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * FROM funcionario");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		
		for (Object[] obj : lista) {
			Funcionario func = new Funcionario();
			func.setId(Integer.parseInt(obj[0].toString()));
			func.setNome(obj[1].toString());
			func.setSalario(Float.parseFloat(obj[2].toString()));
			
			funcionarios.add(func);
		}
		
		return funcionarios;
	}
	
}
