
/**
 * A subclass of World. Its borderControl method allows for a rigid walled world.
 * @author Tom Esparon
 *
 */
public class EdgeWorld extends World {

	public EdgeWorld() {

		// Create a creature matrix
		this.matrix = new Creature[ROWS][COLS];

	}

	@Override
	public synchronized boolean borderControl(int nx, int ny) {

		if ((nx >= 0 && nx < ROWS) && (ny >= 0 && ny < COLS)) {

			return true;
		} else {
			return false;
		}

	}

}
