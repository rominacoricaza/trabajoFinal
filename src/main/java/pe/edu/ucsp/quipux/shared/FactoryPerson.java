package pe.edu.ucsp.quipux.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;


public interface FactoryPerson extends RequestFactory {
	
	PersonRequest getRequest();
}