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
//import javax.persistence.Transient;
import javax.persistence.TypedQuery;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name="patient")

public class Patient implements IsSerializable {

	@Id
	@SequenceGenerator(name = "PATIENT_ID_DOCUMENT_GENERATOR", sequenceName = "PATIENT_ID_DOCUMENT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_ID_DOCUMENT_GENERATOR")

	@Column(name="id")
	private Integer id;
	@Column(name="id_person")
	private Integer id_person;
	@Column(name="date_of_registration")
	private String date_of_registration;
	
	public Patient() {
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_person() {
		return this.id_person;
	}
	public void setId_person(Integer id_person) {
		this.id_person = id_person;
	}
	public String getDate() {
		return this.date_of_registration;
	}
	public void setdate(String date) {
		this.date_of_registration = date;
	}
	public static EntityManager entityManager() {
		return (new UnitPersistence()).get();
	}
	public static List<Patient> findAll() {
		Patient c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Patient> query = em.createQuery("SELECT pa FROM Patient pa ", Patient.class);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return Collections.emptyList();
	}

	public static Patient findPatient(Integer id) {
		Patient c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Patient.class, id);
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
