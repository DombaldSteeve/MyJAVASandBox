package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
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

	
	public static void Display() throws SQLException  {
		
		
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" --------- Gestion Base de donnée : compta --------- ");
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" ----------         Menu Principal         ---------" );
		System.out.println(" ----------     ######################     ----------");
		System.out.println(" Taper le numéro correspondant à la Table souhaitée :");
		System.out.println(" ----------    1 - Gestion Fournisseur     ----------");
		System.out.println(" ----------    2 - Gestion Article         ----------");
		System.out.println(" ----------    3 - Gestion Bon             ----------");
		System.out.println(" ----------    4 - Créer une Promotion     ----------");
		System.out.println(" ----------     ######################     ----------");
		
			String input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
			switch (input) {
			
				case "1" : // Gestion Fournisseur
					System.out.println();
					System.out.println(" ----------      ######################      ----------");
					System.out.println(" ------ Gestion Base de la Table : fournisseur ------- ");
					System.out.println(" ----------      ######################      ----------");
					System.out.println(" ----------      ######################      ----------");
					System.out.println(" ----------         Menu Fournisseur         ----------");
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
							System.out.println("Entrez le nom du fournisseur à ajouter :");
							String inputInsert = ScannerLauncher.getUserInput();
							ScannerMenuInsert.scannerMenuInsertFour(inputInsert);
							ScannerMenu.Display();
							
						case "2" : // modifier un fournisseur
							System.out.println("Veuillez saisir le nom du " + " " + four + " " + " à modifier :");
							String userParam1 = ScannerLauncher.getUserInput();
							System.out.println("Veuillez saisir le nom du nouveau " + four + ":");
							String userParam2 = ScannerLauncher.getUserInput();
							ScannerMenuUpdate.scannerMenuUpdateFournisseur(userParam1, userParam2);
							ScannerMenu.Display();
							
						case "3" :
							System.out.println("Veuillez saisir l'ID du " + " " + four + " " + " à supprimer :");
							int deleteFour = Integer.parseInt(ScannerLauncher.getUserInput());
							ScannerMenuDelete.scannerMenuDeleteFour(deleteFour);
							System.out.println();
							ScannerMenu.Display();
							
						case "4" :
							List<Fournisseur> listefour = ScannerMenuExtraire.scannerMenuExtraireFour();
							System.out.println(listefour);
							System.out.println();
							ScannerMenu.Display();
							
						case "5" : // afficher un seul fournisseur (fiche())
							System.out.println("ID du fournisseur à afficher :");
							int afficherFiche = Integer.parseInt(ScannerLauncher.getUserInput());
							Fournisseur f = ScannerMenuFiche.scannerMenuFicheFour(afficherFiche);
							System.out.println(f);
							System.out.println();
							ScannerMenu.Display();
							
						case "6" :
							ScannerMenu.Display();
							
							default :
								System.out.println("Erreur de saisie !");
								System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
								input = ScannerLauncher.getUserInput();
								ScannerMenu.Display();
				}
					
				case "2" : // Gestion Article
					System.out.println();
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" --------  Gestion Base de la Table : article --------- ");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" -----------          Menu Article           -----------");
					System.out.println(" -----------     ######################      -----------");
					System.out.println("  Taper le numéro correspondant à la méthode souhaitée :");
					System.out.println(" -----------    1 - Créer un " + art + "     -----------");
					System.out.println(" -----------    2 - Modifier un " + art + "  -----------");
					System.out.println(" 3 - Supprimer un " + art);
					System.out.println(" 4 - Afficher l'ensemble des " + art);
					System.out.println(" 5 - Afficher un seul " + art);
					System.out.println(" 6 - Retour au menu principal ");
					System.out.println(" -----------     ######################      -----------");
					
					input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
					switch (input) {
					
						case "1" :
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
							System.out.println(" --------  Gestion Base de la Table : article -------- ");
							System.out.println(" ----------      ######################      ----------");
							System.out.println(" ----------      ######################      ----------");
							System.out.println(" Menu Article ");
							System.out.println(" ----------      ######################      ----------");
							System.out.println(" Taper le numéro correspondant à la méthode souhaitée :");
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
									int idFourR = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir la nouvelle référence de l' " + art);
									String refFour = ScannerLauncher.getUserInput();
									ScannerMenuUpdate.scannerMenuUpdateArticleRef(idFourR, refFour);
									System.out.println();
									ScannerMenu.Display();
									
								case "2" :
									System.out.println();
									System.out.println("Veuillez saisir l'ID de l' " + art + " à modifier");
									int idFourD = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir la nouvelle désignation de l' " + art);
									String desFour = ScannerLauncher.getUserInput();
									ScannerMenuUpdate.scannerMenuUpdateArticleRef(idFourD, desFour);
									System.out.println();
									ScannerMenu.Display();
									
								case "3" :
									System.out.println();
									System.out.println("Veuillez saisir l'ID de l' " + art + " à modifier");
									int idFourP = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir le nouveau prix de l' " + art);
									String prxFour = ScannerLauncher.getUserInput();
									ScannerMenuUpdate.scannerMenuUpdateArticleRef(idFourP, prxFour);
									System.out.println();
									ScannerMenu.Display();
									
								case "4" :
									System.out.println();
									System.out.println("Veuillez saisir l'ID de l' " + art + " à modifier");
									int idFourId = Integer.parseInt(ScannerLauncher.getUserInput());
									System.out.println("Veuillez saisir le nouvelle ID Fournisseur de l' " + art);
									String idFour = ScannerLauncher.getUserInput();
									ScannerMenuUpdate.scannerMenuUpdateArticleRef(idFourId, idFour);
									System.out.println();
									ScannerMenu.Display();
									
								case "5" :
									ScannerMenu.Display();
									
									default :
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
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" --------  Gestion Base de la Table : article -------- " );
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" Menu Principal ");
					System.out.println(" -----------     ######################      -----------");
					System.out.println(" Taper le numéro correspondant à la méthode souhaitée :" );
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
							//afficher methode create bon
						case "2" :
							// afficher methode modifier bon
						case "3" :
							//afficher methode supp bon
						case "4" :
							System.out.println();
							List<Bon> listeBon = ScannerMenuExtraire.scannerMenuExtraireBon();
							System.out.println(listeBon);
							System.out.println();
							ScannerMenu.Display();
							
						case "5" :
							System.out.println();
							System.out.println("Veuillez saisir l'ID du bon à afficher :");
							int afficherFiche = Integer.parseInt(ScannerLauncher.getUserInput());
							Bon a = ScannerMenuFiche.scannerMenuFicheBon(afficherFiche);
							System.out.println(a);
							System.out.println();
							
							ScannerMenu.Display();
							
							
						case "6" :
							ScannerMenu.Display();
							default :
								System.out.println("Erreur de saisie !");
								System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
								input = ScannerLauncher.getUserInput();
								ScannerMenu.Display();
				}
					
				case "4" : // Gestion des promotions
					System.out.println(" -----------     ########################      -----------");
					System.out.println(" -----------      Création d'un promotion      -----------");
					System.out.println(" -----------     ########################      -----------");
					System.out.println(" -----------     ########################      -----------");
					System.out.println(" -----------          Menu Principal           -----------");
					System.out.println(" -----------     ########################      -----------");
					System.out.println(" Selection de l'article sur lequel appliquer la promotion ");
					System.out.println(" 1 - Créer un " + bon );
					System.out.println(" 2 - Modifier un " + bon);
					System.out.println(" 3 - Supprimer un " + bon);
					System.out.println(" 4 - Afficher l'ensemble des " + bon);
					System.out.println(" 5 - Afficher un seul " + bon);
					System.out.println(" 6 - Retour au menu principal ");
					System.out.println(" -----------     ########################      -----------");
					input = ScannerLauncher.getUserInput(); // récupération dce la saisie utilisateur
					switch (input) {
						case "1" :
							//afficher methode create bon
						case "2" :
							// afficher methode modifier bon
						case "3" :
							//afficher methode supp bon
						case "4" :
							//afficher tout les bon
						case "5" :
							//afficher un seul bon
						case "6" :
							ScannerMenu.Display();
							default :
								System.out.println("Erreur de saisie !");
								System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
								input = ScannerLauncher.getUserInput();
								ScannerMenu.Display();
				}
				
				default :
					System.out.println("Erreur de saisie !");
					System.out.println("Veuillez taper sur une touche pour être redirigé au menu principal.");
					input = ScannerLauncher.getUserInput();
					ScannerMenu.Display();
			}
	
	
	}

	
}
