 package phase2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

	/**
	 * @author AJADI, HASSAN
	 *
	 */

public class Jeddah {

	Random r = new Random();				//the random object creation for generating use of random value
	
	
	//Data fields
	private ArrayList<District> district;
	private ArrayList<Resident> residentOfJeddah;

	public Jeddah(){

		int numberOfDistrict = r.nextInt(21) + 6; 				// A random number to be used for creating districts. 
		District [] district = new District[numberOfDistrict];		//Array Object creation to hold the district objects.

			// This for loop is used in creating and filling the array objects of  District.
		 for(int d = 0; d < district.length; d++){
			 district[d] = new District();
		 }

		 //This ArrayList object is used to convert the Array objects containing the district object into a list by the use of the method (asList).
		 ArrayList<District> districts = new ArrayList<>(Arrays.asList(district));
		 
		 setDistrict(districts);		//The setMethod to initialize the variable district once this construction.
	}


	// The main method 
	public static void main(String[] args){
		
		/**
		 * Set Up
		 * 1. Create Array of Districts
		 *
		 * Main Loop
		 * 1. Jeddah decides everyday which building to demolish.
		 * 	 
		 * 2. Tells residents to move to new building
		 *
		 * 3. Families settle in new district.
		 *
		 * 4. Jeddah recalculate every district living cost
		 *
		 */


			Jeddah downTown = new Jeddah(); // A Jeddah object that is referenced by the variable downTown.
			Jeddah upNorth = new Jeddah();		//A Jeddah object that is referenced by the variable upNorth.

		System.out.println("--------------------------------------------------------------------------------------------------------- DISTRICTS DATA (BEFORE CHANGES)-----------------------------------------------------------------------------------");
		printInfo(downTown.getDistrict());
		System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------ POSSIBLE DISTRICTS TO MOVE TO(BEFORE CHANGES) ------------------------------------------------------------------------------");
		printInfo(upNorth.getDistrict());

	

		//The main-loop that help to simulate the real-life of the project in term of numbers of days of the week.
		for(int i = 1; i <= 7; i++){

		System.out.printf("============================== DAY %d =================================", i);
		System.out.println();


		//The command of the project that the doctor wants to be separated into steps, as stated in the Set up above.
		
		Jeddah demolished = demolish(downTown);   //decide what district to demolish
		
		
		ArrayList<District> districtMove = move(demolished,upNorth);		//apply the move
		
		ArrayList<District> renumeration = recalculate(districtMove);			//do the recalculation
		
		printInfo(renumeration);   //print the excepted output
		
		
		}

	}
	
	
	//the getters and setters method fields
	
	public ArrayList<District> getDistrict(){
		return district;
	}

	public void setDistrict(ArrayList<District> districts){
		district = districts;
	}

	/**
	 * @return the residentOfJeddah
	 */
	
	public ArrayList<Resident> getResidentOfJeddah() {
		return residentOfJeddah;
	}


	/**
	 * @param residentOfJeddah the residentOfJeddah to set
	 */
	
	public void setResidentOfJeddah(ArrayList<Resident> residentOfJeddah) {
		this.residentOfJeddah = residentOfJeddah;
	}


	
	
	
	public static Jeddah demolish(Jeddah objectOfJeddah){
		Random rand = new Random(); // this object is used to randomly change the status of some of the objects boolean variable demolish to "true".
		
		// The outer loop to iterate within the district in an object of Jeddah.
		for (int i = 0; i < objectOfJeddah.getDistrict().size(); i++){

				//The nested loops to execute the demolish step intended by this method on the objects that are demolishable
				for(int j = 0; j < objectOfJeddah.getDistrict().get(i).getBuildings().size(); j++){
					objectOfJeddah.getDistrict().get(i).getBuildings().get(j).setDemolished(rand.nextBoolean());
				}

				for(int k = 0; k < objectOfJeddah.getDistrict().get(i).getMasjids().size(); k++){
					objectOfJeddah.getDistrict().get(i).getMasjids().get(k).setDemolished(rand.nextBoolean());
				}

				for(int l = 0; l <  objectOfJeddah.getDistrict().get(i).getSchools().size(); l++){
					objectOfJeddah.getDistrict().get(i).getSchools().get(l).setDemolished(rand.nextBoolean());
				}

		}

		return objectOfJeddah;		// the return of an object of jeddah that would have had some changes in its object as demolished to be "true".
	}



