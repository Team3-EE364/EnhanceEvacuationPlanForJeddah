package phase2;

import java.util.Random;
	
	/**
	 * @author HASSAN
	 */

public class Employee {

	//data fields.
	
	private int salary;
	private int commuteCost;
	
	Random rnd = new Random(); //A random object to generate random numbers used in this class.

	/**
	 * @param salary
	 * @param commuteCost
	 */
	
	
	//constructors fields
	public Employee( int salary, int commuteCost) {
		setSalary(salary);
		setCommuteCost(commuteCost);
	}


	public Employee() {

		setSalary((rnd.nextInt(10)+1) * 5000);				//setting the salary by using a random value which might range from 5000 to 50000.
		setCommuteCost((int)(0.05*getSalary()));			//setting the commute cost  by using a random value, by assuming it to be 5% of the salary.

	}


	
	//methods fields
	//getters and setters
	
	/**
	 * @return commuteCost
	 * @return salary
	 */

	public int getCommuteCost() {
		return commuteCost;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setCommuteCost(int commuteCost) {
		this.commuteCost = commuteCost;
	}

}
