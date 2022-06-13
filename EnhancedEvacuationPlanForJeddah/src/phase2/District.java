package phase2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class District {

	/**
	 *
	 * @author AJADI
	 */
	
		Random r = new Random();

		//data fields
	private ArrayList <Building> buildings;
	private double demolishingPercent;
	private ArrayList<School> schools;
	private ArrayList<Company> companies;
	private ArrayList<Mosque> masjids;
	private int livingCostPerMonth;
	private double trafficPercent;
	private int movingCost;
	private int randomnessPercent;
	private double populationPercent;


	/**
	 * @param buildings
	 * @param demolishingPercent
	 * @param schools
	 * @param companies
	 * @param masjids
	 * @param livingCostPerMonth
	 * @param trafficPercent
	 * @param movingCost
	 * @param randomnessPercent
	 * @param populationPercent
	 */
	
	public District(ArrayList<Building> buildings, double demolishingPercent, ArrayList<School> schools,
			ArrayList<Company> companies, ArrayList<Mosque> masjids, int livingCostPerMonth, double trafficPercent,
			int movingCost, int randomnessPercent, double populationPercent) {

		setBuildings(buildings);
		setDemolishingPercent(demolishingPercent);
		setSchools(schools);
		setCompanies(companies);
		setMasjids(masjids);
		setLivingCostPerMonth(livingCostPerMonth);
		setTrafficPercent(trafficPercent);
		setMovingCost(movingCost);
		setRandomnessPercent(randomnessPercent);
		setPopulationPercent(populationPercent);
	}


	public District(){
		
		int variable = r.nextInt(21) + 20;																	//random number from 20 to 40
		int variable1 = r.nextInt(4) + 7;																		//random number from 7 to 10 for creating masjid, school and company objects
		double variable2 = r.nextDouble();																		//random number 0.0 - 1.0  
		int variable3 = (r.nextInt(9) + 2) *1000;																	//random number from 2000 to 10000 for moving cost
		int variable4 = (int) (variable + variable1 + variable2 + variable3);									//summing all the random number generated to calculate degree of randomness
		
		//creation of array objects
		
				Building [] building = new Building[variable];											//creation of array objects to hold references to building objects.
				School [] school1 = new School[variable1];												//creation of array objects to hold references to school objects.
				Company [] company_1 = new Company[variable1];											//creation of array objects to hold references to company objects.
				Mosque [] masjd = new Mosque[variable1];												//creation of array objects to hold references to Mosque objects.

				// for loop to iterate the building array object and create and fill the building object in it.
				for (int b = 0; b < building.length; b++){
					building[b] = new Building();
				}
		
				// for loop to iterate the school array object and create and fill the school object in it.
				for (int s = 0; s < school1.length; s++){
					school1[s] = new School();
				}
				
				// for loop to iterate the company array object and create and fill the company object in it.
				for (int c = 0; c < company_1.length; c++){
					company_1[c] = new Company();
				}
		
				// for loop to iterate the mosque array object and create and fill the mosque object in it.
				for (int m = 0; m < masjd.length; m++){
					masjd[m] = new Mosque();
				}

				ArrayList<Building> house =  new ArrayList<>(Arrays.asList(building));				//Conversion of the array of house object to ArrayList.
				ArrayList<School> school =  new ArrayList<>(Arrays.asList(school1));				//Conversion of the array of School object to ArrayList.
				ArrayList<Company> company =  new ArrayList<>(Arrays.asList(company_1));			//Conversion of the array of Company object to ArrayList.
				ArrayList<Mosque> mosque =  new ArrayList<>(Arrays.asList(masjd));					//Conversion of the array of Mosque object to ArrayList.




		setBuildings(house);																			//for setting the building data field.
		setDemolishingPercent(variable2);																//for setting the demolishing percent data field.
		setSchools(school);																				//for setting the school data field.
		setCompanies(company);																			//for setting the company data field.
		setMasjids(mosque);																				//for setting the mosque data field.
		setLivingCostPerMonth(findAverageLivingCost(house.get(r.nextInt(variable)).getResidents()));	//for setting the cost of living data field.
		setTrafficPercent((censor(house) * 2)/divisor(house));															//for setting the traffic data field.
		setMovingCost(variable3);																		//for setting the moving cost data field.
		setRandomnessPercent(variable4/100);															//for setting the randomness data field.
		setPopulationPercent(censor(house)/divisor(house));														//for setting the population percent data field.
	}



	/**
	 * The getters method section
	 * @return buildings
	 * @return demolishedPercent
	 * @return schools
	 * @return companies
	 * @return masjid
	 * @return livingCostPerMonth
	 * @return trafficPercent
	 * @return movingCost
	 * @return randomnessPercent
	 * @return populationPercent
	 */
	
	public ArrayList<Building> getBuildings() {
		return buildings;
	}
	public double getDemolishingPercent() {
		return demolishingPercent;
	}
	public ArrayList<School> getSchools() {
		return schools;
	}
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public ArrayList<Mosque> getMasjids() {
		return masjids;
	}
	public int getLivingCostPerMonth() {
		return livingCostPerMonth;
	}
	public double getTrafficPercent() {
		return trafficPercent;
	}
	public int getMovingCost() {
		return movingCost;
	}
	public int getRandomnessPercent() {
		return randomnessPercent;
	}
	public double getPopulationPercent() {
		return populationPercent;
	}



/*
 * The setters methods section
 */
	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}
	public void setDemolishingPercent(double demolishingPercent) {
		this.demolishingPercent = demolishingPercent;
	}
	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	public void setMasjids(ArrayList<Mosque> masjids) {
		this.masjids = masjids;
	}
	public void setLivingCostPerMonth(int livingCostPerMonth) {
		this.livingCostPerMonth = livingCostPerMonth;
	}
	public void setTrafficPercent(double trafficPercent) {
		this.trafficPercent = trafficPercent;
	}
	public void setMovingCost(int movingCost) {
		this.movingCost = movingCost;
	}
	public void setRandomnessPercent(int randomnessPercent) {
		this.randomnessPercent = randomnessPercent;
	}
	public void setPopulationPercent(double populationPercent) {
		this.populationPercent = populationPercent;
	}





	/**
	 *
	 * In this method Resident is taken as a parameter and used to find the
	 * average living cost in a certain district
	 * @param Resident
	 */
	
	 public  int findAverageLivingCost (ArrayList<Resident> resident){
		 
		 int sum = 0, sum1 = 0;												// the initial instantiation of the variable to store values of income for both family and single, to be used in this method.
		 
		 ArrayList<Family> family = new ArrayList<>();					//creating an array list of family to hold the family object creation later in this method.
		 ArrayList<Single> single = new ArrayList<>();					//creating an array list of family to hold the family object creation later in this method.

		 /**
		  * Because the Resident can either be a single or family
		  * there was need to check and separate them.
		  */

		 for (int f = 0; f < resident.size(); f++){

				 if (resident.get(f) instanceof Family){													//checking if the object of the resident array is of family(polymorphism).
					 		family.add((Family) resident.get(f));								//adding the family object the the previous array list created.
				 }
		
				 else{
					 single.add((Single) resident.get(f));										//adding the single object the the previous array list created.
				 }

		 }

			 for (int j = 0; j< family.size(); j++){								//getting the income from the array of family objects and summing it up in the variable sum.
				 sum += family.get(j).getFamilyIncomePerMonth();
			 }

			 for (int k = 0; k < single.size(); k++){
				 
				 for(int p = 0; p < single.get(k).getEmployeeList().size(); p++){
					 
					 sum1 += single.get(k).getEmployeeList().get(p).getSalary();				//getting the income from the array of single objects and summing it up in the variable sum.
				 }
			 }



		return (sum + sum1)/(family.size() + single.size());										//returning the average income. although the divisor was multiplied by 10 to make the data close to real-life value.

	 }
	 
	 /**
	  * This method takes building check the number of Residents in each
	  * and sum up the number and divide by a 100 to get a percentage of
	  * the population in a district.
	  * @param building
	  * @return headCount
	  */
	 
	 public double censor(ArrayList<Building> building){

		 double headCount = 0;

		 for (int c = 0; c < building.size(); c++){
			 for(int d = 0; d < building.get(c).getResidents().size(); d++){
				 headCount +=  building.get(c).getResidents().get(d).numOfResident;
			 }
		 }


		 return headCount;
	 }
	 
	 
	 public int divisor(ArrayList<Building> building) {   	//the divisor method is to be used in the equation to generate the % population of the total number of people living in building.
		 int apartmentNum = 0;										//Initializing the variable to store the value of the total apartment in building array.
		 
		 for(int i = 0; i < building.size(); i++) {							//for loop for iterating within he building
			 
			 apartmentNum += building.get(i).getAppartments();
		 }
		 
		 return building.size() * apartmentNum;								//return of the product of the building size and the total number o apartments.
		 
	 }

}
