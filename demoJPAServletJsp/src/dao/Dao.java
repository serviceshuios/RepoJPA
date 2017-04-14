package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Contact;

public class Dao implements IDao {

	// 1: ouverture de l'unité de persistance
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
	@Override
	public int ajouterAdresse(Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(a);
		tx.commit();
		em.close();
		return a.getId();
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		c.setAdresse(a);
		em.persist(c);
		tx.commit();
		em.close();
		return a.getId();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Contact> findAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse findAdresse(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdresse(Adresse a) {
		// TODO Auto-generated method stub
		
	}

}
