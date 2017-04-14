package service;

import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Adresse;
import metier.Contact;

public class IserviceImpl implements Iservice {

	private IDao dao = new Dao();
	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		// TODO Auto-generated method stub
		return dao.ajouterContactAdresse(c, a);
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
