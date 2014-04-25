package fr.ifsic.gae.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;

import fr.ifsic.gae.client.GreetingService;
import fr.ifsic.gae.shared.FieldVerifier;
import fr.ifsic.gae.shared.Home;
import fr.ifsic.gae.shared.Person;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	EntityManager manager;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		manager = EMF.get().createEntityManager();
		
	}
	
	@Override
	public Person createPerson(String nom, String prenom, String mail, String profilFcbk) {
		Person p = new Person(nom, prenom,mail, profilFcbk);
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(p);
		t.commit();
		
		return p;
	}
	
	public List<Person> listAllPerson(){
		List<Person> res = new ArrayList<>();
		res.addAll(manager.createQuery("select p from Person as p",Person.class).getResultList());
		return res;
		
	}

	@Override
	public Home createHome(int tailleResid, int nbrePieces, String adresse,
			String adresseIp) {
		Home h = new Home(tailleResid,nbrePieces,adresse,adresseIp);
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(h);
		t.commit();
		
		return h;
	}
	
	
	
}
