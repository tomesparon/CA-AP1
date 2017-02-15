
public abstract class Creature implements Runnable{
	// Needed stuff
	protected double fitness;
	private final World world;
	
	public Creature(double fitness, World world) {
	
		this.fitness = fitness;
		this.world = world;
		
	}
	// Must implement a generate life-span
	abstract int generateLifeSpan();
	
	
	// Generic testing method
	public String description() {
		String ds = "I am a creature with fitness " + fitness ;
		return ds;
	}
	
	public World getWorld() {
		return world;
	}
	

	
	public double getFitness() {
		return fitness;
		}
	// Generic method for moveset
	

	
	
}
