package pe.edu.ucsp.quipux.shared;

import java.util.List;


import pe.edu.ucsp.quipux.server.Person;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Person.class)
public interface PersonRequest extends RequestContext {
	Request<PersonProxy> findPerson(Integer id);
	Request<List<PersonProxy>> findAll();
}
