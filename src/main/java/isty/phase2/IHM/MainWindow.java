
package isty.phase2.IHM;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import org.json.JSONObject;

import isty.phase2.Groupe.GroupeImplementation;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class MainWindow {

	public JFrame frame;
	/**
	 * Create the application.
	 */
	public MainWindow(GroupeImplementation sess) {

		initialize(sess);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GroupeImplementation sess) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);

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


		JFormattedTextField idGroupe = new JFormattedTextField();
		idGroupe.setText("ID");
		idGroupe.setBounds(6, 157, 295, 26);
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


		JButton dGroupe = new JButton("Supprimer groupe");
		dGroupe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String url = "http://localhost:8080/hello"; // Remplacez par votre endpoint réel

				Client client = ClientBuilder.newClient();
				Response response = client.target(url).request().get();

				if (response.getStatus() == 200) {
					String resultat = response.readEntity(String.class);
					System.out.println("Réponse du serveur : " + resultat);
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
			JSONObject req = new JSONObject();
			req.put("id", idGroupe.getText());
			String rep = sess.getGroupe(req.toString());
			if (!rep.equals("erreur"))
			{
	
			console.setText(rep);
			}
			else
			{
				console.setText("");
				console.append("Erreur affichage vérifier l'exitence de l'id\n");
			}

			}
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
				String isu = iSujet.getText();
				String iel = iEleve.getText();
				String iue = iEU.getText();
				// Générez un ID unique entre 1 et 100 inclus
				int randomId;
				do {
				    randomId = random.nextInt(100) + 1;
				} while (!groupeIds.add(randomId));

				// Convertissez le nombre en une chaîne
				String id = Integer.toString(randomId);
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("ueID", iue);
				obj.put("eleveID", iel);
				obj.put("sujetID", isu);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createGroupe(obj.toString()));
				console.append("Groupe crée, id :"+ objRet.getString("id"));
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
				String id = idUE.getText();
				JSONObject obj = new JSONObject();
				obj.put("UUID", id);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.deleteEU(obj.toString()));
				if (objRet.getString("result").equals("done"))
					console.append("UE supprimée, id :"+ id);
				else
					console.append("Erreur suppression vérfier l'exitence de l'id");
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
				JSONObject req = new JSONObject();
				req.put("id", idEleve.getText());
				String rep = sess.getEleve(req.toString());
				if (!rep.equals("erreur"))
				{
					JSONObject view  = new JSONObject(rep);
					String id = view.getString("id");
					String prenom = view.getString("prenom");
					String nom = view.getString("nom");
					console.setText("");
					console.append(" Elève : ID ; Prenom ; Nom \n");
					console.append(""+id+" ; "+ prenom +" ; "+ nom +"\n");
				}
				else
				{
					console.setText("");
					console.append("Erreur affichage vérfier l'éxitence de l'id\n");
				}


			}
		});
		vEleve.setBounds(303, 186, 135, 29);
		vEleve.setForeground(Color.white);
		vEleve.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(vEleve);

		JButton vSujet = new JButton("Afficher sujet");
		vSujet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JSONObject req = new JSONObject();
				req.put("id", idSujet.getText());
				String rep = sess.getSujet(req.toString());
				if (!rep.equals("erreur"))
				{
					JSONObject view  = new JSONObject(rep);
					String id = view.getString("id");
					String titre = view.getString("titre");
					LocalTime fin = LocalTime.parse(view.getString("fin"));
					LocalDate jour = LocalDate.parse(view.getString("jour"));
					console.setText("");
					console.append("Sujet : ID ; titre ; fin ; jour \n");
					console.append(""+id+" ; "+ titre +" ; "+ fin +" ; "+jour +"\n");
				}
				else
				{
					console.setText("");
					console.append("Erreur affichage vérfier l'exitence de l'id\n");
				}

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
				JSONObject req = new JSONObject();
				req.put("id", idUE.getText());
				String rep = sess.getUE(req.toString());
				if (!rep.equals("erreur"))
				{
					JSONObject view  = new JSONObject(rep);
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
				}
				else
				{
					console.setText("");
					console.append("Erreur affichage vérfier l'exitence de l'id\n");
				}
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
				String id = idSujet.getText();
				JSONObject obj = new JSONObject();
				obj.put("UUID", id);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.deleteSujet(obj.toString()));
				if (objRet.getString("result").equals("done"))
					console.append("Sujet supprimé, id :"+ id);
				else
					console.append("Erreur suppression vérfier l'exitence de l'id");
				//TODO: This needs testing (not tested)
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
				String id = idEleve.getText();
				JSONObject obj = new JSONObject();
				obj.put("UUID", id);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.deleteEleve(obj.toString()));
				if (objRet.getString("result").equals("done"))
					console.append("Eleve supprimé, id :"+ id);
				else
					console.append("Erreur suppression vérfier l'exitence de l'id");
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

				// Convertissez le nombre en une chaîne
				String id = Integer.toString(randomId);
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("code", co);
				obj.put("intitule", inti);
				obj.put("cours", cou);
				obj.put("td", TD);
				obj.put("tp", TP);
				obj.put("valeur", val);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createEU(obj.toString()));
				console.append("UE cree, id :"+ objRet.getString("id"));

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
				
				// Convertissez le nombre en une chaîne
				// Générez un ID unique entre 1 et 100 inclus
				int randomId;
				do {
				    randomId = random.nextInt(100) + 1;
				} while (!sujetIds.add(randomId));

				// Convertissez le nombre en une chaîne
				String id = Integer.toString(randomId);
				String tit = titre.getText();
				String fi = fin.getText();
				String jo = jour.getText();
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("titre", tit);
				obj.put("fin", fi);
				obj.put("jour", jo);
				//TODO: Test this shit !
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createSujet(obj.toString()));
				console.append("Sujet crée, id :"+ objRet.getString("id"));

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
				String p = prenom.getText();
				String n = nom.getText();
				// Générez un ID unique entre 1 et 100 inclus
				int randomId;
				do {
				    randomId = random.nextInt(100) + 1;
				} while (!eleveIds.add(randomId));

				// Convertissez le nombre en une chaîne
				String id = Integer.toString(randomId);
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("prenom", p);
				obj.put("nom", n);
				console.setText("");
				JSONObject objRet = new JSONObject(sess.createEleve(obj.toString()));
				console.append("Eleve crée, id :"+ objRet.getString("id"));

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
				String ls = sess.listGroupe();
				JSONObject obj = new JSONObject(ls);
				console.setText("");
				console.append("Groupe : ID ; ID Eleve ;ID Sujet ; ID Ue \n");
				console.append(obj.getString("response"));

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
				String ls = sess.listEleve();
				JSONObject obj = new JSONObject(ls);
				console.setText("");
				console.append("Elève : ID ;Prenom ; Nom \n");
				console.append(obj.getString("response"));

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
				String ls = sess.listSujet();
				JSONObject obj = new JSONObject(ls);
				console.setText("");
				console.append("Sujet : ID ; titre ;fin ; jour \n");
				console.append(obj.getString("response"));
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
				String ls = sess.listEU();
				JSONObject obj = new JSONObject(ls);
				console.setText("");
				console.append("UE : ID ; code ; intitule ;cours ; td ; tp ; valeur \n");
				console.append(obj.getString("response"));
			}
		});
		lUE.setBounds(467, 281, 127, 29);
		lUE.setForeground(Color.white);
		lUE.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(lUE);


	}
}
