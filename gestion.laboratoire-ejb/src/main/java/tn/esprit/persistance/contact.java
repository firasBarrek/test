package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: contact
 *
 */
@Entity

public class contact implements Serializable {

	   
	@Id
	private int id;
	private String email;
	private int numTel;
	private String adresse;
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="contact")
	private Employe employe;
	
	public contact() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public int getNumTel() {
		return this.numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
   
}
