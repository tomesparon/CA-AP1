
public abstract class Creature implements Runnable{
	// Needed stuff
	protected final World world;
	
//	protected final static int[][] circleMoves = {
//            {-1, -1}, {-1, 0}, {-1, 1}
//            , {0, 1}, {1, 1}, {1, 0}
//            , {1, -1}, {0, -1}, {0, 0}
//    };
	
	protected int x;
	protected int y;
	
	
	public Creature(World world, int xin, int yin) {
	
		
		this.world = world;
		x = xin;
		y = yin;
		
		
	}
	// Must implement a generate life-span
	abstract int generateLifeSpan();
	
	abstract double getFitness();

	
	public World getWorld() {
		return world;
	}
	
	
	
	
	// Should i synchronized ??
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
