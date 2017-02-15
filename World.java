import java.util.concurrent.locks.*;

public class World {

	final int rows = 10;
    final int cols = 30;
    String[][] matrix;
	String unoccupied = ".";
	//Safety first
	private ReentrantLock worldLock = new ReentrantLock();
	private Condition condition = worldLock.newCondition();
    
	public World() {
		
		this.matrix = new String[rows][cols];
		
		
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				
				matrix[i][j] = unoccupied;
			}
		}
		
	}
    
	
	/**
	 * Displays the world as it stands
	 */
	public void printWorld(){
		
		
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	//setter? this is a test
	public void addToWorld(String name) {

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {

				matrix[0][j] = name;

			}

		}
	
	}
	// Textually represent the species
	public String toString(){
		
		
		return unoccupied;
		
		
	}
	
	
	
}
