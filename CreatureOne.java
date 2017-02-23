import java.util.Random;

/**
 * A creature, called One has a max life of 10 and a fitlevel of 0.8
 * 
 * @author Tom Esparon
 *
 */
public class CreatureOne extends Creature {

	private final static int MAXLIFE = 10;
	private final static double FITLEVEL = 0.8;
	private String itsName = "1";

	// Stores for creature attributes
	private int span;
	private double fitness;

	public CreatureOne(World world, int x, int y) {
		super(world, x, y);
		this.span = generateLifeSpan();
		this.fitness = FITLEVEL;

	}

	@Override
	public int generateLifeSpan() {
		Random rn = new Random();
		int span = rn.nextInt(MAXLIFE);
		return span;
	}

	@Override
	public int getSpan() {
		return span;

	}

	@Override
	public double getFitness() {
		
		return fitness;
	}

	@Override
	public Creature makeCreature() {
		Creature one = new CreatureOne(world, x, y);
		return one;
	}

	// Fetch string representation of creature.
	public String toString() {
		return itsName;

	}

	@Override
	public Creature createChild(int i, int j) {
		Creature child = new CreatureOne(world, i, j);
		return child;
	}

}
