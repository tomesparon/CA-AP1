
/**
 * A subclass of World. Its borderControl method allows for a wrap-around
 * This class currently does not operate completely.
 * @author Tom Esparon
 *
 */
public class WrapWorld extends World {

	public WrapWorld() {

		// Create a creature matrix
		this.matrix = new Creature[ROWS][COLS];

	}
	// Could not get this to cause a wrap-world.
	@Override
	public synchronized boolean borderControl(int nx, int ny) {

		if ((nx < 0 && nx > ROWS) && (ny < 0 && ny > COLS)) {
			//creature.setX(ROWS + nx);
			//creature.setY(COLS + ny);
			return true;
		}
		else{
		return false;
		}

	}

}
