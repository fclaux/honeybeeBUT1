package honeybee.model;

import java.util.List;

public class Colony {
	private List<HoneyBee> colonyOfHoneyBees;

	public Colony(List<HoneyBee> colonyOfHoneyBees) {
		this.colonyOfHoneyBees = colonyOfHoneyBees;
	}

	public List<HoneyBee> getColonyOfHoneyBees() {
		return colonyOfHoneyBees;
	}
	
	public int getNbQueenNoire() {
		int nbQueenNoire=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Queen)&&(honeybee.getSpecies()==Species.NOIRE)) {
				nbQueenNoire++;
			}
		}
		return nbQueenNoire;
	}

	public int getNbQueenItalienne() {
		int nbQueenItalienne=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Queen)&&(honeybee.getSpecies()==Species.ITALIENNE)) {
				nbQueenItalienne++;
			}
		}
		return nbQueenItalienne;
	}

	public int getNbQueenCaucasienne() {
		int nbQueenCaucasienne=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Queen)&&(honeybee.getSpecies()==Species.CAUCASIENNE)) {
				nbQueenCaucasienne++;
			}
		}
		return nbQueenCaucasienne;
	}

	public int getNbWorkerNoire() {
		int nbWorkerNoire=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Worker)&&(honeybee.getSpecies()==Species.NOIRE)) {
				nbWorkerNoire++;
			}
		}
		return nbWorkerNoire;
	}

	public int getNbWorkerItalienne() {
		int nbWorkerItalienne=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Worker)&&(honeybee.getSpecies()==Species.ITALIENNE)) {
				nbWorkerItalienne++;
			}
		}
		return nbWorkerItalienne;
	}

	public int getNbWorkerCaucasienne() {
		int nbWorkerCaucasienne=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Worker)&&(honeybee.getSpecies()==Species.CAUCASIENNE)) {
				nbWorkerCaucasienne++;
			}
		}
		return nbWorkerCaucasienne;
	}

	public int getNbDroneNoire() {
		int nbDroneNoire=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Drone)&&(honeybee.getSpecies()==Species.NOIRE)) {
				nbDroneNoire++;
			}
		}
		return nbDroneNoire;
	}

	public int getNbDroneItalienne() {
		int nbDroneItalienne=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Drone)&&(honeybee.getSpecies()==Species.ITALIENNE)) {
				nbDroneItalienne++;
			}
		}
		return nbDroneItalienne;
	}

	public int getNbDroneCaucasienne() {
		int nbDroneCaucasienne=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if ((honeybee instanceof Drone)&&(honeybee.getSpecies()==Species.CAUCASIENNE)) {
				nbDroneCaucasienne++;
			}
		}
		return nbDroneCaucasienne;
	}
	
	public int getNbQueen() {
		int nbQueen=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if (honeybee instanceof Queen) {
				nbQueen++;
			}
		}
		return nbQueen;
	}
	
	public int getNbWorker() {
		int nbWorker=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if (honeybee instanceof Worker) {
				nbWorker++;
			}
		}
		return nbWorker;
	}
	
	public int getNbDrone() {
		int nbDrone=0;
		for(HoneyBee honeybee : colonyOfHoneyBees) {
			if (honeybee instanceof Drone) {
				nbDrone++;
			}
		}
		return nbDrone;
	}
	
	public int getNbHoneyBee() {
		return colonyOfHoneyBees.size();
	}
	
	public void addHoneyBee(HoneyBee honeybee) {
		colonyOfHoneyBees.add(honeybee);
	}
	
	public void addGroupOfHoneyBee(int nbHoneyBee, HoneyBee honeybee) {
		for (int i=0; i<nbHoneyBee; i++) {
			this.addHoneyBee(honeybee);
		}
	}
	
	
}
