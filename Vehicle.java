
public abstract class Vehicle {

	protected Person[][] personsOnBoard;
	protected int numberOfRows;
	protected int maxSeatsPerRow;
	protected int[] numSeatsPerRow;
	
	public Vehicle(int numRows, int numSeatsPerRow) {
		numberOfRows = numRows;
		maxSeatsPerRow = numSeatsPerRow;
		this.numSeatsPerRow = new int[numRows];
		
		for(int i = 0;i<this.numSeatsPerRow.length;i++) {
			this.numSeatsPerRow[i] = numSeatsPerRow;
		}
		
		personsOnBoard = new Person[numRows][numSeatsPerRow];
	}
	public Vehicle(int[] numSeatsPerRow) {
		numberOfRows = numSeatsPerRow.length;
		this.numSeatsPerRow = new int[numberOfRows];
		
		for(int i = 0;i<this.numSeatsPerRow.length;i++) {
			this.numSeatsPerRow[i] = numSeatsPerRow[i];
		}
		
		personsOnBoard = new Person[numberOfRows][];
		
		for(int i = 0;i<this.numSeatsPerRow.length;i++) {
			personsOnBoard[i] = new Person[numSeatsPerRow[i]];
		}
	}
	public Vehicle(Person driver, int[] numSeatsPerRow) {
		numberOfRows = numSeatsPerRow.length;
		this.numSeatsPerRow = new int[numberOfRows];
		
		for(int i = 0;i<this.numSeatsPerRow.length;i++) {
			this.numSeatsPerRow[i] = numSeatsPerRow[i];
		}
		
		personsOnBoard = new Person[numberOfRows][];
		for(int i = 0;i<this.numSeatsPerRow.length;i++) {
			personsOnBoard[i] = new Person[numSeatsPerRow[i]];
		}
		
		if(driver.hasDriverLicense()) {
			personsOnBoard[0][0] = driver;
		}
	}
	public abstract boolean loadPassenger(Person p);
	public abstract int loadPassengers(Person [] peeps);
	
	public void setDriver(Person p) throws InvalidDriverException{
		try {
			if(p.hasDriverLicense() == false || p == null) {
				throw new InvalidDriverException();
			}else {
				personsOnBoard[0][0] = p;
			}
		}catch(InvalidDriverException o) {
			throw new InvalidDriverException();
		}
	}
	
	public Person getDriver() {
	
		return personsOnBoard[0][0];
	}
	public boolean hasDriver() {
		if(personsOnBoard[0][0]!=null) {
			return true;
		}
		return false;
	}
	
	public int getNumberOfAvailableSeats() {
		int count = 0;
//		for (int j = 0; j < personsOnBoard[0].length; j++){
//			 if(!(personsOnBoard[0][j] instanceof Person)) {
//        		 count++;
//        	 }
//		}
		for (int i = 0; i < personsOnBoard.length; i++){
	         for (int j = 0; j < personsOnBoard[i].length; j++){
	        	 if(!(personsOnBoard[i][j] instanceof Person)) {
	        		 count++;
	        	 }
	         }
	       }
		return count;
	}
	public int getNumberOfAvailableSeatsInRow(int row) {
		int count = 0;
		if(row>=numberOfRows || row<0) {
			return -1;
		}
		for(int i= 0;i < personsOnBoard[row].length;i++) {
			if(!(personsOnBoard[row][i] instanceof Person)) {
       		 count++;
       	 }
		}
		return count;
	}
	public int getNumberOfPeopleOnBoard() {
		int count = 0;
		for (int i = 0; i < personsOnBoard.length; i++){
	         for (int j = 0; j < personsOnBoard[i].length; j++){
	        	 if(personsOnBoard[i][j] instanceof Person) {
	        		 count++;
	        	 }
	         }
	       }
		
		return count;
	}
	public int getNumberOfPeopleInRow(int row) {
		int count = 0;
		if(row>=numberOfRows || row<0) {
			return -1;
		}
		for(int i= 0;i < personsOnBoard[row].length;i++) {
			if(personsOnBoard[row][i] instanceof Person) {
       		 count++;
       	 }
		}
		return count;
	}
	public Person getPersonInSeat(int row,int col) {
		if(row>=numberOfRows || row<0) {
			return null;
		}
		return personsOnBoard[row][col];
	}
	public int[] getLocationOfPersonInVehicle(Person p) {
		int[] location = new int[2];
		if(p==null) {
			 location[0] = -1;
			 location[1] = -1;
			 return location;
		}
		
		
		for (int i = 0; i < personsOnBoard.length; i++){
	         for (int j = 0; j < personsOnBoard[i].length; j++){
	        	 if(personsOnBoard[i][j]!=null) {
	        		if (personsOnBoard[i][j].equals(p)) {
	        		 location[0]=i;
	        		 location[1]=j;
	        		 return location;
	        		}
	        	 }
	         }
	       }
		return location = new int[] {-1,-1};
	}
	
	public Person[] getPeopleInRow(int row) {
		
		if(row>=numberOfRows || row<0) {
			return null;
		}
		Person people[] = new Person[getNumberOfPeopleInRow(row)];
		
		if(getNumberOfPeopleInRow(row)<=0) {
			return null;
		}
		
		for(int i= 0;i < personsOnBoard[row].length;i++) {
			if(personsOnBoard[row][i] instanceof Person) {
				 people[i] = personsOnBoard[row][i].clone();
				
       	 }
		}
		return people;
	}
	public Person[][] getPeopleOnBoard(){
		
		Person people[][] = new Person[numberOfRows][];
		for(int i = 0;i<this.personsOnBoard.length;i++) {
			people[i] = new Person[numSeatsPerRow[i]];
		}
		
		for(int row=0; row<personsOnBoard.length; row++){
			for(int col=0; col<people[row].length; col++){
				if(personsOnBoard[row][col]!=null) {
					people[row][col] = personsOnBoard[row][col].clone();
				}
				}
			}
		return people;
	}
	public String getNamesOfPeopleOnBoard() {
		String s = "[";
		
		for(int row=0; row<numberOfRows; row++){
			for(int col=0; col<personsOnBoard[row].length; col++){
	        	 	if(personsOnBoard[row][col] instanceof Person) {
	        	 		s+= personsOnBoard[row][col].getName()+",";
	        	 	}
				}
			}
		s = s.substring(0,s.length()-1);
		s+="]";
		
		return s;
	}
	public boolean isPersonInVehicle(Person p) {
		if(p==null) {
			return false;
		}
		int[] location = getLocationOfPersonInVehicle(p);
		if(location[0]==-1 || location[1]==-1) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean isPersonDriver(Person p) {
		if(p==null) {
			return false;
		}
		if(!(personsOnBoard[0][0] instanceof Person)) {
			return false;
		}
		if(personsOnBoard[0][0].equals(p)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
