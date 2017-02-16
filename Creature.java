
public abstract class Creature implements Runnable{
	// Needed stuff
	protected double fitness;
	private final World world;
	
	private final static int[][] circleMoves = {
            {-1, -1}, {-1, 0}, {-1, 1}
            , {0, 1}, {1, 1}, {1, 0}
            , {1, -1}, {0, -1}, {0, 0}
    };
	
	protected int x;
	protected int y;
	
	
	public Creature(double fitness, World world, int xin, int yin) {
	
		this.fitness = fitness;
		this.world = world;
		x = xin;
		y = yin;
		
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
	
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	

	
	
}
