package honeybee.model;

public abstract class HoneyBee {
	protected final Species species;
	
	protected HoneyBee (Species species) {
		this.species=species;
	}
	
	public Species getSpecies() {
		return this.species;
	}
	
	public String doYourJob() {
		return this.species + " I'm a HoneyBee!";
	}
	public String fly() {
		return "I believe, I can fly.";
	}
}
