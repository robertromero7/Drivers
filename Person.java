
public class Person {

	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;
	
	public Person(String name, boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.hasDriverLicense = hasDriverLicense;
		this.age = age;
		this.height =  height;
	}
	public String getName() {
		return name;
	}
	public boolean hasDriverLicense() {
		return hasDriverLicense;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public Person clone() {
		Person x = new Person(name,hasDriverLicense,age,height);
		return x;
	}
	public boolean equals(Object o) {
		if(o == null){
			return false;
			}
		if(this == o){
			return true;
			}
		if(o instanceof Person){
			
			Person person = (Person)o;
			if(this.name.equalsIgnoreCase(person.getName())){
				
				if(this.hasDriverLicense == person.hasDriverLicense()){
					
					if(this.age == person.getAge()) {
						
						if(this.height == person.getHeight()) {
				
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	public String toString() {
		
		if(hasDriverLicense) {
			return String.format("Person [name= %10s | age= %02d | height= %02d | has license]", name, age, height, hasDriverLicense);
		}
		else {
			return String.format("Person [name= %10s | age= %02d | height= %02d | no license]", name, age, height, hasDriverLicense);

		}
	}
}