	/**
	 * This method return the table format where the result are displayed
	 * @param ArrayList District
	 */

	public static void printInfo(ArrayList<District> arrayOfDistricts){
		
		System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		System.out.println("DISTRICT\tNUM. OF BUILDING\t RESIDENT \tAVERAGE LIVING-COST\tPOPULATION-INDEX\tTRAFFIC-INDEX \t\t\tMUSOLYs \t\tNUM. OF MASJIDs \t\tCAPACITY \t\tPERCENT OF MUSOLY");
		System.out.println("\t\t\t\t\tFAM | SINGLE\t\tSAR\t\t\t%\t\t\t%");
		System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");

			int people = 0, musoly = 0, capacityOfMasjids = 0;	// the initialization of the local variables
			

		for(int i = 0; i < arrayOfDistricts.size(); i++){	//The outer loop to dive into each districts.

			System.out.print("District " + (i+1)); // to print the district to console. needs revision.

			for(int j = 0; j < arrayOfDistricts.get(i).getBuildings().size(); j++){ // a nested-loop to dive into the building arrays.



				for(int k = 0; k < arrayOfDistricts.get(i).getBuildings().get(j).getResidents().size(); k++){ //a nested nested-loop to iterate between resident arrays.

						people += arrayOfDistricts.get(i).getBuildings().get(j).getResidents().get(k).numOfResident;			//the summing of the people in the district.
						
						if(arrayOfDistricts.get(i).getBuildings().get(j).getResidents().get(k) instanceof Family) {  //for loop to check and get the num of male
							musoly += ((Family) arrayOfDistricts.get(i).getBuildings().get(j).getResidents().get(k)).getNumOfMale();
						}

				}


			}
			
			for(int l = 0; l < arrayOfDistricts.get(i).getMasjids().size(); l++) {		//for loop to iterate with the masjid array
				
				capacityOfMasjids += arrayOfDistricts.get(i).getMasjids().get(l).getMaxCapacity();
				
			}
			
			//The print command that print to the console the expected output.
			System.out.print("\t\t" + arrayOfDistricts.get(i).getBuildings().size());
			System.out.print("\t\t" + people);
			System.out.print("\t\t\t" + arrayOfDistricts.get(i).getLivingCostPerMonth());
			System.out.printf("\t\t\t%.4f" , arrayOfDistricts.get(i).getPopulationPercent());
			System.out.printf("\t\t\t%.4f" , arrayOfDistricts.get(i).getTrafficPercent());
			System.out.print("\t\t\t" + musoly);
			System.out.print("\t\t\t" + arrayOfDistricts.get(i).getMasjids().size());
			System.out.print("\t\t\t\t" + capacityOfMasjids);
			System.out.printf("\t\t\t\t%.4f" , (musoly/(double)capacityOfMasjids));
			System.out.println();
			musoly = 0;																				//avoiding error in multiple summation
			capacityOfMasjids =0;																	//avoiding error in multiple summation
			people =0;																				//avoiding error in multiple summation
		}
	}



	/**
	 * @param objectOfJeddah_1
	 * @param objectOfJeddah_2
	 * 
	 * This method take two Jeddah object and check if from the expected demolished district 
	 * then move the resident from that district to another district.
	 * 
	 * @return objectOfJeddah_2.getDistrict().
	 * it returns an array of districts that has seen in-flux of resident
	 * 
	 */
	
