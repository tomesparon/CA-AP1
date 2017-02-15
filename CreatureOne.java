import java.util.Random;

public class CreatureOne extends Creature{
	
	private final static int MAXLIFE = 10;
	String itsName = "1";

	public CreatureOne(double fitness) {
		super(fitness);
		
		
	}  

//	private double fitness;
//	private int lifespan;
	//private static final double LEVEL = 0.8;
	
	
	
	
	public String getItsName() {
		return itsName;
	}

	public void setItsName(String itsName) {
		this.itsName = itsName;
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
	
	
	public double getFitness() {
	return fitness;
	}

	@Override
	public void run(){
		
		try {
			World test = new World();
			// Task statements
			for (int i = 0; i < 10; i++) {
				CreatureOne one = new CreatureOne(fitness);
				int span = one.generateLifeSpan();
				System.out.println(i + ": " + one.description() + " LIFE OF " + span);
				
				//test.addToWorld(itsName);
				test.printWorld();
				Thread.sleep(span * 1000);
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
