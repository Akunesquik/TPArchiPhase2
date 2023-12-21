
package isty.phase2.IHM;

import isty.phase2.Groupe.*;
import isty.phase2.server.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URI;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;
import java.time.LocalTime;
import java.time.LocalDate;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.client.WebTarget;
import org.json.JSONObject;

public class MainWindow {
	private static Logger logger = Logger.getLogger(MainWindow.class.getSimpleName());
	public JFrame frame;
	ClientConfig clientConfig;
	/**
	 * Create the application.
	 */
	public MainWindow() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ClientConfig.configCheck();
		clientConfig = ClientConfig.loadConfig();
		

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);

		/**
		 * Test De la disponibilité du serveur
		 * Pop up si non trouvé
		 */
		Client client_test = ClientBuilder.newClient();
		try {
			URI uri = UriBuilder.fromUri(clientConfig.getAdress()).port(clientConfig.getPort()).build();
			Response response = client_test.target(uri.toString() + "hello").request().get();
			if (response.getStatus() == Response.Status.OK.getStatusCode()) {
				logger.info("Le serveur est disponible : " + uri.toURL());
			}
		} catch (Exception e) {
			logger.severe("Erreur lors de la connexion au serveur : " + e.getMessage());
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Résultat de la connexion au serveur", JOptionPane.WARNING_MESSAGE);
		} finally {
			client_test.close();
		}
		
		/**
		 * Zone de Texte "prenom" de l'ELEVE fonction de focus comprise
		 */
		JFormattedTextField prenom = new JFormattedTextField();
		prenom.setText("Prenom");
		prenom.setBounds(6, 6, 79, 26);
		prenom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (prenom.getText().equals("Prenom")) {
					prenom.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (prenom.getText().isEmpty()) {
					prenom.setText("Prenom");
				}
			}
		});
		frame.getContentPane().add(prenom);
		frame.setVisible(true);

		/**
		 * Zone de Texte "nom" de l'ELEVE fonction de focus comprise
		 */
		JFormattedTextField nom = new JFormattedTextField();
		nom.setText("Nom");
		nom.setBounds(85, 6, 79, 26);
		nom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (nom.getText().equals("Nom")) {
					nom.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nom.getText().isEmpty()) {
					nom.setText("Nom");
				}
			}
		});
		frame.getContentPane().add(nom);
		frame.setVisible(true);

		/**
		 * Zone de Texte "TITRE" du sujet fonction de focus comprise
		 */
		JFormattedTextField titre = new JFormattedTextField();
		titre.setText("Titre");
		titre.setBounds(6, 34, 79, 26);
		titre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (titre.getText().equals("Titre")) {
					titre.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (titre.getText().isEmpty()) {
					titre.setText("Titre");
				}
			}
		});
		frame.getContentPane().add(titre);
		frame.setVisible(true);

		/**
		 * Zone de Texte "Heure" du sujet fonction de focus comprise
		 */
		JFormattedTextField fin = new JFormattedTextField();
		fin.setText("Heure: hh:mm");
		fin.setBounds(85, 34, 79, 26);
		fin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fin.getText().equals("Heure: hh:mm")) {
					fin.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fin.getText().isEmpty()) {
					fin.setText("Heure: hh:mm");
				}
			}
		});
		frame.getContentPane().add(fin);
		frame.setVisible(true);

		/**
		 * Zone de Texte "Jour" du sujet fonction de focus comprise
		 */
		JFormattedTextField jour = new JFormattedTextField();
		jour.setText("aa-mm-jj");
		jour.setBounds(167, 34, 79, 26);
		jour.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (jour.getText().equals("aa-mm-jj")) {
					jour.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (jour.getText().isEmpty()) {
					jour.setText("aa-mm-jj");
				}
			}
		});
		frame.getContentPane().add(jour);
		frame.setVisible(true);

		/**
		 * Zone de Texte "CODE" de l'UE fonction de focus comprise
		 */
		JFormattedTextField code = new JFormattedTextField();
		code.setText("Code");
		code.setBounds(6, 63, 79, 26);
		code.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (code.getText().equals("Code")) {
					code.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (code.getText().isEmpty()) {
					code.setText("Code");
				}
			}
		});
		frame.getContentPane().add(code);
		frame.setVisible(true);

		/**
		 * Zone de Texte "Intitulé" de l'UE fonction de focus comprise
		 */
		JFormattedTextField intitule = new JFormattedTextField();
		intitule.setText("Intitulé");
		intitule.setBounds(85, 63, 79, 26);
		intitule.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (intitule.getText().equals("Intitulé")) {
					intitule.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (intitule.getText().isEmpty()) {
					intitule.setText("Intitulé");
				}
			}
		});
		frame.getContentPane().add(intitule);
		frame.setVisible(true);

		/**
		 * Zone de Texte "TD" de l'UE fonction de focus comprise
		 */
		JFormattedTextField td = new JFormattedTextField();
		td.setText("TD (0.0)");
		td.setBounds(167, 63, 79, 26);
		td.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (td.getText().equals("TD (0.0)")) {
					td.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (td.getText().isEmpty()) {
					td.setText("TD (0.0)");
				}
			}
		});
		frame.getContentPane().add(td);
		frame.setVisible(true);

		/**
		 * Zone de Texte "TP" de l'UE fonction de focus comprise
		 */
		JFormattedTextField tp = new JFormattedTextField();
		tp.setText("TP (0.0)");
		tp.setBounds(247, 63, 79, 26);
		tp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tp.getText().equals("TP (0.0)")) {
					tp.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tp.getText().isEmpty()) {
					tp.setText("TP (0.0)");
				}
			}
		});
		frame.getContentPane().add(tp);
		frame.setVisible(true);

		/**
		 * Zone de Texte COURS" de l'UE fonction de focus comprise
		 */
		JFormattedTextField cours = new JFormattedTextField();
		cours.setText("Cours(0.0)");
		cours.setBounds(332, 63, 79, 26);
		cours.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (cours.getText().equals("Cours(0.0)")) {
					cours.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (cours.getText().isEmpty()) {
					cours.setText("Cours(0.0)");
				}
			}
		});
		frame.getContentPane().add(cours);
		frame.setVisible(true);

		/**
		 * Zone de Texte "Valeur" de l'UE fonction de focus comprise
		 */
		JFormattedTextField valeur = new JFormattedTextField();
		valeur.setText("Valeur(0.0)");
		valeur.setBounds(411, 63, 68, 26);
		valeur.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (valeur.getText().equals("Valeur(0.0)")) {
					valeur.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (valeur.getText().isEmpty()) {
					valeur.setText("Valeur(0.0)");
				}
			}
		});
		frame.getContentPane().add(valeur);
		frame.setVisible(true);

		/**
		 * Zone de Texte "ID Eleve" du Groupe fonction de focus comprise
		 */
		JFormattedTextField idEleve = new JFormattedTextField();
		idEleve.setText("ID");
		idEleve.setBounds(6, 186, 295, 26);
		idEleve.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (idEleve.getText().equals("ID")) {
					idEleve.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idEleve.getText().isEmpty()) {
					idEleve.setText("ID");
				}
			}
		});
		frame.getContentPane().add(idEleve);
		frame.setVisible(true);

		/**
		 * Zone de Texte "ID Sujet" du Groupe fonction de focus comprise
		 */
		JFormattedTextField idSujet = new JFormattedTextField();
		idSujet.setText("ID");
		idSujet.setBounds(6, 214, 295, 26);
		idSujet.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (idSujet.getText().equals("ID")) {
					idSujet.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idSujet.getText().isEmpty()) {
					idSujet.setText("ID");
				}
			}
		});
		frame.getContentPane().add(idSujet);
		frame.setVisible(true);

		/**
		 * Zone de Texte "IDUE" du Groupe fonction de focus comprise
		 */
		JFormattedTextField idUE = new JFormattedTextField();
		idUE.setText("ID");
		idUE.setBounds(6, 243, 295, 26);
		idUE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (idUE.getText().equals("ID")) {
					idUE.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idUE.getText().isEmpty()) {
					idUE.setText("ID");
				}
			}
		});
		frame.getContentPane().add(idUE);
		frame.setVisible(true);

		/**
		 * Zone de Texte "ID ELEVE" pour la suppression fonction de focus comprise
		 */
		JFormattedTextField iEleve = new JFormattedTextField();
		iEleve.setText("ID Elève");
		iEleve.setBounds(6, 90, 79, 26);
		iEleve.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (iEleve.getText().equals("ID Elève")) {
					iEleve.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (iEleve.getText().isEmpty()) {
					iEleve.setText("ID Elève");
				}
			}
		});
		frame.getContentPane().add(iEleve);
		frame.setVisible(true);

		/**
		 * Zone de Texte "ID SUjet" pour la suppression fonction de focus comprise
		 */
		JFormattedTextField iSujet = new JFormattedTextField();
		iSujet.setText("ID Sujet");
		iSujet.setBounds(85, 90, 79, 26);
		iSujet.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (iSujet.getText().equals("ID Sujet")) {
					iSujet.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (iSujet.getText().isEmpty()) {
					iSujet.setText("ID Sujet");
				}
			}
		});
		frame.getContentPane().add(iSujet);
		frame.setVisible(true);

		/**
		 * Zone de Texte "ID UE" pour la suppression fonction de focus comprise
		 */
		JFormattedTextField iEU = new JFormattedTextField();
		iEU.setText("ID UE");
		iEU.setBounds(167, 90, 79, 26);
		iEU.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (iEU.getText().equals("ID UE")) {
					iEU.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (iEU.getText().isEmpty()) {
					iEU.setText("ID UE");
				}
			}
		});
		frame.getContentPane().add(iEU);
		frame.setVisible(true);

		/**
		 * Zone de Texte "ID GROUPE" pour la suppression fonction de focus comprise
		 */
		JFormattedTextField idGroupe = new JFormattedTextField();
		idGroupe.setText("ID");
		idGroupe.setBounds(12, 157, 295, 26);
		idGroupe.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (idGroupe.getText().equals("ID")) {
					idGroupe.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idGroupe.getText().isEmpty()) {
					idGroupe.setText("ID");
				}
			}
		});
		frame.getContentPane().add(idGroupe);
		frame.setVisible(true);

		JTextArea console = new JTextArea();
		console.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(console);
		scrollPane.setBounds(8, 340, 570, 210);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);

		/**
		 * Bouton "Suppr Groupe" Avec la fonction d'effacement comprise de le action
		 * Listener
		 */
		JButton dGroupe = new JButton("Supprimer groupe");
		dGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"Groupe/delete"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idGroupe.getText().toString();

				Form form = new Form();
				form.param("id",idselect);


                Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));


				// Traiter la réponse
				if (response.getStatus() == 200) {
					console.setText("");
					String resultat = response.readEntity(String.class);
					JSONObject view  = new JSONObject(resultat);
					if (view.getString("result").equals("done")){
						console.append("Groupe supprimée, id :"+ idselect);
					}

				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}

				client.close();
                

            }
            /*
             * @Override
            public void actionPerformed(ActionEvent e) {
                String id = idGroupe.getText();
                JSONObject obj = new JSONObject();
                obj.put("UUID", id);
                console.setText("");
                JSONObject objRet = new JSONObject(sess.deleteGroupe(obj.toString()));
                if (objRet.getString("result").equals("done"))
                    console.append("groupe supprimé, id :"+ id);
                else
                    console.append("Erreur suppression vérifier l'exitence de l'id");
                

            }
            */
        });
		dGroupe.setBounds(436, 157, 158, 29);
		dGroupe.setForeground(Color.white);
		dGroupe.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(dGroupe);

		JButton vGroupe = new JButton("Afficher groupe");
		vGroupe.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"Groupe/search"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idGroupe.getText().toString();
				
				Form form = new Form();
				form.param("id",idselect);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				// Traiter la réponse
				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					console.setText(resultat);
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}

			}

			// JSONObject req = new JSONObject();
			// req.put("id", idGroupe.getText());
			// String rep = sess.getGroupe(req.toString());
			// if (!rep.equals("erreur"))
			// {
	
			// console.setText(rep);
			// }
			// else
			// {
			// 	console.setText("");
			// 	console.append("Erreur affichage vérifier l'exitence de l'id\n");
			// }
		});
		vGroupe.setBounds(303, 157, 135, 29);
		vGroupe.setForeground(Color.white);
		vGroupe.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(vGroupe);

		// Créez une instance de Random
		Random random = new Random();
		// Créez un ensemble pour stocker les IDs générés
		Set<Integer> groupeIds = new HashSet<>();
		Set<Integer> sujetIds = new HashSet<>();
		Set<Integer> eleveIds = new HashSet<>();
		Set<Integer> ueIds = new HashSet<>();

		JButton cGroupe = new JButton("Creer groupe");
		cGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL() + "Groupe/create"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
				WebTarget target = client.target(apiUrl);

				String isu = iSujet.getText();
				String iel = iEleve.getText();
				String iue = iEU.getText();

				// Générez un ID unique entre 1 et 100 inclus
				int randomId;
				do {
				     randomId = random.nextInt(100) + 1;
				} while (!groupeIds.add(randomId));
				String id = Integer.toString(randomId);

				Form form = new Form();
				form.param("id",id);
				form.param("iSujet",isu);
				form.param("iEleve", iel);
				form.param("iEU", iue);

       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				// Traiter la réponse
				if (response.getStatus() == 200) {

					String resultat = response.readEntity(String.class);
					JSONObject objRet = new JSONObject(resultat);
					console.setText("");
					console.append("Groupe crée, id :"+ objRet.getString("id"));
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}

				// String isu = iSujet.getText();
				// String iel = iEleve.getText();
				// String iue = iEU.getText();
				// // Générez un ID unique entre 1 et 100 inclus
				// int randomId;
				// do {
				// randomId = random.nextInt(100) + 1;
				// } while (!groupeIds.add(randomId));

				// // Convertissez le nombre en une chaîne
				// String id = Integer.toString(randomId);
				// JSONObject obj = new JSONObject();
				// obj.put("id", id);
				// obj.put("ueID", iue);
				// obj.put("eleveID", iel);
				// obj.put("sujetID", isu);
				// console.setText("");
				// JSONObject objRet = new JSONObject(sess.createGroupe(obj.toString()));
				// console.append("Groupe crée, id :"+ objRet.getString("id"));
			}
		});
		cGroupe.setBounds(477, 90, 117, 29);
		cGroupe.setForeground(Color.white);
		cGroupe.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(cGroupe);

		JButton dUE = new JButton("Supprimer UE");
		dUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"UE/delete"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idUE.getText().toString();
				
				Form form = new Form();
				form.param("id",idselect);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				
				console.append(response.toString());
				// Traiter la réponse
				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					JSONObject view  = new JSONObject(resultat);
					if (view.getString("result").equals("done")){
						console.setText("");
						console.append("UE supprimée, id :"+ idselect);
					}
						
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}




				// String id = idUE.getText();
				// JSONObject obj = new JSONObject();
				// obj.put("UUID", id);
				// console.setText("");
				// JSONObject objRet = new JSONObject(sess.deleteEU(obj.toString()));
				// if (objRet.getString("result").equals("done"))
				// console.append("UE supprimée, id :"+ id);
				// else
				// console.append("Erreur suppression vérfier l'exitence de l'id");
			}
		});
		dUE.setBounds(436, 243, 158, 29);
		dUE.setForeground(Color.white);
		dUE.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(dUE);

		JButton vEleve = new JButton("Afficher élève");
		vEleve.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"Eleve/search"; // Remplacez par votre URL réelle
				System.out.println(clientConfig.getURL());
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idEleve.getText().toString();
				
				Form form = new Form();
				form.param("id",idselect);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				// Traiter la réponse
				if (response.getStatus() == 200) {

					String resultat = response.readEntity(String.class);
					JSONObject view  = new JSONObject(resultat);
					String id = view.getString("id");
					String prenom = view.getString("prenom");
					String nom = view.getString("nom");
					console.setText("");
					console.append(" Elève : ID ; Prenom ; Nom \n");
					console.append(""+id+" ; "+ prenom +" ; "+ nom +"\n");
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}

			}



				// JSONObject req = new JSONObject();
				// req.put("id", idEleve.getText());
				// String rep = sess.getEleve(req.toString());
				// if (!rep.equals("erreur"))
				// {
				// 	JSONObject view  = new JSONObject(rep);
				// 	String id = view.getString("id");
				// 	String prenom = view.getString("prenom");
				// 	String nom = view.getString("nom");
				// 	console.setText("");
				// 	console.append(" Elève : ID ; Prenom ; Nom \n");
				// 	console.append(""+id+" ; "+ prenom +" ; "+ nom +"\n");
				// }
				// else
				// {
				// 	console.setText("");
				// 	console.append("Erreur affichage vérfier l'éxitence de l'id\n");
				// }


			}
		);
		vEleve.setBounds(303, 186, 135, 29);
		vEleve.setForeground(Color.white);
		vEleve.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(vEleve);

		JButton vSujet = new JButton("Afficher sujet");
		vSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"Sujet/search"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idSujet.getText().toString();
				
				Form form = new Form();
				form.param("id",idselect);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				// Traiter la réponse
				if (response.getStatus() == 200) {

					String resultat = response.readEntity(String.class);
					JSONObject view  = new JSONObject(resultat);
				 	String id = view.getString("id");
				 	String titre = view.getString("titre");
				 	LocalTime fin = LocalTime.parse(view.getString("fin"));
				 	LocalDate jour = LocalDate.parse(view.getString("jour"));
				 	console.setText("");
				 	console.append("Sujet : ID ; titre ; fin ; jour \n");
				 	console.append(""+id+" ; "+ titre +" ; "+ fin +" ; "+jour +"\n");
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}
				// JSONObject req = new JSONObject();
				// req.put("id", idSujet.getText());
				// String rep = sess.getSujet(req.toString());
				// if (!rep.equals("erreur"))
				// {
				// JSONObject view = new JSONObject(rep);
				// String id = view.getString("id");
				// String titre = view.getString("titre");
				// LocalTime fin = LocalTime.parse(view.getString("fin"));
				// LocalDate jour = LocalDate.parse(view.getString("jour"));
				// console.setText("");
				// console.append("Sujet : ID ; titre ; fin ; jour \n");
				// console.append(""+id+" ; "+ titre +" ; "+ fin +" ; "+jour +"\n");
				// }
				// else
				// {
				// console.setText("");
				// console.append("Erreur affichage vérfier l'exitence de l'id\n");
				// }

			}
		});
		vSujet.setBounds(303, 214, 135, 29);
		vSujet.setForeground(Color.white);
		vSujet.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(vSujet);

		JButton vUE = new JButton("Afficher UE");
		vUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"UE/search"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idUE.getText().toString();
				
				Form form = new Form();
				form.param("id",idselect);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				// Traiter la réponse
				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					JSONObject view  = new JSONObject(resultat);
					String id = view.getString("id");
					String code = view.getString("code");
					String intitule = view.getString("intitule");
					float cours = Float.parseFloat(view.getString("cours"));
					float td = Float.parseFloat(view.getString("td"));
					float tp = Float.parseFloat(view.getString("tp"));
					float valeur = Float.parseFloat(view.getString("valeur"));
					console.setText("");
					console.append("UE : ID;code ; intitule ; cours;td ; tp;valeur \n");
					console.append(""+id+" ; "+ code +" ; "+ intitule +" ; "+cours +" ; "+td+ " ; "+ tp +" ; "+valeur+"\n");
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}

				// JSONObject req = new JSONObject();
				// req.put("id", idUE.getText());
				// String rep = sess.getUE(req.toString());
				// if (!rep.equals("erreur"))
				// {
				// JSONObject view = new JSONObject(rep);
				// String id = view.getString("id");
				// String code = view.getString("code");
				// String intitule = view.getString("intitule");
				// float cours = Float.parseFloat(view.getString("cours"));
				// float td = Float.parseFloat(view.getString("td"));
				// float tp = Float.parseFloat(view.getString("tp"));
				// float valeur = Float.parseFloat(view.getString("valeur"));
				// console.setText("");
				// console.append("UE : ID;code ; intitule ; cours;td ; tp;valeur \n");
				// console.append(""+id+" ; "+ code +" ; "+ intitule +" ; "+cours +" ; "+td+ " ;
				// "+ tp +" ; "+valeur+"\n");
				// }
				// else
				// {
				// console.setText("");
				// console.append("Erreur affichage vérfier l'exitence de l'id\n");
				// }
			}
		});
		vUE.setBounds(303, 243, 135, 29);
		vUE.setForeground(Color.white);
		vUE.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(vUE);

		JButton dSujet = new JButton("Supprimer sujet");
		dSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"Sujet/delete"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idSujet.getText().toString();
				
				Form form = new Form();
				form.param("id",idselect);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				
				console.append(response.toString());
				// Traiter la réponse
				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					JSONObject view  = new JSONObject(resultat);
					if (view.getString("result").equals("done"))
						console.append("Sujet supprimée, id :"+ idselect);
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}
				// String id = idSujet.getText();
				// JSONObject obj = new JSONObject();
				// obj.put("UUID", id);
				// console.setText("");
				// JSONObject objRet = new JSONObject(sess.deleteSujet(obj.toString()));
				// if (objRet.getString("result").equals("done"))
				// console.append("Sujet supprimé, id :"+ id);
				// else
				// console.append("Erreur suppression vérfier l'exitence de l'id");
				// TODO: This needs testing (not tested)
			}
		});
		dSujet.setBounds(436, 214, 158, 29);
		dSujet.setForeground(Color.white);
		dSujet.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(dSujet);

		JButton dEleve = new JButton("Supprimer éleve");
		dEleve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL()+"Eleve/delete"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String idselect = idEleve.getText().toString();
				
				Form form = new Form();
				form.param("id",idselect);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				
				console.append(response.toString());
				// Traiter la réponse
				if (response.getStatus() == 200) {
					console.setText("");
					String resultat = response.readEntity(String.class);
					JSONObject view  = new JSONObject(resultat);
					if (view.getString("result").equals("done")){
						console.append("Eleve supprimée, id :"+ idselect);
					}
						
				} else {
					System.out.println("Erreur lors de la requête. Code : " + response.getStatus());
				}

				client.close();
				// String id = idEleve.getText();
				// JSONObject obj = new JSONObject();
				// obj.put("UUID", id);
				// console.setText("");
				// JSONObject objRet = new JSONObject(sess.deleteEleve(obj.toString()));
				// if (objRet.getString("result").equals("done"))
				// console.append("Eleve supprimé, id :"+ id);
				// else
				// console.append("Erreur suppression vérfier l'exitence de l'id");
			}
		});
		dEleve.setBounds(436, 186, 158, 29);
		dEleve.setForeground(Color.white);
		dEleve.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(dEleve);

		JButton cUE = new JButton("Creer UE");
		cUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL() +"UE/create"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				String co = code.getText();
				String inti = intitule.getText();
				String cou = cours.getText();
				String TD = td.getText();
				String TP = tp.getText();
				String val = valeur.getText();

				// Générez un ID unique entre 1 et 100 inclus
				int randomId;
				do {
				    randomId = random.nextInt(100) + 1;
				} while (!ueIds.add(randomId));
				String id = Integer.toString(randomId);

				Form form = new Form();
				form.param("id", id);
				form.param("code", co);
				form.param("intitule", inti);
				form.param("cours", cou);
				form.param("td", TD);
				form.param("tp", TP);
				form.param("valeur", val);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				// Traiter la réponse
				if (response.getStatus() == 200) {

					String resultat = response.readEntity(String.class);
					JSONObject objRet = new JSONObject(resultat);
					console.setText("");
					console.append("UE cree, id :"+ objRet.getString("id"));
				} else {
					logger.warning("Erreur lors de la requête. Code : " + response.getStatus());
				}
				
				// String co = code.getText();
				// String inti = intitule.getText();
				// String cou = cours.getText();
				// String TD = td.getText();
				// String TP = tp.getText();
				// String val = valeur.getText();
				// // Générez un ID unique entre 1 et 100 inclus
				// int randomId;
				// do {
				// randomId = random.nextInt(100) + 1;
				// } while (!ueIds.add(randomId));

				// // Convertissez le nombre en une chaîne
				// String id = Integer.toString(randomId);
				// JSONObject obj = new JSONObject();
				// obj.put("id", id);
				// obj.put("code", co);
				// obj.put("intitule", inti);
				// obj.put("cours", cou);
				// obj.put("td", TD);
				// obj.put("tp", TP);
				// obj.put("valeur", val);
				// console.setText("");
				// JSONObject objRet = new JSONObject(sess.createEU(obj.toString()));
				// console.append("UE cree, id :"+ objRet.getString("id"));

			}
		});
		cUE.setBounds(477, 63, 117, 29);
		cUE.setForeground(Color.white);
		cUE.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(cUE);

		JButton cSujet = new JButton("Creer Sujet");
		cSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL() + "Sujet/create"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
        		WebTarget target = client.target(apiUrl);

				int randomId;
				 do {
				     randomId = random.nextInt(100) + 1;
				 } while (!sujetIds.add(randomId));

				String id = Integer.toString(randomId);
				String tit = titre.getText();
				String fi = fin.getText();
				String jo = jour.getText();
				// Générez un ID unique entre 1 et 100 inclus
				 

				Form form = new Form();
				form.param("id", id);
				form.param("titre", tit);
				form.param("fin", fi);
				form.param("jour", jo);

				// Envoyer la requête POST avec les données
       			Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
				
				// Traiter la réponse
				if (response.getStatus() == 200) {

					String resultat = response.readEntity(String.class);
					JSONObject objRet = new JSONObject(resultat);
					console.setText("");
					console.append("Sujet crée, id :"+ objRet.getString("id"));
				} else {
					logger.warning("Erreur lors de la requête. Code : " + response.getStatus());
				}
				
				client.close();
				// // Convertissez le nombre en une chaîne
				// // Générez un ID unique entre 1 et 100 inclus
				// int randomId;
				// do {
				// randomId = random.nextInt(100) + 1;
				// } while (!sujetIds.add(randomId));

				// // Convertissez le nombre en une chaîne
				// String id = Integer.toString(randomId);
				// String tit = titre.getText();
				// String fi = fin.getText();
				// String jo = jour.getText();
				// JSONObject obj = new JSONObject();
				// obj.put("id", id);
				// obj.put("titre", tit);
				// obj.put("fin", fi);
				// obj.put("jour", jo);
				// //TODO: Test this shit !
				// console.setText("");
				// JSONObject objRet = new JSONObject(sess.createSujet(obj.toString()));
				// console.append("Sujet crée, id :"+ objRet.getString("id"));

			}
		});
		cSujet.setBounds(477, 34, 117, 29);
		cSujet.setForeground(Color.white);
		cSujet.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(cSujet);

		JButton cEleve = new JButton("Creer Eleve");
		cEleve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Créer une instance du client JAX-RS
				Client client = ClientBuilder.newClient();

				// Définir l'URL de la ressource
				String apiUrl = clientConfig.getURL() + "Eleve/create"; // Remplacez par votre URL réelle
				// Créer une instance de WebTarget pour l'URL de la ressource
				WebTarget target = client.target(apiUrl);

				String p = prenom.getText();
				String n = nom.getText();
				// Générez un ID unique entre 1 et 100 inclus
				int randomId;
				do {
					randomId = random.nextInt(100) + 1;
				} while (!eleveIds.add(randomId));

				Form form = new Form();
				form.param("prenom", p);
				form.param("nom", n);
				form.param("id", String.valueOf(randomId));

				// Envoyer la requête POST avec les données
				Response response = target.request(MediaType.APPLICATION_JSON)
						.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));

				// Traiter la réponse
				if (response.getStatus() == 200) {

					String resultat = response.readEntity(String.class);
					JSONObject objRet = new JSONObject(resultat);
					console.setText("");
					console.append("Eleve crée, id :" + objRet.getString("id"));
				} else {
					logger.warning("Erreur lors de la requête. Code : " + response.getStatus());
				}

				client.close();
				

				// String p = prenom.getText();
				// String n = nom.getText();
				// // Générez un ID unique entre 1 et 100 inclus
				// int randomId;
				// do {
				// randomId = random.nextInt(100) + 1;
				// } while (!eleveIds.add(randomId));

				// // Convertissez le nombre en une chaîne
				// String id = Integer.toString(randomId);
				// JSONObject obj = new JSONObject();
				// obj.put("id", id);
				// obj.put("prenom", p);
				// obj.put("nom", n);
				// console.setText("");
				// JSONObject objRet = new JSONObject(sess.createEleve(obj.toString()));
				// console.append("Eleve crée, id :"+ objRet.getString("id"));

			}
		});
		cEleve.setBounds(477, 6, 117, 29);
		cEleve.setForeground(Color.white);
		cEleve.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(cEleve);

		JButton lGroupe = new JButton("Lister groupes");
		lGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = clientConfig.getURL() + "Groupe/list"; // Remplacez par votre endpoint réel

				Client client = ClientBuilder.newClient();
				Response response = client.target(url).request().get();

				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					JSONObject obj = new JSONObject(resultat);
					console.setText("");
					console.append("Groupe : ID ; ID Eleve ;ID Sujet ; ID Ue \n");
					console.append(obj.getString("response"));

				} else {
					logger.warning("Erreur lors de la requête. Code : " + response.getStatus());
				}

				client.close();
				// String ls = sess.listGroupe();
				// JSONObject obj = new JSONObject(ls);
				// console.setText("");
				// console.append("Groupe : ID ; ID Eleve ;ID Sujet ; ID Ue \n");
				// console.append(obj.getString("response"));

			}
		});
		lGroupe.setBounds(6, 281, 127, 29);
		lGroupe.setForeground(Color.white);
		lGroupe.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(lGroupe);

		JButton lEleve = new JButton("Lister éleves");
		lEleve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String url = clientConfig.getURL() + "Eleve/list"; // Remplacez par votre endpoint réel

				Client client = ClientBuilder.newClient();
				Response response = client.target(url).request().get();

				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);

					JSONObject obj = new JSONObject(resultat);
					console.setText("");
					console.append("Elève : ID ;Prenom ; Nom \n");
					console.append(obj.getString("response"));

				} else {
					logger.warning("Erreur lors de la requête. Code : " + response.getStatus());
				}

				client.close();

				// String ls = sess.listEleve();
				// JSONObject obj = new JSONObject(ls);
				// console.setText("");
				// console.append("Elève : ID ;Prenom ; Nom \n");
				// console.append(obj.getString("response"));

			}
		});
		lEleve.setBounds(162, 281, 127, 29);
		lEleve.setForeground(Color.white);
		lEleve.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(lEleve);

		JButton lSujet = new JButton("Lister sujet");
		lSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = clientConfig.getURL() + "Sujet/list"; // Remplacez par votre endpoint réel

				Client client = ClientBuilder.newClient();
				Response response = client.target(url).request().get();

				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					JSONObject obj = new JSONObject(resultat);
					console.setText("");
					console.append("Sujet : ID ; titre ;fin ; jour \n");
					console.append(obj.getString("response"));

				} else {
					logger.warning("Erreur lors de la requête. Code : " + response.getStatus());
				}

				client.close();
				// String ls = sess.listSujet();
				// JSONObject obj = new JSONObject(ls);
				// console.setText("");
				// console.append("Sujet : ID ; titre ;fin ; jour \n");
				// console.append(obj.getString("response"));
			}
		});
		lSujet.setBounds(317, 281, 127, 29);
		lSujet.setForeground(Color.white);
		lSujet.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(lSujet);

		JButton lUE = new JButton("Lister UE");
		lUE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String url = clientConfig.getURL() +"UE/list"; // Remplacez par votre endpoint réel

				Client client = ClientBuilder.newClient();
				Response response = client.target(url).request().get();

				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					JSONObject obj = new JSONObject(resultat);
					console.setText("");
					console.append("UE : ID ; code ; intitule ;cours ; td ; tp ; valeur \n");
					console.append(obj.getString("response"));

				} else {
					logger.warning("Erreur lors de la requête. Code : " + response.getStatus());
				}

				client.close();
				// String ls = sess.listEU();
				// JSONObject obj = new JSONObject(ls);
				// console.setText("");
				// console.append("UE : ID ; code ; intitule ;cours ; td ; tp ; valeur \n");
				// console.append(obj.getString("response"));
			}
		});
		lUE.setBounds(467, 281, 127, 29);
		lUE.setForeground(Color.white);
		lUE.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(lUE);

	}
}
