import java.util.Arrays;
import java.util.concurrent.locks.*;

public class World {

	final int rows = 10;
    final int cols = 30;
    Creature[][] matrix;
	String unoccupied = "-";
	//Safety first
	private ReentrantLock worldLock = new ReentrantLock();
	private Condition condition = worldLock.newCondition();
	//private boolean placing = false; // to begin with.
    
	public World() {
		
		// Create a matrix
		this.matrix = new Creature[rows][cols];
		
		
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
			System.out.println("_______________");
			
			//System.out.println(Arrays.deepToString(matrix));
	}
	
	//setter? this is a test setWorld
	public synchronized void addToWorld(Creature creature) {
		
			for (int i = 0; i < this.matrix.length; i++) {
				for (int j = 0; j < this.matrix[0].length; j++) {
					matrix[creature.getX()][creature.getY()] = creature;
				}
			}
	}

	
	
}
