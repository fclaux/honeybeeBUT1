package honeybee.application;

import honeybee.gui.Console;
import honeybee.model.Drone;
import honeybee.model.HoneyBee;
import honeybee.model.Queen;
import honeybee.model.Species;
import honeybee.model.Worker;

public class SandBox {

	public static void main(String[] args) {
		HoneyBee melli = new Queen(Species.NOIRE);
		HoneyBee may = new Worker(Species.ITALIENNE);
		HoneyBee will = new Drone(Species.CAUCASIENNE);
		
		Console.title(" Appel à getClass de la classe Object ");
		Console.message("Classe de l'objet melli : " + melli.getClass());
		Console.message("Classe de l'objet may : " + may.getClass());
		Console.message("Classe de l'objet will : " + will.getClass());
		
		Console.title(" Appel à getName de la classe Class via le mot clé class (cast de Queen, Worker, Drone en Class) ");
		Console.message("Classe d'un objet Class Queen.class : " + (Queen.class).getName());
		Console.message("Classe d'un objet Class Worker.class : " + (Worker.class).getName());
		Console.message("Classe d'un objet Class Drone.class : " + (Drone.class).getName());
		
		Console.title(" Appel à getName de la classe HoneyBey ");
		Console.message("Nom de l'objet melli : " + melli.getSpecies());
		Console.message("Nom de l'objet may : " + may.getSpecies());
		Console.message("Nom de l'objet will : " + will.getSpecies());
		
		Console.title(" Opérateur instanceof ");
		if (melli instanceof HoneyBee)
			Console.message("melli est une instance de HoneyBee");
		if (melli instanceof Queen)
			Console.message("melli est une instance de Queen");
		if (melli instanceof Worker)
			Console.message("melli est une instance de Worker");
		if (melli instanceof Drone)
			Console.message("melli est une instance de Drone");
		
	
	}

}
