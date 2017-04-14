package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(name="Adresse.findAll",query="SELECT a FROM Adresse a"),
	@NamedQuery(name="Adresse.findByRue",query="SELECT a FROM Adresse a where a.numRue like :rue")
})
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String numRue;
	private String ville;
	private String codePostal;
	@Transient
	private String commentaires;
	@OneToMany(mappedBy="adresse",fetch=FetchType.EAGER)
	private Set<Contact> contacts=new HashSet<Contact>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumRue() {
		return numRue;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numRue=" + numRue + ", ville=" + ville + ", CodePostal=" + codePostal + "]";
	}
	
}
