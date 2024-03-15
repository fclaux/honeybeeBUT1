package honeybee.model;

public class Beehive {
	private final String name;
	private final Integer comissioningYear;
	private Integer nbHoneySuper;
	private Colony colony;
	
	public Beehive(String name, Integer comissioningYear, Integer nbHoneySuper, Colony colony) {
		this.name = name;
		this.comissioningYear = comissioningYear;
		this.nbHoneySuper = nbHoneySuper;
		this.colony = colony;
	}
	

	public Integer getNbHoneySuper() {
		return nbHoneySuper;
	}

	public void setNbHoneySuper(Integer nbHoneySuper) {
		this.nbHoneySuper = nbHoneySuper;
	}

	public String getName() {
		return name;
	}

	public Integer getComissioningYear() {
		return comissioningYear;
	}

	public Colony getColony() {
		return colony;
	}
	
	
}
