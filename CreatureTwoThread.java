
public class CreatureTwoThread extends Thread {

	private double fitness;
	private int lifespan;
	
	
	public CreatureTwoThread(double fitness, int lifespan) {
		
		this.fitness = fitness;
		this.lifespan = lifespan;
		
		
	}

	
	/**
	 * @param fitness the fitness to set
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}




	/**
	 * @param lifespan the lifespan to set
	 */
	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}

	
	
	/**
	 * @return the fitness
	 */
	public double getFitness() {
		return fitness;
	}



	/**
	 * @return the lifespan
	 */
	public int getLifespan() {
		return lifespan;
	}




	public void run()
    {
    try
        {
        // Do all time steps.
        

            // Wait for all the other threads to get to this point, then
            // print next state of all cells and update all cells'
            // current states to equal next states (in the single
            // threaded barrier action).
            //barrier.await();
            
        }
    catch (Exception exc)
        {
        }
    }
}
