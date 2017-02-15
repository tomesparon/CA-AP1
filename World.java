
public class World {

	final int rows = 10;
    final int cols = 30;
    String[][] matrix;
	String unoccupied = ".";
    
    
	public World() {
		
		this.matrix = new String[rows][cols];
		
		
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				
				matrix[i][j] = unoccupied;
			}
		}
		
	}
    
	
	public void printWorld(){
		
		//this.matrix[3][3] = one.toString();
		
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				//matrix[0][j]= one.getItsName();
				System.out.print(matrix[i][j] + " ");
	
			}
			System.out.print("\n");
		}
	
		
	}
	
	public void addToWorld(String name) {

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				
				matrix[i][j]= name;
				
	
			}

		}
	
	}
	
}
