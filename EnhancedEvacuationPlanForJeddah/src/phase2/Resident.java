package phase2;

import java.util.Random;

public abstract class Resident {

	/**
	 * @author ZYAD
	 */
	
	Random r = new Random();

	protected int numOfResident;
	protected int commuteCost;
	protected int appartmentNum;

	public Resident(){

	}


	/**
	 * @param numOfResident
	 * @param comuteCost
	 * @param appartmentNum
	 */


	public Resident(int numOfResident, int commuteCost, int appartmentNum) {

		setNumOfResident(numOfResident);
		setCommuteCost(commuteCost);
		setAppartmentNum(appartmentNum);
	}
	
	
		//The method fields
	
	//the getters and setters
	public int getNumOfResident() {
		return numOfResident;
	}
	public void setNumOfResident(int numOfResident) {
		this.numOfResident = numOfResident;
	}
	public int getCommuteCost() {
		return commuteCost;
	}
	public void setCommuteCost(int commuteCost) {
		this.commuteCost = commuteCost;
	}


	public int getAppartmentNum() {
		return appartmentNum;
	}
	public void setAppartmentNum(int appartmentNum) {
		this.appartmentNum = appartmentNum;
	}
}
