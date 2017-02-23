
/**
 *  Main method which creates a new world.
 *  Uncomment either line 14 or 15 to test each world
 *  However, I could not manage to get WrapWorld to work
 * @author Tom Esparon
 *
 */
public class TestWorld {

	public static void main(String[] args) throws InterruptedException {

		// Choose your world type: WrapWorld = no edges. EdgeWorld = has edges
		
		// World world = new WrapWorld();
		World world = new EdgeWorld();

		// Generate random growth at beginning.
		world.populate(world);

		// Simple print loop for every 0.5 seconds
		for (;;) {
			world.printWorld();
			Thread.sleep(500);
		}

	}

}
