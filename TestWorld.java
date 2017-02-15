
public class TestWorld {

	
	private final static int ROWS = 10;
	private final static int COLS = 10;
	
	
	
	
	
	public static void main(String[] args) {
		
//		Start my objects
//		Waiter w = new Waiter();
//		Chef c = new Chef(w);
//		Diner d = new Diner(w);
//		c.start();
//		d.start();
		
//		int [][] grid = new int [ROWS][COLS];

//		int a = (grid.length);//10
//		int b = (grid[0].length);//10
//        
//		for(int i = 0; i < a; i++){ // 1 2 3 4 5 x axis
//		    for(int j = 0; j <b; j++) { // 1 2 3 4 5 y axis
		        
		       
		
		CreatureOne one = new CreatureOne(0.8);
		System.out.println(one.description()+ " LIFE OF "+ one.generateLifeSpan());
		CreatureTwo two = new CreatureTwo(0.4);
		System.out.println(two.description()+ " LIFE OF "+ two.generateLifeSpan());
		
		Creature[][] area = new Creature[ROWS][COLS];
			for(int i = 0;i < area.length;i++){
				for(int j = 0; j <area[0].length; j++){
					System.out.print(one.generateLifeSpan());
					
				}
				System.out.println();
			}
		
	}
	
	
	
}
