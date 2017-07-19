/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.util.List;

/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
public interface IDAOBase<T, I> {

	public void insert(T data) throws Exception;
	public List<T> getAll() throws Exception;
	public T getById(I id) throws Exception;
	public void update(T data) throws Exception;
	public void delete(T data) throws Exception;
}
