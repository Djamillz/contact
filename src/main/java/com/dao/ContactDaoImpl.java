package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.model.Contact;
import com.utils.Contexte;

public class ContactDaoImpl implements ContactDao {
	EntityManager em = Contexte.getInstance().getEmf().createEntityManager();

	@Override
	public List<Contact> findAll() {
		Query q = null;
		List<Contact> contacts = new ArrayList<>();
		try {
			q = em.createQuery("from Contact");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return q.getResultList();
	}

	@Override
	public Contact findByKey(Integer id) {
		return em.find(Contact.class, id);
	}

	@Override
	public Contact insert(Contact obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return obj;
	}

	@Override
	public Contact update(Contact obj) {
		Contact a = null;
		try {
			em.getTransaction().begin();
			a = em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		}
		return a;
	}

	@Override
	public void deleteByKey(Integer id) {
		Contact a = em.find(Contact.class, id);
		try {
			em.getTransaction().begin();
			if (id != null) {
				em.remove(a);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
