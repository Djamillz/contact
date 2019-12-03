package com.dao;

import java.util.List;

public interface GenericDao<T, K> {
	List<T> findAll();

	T findByKey(K id);

	T insert(T obj);

	T update(T obj);

	void deleteByKey(K id);

}