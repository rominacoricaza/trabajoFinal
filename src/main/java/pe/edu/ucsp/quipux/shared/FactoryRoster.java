package pe.edu.ucsp.quipux.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;


public interface FactoryRoster extends RequestFactory {
	RosterRequest getRequest();
	//PatientRequest getRequest2();
}
