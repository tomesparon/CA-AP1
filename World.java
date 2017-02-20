import java.util.Arrays;
import java.util.concurrent.locks.*;

public class World {

	public static final int ROWS = 10; // X is row number
    public static final int COLS = 30;// Y is col number
    Creature[][] matrix;
	String unoccupied = "-";
	//Safety first
	private ReentrantLock worldLock = new ReentrantLock();
	private Condition condition = worldLock.newCondition();
	//private boolean placing = false; // to begin with.
    
	public World() {
		
		// Create a matrix
		this.matrix = new Creature[ROWS][COLS];
		
		
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				
				matrix[i][j] = null;
			}
		}
		
	}
    
	
	/**
	 * Displays the world as it stands getWorld
	 */
	public synchronized void printWorld(){
		
			
			for (int i = 0; i < this.matrix.length; i++) {
				for (int j = 0; j < this.matrix[0].length; j++) {
					if(matrix[i][j]==null){
						System.out.print(unoccupied);
					}else
						System.out.print(matrix[i][j]);
				}
				System.out.println();
			}
			System.out.println("____________________________^");
			
			
	}
	
	//setter? this is a test setWorld
	public synchronized void addToWorld(Creature creature) {

		matrix[creature.getX()][creature.getY()] = creature;

	}

	public boolean itsEmpty(int x, int y){
			
		if(matrix[x][y]==null){
			return true;
		}
		return false;
			
	}
	
	// checkRival method
	public double rivalFit(int x, int y){
		
		double occupier = matrix[x][y].getFitness();
		
		return occupier;
	}
}
