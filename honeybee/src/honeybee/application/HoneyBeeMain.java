package honeybee.application;

import java.util.Arrays;
import java.util.List;

import honeybee.gui.Console;
import honeybee.model.Drone;
import honeybee.model.HoneyBee;
import honeybee.model.Queen;
import honeybee.model.Species;
import honeybee.model.Worker;

public class HoneyBeeMain {
	
	public static void main(String[] args) {
		
		collectionOfHoneyBees();
	}

	@SuppressWarnings("unused")
	private static void someHoneyBees() {
		Console.title(" Some honeybees ");
		HoneyBee queen = new Queen(Species.NOIRE);
		HoneyBee firstWorker = new Worker(Species.ITALIENNE);
		HoneyBee secondWorker = new Worker(Species.ITALIENNE);
		HoneyBee thirdWorker = new Worker(Species.ITALIENNE);
		HoneyBee firstDrone = new Drone(Species.CAUCASIENNE);
		HoneyBee secondDrone = new Drone(Species.CAUCASIENNE);

		Console.message(queen.doYourJob());
		Console.message(firstWorker.doYourJob());
		Console.message(secondWorker.doYourJob());
		Console.message(thirdWorker.doYourJob());
		Console.message(firstDrone.doYourJob());
		Console.message(secondDrone.doYourJob());

		Console.separateur();

		Console.message(queen.fly());
		Console.message(firstWorker.fly());
		Console.message(secondWorker.fly());
		Console.message(thirdWorker.fly());
		Console.message(firstDrone.fly());
		Console.message(secondDrone.fly());
	}
	@SuppressWarnings("unused")
	private static void arrayOfHoneyBees() {
		Console.title(" Array of honeybees ");
		
		HoneyBee[] honeyBees = {new Queen(Species.NOIRE),new Drone(Species.CAUCASIENNE),new Drone(Species.CAUCASIENNE),new Worker(Species.ITALIENNE),new Worker(Species.ITALIENNE),new Worker(Species.ITALIENNE)};
		
		for(int i=0; i<honeyBees.length; i++) {
			Console.message(honeyBees[i].doYourJob());
		}
		Console.separateur();
		for (HoneyBee honeyBee : honeyBees) {
			Console.message(honeyBee.fly());
		}
		Console.separateur();
	}
	
	private static void collectionOfHoneyBees() {
		
		int nbQueen;
		int nbWorker;
		int nbDrone;
		int nbHoneyBee;
		
		nbQueen=0;
		nbWorker=0;
		nbDrone=0;
		nbHoneyBee=0;
		
		Console.title(" Collection of honeybees ");
		
		List<HoneyBee> honeybees = Arrays.asList(new Queen(Species.NOIRE),new Drone(Species.CAUCASIENNE),new Drone(Species.CAUCASIENNE),new Worker(Species.ITALIENNE),new Worker(Species.ITALIENNE),new Worker(Species.ITALIENNE));
		
		for (HoneyBee honeyBee : honeybees) {
			Console.message(honeyBee.doYourJob());
			Console.message(honeyBee.fly());
			Console.separateur();
			
			if (honeyBee instanceof HoneyBee)
				nbHoneyBee++;
			if (honeyBee instanceof Queen)
				nbQueen++;
			if (honeyBee instanceof Worker)
				nbWorker++;
			if (honeyBee instanceof Drone)
				nbDrone++;
		}
		
		Console.title(" My collection has "+ nbHoneyBee +" honeybees ");
		Console.message(" -> " + nbQueen + " queen(s)");
		Console.message(" -> " + nbWorker + " worker(s)");
		Console.message(" -> " + nbDrone + " drone(s)");
		
	}

}
