
public class Bicycle extends Vehicle implements Comparable<Bicycle>{
	
	public Bicycle(int numRows, int numSeatsPerRow) {
		super(numRows, numSeatsPerRow);
		// TODO Auto-generated constructor stub
	}

	private double weight;

	@Override
	public int compareTo(Bicycle o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean loadPassenger(Person p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		// TODO Auto-generated method stub
		return 0;
	}
}
