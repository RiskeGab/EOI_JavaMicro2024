package com.example.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerBuilder {
	private static EntityManagerFactory emf = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("product_manager_v2");
		}
		return emf;
	}

	public static void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}
}
