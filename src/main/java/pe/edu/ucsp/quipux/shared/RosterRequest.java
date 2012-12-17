package pe.edu.ucsp.quipux.shared;

import java.util.List;

import pe.edu.ucsp.quipux.server.Roster;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Roster.class)
public interface RosterRequest extends RequestContext{
	Request<RosterProxy> findRoster(Integer id);
	Request<List<RosterProxy>> findAll();
}