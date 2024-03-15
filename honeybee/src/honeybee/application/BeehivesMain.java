package honeybee.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import honeybee.gui.Console;
import honeybee.model.Beehive;
import honeybee.model.Colony;
import honeybee.model.Drone;
import honeybee.model.HoneyBee;
import honeybee.model.Queen;
import honeybee.model.Species;
import honeybee.model.Worker;

public class BeehivesMain {

	public static final String TABULATION = "\t";
	
	public static void main(String[] args) {

		List<HoneyBee> colonyOfHoneyBees= new ArrayList<>();
		Colony colony = new Colony(colonyOfHoneyBees);
		int menuChoice;
		
		Scanner keyboard = new Scanner(System.in);
		
		Console.message("Entrez le nom de la ruche : ");
		String behiveName = keyboard.nextLine();
		Console.message("Entrez le nombre de hausses : ");
		int nbHoneySuper = keyboard.nextInt();
		
		Beehive beehive = new Beehive(behiveName, 2024, nbHoneySuper, colony);
		
		
		do {
			title(beehive);
			principalMenu(beehive);
			menuChoice = keyboard.nextInt();
			
			switch (menuChoice) {
				case 0 :
					Console.message("Au revoir !");
					break;
				case 1 :
					beehive.setNbHoneySuper(beehive.getNbHoneySuper()+1);
					break;
				case 2 : 
					expandColony(keyboard, beehive);
					break;
				case 3 :
					colonyInformation(beehive);
					break;
				case 4 :
					if (beehive.getColony().getNbHoneyBee()>0)
						Console.message("La colonie s'envole !");
					else
						Console.erreurMenu();
					break;
				case 5 :
					if (beehive.getColony().getNbHoneyBee()>0)
						Console.message("La colonie travaille !");
					else
						Console.erreurMenu();
					break;
				default:
					Console.erreurMenu();
					break;
			}
		}while (menuChoice!=0);
		
		
		keyboard.close();
	}


	private static void colonyInformation(Beehive beehive) {
		
		if (beehive.getColony().getNbQueenNoire()>0)
			Console.message(" -> " + beehive.getColony().getNbQueen() + " reine (abeille noire)");
		else if (beehive.getColony().getNbQueenItalienne()>0)
			Console.message(" -> " + beehive.getColony().getNbQueen() + " reine (abeille italienne)");
		else if (beehive.getColony().getNbQueenCaucasienne()>0)
			Console.message(" -> " + beehive.getColony().getNbQueen() + " reine (abeille caucasienne)");
		else
			Console.message(" -> " + beehive.getColony().getNbQueen() + " reine");
		
		Console.message(" -> " + beehive.getColony().getNbWorker() + " ouvrière(s)");
		if (beehive.getColony().getNbWorkerNoire()>0)
			Console.message(TABULATION + " -> " + beehive.getColony().getNbWorkerNoire() + " abeille(s) noire(s)");
		if (beehive.getColony().getNbWorkerItalienne()>0)
			Console.message(TABULATION + " -> " + beehive.getColony().getNbWorkerItalienne() + " abeille(s) italienne(s)");
		if (beehive.getColony().getNbWorkerCaucasienne()>0)
			Console.message(TABULATION + " -> " + beehive.getColony().getNbWorkerCaucasienne() + " abeille(s) caucasienne(s)");
		
		Console.message(" -> " + beehive.getColony().getNbDrone() + " faux-bourdon(s)");
		if (beehive.getColony().getNbDroneNoire()>0)
			Console.message(TABULATION + " -> " + beehive.getColony().getNbDroneNoire() + " abeille(s) noire(s)");
		if (beehive.getColony().getNbDroneItalienne()>0)
			Console.message(TABULATION + " -> " + beehive.getColony().getNbDroneItalienne() + " abeille(s) italienne(s)");
		if (beehive.getColony().getNbDroneCaucasienne()>0)
			Console.message(TABULATION + " -> " + beehive.getColony().getNbDroneCaucasienne() + " abeille(s) caucasienne(s))");
	}


