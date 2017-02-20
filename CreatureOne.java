import java.util.Random;

public class CreatureOne extends Creature{
	
	private final static int MAXLIFE = 10;
	private final static double FITLEVEL = 0.8;
	private String itsName = "1";
	private int span;
	private double fitness;
	
	public CreatureOne(World world, int x, int y) {
		super(world,x,y);
		this.span = generateLifeSpan();
		this.fitness = FITLEVEL;
		
		
	}  


	// Debugging object description method
	public String description() {
		String ds = "A new creature 1 spawned with fitness " + fitness + ",Span of " + span;
		return ds;
	}

	@Override
	public int generateLifeSpan() {
		Random rn = new Random();
		int span = rn.nextInt(MAXLIFE);
		return span;
	}
	
	
	@Override
	public int getSpan(){
		return span;
		
	}

	
	@Override
	public double getFitness() {
		// TODO Auto-generated method stub
		return fitness;
	}
	
	@Override
	public Creature makeCreature() {
		Creature one = new CreatureOne(getWorld(), x, y);
		return one;
	}
	
	// Fetch string representation of creature.
	public String toString(){
		return itsName;
		
	}



	@Override
	public Creature createChild(int i, int j) {
		Creature child = new CreatureOne(getWorld(), i, j);
		return child;
	}
	

}
