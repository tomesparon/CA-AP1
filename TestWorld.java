
public class TestWorld {

	
	private final static int ROWS = 10;
	private final static int COLS = 10;
	
	
	
	
	
	public static void main(String[] args) {

		       
	
		
//		Creature[][] area = new Creature[ROWS][COLS];
//			for(int i = 0;i < area.length;i++){
//				for(int j = 0; j <area[0].length; j++){
//					System.out.print(one.generateLifeSpan());
//					
//				}
//				System.out.println();
//			}
		
		Runnable species1 = new CreatureOne(0.8);
		Runnable species2 = new CreatureTwo(0.4);
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
//		World test = new World();
//		test.printWorld();
		
		
	}
	
	
	
}