	private static void expandColony(Scanner keyboard, Beehive beehive) {
		
		Species[] species = {Species.NOIRE, Species.ITALIENNE, Species.CAUCASIENNE};
		int menuAddHoneyBee;
		int nbOptionsMenuAddHoneyBee=3;
		
		do {
			title(beehive);
			expandColonyMenu(beehive, nbOptionsMenuAddHoneyBee);
			menuAddHoneyBee = keyboard.nextInt();
			if ((menuAddHoneyBee==nbOptionsMenuAddHoneyBee-2)&&beehive.getColony().getNbQueen()==0) {
				addQueen(keyboard, beehive, species);
				nbOptionsMenuAddHoneyBee--;
			}
			else if ((menuAddHoneyBee==nbOptionsMenuAddHoneyBee-1)||(menuAddHoneyBee==nbOptionsMenuAddHoneyBee)) {
				addWorkerAndDrone(keyboard, beehive, species, menuAddHoneyBee, nbOptionsMenuAddHoneyBee);
			}
			else if (menuAddHoneyBee==0) {
				Console.message("Retour au menu précédent ");
			}
			else {
				Console.erreurMenu();
			}
		}while (menuAddHoneyBee!=0);
	}

	private static void addWorkerAndDrone(Scanner keyboard, Beehive beehive, Species[] species, int menuAddHoneyBee,
			int nbOptionsMenuAddHoneyBee) {
		int nbHoneyBeeAdd;
		int speciesIndex;
		do {
			Console.message("Choisissez le nombres d'abeilles que vous voudrez ajouter (>0) :");
			nbHoneyBeeAdd = keyboard.nextInt();
		} while (nbHoneyBeeAdd<1);
		do {
			speciesMenu();
			speciesIndex = keyboard.nextInt();
		} while (speciesIndex<1||speciesIndex>3);
		
		if (menuAddHoneyBee==nbOptionsMenuAddHoneyBee-1)
			beehive.getColony().addGroupOfHoneyBee(nbHoneyBeeAdd, new Worker(species[speciesIndex-1]));
		else
			beehive.getColony().addGroupOfHoneyBee(nbHoneyBeeAdd, new Drone(species[speciesIndex-1]));
	}

	private static void addQueen(Scanner keyboard, Beehive beehive, Species[] species) {
		int speciesIndex;
		do {
			speciesMenu();
			speciesIndex = keyboard.nextInt();
		} while (speciesIndex<1||speciesIndex>3);
		beehive.getColony().addHoneyBee(new Queen(species[speciesIndex-1]));
	}
	

	private static void expandColonyMenu(Beehive beehive, int nbOptionsAddHoneyBeeMenu) {
		if (beehive.getColony().getNbQueen()==0)
			Console.message("   " + (nbOptionsAddHoneyBeeMenu-2) + ".  Ajouter une reine");
		Console.message("   " + (nbOptionsAddHoneyBeeMenu-1) + ".  Ajouter un groupe d'ouvrières");
		Console.message("   " + nbOptionsAddHoneyBeeMenu + ".  Ajouter un groupe de faux-bourdons");
		Console.message("   0.  Revenir au menu principal");
		Console.separateur();
	}
	

	private static void title(Beehive beehive) {
		Console.separateur();
		Console.message("La colonie de la ruche " + beehive.getName());
		Console.message("Actuellement, cette ruche possède "+ beehive.getNbHoneySuper() +" hausses" );
		Console.message("et la colonie contient " + beehive.getColony().getNbHoneyBee()+" abeille(s)");
		Console.separateur();
	}
	
	private static void speciesMenu() {
		Console.message("Choisissez l'espèce pour votre/vos abeille(s) : ");
		Console.message("   1.  Noire");
		Console.message("   2.  Italienne");
		Console.message("   3.  Caucasienne");
	}
	
	private static void principalMenu(Beehive beehive) {
		Console.message("   1.  Ajouter une hausse");
		Console.message("   2.  Agrandire la colonie");
		Console.message("   3.  Détailler la colonie");
		if (beehive.getColony().getNbHoneyBee()>0) {
			Console.message("   4.  Faire voler la colonie");
			Console.message("   5.  Faire travailler la colonie");
		}
		Console.message("   0.  Revenir au menu principal");
	}


}
