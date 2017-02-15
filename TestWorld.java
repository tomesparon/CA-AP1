
public class TestWorld {

	
	private final static int ROWS = 10;
	private final static int COLS = 20;
	
	
	
	
	
	
	public static void main(String[] args) {
		
//		Start my objects
//		Waiter w = new Waiter();
//		Chef c = new Chef(w);
//		Diner d = new Diner(w);
//		c.start();
//		d.start();
		
		int [][] grid = new int [ROWS][COLS];

		int a = (grid.length);//10
		int b = (grid[0].length);//10

		for(int i = 0; i < a; i++){ // 1 2 3 4 5 x axis
		    for(int j = 0; j <b; j++) { // 1 2 3 4 5 y axis
		        int x = 0;
		        grid[i][j] = x;
		        
		            System.out.print(" " + x + " ");
		        
		    }//end of for J
		    System.out.println();
		}// end for i
		
		
		
		
	}
	
	
	
}
