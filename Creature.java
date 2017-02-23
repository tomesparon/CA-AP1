
/**
 *  An abstract class for creature. Contains methods that allow for 
 *  creature reproduction and how to place them on the world.
 * @author Tom Esparon
 *
 */
public abstract class Creature implements Runnable {

	protected final World world;// The one and only world. A shared object
	protected int x; // x-row position of creature
	protected int y; // y-col position of creature

	public Creature(World world, int xin, int yin) {

		// Sets the world passed to world.populate
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

	// Get life-span from a subclass
	protected int getSpan() {
		return generateLifeSpan();
	}

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

	// The Runnables method.
	// Contains most of the reproduction and border logic.
	public void run() {

		try {
			// Create a parent to start
			Creature creature = makeCreature();

			// Add parent to the world
			this.world.addToWorld(creature, creature.getX(), creature.getY());
			// Parent lives for its life-span
			Thread.sleep(getSpan() * 1000);

			/*
			 * Adding children loop
			 * 
			 * This 2D for loop checks if a child can be placed around the
			 * parent in a +1 perimeter. Each round of the loop, change the new
			 * x,y coordinate (nx,ny)
			 * 
			 */
			for (int nx = x - 1; nx <= x + 1; nx++) {
				for (int ny = y - 1; ny <= y + 1; ny++) {

					// Border control if statement. Changes condition on
					// different world
					if (this.world.borderControl(nx, ny) == true) {

						// Determine chance of placing a new child
						// If the perimeter is empty, roll dice to place child
						// in square.
						if (this.world.isEmpty(nx, ny) == true && Math.random() <= creature.getFitness()) {

							creature.setX(nx);
							creature.setY(ny);
							Thread child = new Thread(createChild(creature.getX(), creature.getY()));
							child.start();

						} else if (this.world.isEmpty(nx, ny) == false
								&& Math.random() <= creature.getFitness() - this.world.rivalFit(nx, ny)) {
							
							creature.setX(nx);
							creature.setY(ny);
							// Remove the occupant if condition met
							this.world.killOccupant(creature, creature.getX(), creature.getY());
							// Start a new thread, that places the creature
							Thread child = new Thread(createChild(creature.getX(), creature.getY()));
							child.start();

						}

					}

				} // end of for-y
			} // end of for-x

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Thread interrupts itself ,hopefully this causes parent to die
			Thread.currentThread().interrupt();
		}

	}

}
