package phase2;

import java.util.ArrayList;
import java.util.Arrays;

	/**
	 * @author AJADI
	 *
	 */

public class Family extends Resident {

	private ArrayList<Student> sFamilyMember;
	private ArrayList<Employee> eFamilyMember;
	private int familyIncomePerMonth;
	private int numOfMale;
	
	/**
	 *@param numOfResident
	 *@param comuteCost
	 *@param appartmentNum
	 *@param sFamilyMember
	 *@param eFamilyMember
	 *@param familyIncomePerMonth
	 *@param numOfMale
	 */

	public Family(int numOfResident, int comuteCost, int appartmentNum, ArrayList<Student> sFamilyMember, ArrayList<Employee> eFamilyMember, int familyIncomePerMonth,
			int numOfMale) {

		super(numOfResident, comuteCost, appartmentNum);
		setsFamilyMember(sFamilyMember);
		seteFamilyMember(eFamilyMember);
		setFamilyIncomePerMonth(familyIncomePerMonth);
		setNumOfMale(numOfMale);

	}

	public Family(){
		int sNum = r.nextInt(6)+1;
		int eNum = r.nextInt(5)+1;


		Employee[] eMember = new Employee[eNum];										//creation of array object to hold reference to employee in the family object
		Student[] sMember = new Student[sNum];											//creation of array object to hold reference to student in the family object

		
		for(int k = 0; k < sNum; k++){
			sMember[k] = new Student();															//adding the student object to the array object

		}

		ArrayList<Student> sFamily = new ArrayList<>(Arrays.asList(sMember));					//converting the array object of student to array list.

		for(int j = 0; j < eNum; j++){
			eMember[j] = new Employee();														//adding the employee object to the array object

		}

		ArrayList<Employee> eFamily = new ArrayList<>(Arrays.asList(eMember));					//converting the array object of student to array list.

		setNumOfResident(eNum + sNum + 1);														//setting the numOfResident to be the size of the employee + size of student +1;
		setCommuteCost(totalCommuteCost(eFamily,sFamily));											//calculating the total cost spent commuting in the family by using employee and student.
		setAppartmentNum(r.nextInt(50)+200);														//setting the apartment number for family to be from 200-249
		setsFamilyMember(sFamily);																	//setting the member of the family that are students.
		seteFamilyMember(eFamily);																	//setting the member of the family that are employees.
		setFamilyIncomePerMonth(totalIncomePerFamily(eFamily));											//setting the total income in the family.
		setNumOfMale(eFamily.size());																	//setting the number of male in a family.
	}

	/**
	 * @return sFamilyMember
	 * @return eFamilyMember
	 * @return FamilyIncomePerMonth
	 * @return numOfMale
	 * @return sum
	 */
	
	//the methods fields
	
	//the getter and setters
	public ArrayList<Student> getsFamilyMember() {
		return sFamilyMember;
	}
	public void setsFamilyMember(ArrayList<Student> sFamilyMember) {
		this.sFamilyMember = sFamilyMember;
	}
	public ArrayList<Employee> geteFamilyMember() {
		return eFamilyMember;
	}
	public void seteFamilyMember(ArrayList<Employee> eFamilyMember) {
		this.eFamilyMember = eFamilyMember;
	}
	public int getFamilyIncomePerMonth() {
		return familyIncomePerMonth;
	}
	public void setFamilyIncomePerMonth(int familyIncomePerMonth) {
		this.familyIncomePerMonth = familyIncomePerMonth;
	}
	public int getNumOfMale() {
		return numOfMale;
	}
	public void setNumOfMale(int numOfMale) {
		this.numOfMale = numOfMale;
	}



	
	//the method totalIncomePerFamily().
	public int totalIncomePerFamily(ArrayList<Employee> efamily){

		int sum = 0;			// the initialisation of the local variable sum for store the income summation.
		
		for (int i = 0; i < efamily.size(); i++ ){  //for loop to iterate an employee array list that is comprised in a family object
			sum += efamily.get(i).getSalary();     // summing up the salary of the employees in a family
		}

		return sum;									// return of the sum.
	}

	
	//the method for calculating the commute cost.
	public int totalCommuteCost(ArrayList<Employee> eFamily, ArrayList<Student> sFamily){

		int sum = 0, num1 = 0, num2 = 0, person=0;  // the initialisation of the local variable sum commute cost

		if (eFamily.size() > sFamily.size()){			//checking if the number of employee is less that number of  studnent in a family
		for (int i = 0; i < eFamily.size(); i++ ){
			num1 += eFamily.get(i).getCommuteCost();	//getting the total num of commute cost for employees
		}

		for (int j = 0; j < sFamily.size(); j++ ){
			num2 += sFamily.get(j).getCommuteCost();		//getting the total num of commute cost for students
		}

			sum = num1 + num2;
		}
		
		else{												//the else statement if not less employees are not less than students
			for (int i = 0; i < eFamily.size(); i++ ){
				person += eFamily.get(i).getSalary();

				sum = (int) Math.ceil(0.2 * person);			//getting he sum of the commute cost and using a math class function on it.
			}
		}

		return sum;													//he return of the sum.
	}


}
