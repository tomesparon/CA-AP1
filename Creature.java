/*			
 * 
 * 
 * 		|Access Levels Cheat Sheet|
 * 		Modifier	Class	Package	Subclass	World
 * 		public		Y		Y		Y			Y
 * 		protected	Y		Y		Y			N
 * 		no modifier	Y		Y		N			N
 * 		private		Y		N		N			N
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */

public abstract class Creature implements Runnable{
	
	protected final World world;// The one and only world. A shared object
	//protected int span;			// THIS DOESN@T WORK!!
	protected int x;			// x-row position of creature
	protected int y;			// y-col position of creature
	
	
	public Creature(World world, int xin, int yin) {
	
		
		this.world = world;
		x = xin;
		y = yin;
		
		
	}
	// Must implement these in each subclass..
	// Methods differ in their outputs
	abstract int generateLifeSpan();
	abstract double getFitness();
	abstract Creature makeCreature();
	abstract Creature createChild(int i, int j);
	abstract String description();
	
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
			creature.getWorld().addToWorld(creature);
			// Print state of the world
			creature.getWorld().printWorld();
			
			// Parent lives for its life-span
			//DEBUGING: System.err.println(creature.description());
			Thread.sleep(getSpan() * 1000);
			//System.err.println(getSpan());
			
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

						// !Important or else too many threads are created!
						// If the perimeter is empty, roll dice to place child in square.
						if (getWorld().itsEmpty(nx, ny) == true && Math.random() <= creature.getFitness()) {
							// New creature thread that gets passed the coordinates of current loop.
							Thread child = new Thread(createChild(creature.getX(), creature.getY()));
							child.start();

						} else if (getWorld().itsEmpty(nx, ny) == false
								&& Math.random() <= creature.getFitness() - getWorld().rivalFit(nx, ny)) {
							
							// Create a child based on fitness difference between parent and occupant.
							// TODO New logic... getThread of square and kill.
							Thread child = new Thread(createChild(creature.getX(), creature.getY()));
							child.start();

						}

					}

				}
			}
			
			// After all that birth, Parent Thread dies.
			Thread.currentThread().interrupt();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}
