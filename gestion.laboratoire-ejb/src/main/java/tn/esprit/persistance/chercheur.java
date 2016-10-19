package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: chercheur
 *
 */
@Entity
@DiscriminatorValue(value="chercheur")
public class chercheur extends Employe implements Serializable {

	
	private String grade;
	private static final long serialVersionUID = 1L;

	public chercheur() {
		super();
	}   
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
   
}
