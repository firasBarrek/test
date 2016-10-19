package tn.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="D_type")
@NamedQueries({
	@NamedQuery(name="auth",query="Select e from Employe e where e.login=:log and e.password=:pass")})

		  		
public class Employe implements Serializable {


	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, unique=true)   
	private String login;
	
	@Column(nullable=false)
	private String password;
	
	//unidirectionnelle one to one
	//@OneToOne
	//private contact contact;
	
	//unidirectionnelle many to one
	//@ManyToOne
	//private laboratoire laboratoire;
	
	
	//public contact getContact() {
	//	return contact;
	//}
	//public void setContact(contact contact) {
		//this.contact = contact;
	//}
	
	@OneToOne
	private contact contact;
	
	@ManyToOne
	private laboratoire laboratoire;
	
	public Employe() {
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
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
