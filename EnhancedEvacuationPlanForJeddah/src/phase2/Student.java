package phase2;

import java.util.Random;

	/**
	 * this class will show us how many students are there in the family and its commute cost
	* @author HASSAN
	*/

public class Student {
	
	Random rand = new Random();
	private int commuteCost;


	/**
	 * @param commuteCost
	 * @return commuteCost
	 */
	
	public Student() {

		setCommuteCost((rand.nextInt(12) + 9)*100); //random generation of commute cost
	}

	public Student(int commuteCost) {
		
		setCommuteCost(commuteCost);
	}


	public int getCommuteCost() {
		return commuteCost;
	}


	public void setCommuteCost(int commuteCost) {
		this.commuteCost = commuteCost;
	}

}
