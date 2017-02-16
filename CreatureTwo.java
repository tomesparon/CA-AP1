import java.util.Random;

public class CreatureTwo extends Creature {
	
	private final static int MAXLIFE = 5;
	private final static double FITLEVEL = 0.4;
	private String itsName = "2";
	private int span;
	private double fitness;

	public CreatureTwo( World world, int x, int y) {
		super(world,x,y);
		this.span = generateLifeSpan();
		this.fitness = FITLEVEL;
	}

//	private double fitness;
//	private int lifespan;
	
	
	
	public String description() {
		String ds = "A new creature 2 spawned with fitness " + fitness + ",Span of " + span;
		return ds;
	}

	@Override
	public int generateLifeSpan() {
		Random rn = new Random();
		int span = rn.nextInt(MAXLIFE);
		return span;
	}

	@Override
	public void run() {
		
		
		
				CreatureTwo two = new CreatureTwo(getWorld(),x,y);
				

				two.getWorld().addToWorld(two);
				two.getWorld().printWorld();
				
				//move to top block
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			

	}

	@Override
	double getFitness() {
		// TODO Auto-generated method stub
		return fitness;
	}
	
	public String toString(){
		return itsName;
		
	}
	
	
	

}

