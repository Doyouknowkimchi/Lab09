package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	
	private double highestsales;
	private double averageSales;
	private SalesAssociate[] team;
	private int numberOfAssociates; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalesReporter analyzer = new SalesReporter();//Where is MarketingAnalyser method? 
				
		analyzer.getData();
		analyzer.computeAverage();
		analyzer.computeHighestsales();
		analyzer.printResult();
	}
		
	public void getData() { //method that get data
			
			System.out.println("Enter the number of salesman: "); // send text to screen
			Scanner myKeyboard = new Scanner(System.in); // readies the program for keyboard input
			
			int numOfSalesmen = myKeyboard.nextInt(); // get Salsemen's value
			
			team = new SalesAssociate[numOfSalesmen]; // set index
			
			for(int i=0; i < numOfSalesmen; i++) { // get salesmen's data by using for method
				System.out.println("Enter data for associate number" + (i+1));
				System.out.print("Name");
				myKeyboard.nextLine();
				String name = myKeyboard.nextLine();
				System.out.print("Sales?");
				double sales = myKeyboard.nextDouble();
				team[i] = new SalesAssociate();
				team[i].setName(name);
				team[i].setSales(sales);
				
			}
			
	}

	public void computeAverage() {
		
		double sum=0;
		
		for(int i=0; i<team.length; i++){
			sum = sum + team[i].getSales();
		}
		averageSales = sum/team.length;
	}
			
	public void computeHighestsales() {
		highestsales = 0;
		
		for (int i = 0; i<team.length; i++) {
			if(highestsales<team[i].getSales())
			{
				highestsales = team[i].getSales();
			}
			
		}
			
				
	}			
	
	
	public void printResult(){
		System.out.println("average : " + averageSales);
		System.out.println("highestsales : " + highestsales);
	
	}


}
