package tn.esprit.persistance;


import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: technicien
 *
 */
@Entity
//@DiscriminatorValue(value="technicien")
public class technicien extends Employe implements Serializable {

	
	private String specialite;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany()
	private List<competence> competences;

	public technicien() {
		super();
	}   
	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
   
}
