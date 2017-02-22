
public class TestWorld {

	
	
	public static void main(String[] args) throws InterruptedException {

		       

		World world = new World();
		Runnable parentOne = new CreatureOne(world,1,1); //starting coordinates
		Runnable parentTwo = new CreatureTwo(world,5,28);// starting coordinates
		Thread first = new Thread(parentOne);
		Thread second = new Thread(parentTwo);
		
		// Start both threads.
		first.start();
		second.start();
		
		
//		for(;;){
//			
//			world.printWorld();
//			Thread.sleep(500);
//		}
		
		
	}
	
	
	
}
