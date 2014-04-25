package fr.ifsic.gae.shared;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.datanucleus.api.jpa.annotations.Extension;


@NamedQueries({@NamedQuery(name="La liste de maison présente dans ma base de données",
query= "select h from Home h")})
@Entity
public class Home implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8853790854567956705L;

	private int tailleResid;
	private int nbrePieces;
	private String adresse;
	private String adresseIp;
	private Long id;
	private Person person;
	
	
	public Home(){
		
		
	}
	public Home(int tailleResid, int nbrePieces, String adresse, String adresseIp){
		this.tailleResid=tailleResid;
		this.nbrePieces=nbrePieces;
		this.adresse=adresse;
		this.adresseIp=adresseIp;
	
	}
	public int getTailleResid() {
		return tailleResid;
	}
	public void setTailleResid(int tailleResid) {
		this.tailleResid = tailleResid;
	}
	public int getNbrePieces() {
		return nbrePieces;
	}
	public void setNbrePieces(int nbrePieces) {
		this.nbrePieces = nbrePieces;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresseIp() {
		return adresseIp;
	}
	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName = "datanucleus1", key = "gae.encoded-pk1", value = "true")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
//	@ManyToOne
//	public Person getPerson() {
//		return person;
//	}
//	public void setPerson(Person person) {
//		this.person = person;
//	}
//	@OneToMany(mappedBy="home", cascade=CascadeType.PERSIST)
//	public List<Heater> getChauffage() {
//		return chauffage;
//	}
//	public void setChauffage(List<Heater> chauffage) {
//		this.chauffage = chauffage;
//	}
//	@Override
//	public String toString() {
//		return "Home [tailleResid= " + tailleResid + ", nbrePieces= "
//				+ nbrePieces + ", adresse= " + adresse + ", adresseIp= "
//				+ adresseIp + "]";
//	}
//	

}
