
public abstract class Creature implements Runnable{
	// Needed stuff
	protected final World world;
	
	protected int span;
	
	protected int x;
	protected int y;
	
	
	public Creature(World world, int xin, int yin) {
	
		
		this.world = world;
		x = xin;
		y = yin;
		
		
	}
	// Must implement these in each subclass..
	abstract int generateLifeSpan();
	abstract double getFitness();
	abstract Creature makeCreature();
	abstract Creature createChild(int i, int j);
	
	public World getWorld() {
		return world;
	}
	
	
	public int getSpan() {
		return span;
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
	
	
	public void run(){
		
		try {
			// @TODO change 'one' to creature.
			Creature one = makeCreature();
			

			// First generation and add in centre
			one.getWorld().addToWorld(one);
			one.getWorld().printWorld();
			// System.err.println(one.getFitness());

			Thread.sleep(getSpan() *  1000);
			//System.err.println("--------------------------" + getSpan());
			// Add children (no conditions)
			for (int nx = x - 1; nx <= x + 1; nx++) {
				for (int ny = y - 1; ny <= y + 1; ny++) {

					// Change spawn position
					// Solid Border control if statement
					if (x < 9 && x > 0 && y < 29 && y > 0) {
						one.setX(nx);
						one.setY(ny);
						
						
						// Important or else billions of threads are created
						// regardless.
						if (getWorld().itsEmpty(nx, ny) == true && Math.random() <= one.getFitness()) {
							Thread child = new Thread(createChild(one.getX(),one.getY()));
							child.start();

						} else if (getWorld().itsEmpty(nx, ny) == false && Math.random() <= one.getFitness()-getWorld().rivalFit(nx, ny)) {
							// Create a child based on fit diff and murder
							//System.err.println(getWorld().rivalFit(nx, ny));
							Thread child = new Thread(createChild(one.getX(),one.getY()));
							child.start();
							
						}
						
						
					}

					
				}
			}
			// Print state with children.
			//one.getWorld().printWorld();
			//Another sleep...
			//Thread.sleep(span * 1000);
			// Parent dies
			Thread.currentThread().interrupt();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
	}
	
	

	
	
}
