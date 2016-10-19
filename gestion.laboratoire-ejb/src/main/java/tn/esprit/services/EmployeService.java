package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.interfaces.EmployeServiceLocal;
import tn.esprit.interfaces.EmployeServiceRemote;
import tn.esprit.persistance.Employe;
import tn.esprit.persistance.chercheur;
import tn.esprit.persistance.technicien;

/**
 * Session Bean implementation class EmployeService
 */
@Stateless
@LocalBean

public class EmployeService implements EmployeServiceRemote, EmployeServiceLocal {

	/**
	 * Default constructor.
	 */

	public EmployeService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "gestion.laboratoire-ejb")
	EntityManager em;

	@Override
	public String ajouterEmploye(Employe employe) {
		try {
			em.persist(employe);
			return "success";
		} catch (Exception e) {
			return "failed";
		}

	}

	@Override
	public void supprimerEmploye(Employe employe) {
		em.remove(em.merge(employe));

		// ou bien em.remove(em.find(Employe.class,employe.getClass()));

	}

	@Override
	public Employe chercherEmploye(int id) {

		return em.find(Employe.class, id);
	}

	@Override
	public void modifierEmploye(Employe employe) {

		em.merge(employe);

	}

	@Override
	public List<technicien> retournerTousLesTechniciens() {

		return em.createQuery("create t from technicien t", technicien.class).getResultList();
	}

	@Override
	public List<chercheur> retournerTousLesChercheurs() {

		return em.createQuery("create c from chercheur c", chercheur.class).getResultList();
	}

	@Override
	public Employe authentifier(String login, String password) {
		try{
			TypedQuery<Employe> query = em.createNamedQuery("auth", Employe.class);
			//Query query = em.createQuery("Select e from Employe e where e.login=:log and e.password=:pass",Employe.class);
			query.setParameter("log", "login");
			query.setParameter("pass", "password");
			return  query.getSingleResult();	
			
		}catch (Exception e){
			return null;
		}
		
	}

}
