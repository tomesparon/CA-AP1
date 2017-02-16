import java.util.Random;

public class CreatureTwo extends Creature {
	
	private final static int MAXLIFE = 5;
	private String itsName = "2";
	
	

	public CreatureTwo(double fitness, World world, int x, int y) {
		super(fitness, world,x,y);
		
	}

//	private double fitness;
//	private int lifespan;
	
	
	
	@Override
	public String description() {
		String ds = "A new creature 2 spawned with fitness " + fitness;
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
		try {
			
			// Task statements
			for (int i = 0; i < 10; i++) {
				CreatureTwo two = new CreatureTwo(fitness, getWorld(),x,y);
				int span = two.generateLifeSpan();
				//System.out.println(i + ": " + two.description() + " LIFE OF " + span);

				
				
				
				two.getWorld().addToWorld(itsName,x,y);
				two.getWorld().printWorld();
				Thread.sleep(span * 1000);
				y++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	

}

