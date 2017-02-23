
public abstract class World {

	public static final int ROWS = 10; // X is row number
    public static final int COLS = 30;// Y is col number
    Creature[][] matrix;
	String unoccupied = "-";
	
    
	public World() {
		
		// Create a creature matrix
		this.matrix = new Creature[ROWS][COLS];
		
	}
    
	/**
	 * Displays the world as it stands.Synchronized so world is not changed when in method.
	 */
	public synchronized void printWorld(){
		
		// Simple total counter
		int total = 0;
		
			for (int i = 0; i < this.matrix.length; i++) {
				for (int j = 0; j < this.matrix[0].length; j++) {
					if(matrix[i][j]==null){
						System.out.print(unoccupied);
					}else{
						System.out.print(matrix[i][j]);
						total++;
					}
				}
				System.out.println();
			}
			// A marker for the bottom of a map and Print out of total pop
			System.out.println("_____________________________^ Total Pop:" + total);
			
			
	}
	
	//Setter method that allows a creature to be added
	public synchronized void addToWorld(Creature creature,int x, int y) {

		matrix[creature.getX()][creature.getY()] = creature;

	}
	
	//Setter method that allows a creature to be killed
	public synchronized void killOccupant(Creature creature, int nx, int ny) {

		matrix[nx][ny] = null;

	}
	
	//A boolean method to check if the square is occupied or not
	public synchronized boolean itsEmpty(int x, int y){
			
		if(matrix[x][y]==null){
			return true;
		}
		return false;
			
	}
	
	//A boolean method to check the queried occupiers fitness
	public synchronized double rivalFit(int x, int y){
		
		double occupierFit = matrix[x][y].getFitness();
		
		return occupierFit;
	}
	
	
}
