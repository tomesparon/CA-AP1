

public abstract class Creature implements Runnable{
	
	protected final World world;// The one and only world. A shared object
	protected int x;			// x-row position of creature
	protected int y;			// y-col position of creature
	
	
	public Creature(World world, int xin, int yin) {
	
		
		this.world = world;
		x = xin;
		y = yin;
		
		
	}
	// Must implement these in each subclass..
	// Subclass Methods differ in their outputs
	abstract int generateLifeSpan();
	abstract double getFitness();
	abstract Creature makeCreature();
	abstract Creature createChild(int i, int j);
	
	// Might not need this.
	protected World getWorld() {
		return world;
	}
	
	// Get life-span from a subclass
	protected int getSpan() {
		return generateLifeSpan();
	}
	// Should i synchronised ??
	protected int getX() {
		return x;
	}
	protected void setX(int x) {
		this.x = x;
	}
	protected int getY() {
		return y;
	}
	protected void setY(int y) {
		this.y = y;
	}
	
	
	public void run() {

		try {
			// Create a parent to start
			Creature creature = makeCreature();

			// Add parent to the world
			
			this.world.addToWorld(creature, creature.getX(), creature.getY());
			// Parent lives for its life-span
			Thread.sleep(getSpan() * 1000);
			
			
			
			/*Adding children loop
			 * 
			 * This 2D for loop checks if a child can be placed around the parent in a +1 perimeter.
			 * Each round of the loop, change the new x,y coordinate (nx,ny)
			 * 
			 * */
			for (int nx = x - 1; nx <= x + 1; nx++) {
				for (int ny = y - 1; ny <= y + 1; ny++) {

					//TODO Solid Border control if statement. WIP: does not work on edges...
					if (x < 9 && x > 0 && y < 29 && y > 0) {
						// Set new square where parent can give birth.. (O.O)
						creature.setX(nx);
						creature.setY(ny);

						// Determine chance of placing a new child
						// If the perimeter is empty, roll dice to place child in square.
						if (this.world.itsEmpty(nx, ny) == true && Math.random() <= creature.getFitness()) {
							// New creature thread that gets passed the coordinates of current loop.
							Thread child = new Thread(createChild(nx,ny));
							child.start();
							

						} else if (getWorld().itsEmpty(nx, ny) == false
								&& Math.random() <= creature.getFitness() - getWorld().rivalFit(nx, ny)) {
							// Remove the occupant if condition met
							this.world.killOccupant(creature,nx,ny);
							// Start a new thread, that places the creature 
							Thread child = new Thread(createChild(nx,ny));
							child.start();
							

						}

					}

				}
			}
			
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			// Thread interrupts itself ,hopefully this causes parent to die
			Thread.currentThread().interrupt();
		}

	}
	
}
