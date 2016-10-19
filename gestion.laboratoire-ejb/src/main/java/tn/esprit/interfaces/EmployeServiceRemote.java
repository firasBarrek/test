package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.persistance.Employe;
import tn.esprit.persistance.chercheur;
import tn.esprit.persistance.technicien;

@Remote
public interface EmployeServiceRemote {
	
	String ajouterEmploye(Employe employe);
	
	void supprimerEmploye(Employe employe);
	
	Employe chercherEmploye(int id);
	
	void modifierEmploye(Employe employe);
	
	List<technicien> retournerTousLesTechniciens();
	
	List<chercheur> retournerTousLesChercheurs();
    public Employe authentifier(String login,String password);
}
