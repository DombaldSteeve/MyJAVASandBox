package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl.*;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.impl.ScannerMenuUpdate;

public class ScannerMenu {
	
	private static String four = "fournisseur";
	private static String art = "article";
	private static String bon = "bon";

	
	public static void Display() throws SQLException {
		
		System.out.println();
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" --------- Gestion Base de donnée : COMPTA --------- ");
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" ----------         Menu Principal         ---------" );
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" Taper le numéro correspondant à la Table souhaitée :");
		System.out.println(" ----------    1 - Gestion Fournisseur     ----------");
		System.out.println(" ----------    2 - Gestion Article         ----------");
		System.out.println(" ----------    3 - Gestion Bon             ----------");
		System.out.println(" ----------    4 - Créer une COMPO         ----------");
		System.out.println(" ----------     ######################     ----------");
		
			String input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
			switch (input) {
			
				case "1" : // Gestion Fournisseur
					System.out.println();
					System.out.println(" ----------      ######################      ----------");
					System.out.println(" ------ Gestion Base de la Table : FOURNISSEUR ------- ");
					System.out.println(" ----------      ######################      ----------");
					System.out.println(" ----------      ######################      ----------");
					System.out.println(" ----------         Menu FOURNISSEUR         ----------");
					System.out.println(" ----------      ######################      ----------");
					System.out.println(" Taper le numéro correspondant à la méthode souhaitée :");
					System.out.println(" --------  1 - Créer un " + four +    "      ----------");
					System.out.println(" --------  2 - Modifier un " + four +  "     ----------");
					System.out.println(" --------  3 - Supprimer un " + four +  "    ----------");
					System.out.println(" --------  4 - Afficher l'ensemble des "+four+"s"+ "---");
					System.out.println(" --------  5 - Afficher un seul " + four + " ----------");
					System.out.println(" --------  6 - Retour au menu principal      ----------");
					System.out.println(" ----------      ######################      ----------");
					
					input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
					switch (input) {
					
						case "1" : // ajouter un Nom de fournisseur (insert())
							System.out.println();
							System.out.println("Entrez le nom du fournisseur à ajouter :");
							String inputInsert = ScannerLauncher.getUserInput();
							ScannerMenuInsert.scannerMenuInsertFour(inputInsert);
							ScannerMenu.Display();
							
						case "2" : // modifier un fournisseur
							System.out.println();
							System.out.println("Veuillez saisir le nom du " + " " + four + " " + " à modifier :");
							String userParam1 = ScannerLauncher.getUserInput();
							System.out.println("Veuillez saisir le nom du nouveau " + four + ":");
							String userParam2 = ScannerLauncher.getUserInput();
							ScannerMenuUpdate.scannerMenuUpdateFournisseur(userParam1, userParam2);
							ScannerMenu.Display();
							
						case "3" :
							System.out.println();
							System.out.println("Veuillez saisir l'ID du " + " " + four + " " + " à supprimer :");
							int deleteFour = Integer.parseInt(ScannerLauncher.getUserInput());
							ScannerMenuDelete.scannerMenuDeleteFour(deleteFour);
							System.out.println();
							ScannerMenu.Display();
							
						case "4" :
							System.out.println();
							List<Fournisseur> listefour = ScannerMenuExtraire.scannerMenuExtraireFour();
							System.out.println(listefour);
							System.out.println();
							ScannerMenu.Display();
							
						case "5" : // afficher un seul fournisseur (fiche())
							System.out.println();
							System.out.println("ID du fournisseur à afficher :");
							int afficherFiche = Integer.parseInt(ScannerLauncher.getUserInput());
							Fournisseur f = ScannerMenuFiche.scannerMenuFicheFour(afficherFiche);
							System.out.println(f);
							System.out.println();
							ScannerMenu.Display();
							
						case "6" :
							ScannerMenu.Display();
							
							default :
								System.out.println();
								System.out.println("Erreur de saisie !");
								System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
								input = ScannerLauncher.getUserInput();
								ScannerMenu.Display();
				}
					
				case "2" : // Gestion Article
					System.out.println();
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" --------  Gestion Base de la Table : ARTICLE --------- ");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" -----------          Menu ARTICLE           -----------");
					System.out.println(" -----------     ######################      -----------");
					System.out.println("  Taper le numéro correspondant à la méthode souhaitée :");
					System.out.println(" -----------     ########################    -----------");
					System.out.println(" -----------    1 - Créer un " + art +      "-----------");
					System.out.println(" -----------    2 - Modifier un " + art +   "-----------");
					System.out.println(" -----------    3 - Supprimer un " + art);
					System.out.println(" -----------    4 - Afficher l'ensemble des " + art);
					System.out.println(" 5 - Afficher un seul " + art);
					System.out.println(" 6 - Retour au menu principal ");
					System.out.println(" -----------     ######################      -----------");
					
					input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
					switch (input) {
					
						case "1" :
							System.out.println();
							System.out.println("Entrez la reference de l' " + art + " à ajouter :");
							String inputInsertRef = ScannerLauncher.getUserInput();
							System.out.println("Entrez la designation de l' " + art + " à ajouter :");
							String inputInsertDesign = ScannerLauncher.getUserInput();
							System.out.println("Entrez le prix de l' " + art + " à ajouter :");
							Double inputInsertPrix = Double.parseDouble(ScannerLauncher.getUserInput());
							System.out.println("Entrez l'ID fournisseur de l' " + art + " à ajouter :");
							int inputInsertIdfou = Integer.parseInt(ScannerLauncher.getUserInput());
							ScannerMenuInsert.scannerMenuInsertArt(inputInsertRef, inputInsertDesign, inputInsertPrix, inputInsertIdfou);
							ScannerMenu.Display();
							
						case "2" :
							System.out.println();
							System.out.println(" ----------      ######################      ----------");
							System.out.println(" --------  Gestion Base de la Table : ARTICLE -------- ");
							System.out.println(" ----------      ######################      ----------");
							System.out.println(" ----------      ######################      ----------");
							System.out.println(" Menu ARTICLE ");
							System.out.println(" ----------      ######################      ----------");
							System.out.println(" Taper le numéro correspondant à la méthode souhaitée :");
							System.out.println(" -----------     ########################    ----------");
							System.out.println(" 1 - Modifier la référence d'un " + art );
							System.out.println(" 2 - Modifier la désignation d'un " + art);
							System.out.println(" 3 - Modifier le prix d'un " + art);
							System.out.println(" 4 - Modifier l'ID fournisseur d'un " + art);
							System.out.println(" 5 - Retour au menu principal ");
							System.out.println(" ----------      ######################      ----------");
							
							input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
							switch (input) {
							
								case "1" :
									System.out.println();
									System.out.println("Veuillez saisir l'ID de l' " + art + " à modifier");
									int idArtR = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir la nouvelle référence de l' " + art);
									String refArt = ScannerLauncher.getUserInput();
									ScannerMenuUpdate.scannerMenuUpdateArticleRef(idArtR, refArt);
									System.out.println();
									ScannerMenu.Display();
									
								case "2" :
									System.out.println();
									System.out.println("Veuillez saisir l'ID de l' " + art + " à modifier");
									int idArtD = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir la nouvelle désignation de l' " + art);
									String desArt = ScannerLauncher.getUserInput();
									ScannerMenuUpdate.scannerMenuUpdateArticleDesign(idArtD, desArt);
									System.out.println();
									ScannerMenu.Display();
									
								case "3" :
									System.out.println();
									System.out.println("Veuillez saisir l'ID de l' " + art + " à modifier");
									int idArtP = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir le nouveau prix de l' " + art);
									Double prxArt = Double.parseDouble(ScannerLauncher.getUserInput());
									ScannerMenuUpdate.scannerMenuUpdateArticlePrix(idArtP, prxArt);
									System.out.println();
									ScannerMenu.Display();
									
								case "4" :
									System.out.println();
									System.out.println("Veuillez saisir l'ID de l' " + art + " à modifier");
									int idArtId = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir le nouvelle ID Fournisseur de l' " + art);
									int idFourArt = Integer.parseInt(ScannerLauncher.getUserInput());
									ScannerMenuUpdate.scannerMenuUpdateArticleIdfou(idArtId, idFourArt);
									System.out.println();
									ScannerMenu.Display();
									
								case "5" :
									ScannerMenu.Display();
									
									default :
										System.out.println();
										System.out.println("Erreur de saisie !");
										System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
										input = ScannerLauncher.getUserInput();
										ScannerMenu.Display();
							}
									
						case "3" :
							System.out.println();
							System.out.println("Veuillez saisir l'ID de l'" + " " + art + " " + " à supprimer :");
							int deleteArt = Integer.parseInt(ScannerLauncher.getUserInput());
							ScannerMenuDelete.scannerMenuDeleteArt(deleteArt);
							System.out.println();
							ScannerMenu.Display();
							
						case "4" :
							System.out.println();
							List<Article> listeArt = ScannerMenuExtraire.scannerMenuExtraireArt();
							System.out.println(listeArt);
							System.out.println();
							ScannerMenu.Display();
							
						case "5" :
							System.out.println();
							System.out.println("Veuillez saisir l'ID de l'article à afficher :");
							int afficherFiche = Integer.parseInt(ScannerLauncher.getUserInput());
							Article a = ScannerMenuFiche.scannerMenuFicheArt(afficherFiche);
							System.out.println(a);
							System.out.println();
							ScannerMenu.Display();
							
						case "6" :
							ScannerMenu.Display();
							
							default :
								System.out.println();
								System.out.println("Erreur de saisie !");
								System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
								input = ScannerLauncher.getUserInput();
								ScannerMenu.Display();
				}
				
				case "3" : // Gestion Bon
					System.out.println();
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" --------  Gestion Base de la Table : BON    -----------");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" Menu Principal du BON ");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" Taper le numéro correspondant à la méthode souhaitée :" );
					System.out.println(" -----------     ########################     -----------");
					System.out.println(" 1 - Créer un " + bon );
					System.out.println(" 2 - Modifier un " + bon);
					System.out.println(" 3 - Supprimer un " + bon);
					System.out.println(" 4 - Afficher l'ensemble des " + bon);
					System.out.println(" 5 - Afficher un seul " + bon);
					System.out.println(" 6 - Retour au menu principal ");
					System.out.println(" -----------     ######################      -----------");
					
					input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
					switch (input) {
					
						case "1" :
							System.out.println();
							System.out.println("Entrez le numéro du " + bon + " à ajouter :");
							int inputInsertNum = Integer.parseInt(ScannerLauncher.getUserInput());
							System.out.println("Entrez le delai du " + bon + " à ajouter :");
							int inputInsertDelai = Integer.parseInt(ScannerLauncher.getUserInput());
							ScannerMenuInsert.scannerMenuInsertBon(inputInsertNum, inputInsertDelai);
							ScannerMenu.Display();
							
						case "2" : // Gestion BON / UPDATE
							System.out.println();
							System.out.println(" -----------     ######################      -----------");
							System.out.println(" ----------- Gestion Base de la Table : BON  ---------- ");
							System.out.println(" -----------     ######################      -----------");
							System.out.println(" -----------     ######################      -----------");
							System.out.println(" -----------          Menu BON               -----------");
							System.out.println(" -----------     ######################      -----------");
							System.out.println("  Taper le numéro correspondant à la méthode souhaitée :");
							System.out.println(" -----------     ########################    -----------");
							System.out.println(" -----------  1 - Modifier le numéro d'un " + bon +"----");
							System.out.println(" -----------  2 - Modifier le delai d'un " + bon + "----");
							System.out.println(" -----------  3 - Retour au menu principal   -----------");
							System.out.println(" ----------      ######################      -----------");
							
							input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
							switch (input) {
							
							case "1" :
								System.out.println();
								System.out.println("Veuillez saisir l'ID d' " + bon + " à modifier");
								int idBonN = Integer.parseInt(ScannerLauncher.getUserInput());
								System.out.println("Veuillez saisir le nouveau numéro du " + bon);
								int numBon = Integer.parseInt(ScannerLauncher.getUserInput());
								ScannerMenuUpdate.scannerMenuUpdateBonDelai(idBonN, numBon);
								System.out.println();
								ScannerMenu.Display();
								
							case "2" :
								System.out.println();
								System.out.println("Veuillez saisir l'ID d' " + bon + " à modifier");
								int idBonD = Integer.parseInt(ScannerLauncher.getUserInput());
								System.out.println("Veuillez saisir le nouveau numéro du " + bon);
								int delaiBon = Integer.parseInt(ScannerLauncher.getUserInput());
								ScannerMenuUpdate.scannerMenuUpdateBonDelai(idBonD, delaiBon);
								System.out.println();
								ScannerMenu.Display();
								
							case "3" :
								ScannerMenu.Display();
								
							default :
								System.out.println();
								System.out.println("Erreur de saisie !");
								System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
								input = ScannerLauncher.getUserInput();
								ScannerMenu.Display();
							}
							
						case "3" :
							System.out.println();
							System.out.println("Veuillez saisir l'ID du" + " " + bon + " " + " à supprimer :");
							int deleteBon = Integer.parseInt(ScannerLauncher.getUserInput());
							ScannerMenuDelete.scannerMenuDeleteBon(deleteBon);
							ScannerMenu.Display();
							
						case "4" :
							System.out.println();
							List<Bon> listeBon = ScannerMenuExtraire.scannerMenuExtraireBon();
							System.out.println(listeBon);
							System.out.println();
							ScannerMenu.Display();
							
						case "5" :
							System.out.println();
							System.out.println("Veuillez saisir le numéro du bon à afficher :");
							int afficherFiche = Integer.parseInt(ScannerLauncher.getUserInput());
							Bon a = ScannerMenuFiche.scannerMenuFicheBon(afficherFiche);
							System.out.println(a);
							System.out.println();
							ScannerMenu.Display();
							
						case "6" :
							ScannerMenu.Display();
							
							default :
								System.out.println();
								System.out.println("Erreur de saisie !");
								System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
								input = ScannerLauncher.getUserInput();
								ScannerMenu.Display();
				}
					
				case "4" : // Gestion des COMPO
					System.out.println();
					System.out.println("-----------     ########################      -----------");
					System.out.println("-----------   Gestion Base de donnée : COMPO  -----------");
					System.out.println("-----------     ########################      -----------");
					System.out.println("-----------     ########################      -----------");
					System.out.println("-----------          Menu Principal           -----------");
					System.out.println("-----------     ########################      -----------");
					System.out.println("-  Taper le numéro correspondant à la méthode souhaitée :");
					System.out.println("-----------     ########################      -----------");
					System.out.println("-----------    1 - Créer une COMPO            -----------");
					System.out.println("-----------    2 - Retour au menu principal   -----------");
					System.out.println("-----------     ########################      -----------");
					
					input = ScannerLauncher.getUserInput(); // récupération de la saisie utilisateur
					switch (input) {
					
						case "1" :
							System.out.println();
							System.out.println("Entrez le nom de l'article à ajouter :");
							String inputInsertDesign = ScannerLauncher.getUserInput();
							System.out.println("Entrez le numéro du bon à ajouter :");
							int inputInsertNum = Integer.parseInt(ScannerLauncher.getUserInput());
							System.out.println("Entrez la quantité à ajouter :");
							int inputInsertQte = Integer.parseInt(ScannerLauncher.getUserInput());
							ScannerMenuInsert.scannerMenuInsertCompoApp(inputInsertDesign, inputInsertNum, inputInsertQte);
							ScannerMenu.Display();
							
						case "2" :
							
							ScannerMenu.Display();
							
						default :
							System.out.println();
							System.out.println("Erreur de saisie !");
							System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
							input = ScannerLauncher.getUserInput();
							ScannerMenu.Display();
				}
				
				default :
					System.out.println();
					System.out.println("Erreur de saisie !");
					System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
					input = ScannerLauncher.getUserInput();
					ScannerMenu.Display();
			}
	
	
	}

	
}