	public static ArrayList<District> move(Jeddah objectOfJeddah_1, Jeddah objectOfJeddah_2) { 

		Random r = new Random();

		ArrayList<Resident> people = new ArrayList<>();

		for (int m = 0; m < objectOfJeddah_2.getDistrict().size(); m++){
			for(int n = 0; n < objectOfJeddah_2.getDistrict().get(m).getBuildings().size(); n++){
				objectOfJeddah_2.setResidentOfJeddah(objectOfJeddah_2.getDistrict().get(m).getBuildings().get(n).getResidents());
			}

			people.addAll(objectOfJeddah_2.getResidentOfJeddah());

			for(int i = 0; i < objectOfJeddah_1.getDistrict().size(); i++){

				for(int j = 0; j < objectOfJeddah_1.getDistrict().get(i).getBuildings().size(); j++){
					
					//the if statement To check if a building is demolished or not.
					if(objectOfJeddah_1.getDistrict().get(i).getBuildings().get(j).isDemolished() == true){

						for (int k = 0; k < objectOfJeddah_1.getDistrict().get(i).getBuildings().get(j).getResidents().size(); k++){ //the loop to iterate into the demolished building.

							objectOfJeddah_1.setResidentOfJeddah((objectOfJeddah_1.getDistrict().get(i).getBuildings().get(j).getResidents())); // setResident method to update the number of resident moving in.
							
							
						}
					}
				}

			}

			people.addAll(objectOfJeddah_1.getResidentOfJeddah());																								//adding all the new resident array

			objectOfJeddah_2.getDistrict().get(m).getBuildings().get(r.nextInt(objectOfJeddah_2.getDistrict().get(m).getBuildings().size())).setResidents(people);		//updating the new resident array in the expected jeddah object that the resident will move to using the set method.

		}




		return objectOfJeddah_2.getDistrict();					//returning the value of district array.

	}

	/**
	 * @param ArrayList<District>
	 * this method take an array of districts and recalculate the living cost.
	 * 
	 * @return districtArrays
	 *  returns an ArrayList which recalculate the living cost as well as the traffic after movement
	 */

	public static ArrayList<District> recalculate(ArrayList<District> districtArrays){
		
		
		//this variables are used to store the sum of income in the both family object and single object that will be later used by the method in recalculating the living cost.
		 int sumOfFamilyIncome = 0, sumOfSingleIncome = 0;				
		 
		 
		 ArrayList<Family> familyList = new ArrayList<>(); 			//creating a family array list to store family objects.
		 ArrayList<Single> singleList = new ArrayList<>();			//creating a single array list to store single objects.

		 /**
		  * Because the Resident can either be a single or family
		  * there was need to check and separate them.
		  */

		 for (int f = 0; f < districtArrays.size(); f++){
			 
			 	
			 for(int g = 0; g < districtArrays.get(f).getBuildings().size(); g++){				//for loop to iterate within the district array
				 
					 for(int i = 0; i < districtArrays.get(f).getBuildings().get(g).getResidents().size(); i++){
						 
							 //to check if the object in the resident array is of the Family | Single Object.
						 if (districtArrays.get(f).getBuildings().get(g).getResidents().get(i) instanceof Family){
							 familyList.add((Family) districtArrays.get(f).getBuildings().get(g).getResidents().get(i));
						 }
		
						 else if(districtArrays.get(f).getBuildings().get(g).getResidents().get(i) instanceof Single){		 //to check if the object in the resident array is of the Family | Single Object.
							 singleList.add((Single) districtArrays.get(f).getBuildings().get(g).getResidents().get(i));
						 	}
	
					 }
					 
			 }
			 
			 
			 for (int j = 0; j< familyList.size(); j++){
				 sumOfFamilyIncome += familyList.get(j).getFamilyIncomePerMonth();														//summing all the income of each family array to be used in calculating average income.
			 }

			 for (int k = 0; k < singleList.size(); k++){
				 for(int p = 0; p < singleList.get(k).getEmployeeList().size(); p++){
					 sumOfSingleIncome += singleList.get(k).getEmployeeList().get(p).getSalary();										//summing all the single income also to be used to calculate the average income.
				 }
			 }


			 districtArrays.get(f).setLivingCostPerMonth((sumOfFamilyIncome + sumOfSingleIncome)/(familyList.size() + singleList.size()));			//to set the new living cost in a district after the addition of new residents.
			 districtArrays.get(f).setPopulationPercent(censor(districtArrays.get(f).getBuildings())/divisor(districtArrays.get(f).getBuildings()));									// to set the population index of the district after movement has been done.
			 districtArrays.get(f).setTrafficPercent( districtArrays.get(f).getPopulationPercent()*2);										// to set the traffic index; and it was divided by 500 since it is said the ration of cars to people is 5:1.
		 
			 sumOfFamilyIncome =0;																						//avoiding error in multiple summation
			 sumOfSingleIncome =0;																							//avoiding error in multiple summation
		 }
				
		 

		return districtArrays; 																												//to return a district with new recalculated information.

	}


