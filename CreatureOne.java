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
		//this.x = 0;
		
	}  


	



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
	public void run(){
		
		try {

			CreatureOne one = new CreatureOne(getWorld(), x, y);

			// First generation and add in centre
			one.getWorld().addToWorld(one);
			one.getWorld().printWorld();
			// System.err.println(one.getFitness());

			Thread.sleep(span * 1000);

			// Add children (no conditions)
			for (int nx = x - 1; nx <= x + 1; nx++) {
				for (int ny = y - 1; ny <= y + 1; ny++) {

					// Change spawn position
					// Solid Border control if statement
					if (x < 9 && x > 0 && y < 29 && y > 0) {
						one.setX(nx);
						one.setY(ny);
						
						
						// Important or else billions of threads are created
						// regardless.
						if (getWorld().itsEmpty(nx, ny) == true && Math.random() <= one.getFitness()) {
							Thread child = new Thread(new CreatureOne(getWorld(), one.getX(), one.getY()));
							child.start();

						} else if (getWorld().itsEmpty(nx, ny) == false && Math.random() <= one.getFitness()-getWorld().rivalFit(nx, ny)) {
							// Create a child based on fit diff and murder
							//System.err.println(getWorld().rivalFit(nx, ny));
							Thread child = new Thread(new CreatureOne(getWorld(), one.getX(), one.getY()));
							child.start();
							
						}
						
						
					}

					
				}
			}
			// Print state with children.
			one.getWorld().printWorld();
			//Another sleep...
			Thread.sleep(span * 1000);
			// Parent dies
			Thread.currentThread().interrupt();

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
