package pe.edu.ucsp.quipux.shared;
	
import pe.edu.ucsp.quipux.server.Patient;
	
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
	
@ProxyFor(Patient.class)
public interface PatientProxy extends EntityProxy {
	
	public Integer getId();
	public void setId(Integer id);
	public Integer getId_person();
	public void setId_person(Integer id_person);
	public String getDate();
	public void setdate(String date);
	
}	
