import java.io.*;
import java.util.*;
public class Car extends Vehicle implements Comparable<Car>, Announcements {

	private int numDoors;
	private int numWindows;
	
	public Car(int numDoors,int numWindows){
		super(2,2);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public Car(int numDoors, int numWindows, int numSeatsPerRow ) {
		super(2,numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public  Car(int numDoors, int numWindows, int [] numSeatsPerRow ) {
		super(numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public Car(int numDoors, int numWindows, Person driver, int [ ] numSeatsPerRow) {
		super(driver,numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	public boolean canOpenDoor(Person p) {
		if(p==null)  return false;
		if(p.getAge()<=5) return false;
		
		
		int rowBoundary = numberOfRows;
		int[] location = new int[2];
		
		location = getLocationOfPersonInVehicle(p);
		
		if(numDoors<2*numberOfRows) {
			rowBoundary = numDoors/2;
		}
		if(location[0]>=rowBoundary) {
			return false;
		}
		if(location[1]==0) {
			return true;
		}
		if(location[1]==personsOnBoard[location[0]].length-1) {
		return true;
		}
		else {
			return false;
		}
	}
	public boolean canOpenWindow(Person p) {
		if(p==null)  return false;
		if(p.getAge()<=2) return false;
		
		
		int rowBoundary = numberOfRows;
		int[] location = new int[2];
		
		location = getLocationOfPersonInVehicle(p);
		
		if(numWindows<2*numberOfRows) {
			rowBoundary = numWindows/2;
		}
		if(location[0]>=rowBoundary) {
			return false;
		}
		if(location[1]==0) {
			return true;
		}
		if(location[1]==personsOnBoard[location[0]].length-1) {
		return true;
		}
		else {
			return false;
		}
	}
	public int getNumDoors() {
		return numDoors;
	}
	public int getNumWindows() {
		return numWindows;
	}
	
		public boolean equals(Object o) {
			if(o == null){
				return false;
				}
			if(this == o){
				return true;
				}
			if(o instanceof Car){
				
				Car car = (Car)o;
				if(this.numWindows ==  car.getNumWindows()){
					
					if(this.numDoors == car.getNumDoors()){
						
						if(this.numberOfRows == car.numberOfRows) {
							
							if(this.maxSeatsPerRow == car.maxSeatsPerRow) {
								
								if(this.numSeatsPerRow.length== car.numSeatsPerRow.length) { 
									
									for(int i = 0;i<numSeatsPerRow.length;i++) {
										
										if(!(this.numSeatsPerRow[i]	== car.numSeatsPerRow[i])) {
											
										return false;
										}
									}
					
								return true;
								}
							}
						}
					}
				}
			}
			
			return false;
		}
	public String toString() {
		String n = numSeatsPerRow();
		String s = String.format("Car: number of doors = %02d | number of windows = %02d | number of rows = %02d | seats per row = %s | names of people on board = %s\n",numDoors,numWindows,numberOfRows,n,getNamesOfPeopleOnBoard());
		
				return s;
	}
	

	private String numSeatsPerRow() {
		String s = "[";
		
		for(int i = 0; i<numSeatsPerRow.length-1;i++) {
			s += numSeatsPerRow[i] + ",";
		}
		
		s += numSeatsPerRow[numSeatsPerRow.length-1] + "]";
		return s;
	}
	@Override
	public String departure() {
		return "All Aboard\n";
	}

	@Override
	public String arrival() {
		return "Everyone Out\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		return "No Backseat Driving\n";
	}

	@Override
	

	public int compareTo(Car c) {
		int numSeats = 0;
		
		for(int i=0;i<numSeatsPerRow.length;i++) {
			numSeats += numSeatsPerRow[i];
		}
		if(c == null){return -1;}
		if((this.getNumberOfPeopleOnBoard() + this.getNumberOfAvailableSeats()) > c.getNumberOfPeopleOnBoard() + c.getNumberOfAvailableSeats()){
			return 1;
		}
		if((this.getNumberOfPeopleOnBoard() + this.getNumberOfAvailableSeats()) < c.getNumberOfPeopleOnBoard() + c.getNumberOfAvailableSeats()){
			return -1;
		}
		return 0;
		
	}
	

	@Override
	public boolean loadPassenger(Person p) {
		
		
		if(p.getAge()>=5 && p.getHeight()>=36) {
		for (int j = 1; j < personsOnBoard[0].length; j++){
			 if(!(personsOnBoard[0][j] instanceof Person)) {
				 personsOnBoard[0][j] = p;
				 return true;
       	 }
		}
		}
		for (int i = 1; i < personsOnBoard.length; i++){
	         for (int j = 0; j < personsOnBoard[i].length; j++){
	        	 if(!(personsOnBoard[i][j] instanceof Person)) {
	        		 personsOnBoard[i][j] = p;
					 return true;
	        	 }
	         }
	       }
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		int count = 0; 
		//if(getNumberOfAvailableSeats()>0) {
		for(int i =0; i<peeps.length ;i++) {
			if(getNumberOfAvailableSeats()>0) {
			loadPassenger(peeps[i]);
			count++;
			}
			}
		//}
		return count;
	}
}
