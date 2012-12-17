package pe.edu.ucsp.quipux.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;


public class proyecto implements EntryPoint {

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	
		public void onModuleLoad() 
		{
		
			Primeraventana p=new Primeraventana();
			p.cabezera();
			p.funcion();
			p.Salida();
			p.Enviar();

		}
	
}


