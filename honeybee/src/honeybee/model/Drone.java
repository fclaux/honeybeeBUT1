package honeybee.model;

public class Drone extends HoneyBee {

	public Drone(Species species) {
		super(species);
	}

	@Override
	public String doYourJob() {
		return super.doYourJob() + "I'm a drone, I'm going to date our Queen!";
	}
}
