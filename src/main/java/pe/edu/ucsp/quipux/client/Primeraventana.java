package pe.edu.ucsp.quipux.client;

import java.util.List;


import pe.edu.ucsp.quipux.shared.ApplicationRequestFactory;
import pe.edu.ucsp.quipux.shared.PruebaProxy;
import pe.edu.ucsp.quipux.shared.PruebaRequest;

import pe.edu.ucsp.quipux.shared.FactoryPatient;
import pe.edu.ucsp.quipux.shared.FactoryPerson;
import pe.edu.ucsp.quipux.shared.PatientProxy;
import pe.edu.ucsp.quipux.shared.PatientRequest;
import pe.edu.ucsp.quipux.shared.PersonProxy;
import pe.edu.ucsp.quipux.shared.PersonRequest;



import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class Primeraventana {
	
	final TextBox iden 		= new TextBox();
	final Button iden_v 		= new Button("Buscar");
	final TextBox app 		= new TextBox();
	final TextBox apm		= new TextBox();
	final TextBox nombre 	= new TextBox();
	final TextBox sexo 		= new TextBox();
	final TextBox dni 		= new TextBox();
	final Button enviar 	= new Button("Enviar_Solicitud");
	final Button salir	  	= new Button("Salir");
	final ListBox listaEspecialidades 	= new ListBox();
	final ListBox listaUbicacion 		= new ListBox();
	final ListBox listaDoctores			= new ListBox();
	final TextBox numeroAtencion 		= new TextBox();
	final 	FactoryPerson persona = GWT.create(FactoryPerson.class);
	final 	FactoryPatient paciente = GWT.create(FactoryPatient.class);
			

	Primeraventana()
	{
		  

		persona.initialize(new SimpleEventBus());
		paciente.initialize(new SimpleEventBus());

		
	}

	public static void main(String[] args) 
	{
		
		
	}
	public void funcion() 
	{
		//PruebaRequest request = rf.getRequest();
		
	 final PersonRequest request = persona.getRequest();
	 final PatientRequest request2 = paciente.getRequest();
		
				RootPanel.get("iden").add(iden);
				RootPanel.get("iden_verifica").add(iden_v);	
				RootPanel.get("app").add(app);
				RootPanel.get("apm").add(apm);
				RootPanel.get("nombre").add(nombre);
				RootPanel.get("sexo").add(sexo);
				RootPanel.get("dni").add(dni);

			
			request.findAll().fire(new Receiver<List<PersonProxy>>()
			{
				@Override
				public void onSuccess( List<PersonProxy> response) 
				{
				   for(int i =0;i<response.size();i++)
				   {
					listaEspecialidades.addItem(response.get(i).getfirst_surname());
					listaUbicacion.addItem(response.get(i).getfirst_surname());
					listaDoctores.addItem(response.get(i).getfirst_surname());
				   }
				   numeroAtencion.setText(Integer.toString(response.size()+1));
				}
			});
			
			RootPanel.get("doctor").add(listaDoctores);
			RootPanel.get("especialidad").add(listaEspecialidades);
			RootPanel.get("ubicacion").add(listaUbicacion);
			RootPanel.get("atencion").add(numeroAtencion);
			
			iden_v.addClickHandler(new ClickHandler() 
			{
			      public void onClick(ClickEvent event)
			      { 
			    	  Integer entero = (Integer)Integer.parseInt((String)iden.getValue());
			    	if(request2.findPatient((Integer)entero)==null)
			    	  {
			    		  Window.alert("VAYA A REGISTRARSE...USTED NO EXISTE : "+iden.getValue());
			    	  }
			    	  else
			    	  {
			    	   PersonProxy p=(PersonProxy) request.findPerson(entero);
			    		app.setText((String)p.getfirst_surname());
			    		apm.setText((String)p.getsecond_surname());
			    		nombre.setText((String)p.getnames());
			    		sexo.setText((String)p.getsexo());
			    		dni.setText((String)Integer.toString(p.getdocument_number()));

			        }
			      }
			});
			
			     
				   
				  

		
	}
	
	public void cabezera() 
	{
		RootPanel.get("enviar").add(enviar);
		RootPanel.get("salir").add(salir);
	}

	public void Salida()
	{		
		salir.addClickHandler(new ClickHandler() 
		{
			public void onClick(ClickEvent event) 
			{
				RootPanel.get("iden").clear();
				RootPanel.get("app").clear();
				RootPanel.get("apm").clear();
				RootPanel.get("nombre").clear();
				RootPanel.get("sexo").clear();
				RootPanel.get("dni").clear();
				
				iden.setText(" ");
				app.setText(" ");
				apm.setText(" ");
				nombre.setText(" ");
				sexo.setText(" ");
				dni.setText(" ");
				funcion();
			}
		});
	}
	public void Enviar()
	{		
		enviar.addClickHandler(new ClickHandler() 
		{
			public void onClick(ClickEvent event) 
			{
				RootPanel.get("cuadro_1").setVisible(false);
				RootPanel.get("cuadro_2").setVisible(true);
				
			}
		});
	}
	



}
