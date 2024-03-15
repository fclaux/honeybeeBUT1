package honeybee.model;

public class Queen extends HoneyBee{
	
	public Queen(Species species) {
		super(species);
	}

	@Override
	public String doYourJob() {
		return super.doYourJob() + "I'm a Queen, any questions?";
	}

}
