package fr.ifsic.gae.shared;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.datanucleus.api.jpa.annotations.Extension;


@Entity
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8853790854567956705L;

	String id;
	
	String nom;
	String prenom;
	String mail;
	String profilFcbk;

	public Person(String nom, String prenom, String mail, String profilFcbk) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail=mail;
		this.profilFcbk=profilFcbk;
	}


	public Person() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getProfilFcbk() {
		return profilFcbk;
	}


	public void setProfilFcbk(String profilFcbk) {
		this.profilFcbk = profilFcbk;
	}
	
	
}
