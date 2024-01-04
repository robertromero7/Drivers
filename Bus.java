
public class Bus extends Car{

	public Bus(int[] numSeatsPerRow) {
		super(2,((2*numSeatsPerRow.length)-1),numSeatsPerRow);
		
	}
	public Bus(Person driver, int[]numSeatsPerRow) {
		super(2,((2*numSeatsPerRow.length)-1),numSeatsPerRow);
		try {
			setDriver(driver);
		} catch (InvalidDriverException e) {
			
		}

		
	}

	public boolean canOpenDoor(Person p) {
		if(p==null) {
			return false;
		}
		if(isPersonDriver(p)) {
			return true;
		}
		if(p.getAge()<=5 || p.getHeight()<=40) {
			return false;
		}
		else {
			int row;
			for (int i = numberOfRows-1; i >= 0; i--){
		         for (int j = personsOnBoard[i].length-1; j >=0; j--){
		        	 if((personsOnBoard[i][j] instanceof Person)) {
		        		  row = i;
		        		 int[] location = new int[2];
		      			location = getLocationOfPersonInVehicle(p);
		      			if(location[0] == row)
		      				return true;
		        	 }
		         }
		       }
		
				return false;
		}
	}
	public boolean canOpenWindow(Person p) {
		if(super.canOpenWindow(p)) {
			if(p.getAge()>5) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
		return "Bus is an extension of " + super.toString();
	}
	@Override
	public String departure() {
		return super.departure()+ "The Bus\n";
	}

	@Override
	public String arrival() {
		return super.arrival()+ "Of The Bus\n";
	}

	@Override
	public String doNotDisturbTheDriver() {
		return super.doNotDisturbTheDriver()+ "On The Bus\n";
	}
	
}
