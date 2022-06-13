package phase2;

import java.util.ArrayList;
import java.util.Arrays;

	/**
	* @author ZYAD
	*/

public class Single extends Resident {
	
	/**
 	* employee Arraylist
 	* an array that holds the number of employees
 	* @param Employee
 	*/

	private ArrayList<Employee> employee;



	public Single(){

		super();								//super invoking
		int num = r.nextInt(5) + 1;				//random generation of num to be used in creating employee Object

		Employee[] employee = new Employee[num];			//creation of the employee object array;
		
		for(int s = 0; s < num; s++){						//for loop to create the employee
			employee[s] = new Employee();

		}

		ArrayList<Employee> employ = new ArrayList<>(Arrays.asList(employee));		//converting it ArrayList

		super.setNumOfResident(num);												//setting the numOfResident
		super.setCommuteCost(averageCommuteCost(employ));							//setting the commute cost
		super.setAppartmentNum(r.nextInt(50)+100);									//setting the apartment to numbers between 100 - 149
		setEmployeeList(employ);														//setting employee.

		/**
		 * @param numOfResident
		 * @param comuteCost
		 * @param apprtmentNum
		 * @param employee
		 * @return employee
		 */

	}

	public Single(int numOfResident, int comuteCost, int appartmentNum, ArrayList<Employee> employee) {

		super(numOfResident, comuteCost,appartmentNum);
		setEmployeeList(employee);
	}




	public ArrayList<Employee> getEmployeeList() {
		return employee;
	}

	public void setEmployeeList(ArrayList<Employee> employee) {
		this.employee = employee;
	}

	/**
	 * 
	 * @param employee
	 * 	ArrayList of employee to used to calculate the commute cost
	 * @return average
	 */

	public int averageCommuteCost(ArrayList<Employee> employee){
		int sum = 0, average = 0;		//initialising the local variables
		
		for (int i = 0; i < employee.size(); i++){ // for to iterate within the employee array
			sum += employee.get(i).getCommuteCost();  //summing the commute cost of each employee.
		}
			average = (sum / employee.size());			//calculate the average
		return average;								// return the average
	}
}
