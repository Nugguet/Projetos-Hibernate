package br.com.inforium.DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {

	public Serializable incluir(T obj);

	public void atualizar(T obj);

	public List<T> recuperarTodos();

	public T recuperar(Serializable id);

	public void excluir(T obj);

}
 