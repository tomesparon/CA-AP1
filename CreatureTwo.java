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


	
	// Debugging object description method
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
	// MERGE INTO THE CREATURE EXTENDED CLASS!!!!!
//	@Override
//	public void run() {
//		
//		
//		
//		try {
//
//			CreatureTwo two = new CreatureTwo(getWorld(), x, y);
//
//			// First generation and add in centre
//			two.getWorld().addToWorld(two);
//			two.getWorld().printWorld();
//			// System.err.println(two.getFitness());
//			//System.err.println(span);
//			Thread.sleep(span * 1000);
//
//			// Add children (no conditions)
//			for (int nx = x - 1; nx <= x + 1; nx++) {
//				for (int ny = y - 1; ny <= y + 1; ny++) {
//					
//					// Change spawn position
//					// Solid Border control if statement
//					if (x < 9 && x > 0 && y < 29 && y > 0) {
//						two.setX(nx);
//						two.setY(ny);
//
//						// Important or else billions of threads are created
//						// regardless.
//						if (getWorld().itsEmpty(nx, ny) == true && Math.random() <= two.getFitness()) {
//							Thread child = new Thread(new CreatureTwo(getWorld(), two.getX(), two.getY()));
//							child.start();
//							
//						} else if (getWorld().itsEmpty(nx, ny) == false && Math.random() <= two.getFitness()-getWorld().rivalFit(nx, ny)) {
//							// Create a child based on fit diff and murder
//							//System.err.println(getWorld().rivalFit(nx, ny));
//							Thread child = new Thread(new CreatureOne(getWorld(), two.getX(), two.getY()));
//							child.start();
//						}
//					}
//					
//				}
//			}
//			// Print state with children.
//			two.getWorld().printWorld();
//			// Another sleep...
//			//Thread.sleep(span * 1000);
//			// Parent dies
//			Thread.currentThread().interrupt();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//			
//
//	}
	
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
		Creature two = new CreatureTwo(getWorld(), x, y);
		return two;
	}

	@Override
	public Creature createChild(int i, int j) {
		Creature child = new CreatureTwo(getWorld(), i, j);
		return child;
	}
	
	

}

