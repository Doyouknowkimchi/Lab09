package edu.handong.csee.java.lab09;

import java.util.Scanner; //import class
/**
 * 
 * This class set sails man's name and their record, after then calculate sails average and highest value
 * getData method set name and record, computeAverage method calculate average of records, 
 * team method set sail's mans name, printResult bring output to screen
 *  
 * please update... umm
 */
public class SalesReporter { //name of class

	private double highestsales; //set instance 1
	private double averageSales; //set instance 2
	private SalesAssociate[] team; //set instance 3
	private int numOfSalesmen; //set instance 4
	private String bestSales;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalesReporter analyzer = new SalesReporter();//Where is MarketingAnalyser method? 

		analyzer.getData(); // implement first method for get data
		analyzer.computeAverage(); // implement second method for calculate average
		analyzer.computeHighestsales(); // implement third method for distinguish highest sales
		analyzer.printResult(); // implement fourth method for send output to screen
	}

	public void getData() { //method that get data

		System.out.println("Enter the number of salesman: "); // send text to screen
		Scanner myKeyboard = new Scanner(System.in); // readies the program for keyboard input

		int numOfSalesmen = myKeyboard.nextInt(); // get Salsemen's value

		team = new SalesAssociate[numOfSalesmen]; // set index

		for(int i=0; i < numOfSalesmen; i++) { // get salesmen's data by using for method
			myKeyboard.nextLine();
			System.out.println("Enter data for associate number" + (i+1)); // send massage to screen
			System.out.print("Name\n"); //send message to screen
			String name = myKeyboard.nextLine(); // get input form keyboard to get name
			System.out.print("Sales?"); // send message to screen
			double sales = myKeyboard.nextDouble(); // get input form keyboard to get sales
			team[i] = new SalesAssociate(); // make object
			team[i].setName(name); // implement method to set name to team[i]
			team[i].setSales(sales); // implement method to set sales to team[i]
		}

	}

	public void computeAverage() { // method calculate average

		double sum=0; // initialize variable

		for(int i=0; i<team.length; i++){ // repeat to get sales average 
			sum = sum + team[i].getSales(); // set sum
		}
		averageSales = sum/team.length; // Calculate average *when data type is string, .length act as size_of 
	}

	public void computeHighestsales() { // method name

		highestsales = 0; // initialize variable

		for (int i = 0; i<team.length; i++) { // repeat to get highest sales
			if(highestsales<team[i].getSales()) // terms of if method
			{
				highestsales = team[i].getSales(); //get who is highest sales
			}			
		}


	}							


	public void printResult(){


		System.out.println("average sales pre associate is $" + averageSales); // message out
		System.out.println("The highest sales per assiciate is$: " + highestsales); // message out

		for (int i = 0; i<team.length; i++) { // repeat to get highest sales
			if(highestsales <= team[i].getSales()) // term of if
			{
				bestSales = team[i].getName(); // find best sales man 
				System.out.println("The following had the highest sales:\n" + "name: " + bestSales +"\n" + "Sales" + highestsales); //message out
				System.out.println(team[i].getSales()-averageSales + "$ above the average\n"); //message out
			}

		}

		System.out.println("The rest of follows"); //message out
		for (int i = 0; i<team.length; i++) { //repeat method
			if(highestsales > team[i].getSales()) //term of method	
			{
				System.out.println("name: " + team[i].getName() +"\n" + "Sales: $" + team[i].getSales()); //message out
				if(averageSales<team[i].getSales()){ //term of method
					System.out.println(team[i].getSales()-averageSales + "above the average"); // message out, when average < sales
				}
				else{ // else case
					System.out.println(averageSales-team[i].getSales() + "below the average"); // message out, when average > sales
				}	
			}
		}
	}				


}
