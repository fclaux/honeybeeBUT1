package honeybee.model;

public class Worker extends HoneyBee {
	
	public Worker(Species species) {
		super(species);
	}

	@Override
	public String doYourJob() {
		return super.doYourJob() + "I'm a worker, I work all day!";
	}

}
