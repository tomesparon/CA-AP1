import java.util.Random;

public class CreatureTwo extends Creature {
	
	private final static int MAXLIFE = 5;
	private final static double FITLEVEL = 0.4;
	private String itsName = "2";
	private int span;
	private double fitness;

	public CreatureTwo(World world, int x, int y) {
		super(world,x,y);
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
	public int getSpan(){
		return span;
		
	}

	@Override
	double getFitness() {
		// TODO Auto-generated method stub
		return fitness;
	}
	
	public String toString(){
		return itsName;
		
	}

	@Override
	public Creature makeCreature() {
		Creature two = new CreatureTwo(world, x, y);
		return two;
	}

	@Override
	public Creature createChild(int i, int j) {
		Creature child = new CreatureTwo(world, i, j);
		return child;
	}
	
	

}

