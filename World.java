import java.util.concurrent.locks.*;

public class World {

	final int rows = 10;
    final int cols = 30;
    String[][] matrix;
	String unoccupied = ".";
	//Safety first
	private ReentrantLock worldLock = new ReentrantLock();
	private Condition condition = worldLock.newCondition();
	private boolean placing = false; // to begin with.
    
	public World() {
		
		this.matrix = new String[rows][cols];
		
		
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				
				matrix[i][j] = unoccupied;
			}
		}
		
	}
    
	
	/**
	 * Displays the world as it stands getWorld
	 */
	public void printWorld(){
		worldLock.lock();
		try{
			while(!placing){
				try{
					condition.await();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
			for (int i = 0; i < this.matrix.length; i++) {
				for (int j = 0; j < this.matrix[0].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			
			
			placing = false;
			condition.signal();
		}finally{
			worldLock.unlock();
			System.out.println("Thread printed world and unlocked ^^^");
		}
		
	}
	
	//setter? this is a test setWorld
	public void addToWorld(String name,int x,int y) {
		worldLock.lock();
		try {

			while (placing) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < this.matrix.length; i++) {
				for (int j = 0; j < this.matrix[0].length; j++) {
					matrix[x][y] = name;
				}
			}
			placing = true;
			condition.signal();
		} finally {
			worldLock.unlock();
			System.out.println("Thread made changes and unlocked VVV");
		}
	}
	// Textually represent the species
	public String toString(){
		
		
		return unoccupied;
		
		
	}
	
	
	
}
