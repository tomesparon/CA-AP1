
public class TestWorld {

	
	
	public static void main(String[] args) throws InterruptedException {
		//Choose your world type: WrapWorld = no edges. EdgeWorld = has edges
		//World world = new WrapWorld();       
		World world = new EdgeWorld();
		
		Runnable parentOne = new CreatureOne(world,1,1); //starting coordinates
		Runnable parentTwo = new CreatureTwo(world,5,28);// starting coordinates
		Thread first = new Thread(parentOne);
		Thread second = new Thread(parentTwo);
		
		// Start both threads.
		first.start();
		second.start();
		
		
		// Simple print loop for every 0.5 seconds
		for(;;){
			
			world.printWorld();
			Thread.sleep(500);
		}
		
		
	}
	
	
	
}
