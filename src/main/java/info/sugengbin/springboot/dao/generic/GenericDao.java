package info.sugengbin.springboot.dao.generic;

import java.io.Serializable;
import java.util.List;

/**
 * 
 *
 * Date:     2017年2月24日<br/> 
 * @author   sugengbin
 */
public interface GenericDao<E> {

	/**
	 * 
	 * @param entity
	 * @return
	 */
	Serializable save(E entity);

	/**
	 * 
	 * @param entity
	 */
	void saveOrUpdate(E entity);

	/**
	 * 
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * 
	 */
	void deleteAll();

	/**
	 * 
	 * @return
	 */
	List<E> findAll();

	/**
	 * 
	 * @param entity
	 * @return
	 */
	List<E> findAllByExample(E entity);

	/**
	 * 
	 * @param id
	 * @return
	 */
	E findById(Serializable id);

	/**
	 * 
	 * @return
	 */
	long count();
	
	/**
	 * Clear session
	 */
	void clear();

	/**
	 * Flush session
	 */
	void flush();
}
