import java.util.Random;

/**
 * A abstract class for the simulation World.
 * It creates a 2D array of creatures and populates the world initially.
 * @author Tom Esparon
 *
 */
public abstract class World {

	public static final int ROWS = 10; // The number of rows down
	public static final int COLS = 50; // The number of columns across
	protected Creature[][] matrix;
	protected String unoccupied = "-";

	public World() {

		// Initialise the creature matrix
		this.matrix = new Creature[ROWS][COLS];

	}

	// Each world subclass has its own rules for borders
	public abstract boolean borderControl(int nx, int ny);

	/**
	 * Displays the world as it stands.Synchronized so world is not changed when
	 * in method.
	 */
	public synchronized void printWorld() {

		// Simple total counter
		int total = 0;

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				if (matrix[i][j] == null) {
					// null, no creature, so marked as '-'
					System.out.print(unoccupied);
				} else {
					// creature present. Prints its string representation
					System.out.print(matrix[i][j]);
					// Add up current inhabitants
					total++;
				}
			}
			System.out.println();
		}
		// A marker for the bottom of a map and Print out of total pop
		System.out.println("___________________________________^ Total Pop:" + total);

	}

	// Setter method that allows a creature to be added
	public synchronized void addToWorld(Creature creature, int x, int y) {

		matrix[creature.getX()][creature.getY()] = creature;

	}

	// Setter method that should allow a creature to be killed
	public synchronized void killOccupant(Creature creature, int nx, int ny) {

		matrix[nx][ny] = null;

	}

	// A boolean method to check if the square is occupied or not
	public synchronized boolean isEmpty(int x, int y) {

		if (matrix[x][y] == null) {
			return true;
		}
		return false;

	}

	// A boolean method to check the queried occupiers fitness
	public synchronized double rivalFit(int x, int y) {

		double occupierFit = matrix[x][y].getFitness();

		return occupierFit;
	}

	// A method to initially place inhabitants into world
	public synchronized void populate(World world) {

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {

				int random = randomGen(0, 2);

				if (random == 1) {
					// Create a creature thread of the first type
					Runnable creatureOne = new CreatureOne(world, i, j);
					Thread thread = new Thread(creatureOne);
					thread.start();
				} else if (random == 2) {
					// Create a creature thread of the second type
					Runnable creatureTwo = new CreatureTwo(world, i, j);
					Thread thread = new Thread(creatureTwo);
					thread.start();

				} else {
					continue;
				}

			}
		}
	}

	// Helper method to make a random number in a range.
	public static int randomGen(int min, int max) {
		Random rn = new Random();
		int range = max - min + 1;
		int randomNum = rn.nextInt(range) + min;
		return randomNum;
	}

}
