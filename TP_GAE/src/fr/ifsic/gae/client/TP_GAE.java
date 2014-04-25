package fr.ifsic.gae.client;

import java.util.List;

import fr.ifsic.gae.shared.FieldVerifier;
import fr.ifsic.gae.shared.Home;
import fr.ifsic.gae.shared.Person;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TP_GAE implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync service = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		
		VerticalPanel v1 = new VerticalPanel();
		HorizontalPanel p1 = new HorizontalPanel();
		HorizontalPanel p2 = new HorizontalPanel();
		HorizontalPanel p3 = new HorizontalPanel();
		HorizontalPanel p4 = new HorizontalPanel();
		HorizontalPanel p5 = new HorizontalPanel();
		VerticalPanel v2 = new VerticalPanel();
		VerticalPanel v3 = new VerticalPanel();
		VerticalPanel v4 = new VerticalPanel();
		VerticalPanel v5 = new VerticalPanel();
		
		Label l1 = new Label("Nom");
		final TextBox t1 = new TextBox();
		p1.add(l1);
		p1.add(t1);
		p1.setSpacing(10);
		v1.add(p1);
		
		
		Label l2 = new Label("Prenom");
		final TextBox t2 = new TextBox();
		
		p2.add(l2);
		p2.add(t2);
		//p2.setSpacing(5);
		v2.add(p2);
		
		Label l3 = new Label("mail");
		final TextBox t3 = new TextBox();
		p3.add(l3);
		p3.add(t3);
		p3.setSpacing(10);
		v3.add(p3);
		
		Label l4 = new Label("ProfilFcbk");
		final TextBox t4 = new TextBox();
		p4.add(l4);
		p4.add(t4);
		//p4.setSpacing(5);
		v4.add(p4);

		
	
		
		
		
		Button bs = new Button("listAllPerson");
		Button b = new Button("create");
		p5.add(bs);
		p5.add(b);
		p5.setSpacing(15);
		v5.add(p5);
		
		
		RootPanel.get().add(v1);
		RootPanel.get().add(v2);
		RootPanel.get().add(v3);
		RootPanel.get().add(v4);
		RootPanel.get().add(v5);
		
		b.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				//service.createPerson(t1.getText(), t2.getText(),t3.getText(),t4.getText(), new AsyncCallback<Person>() {
					service.createHome(72, 3, "avenue de la", "138.128.152", new AsyncCallback<Home>() {
						
					
					@Override
					public void onSuccess(Home result) {
						//Window.alert("Ok " + result.getNom()+ result.getPrenom() + " cree");
						Window.alert("Ok " + result.getAdresse()+  " cree");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
		});
		
		bs.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				service.listAllPerson(new AsyncCallback<List<Person>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(List<Person> result) {
						StringBuffer buf = new StringBuffer();
						for (Person p : result){
							buf.append("person " + p.getId() + " "+ p.getNom() + " " + p.getPrenom());
						}
						Window.alert(buf.toString());
					}
				});
			}
		});
		
		
	}
}
