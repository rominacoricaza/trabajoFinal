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
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * The persistent class for the prueba database table.
 * 
 */
@Entity
@Table(name="roster")
public class Roster implements IsSerializable {

	@Id
	@SequenceGenerator(name = "ROSTER_ID_GENERATOR", sequenceName = "ROSTER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROSTER_ID_GENERATOR")

	@Column(name="id")
	private Integer id_serial;
	
	@Column(name="id_person")
	private Integer id_person;
	
	@Column(name="id_institution")
	private Integer id_institution;
	
	@Column(name="mm")
	private Integer mm;
	
	@Column(name="dd")
	private Integer dd;
	
	@Column(name="yyy")
	private Integer yyyy;
	
	@Column(name="id_physical_location")
	private Integer id_physical_location;
	
	@Column(name="id_service_offered")
	private Integer id_service_offered;
	
	public Roster() {
	}

	public Integer getId() {
		return this.id_serial;
	}

	public void setId(Integer id) {
		this.id_serial = id;
	}

	public Integer getId_person() {
		return this.id_person;
	}

	public void setId_institution(Integer id_institution) {
		this.id_institution = id_institution;
	}

	public Integer getDd() {
		return this.dd;
	}
	
	public Integer getMm() {
		return this.mm;
	}
	
	public Integer getYyyy() {
		return this.yyyy;
	}
	
	
	public Integer getId_physical_location() {
		return this.id_physical_location;
	}
	
	public String getPhysical_location() {
		switch(this.id_physical_location)
		{
		case 1:return "101"; 
		case 2:return "102"; 
		case 3:return "103"; 
		case 4:return "104"; 
		case 5:return "105"; 
		default:return "NADA"; 
		}
	}
	
	public Integer getId_service_offered() {
		return this.id_service_offered;
	}
	
	public String  getService_offered() {
		switch(this.id_service_offered)
		{
		case 1:return "Medicina"; 
		case 2:return "Pediatria"; 
		case 3:return "Odontologia"; 
		case 4:return "Cardiologia"; 
		case 5:return "Traumatologia"; 
		default:return "NADA"; 
		}
	}


	public void setNombre(Integer dd) {
		this.dd = dd;
	}

	public static EntityManager entityManager() {
		return (new UnitPersistence()).get();
	}

	public static List<Roster> findAll() {
		Roster c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Roster> query = em.createQuery("SELECT p FROM Roster p", Roster.class);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error2");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return Collections.emptyList();
	}

	public static Roster findRoster(Integer id) {
		Roster c = null;
		EntityManager em = entityManager();
		try {
			em.getTransaction().begin();
			c = em.find(Roster.class, id);
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

