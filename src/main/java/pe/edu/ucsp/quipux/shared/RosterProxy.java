package pe.edu.ucsp.quipux.shared;


import pe.edu.ucsp.quipux.server.Roster;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(Roster.class)
public interface RosterProxy  extends EntityProxy{
	

	public Integer getId();
	public void setId(Integer id);
	public Integer getId_person();
	public void setId_institution(Integer id_institution);
	public Integer getDd();
	public Integer getMm();
	public Integer getYyyy();
	public Integer getId_physical_location();
	public String getPhysical_location();
	public Integer getId_service_offered();
	public String  getService_offered();
	public void setNombre(Integer dd);

}