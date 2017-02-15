
public abstract class Creature implements Runnable{
	// Needed stuff
	protected double fitness;
	
	
	public Creature(double fitness) {
	
		this.fitness = fitness;
		
	}
	
	abstract int generateLifeSpan();
	
	
	
	public String description() {
		String ds = "I am a creature with fitness " + fitness ;
		return ds;
	}
	
	
	
	
	
}
