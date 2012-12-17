package pe.edu.ucsp.quipux.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;


public interface FactoryPatient extends RequestFactory {
	PatientRequest getRequest();
	//PatientRequest getRequest2();
}
