package pe.edu.ucsp.quipux.server;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name="person")
public class Person  implements IsSerializable {
	
	@Id
	@SequenceGenerator(name = "PERSON_ID_GENERATOR", sequenceName = "PERSON_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID_GENERATOR")
	@Column(name="id")
	private Integer id;
	@Column(name="first_surname")
	private String first_surname;
	@Column(name="second_surname")
	private String second_surname;
	@Column(name="names")
	private String names;
	@Column(name="document_number")
	private Integer document_number;
	@Column(name="id_sex")
	private Integer id_sex;
	
	public Person() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfirst_surname() {
		return this.first_surname;
	}
	public String getsecond_surname() {
		return this.second_surname;
	}
	public String getnames() {
		return this.names;
	}
	
	public Integer getdocument_number() {
		return this.document_number;
	}
	
	public String getsexo() {
		if(this.id_sex==1) {return "Femenino";}
		else return "Masculino";
	}
	
	public void setid_person(String first_surname) {
		this.first_surname = first_surname;
	}

	public static EntityManager entityManager() {
		return (new UnitPersistence()).get();
	}

	public static List<Person> findAll() {
		Person c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return Collections.emptyList();
	}

	public static Person findPerson(Integer id) {
		Person c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Person.class, id);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return c;
	}

	public Integer getVersion() {
		return 0;
	}

	public void setVersion(Integer version) {

	}
	
}
