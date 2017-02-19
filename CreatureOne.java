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

			one.getWorld().addToWorld(one);
			one.getWorld().printWorld();
			
			Thread.sleep(1000);
			// Add children (no conditions)
			for (int nx = x-1 ; nx <=x + 1; nx++) {
				for (int ny = y-1; ny <= y + 1; ny++) {

					one.setX(nx);
					one.setY(ny);
					one.getWorld().addToWorld(one);
					
					

				}
			}
			one.getWorld().printWorld();
			
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
		return "1";
		
	}
	

}
