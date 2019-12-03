package com.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Contexte {

	private static Contexte instance;
	private EntityManagerFactory emf;
	private Logger LOGGER = LogManager.getLogger(Contexte.class.getName());
	private static Logger LOGGER1 = LogManager.getLogger(Contexte.class.getName());

	private Contexte() {
		try {
			LOGGER.debug("creation d'un persistence context:contact");
			emf = Persistence.createEntityManagerFactory("contact");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Contexte getInstance() {
		if (instance == null) {
			instance = new Contexte();
		}
		LOGGER1.debug("recup singleton");

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public static void setInstance(Contexte instance) {
		Contexte.instance = instance;
	}



}