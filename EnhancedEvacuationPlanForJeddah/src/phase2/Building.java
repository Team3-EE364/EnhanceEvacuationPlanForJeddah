 package phase2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Building implements Demolishable {

	/**
	 * 
	 * @author ZYAD, AbdulRahman
	 * this class represnts the buildings in jeddah districts 
	 */

	private ArrayList<Resident> residents;
	private int area;
	private boolean demolished;
	private int appartments;
	private int rent;

	Random r = new Random();


	/**
	 * @param residents
	 * @param area
	 * @param demolished
	 * @param appartments
	 * @param rent
	 */
	
	public Building(ArrayList<Resident> residents, int area, boolean demolished, int appartments,
			int rent) {

			setResidents(residents);
			setArea(area);
			setDemolished(demolished);
			setAppartments(appartments);
			setRent(rent);
	}

	public Building(){ //no-arg constructor.

		int variable = r.nextInt(10) + 7;  								//a random number to determine the numbers of family array object to be created.
		int variable1 = r.nextInt(4) + 3;								//a random number to determine the numbers of family array object to be created.

		Family [] family = new Family[variable];						//Family array object to hold references to family objects
		Single [] single = new Single[variable1];						//Single array object to hold references to single objects
		
			
			//for loop to help in creating and filling of the family array object
			for (int f = 0; f < variable; f++){
				family[f] = new Family();
			}

			//for loop to help in creating and filling of the single array object
			for (int s = 0; s < variable1; s++){
				single[s] = new Single();
			}



		ArrayList<Resident> dweller = new ArrayList<>(Arrays.asList(family));  // to add the array object of both family and single to an ArrayList of the type resident.


		for (int i = 0; i < single.length; i++){  								 // to complete the addition of the single array to the resident ArrayList.
			dweller.add(single[i]);
		}

		setResidents(dweller);														// To mutate the resident field to the value of the dwellers.
		setArea((r.nextInt(21)+100)*(r.nextInt(11)+50));  							// to set the area field.
		setDemolished(false); 														// to set the demolished field.
		setAppartments(dweller.size());    											// to set the apartment field to the number of the dwellers size- that is the number of resident-
		setRent((int)(r.nextDouble()*5001)); 										//to set the salary field


		/**
		 * @return residents
		 * @return demolished
		 * @return appartments
		 * @return rent
		 */
	}
	
	
	//The method fields
	//the getters

	public ArrayList<Resident> getResidents() {
		return residents;
	}
	public int getArea() {
		return area;
	}

	public boolean isDemolished() {
		return demolished;
	}
	public int getAppartments() {
		return appartments;
	}
	public int getRent() {
		return rent;
	}



	//the setters
	public void setResidents(ArrayList<Resident> residents) {
		this.residents = residents;
	}
	public void setArea(int area) {
		this.area = area;
	}

	public void setDemolished(boolean demolished) {
		this.demolished = demolished;
	}
	public void setAppartments(int appartments) {
		this.appartments = appartments;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}

}
