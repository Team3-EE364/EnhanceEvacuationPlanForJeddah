package phase2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Company {
	
	/**
	 * This class represents the salary and the comute cost of the employees
	 * @author HASSAN
	 */

//	data fields
	private ArrayList<Employee> employee;
	private int salary;
	private int comuteCost;


	Random rand = new Random();

	/**
	 * @param employee
	 * @param salary
	 * @param comuteCost
	 */
	
	public Company(ArrayList<Employee> employee, int salary, int comuteCost) {


		setEmployee(employee);
		setSalary(salary);
		setComuteCost(comuteCost);

	}

	public Company() {																	 //no-arg constructor.

		int num = rand.nextInt(200)+15;							// a random number to be used in the creation of employee array objects.

		Employee[] employee = new Employee[num];   										//the employee array object to hold references o=to employee objects.
		
		//the for loop for creating and filling the object of employee.
		for (int e = 0; e < num; e++){
			employee[e] = new Employee();
		}

		ArrayList<Employee>employeeList = new ArrayList<>(Arrays.asList(employee)); 	//conversion of the array objects to ArrayList.

		setEmployee(employeeList);														//to set the employee data field.
		setSalary(salary);																//to set the salary data field.
		setComuteCost(comuteCost);														//to set the CommuteCost data field.

	}

	/**
	 *@return employee
	 *@return salary
	 *@return comuteCost 
	 */

	//The getter and setter methods field
	public ArrayList<Employee> getEmployee() {
		return employee;														
	}
	public void setEmployee(ArrayList<Employee> employee) {
		this.employee = employee;													
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getComuteCost() {
		return comuteCost;
	}
	public void setComuteCost(int comuteCost) {
		this.comuteCost = comuteCost;
	}
}
