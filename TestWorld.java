
public class TestWorld {

	
	
	public static void main(String[] args) {

		       

		World world = new World();
		Runnable species1 = new CreatureOne(world,1,1); //starting coordinates
		Runnable species2 = new CreatureTwo(world,5,28);// starting coordinates
		Thread first = new Thread(species1);
		Thread second = new Thread(species2);
		
		// On your marks...
		first.start();
		second.start();

		
		
	}
	
	
	
}
