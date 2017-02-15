
public class TestWorld {

	
	private final static double FIT1 = 0.8;
	private final static double FIT2 = 0.4;
	
	
	
	public static void main(String[] args) {

		       

		World world = new World();
		Runnable species1 = new CreatureOne(FIT1,world); //param its name
		Runnable species2 = new CreatureTwo(FIT2, world);
		Thread first = new Thread(species1);
		Thread second = new Thread(species2);
		// On your marks...
		first.start();
//		try {
//			//wait for thread to die before proceeding to species 2
//			first.join();
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
		//On your marks...
		second.start();

		
		
	}
	
	
	
}
