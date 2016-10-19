package tn.esprit.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: competence
 *
 */
@Entity

public class competence implements Serializable {

	   
	@Id
	private int id;
	

	private String nom;
	private static final long serialVersionUID = 1L;
	@Lob
	private String description;
	
	@ManyToMany(mappedBy="competences")
	private List<technicien> techniciens;

	public competence() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

   
}
