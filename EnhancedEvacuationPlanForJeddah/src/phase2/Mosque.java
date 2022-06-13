package phase2;

import java.util.Random;

public class Mosque implements Demolishable {
	
	/**
	 * @author AbdulRahman
	 */

		private int maxCapacity;
		private boolean demolished;
	
	
	
		public Mosque(){ //no-arg constructor
			Random random = new Random();
			setMaxCapacity((random.nextInt(9)+2) * 150);  // random number to generate the capacity of masjid
			setDemolished(false);               //setting the demolish status initially to false.
		}
	
		/**
		 *@param maxCapacity
		 *@param demolished 
		 *@return maxCapacity
		 *@return demolished 
		 */
		
		public Mosque(int maxCapacity, boolean demolished) {
	
			setMaxCapacity(maxCapacity);
			setDemolished(demolished);
	
		}
	
	
	//the getters methods field
		public int getMaxCapacity() {
			return maxCapacity;
		}
	
		public boolean isDemolished() {
			return demolished;
		}
	
		//the setters methods field
		public void setMaxCapacity(int maxCapacity) {
			this.maxCapacity = maxCapacity;
		}
		
		public void setDemolished(boolean demolished) {
			this.demolished = demolished;
		}
		
		
}
