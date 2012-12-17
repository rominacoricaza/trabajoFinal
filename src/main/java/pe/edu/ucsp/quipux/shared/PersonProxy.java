package pe.edu.ucsp.quipux.shared;
	
import pe.edu.ucsp.quipux.server.Person;
	
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
	
@ProxyFor(Person.class)
public interface PersonProxy extends EntityProxy {

	public Integer getId();
	public void setId(Integer id);
	public String getfirst_surname();
	public  String getsecond_surname();
	public  String getnames() ;
	public String getsexo();
	public Integer getdocument_number();
	public void setid_person(String first_surname);
	
}	