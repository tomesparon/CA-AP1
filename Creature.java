
public abstract class Creature implements Runnable{
	// Needed stuff
	protected double fitness;
	//private final World world;
	
	public Creature(double fitness) {
	
		this.fitness = fitness;
		//this.world = world
		
	}
	// Must implement a generate lifespan
	abstract int generateLifeSpan();
	
	
	// Generic testing method
	public String description() {
		String ds = "I am a creature with fitness " + fitness ;
		return ds;
	}
	
	
	// Generic method for moveset
	
	
}
