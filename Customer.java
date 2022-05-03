
public class Customer {
	int age;
	String name;

	public Customer(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public Customer(Customer customer) {
		this(customer.getAge(), customer.getName());
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + " " + age;
	}
}
