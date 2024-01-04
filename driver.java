import java.util.Arrays;

public class driver {
	public static void main(String[ ] args ) throws InvalidDriverException {
		Person p = new Person("Robert",true,18,100);
		Person x = new Person("Rob",false,15,121);
		Person t = new Person("Roberto",false,4,118);
		Person r = new Person("Robertson",true,3,124);
		
		int[] numSeats = {2,2,3};
		
		Car bmw = new Car(4,4,numSeats);
		bmw.setDriver(p);
		
	//	System.out.println(bmw.personsOnBoard[0].length);
		bmw.personsOnBoard[0][1] = t;
		bmw.personsOnBoard[1][0] = x;
		bmw.personsOnBoard[1][1] = p;
		bmw.personsOnBoard[2][2] = r;
	//	System.out.println(Arrays.toString(bmw.getLocationOfPersonInVehicle(x)));
		System.out.println(bmw.getNumberOfAvailableSeatsInRow(3));
	//	System.out.println(bmw.getNumberOfPeopleOnBoard());
	//	System.out.println(bmw.toString());
	//	System.out.println(Arrays.toString(bmw.getLocationOfPersonInVehicle(x)));
	//	System.out.println(bmw.canOpenDoor(r));
	}
}