	/**
	 * return a double which will represent an head count of the resident
	 * and it is used to calculate the population index and traffic index
	 * @param ArrayList of Building
	 * @return headCount
	 */
	
	public static double censor(ArrayList<Building> buildingArrays){

		// initial instantiation of the variable to be used in this method to hold the sum of the numbers of residents.
		 double headCount = 0; 	
		 
		 
		 // the for loop to iterate within the building arrays to capture the numbers of residents.
		 for (int c = 0; c < buildingArrays.size(); c++){
			 for(int d = 0; d < buildingArrays.get(c).getResidents().size(); d++){ //nested loop to iterate the arrays of resident in a building.
				 headCount +=  buildingArrays.get(c).getResidents().get(d).numOfResident;		//The summation of the number of residents in the building.
			 }
		 }


		 return headCount; // the return value of the head count.
	 }

	
	/**
	 * 
	 * @param building
	 * an array of building to be iterated to get it numbers of apartments
	 * @return building size * apartment total number
	 */
	
	public static int divisor(ArrayList<Building> building) {   	//the divisor method is to be used in the equation to generate the % population of the total number of people living in building.
		 int apartmentNum = 0;										//initialising the variable to store the value of the total apartment in building array.
		 
		 for(int i = 0; i < building.size(); i++) {							//for loop for iterating within he building
			 
			 apartmentNum += building.get(i).getAppartments();
		 }
		 
		 return building.size() * apartmentNum;								//return of the product of the building size and the total number o apartments.
		 
	 }

	
	/**
	 * 
	 * @param districtList
	 * an ArrayList of district to check the status of the demolition in it
	 * @return String flag
	 * A string to show the status of the districts in the array of district pass to it
	 */
	
	public static void status(ArrayList<District> districtList) {
		
		int numOfTrueInBuilding = 0, numOfTrueInMosque = 0, numOfTrueInSchool = 0, flag = 0; //Initializing local variables
		
		
		//for loop that iterates with district array
		for (int i = 0; i < districtList.size(); i++) {
			
			for(int j = 0; j < districtList.get(i).getBuildings().size(); j++) {	//for loop that iterates with building array
				
				if(districtList.get(i).getBuildings().get(j).isDemolished() == true) {		//checking if the Building is demolished
					
					numOfTrueInBuilding += 1;  												// if true add up 1 to the variable
					
				}
			}
			
			for(int k = 0; k < districtList.get(i).getMasjids().size(); k++) {		//for loop that iterates with MAsjid array
				
				if(districtList.get(i).getMasjids().get(k).isDemolished() == true) {	//checking if the Mosque is demolished
					
					numOfTrueInMosque += 1;										// if true add up 1 to the variable
					
				}
			}
			
			for(int l = 0; l < districtList.get(i).getSchools().size(); l++) {			//for loop that iterates with School array
				
				if(districtList.get(i).getSchools().get(l).isDemolished() == true) {		//checking if the School is demolished
					
					numOfTrueInSchool += 1;											// if true add up 1 to the variable
					
				}
			}
			
			flag = (numOfTrueInBuilding + numOfTrueInMosque + numOfTrueInSchool)/(districtList.get(i).getBuildings().size()+districtList.get(i).getMasjids().size() + districtList.get(i).getSchools().size() );
		
			flag = flag *100;  // to get the flag into a percentage to be used to get the status of demolition
			
			if(flag >= 50) { 								//checking the status
				System.out.print("\t\t\t\t\t\t\tFully-Demolished");									//print status 
				
			}
			
			else {							//checking the status
				System.out.print("\t\t\t\t\t\t\tHalfway-Demolished");								//print status 
				
			}
			
			
		}
		System.out.println();
	
	}
}