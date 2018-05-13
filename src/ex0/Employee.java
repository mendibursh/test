package ex0;

abstract public class Employee {

	String firstName;
	String lastName;
	int id;
	
	// Getters and setters 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Employee(String fn, String ln , int _id) {
		// TODO Auto-generated constructor stub
		
		firstName =fn;
		lastName = ln;
		id =_id;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
		firstName = "plony";
		lastName = "almony";
		id = 0;
	}
	  public String toString() {
		 // System.out.println(firstName + "\n" + lastName + "\n" + id);
		  return (firstName + "\n" + lastName + "\n" + id);
	  }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	abstract double earnings ();        
}


