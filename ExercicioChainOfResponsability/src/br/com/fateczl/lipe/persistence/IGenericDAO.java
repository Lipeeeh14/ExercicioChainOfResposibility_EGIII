package br.com.fateczl.lipe.persistence;

import java.util.List;

public interface IGenericDAO<T> {
	public void cadastrar(T entity);
	public void atualizar(T entity);
	public void deletar(T entity);
	public T consultar(T entity);
	public List<T> listar();
}
