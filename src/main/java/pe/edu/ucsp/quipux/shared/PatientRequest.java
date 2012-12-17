package pe.edu.ucsp.quipux.shared;

import java.util.List;


import pe.edu.ucsp.quipux.server.Patient;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Patient.class)
public interface PatientRequest extends RequestContext {
	Request<PatientProxy> findPatient(Integer id);
	Request<List<PatientProxy>> findAll();
}
