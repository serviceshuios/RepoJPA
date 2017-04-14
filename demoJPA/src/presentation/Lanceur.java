package presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Adresse;
import metier.Contact;
import metier.Film;
import metier.LongMetrage;
import metier.TeleFilm;

public class Lanceur {

	public static void main(String[] args) {
		// 1: ouverture de l'unité de persistance
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		
		// 2: Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 3: Création d'un Objet métier
		Adresse s = new Adresse();
		s.setVille("LYON");
		s.setNumRue("120 rue massena");
		s.setCodePostal("69006");
		
		Contact c = new Contact();
		c.setNom("Christian");
		c.setPrenom("eddy");
		c.setEmail("services.huios@gmail.com");
		c.setAdresse(s);
		// avant le persist, pas d'ID attribué
		System.out.println(s);
		LongMetrage lm = new LongMetrage();
		lm.setNomFilm("film1");
		lm.setCinema("GAUMONT");
		
		
		
		TeleFilm tf = new TeleFilm();
		tf.setChaine("TF1");
		tf.setNomFilm("Josephine ...");
		
		TeleFilm tf2 = new TeleFilm();
		tf.setChaine("TF1");
		tf.setNomFilm("les experts ...");
		
		Set<Film> films = new HashSet<Film>();
		films.add(tf);
		films.add(lm);
		c.setFilms(films);
		
		
		// 4: Persistence de l'objet métier
		//em.persist(lm);
		//em.persist(tf);
		// avant le persist, pas d'ID attribué
		em.persist(tf2);
		System.out.println(c);
		em.persist(c);
		// 5: validation de la transaction
		// après le persist, un ID est attribué et tout de suite disponible
		System.out.println(c);
		System.out.println(s);
		tx.commit();
		
		// récuperer le film d'ID 1
		Film f = em.find(Film.class, 1);
		System.out.println(f);
		
		// modification film d'ID 1
		f.setNomFilm("film modifié");
		tx.begin();
		em.merge(f);
		tx.commit();
		
		//suppression film d'ID 1
		tx.begin();
		em.remove(f);
		tx.commit();
		
		// rechercher tous les films en BDD
		List<Film> listeFilm = em.createQuery("SELECT f FROM Film f").getResultList();
		for(Film fl : listeFilm )
		{
			System.out.println(fl);
		}
		
		// recherche les films par nom de Film
		Query q = em.createQuery("SELECT f FROM Film f where f.nomFilm = :leNom");
		q.setParameter("leNom", "film1");
		List<Film> listeFilm2 = q.getResultList();
		
		for(Film fl : listeFilm2 )
		{
			System.out.println(fl);
		}
		
		// rechercher les films contenant un mot ou une lettre
		Query q2 = em.createQuery("SELECT f FROM Film f where f.nomFilm like :leNom");
		q2.setParameter("leNom", "%l%");
		List<Film> listeFilm3 = q2.getResultList();
		
		for(Film fl : listeFilm3 )
		{
			System.out.println(fl);
		}
		// exemple de getSingleResult()
		Film f5 = (Film) em.createQuery("SELECT f FROM Film f where f.idFilm=2").getSingleResult();
		System.out.println(f5);
		
		// exemple de jointure entre contact et adresse
		
		Query q3 = em.createQuery("SELECT c FROM Contact c left join c.adresse");
		List<Contact> listeC = q3.getResultList();
		for(Contact ct : listeC)
		{
			System.out.println(ct);
			System.out.println(ct.getFilms());
		}
		
System.out.println("----------------------------------------------------------------------");
System.out.println("ADRESSE ET CONTACTS DANS LES ADRESSES");
		Query q5 = em.createQuery("SELECT a FROM Adresse a");
		List<Adresse> listeC2 = q5.getResultList();
		for(Adresse ct : listeC2)
		{
			System.out.println(ct);
			System.out.println(ct.getContacts());
		}
		
		// appel d'une requête nommée
		Query q4=em.createNamedQuery("Contact.findAll");
		List<Contact> lst = q4.getResultList();
		for(Contact ct : lst)
		{
			System.out.println(ct);
			
		}
		// 6: Fermeture de l'unité de persistance
		em.close();
		emf.close();

	}

}
