import java.util.Random;

public class CreatureTwo extends Creature {
	
	private final static int MAXLIFE = 5;
	

	public CreatureTwo(double fitness) {
		super(fitness);
		
	}

//	private double fitness;
//	private int lifespan;
	
	
	
	
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
		// Task statements
		for(int i =0; i <10; i++){
			CreatureTwo two = new CreatureTwo(fitness);
			int span = two.generateLifeSpan();
			System.out.println(i +": " +two.description()+ " LIFE OF "+ span);
			try {
				Thread.sleep(span*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
	
	
	
	
	

}

