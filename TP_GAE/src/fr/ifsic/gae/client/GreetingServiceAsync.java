package fr.ifsic.gae.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.ifsic.gae.shared.Home;
import fr.ifsic.gae.shared.Person;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void createPerson(String nom, String prenom, String mail,
			String profilFcbk, AsyncCallback<Person> callback);

	void createHome(int tailleResid, int nbrePieces, String adresse,
			String adresseIp, AsyncCallback<Home> callback);

	void listAllPerson(AsyncCallback<List<Person>> callback);
}
