import java.util.Random;

public class CreatureOne extends Creature{
	
	private final static int MAXLIFE = 10;
	private String itsName = "1";
	
	
	public CreatureOne(double fitness,World world, int x, int y) {
		super(fitness,world,x,y);
		
		
	}  


	



	public String description() {
		String ds = "A new creature 1 spawned with fitness " + fitness ;
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
			//World test = new World();
			// Task statements
			for (int i = 0; i < 10; i++) {
				CreatureOne one = new CreatureOne(fitness,getWorld(),x,y);
				int span = one.generateLifeSpan();
				//System.out.println(i + ": " + one.description() + " LIFE OF " + span);
				
				//test.addToWorld(itsName);
				//test.printWorld();
				one.getWorld().addToWorld(itsName,x,y);
				one.getWorld().printWorld();
				
				Thread.sleep(span * 1000);
				y++; //increment its row
				//Then loop
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
//	public String toString(){
//		return "1";
//		
//		
//	}
	

}
