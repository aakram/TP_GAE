package fr.ifsic.gae.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.ifsic.gae.shared.Home;
import fr.ifsic.gae.shared.Person;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	Person createPerson(String nom, String prenom, String mail, String profilFcbk);
	 Home createHome(int tailleResid, int nbrePieces, String adresse, String adresseIp);
	 List<Person> listAllPerson();
	
}
