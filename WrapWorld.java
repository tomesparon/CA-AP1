
public class WrapWorld extends World{
	

	
    //is needed?
	public WrapWorld() {
		
		// Create a creature matrix
		this.matrix = new Creature[ROWS][COLS];
		
	}
    
	
	@Override
	public void borderControl() {
		//probably boolean return
		
	}
	
	//Setter method that allows a creature to be added
	public synchronized void addToWorld(Creature creature) {

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
