import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	int orderNum;
	DAY orderDay;
	Customer customer;
	int orderTime;
	ArrayList order = new ArrayList();

	public int randomNumber() {
		Random rand = new Random();
		int randInt = rand.nextInt(80000) + 10000;
		return randInt;
	}

	public Order(int orderTime, DAY orderDay, Customer customer) {
		this.orderNum = randomNumber();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
	}

	public boolean isWeekend() {
		boolean weekend = false;
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY)
			weekend = true;
		return weekend;
	}

	public Beverage getBeverage(int itemNo) {
		return (Beverage) order.get(itemNo);
	}

	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		order.add(coffee);
	}

	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol alcohol = new Alcohol(bevName, size);
		order.add(alcohol);
	}

	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addPRotien);
		order.add(smoothie);
	}

	public double calcOrderTotal() {
		double price = 0;
		for (int i = 0; i < order.size(); i++) {
			price += ((Beverage) order.get(i)).calcPrice();
		}
		return price;
	}

	public int findNumOfBeveType(TYPE type) {
		int numOfType = 0;
		for (int i = 0; i < order.size(); i++) {
			if (((Beverage) order.get(i)).getBevType() == type)
				numOfType += 1;
		}
		return numOfType;
	}

	public String toString() {
		return orderNum + " " + orderTime + " " + customer.name + " " + customer.age + " " + order;
	}

	public int compareTo(Order o) {
		int status = 0;
		if (this.orderNum > o.orderNum)
			status = 1;
		if (this.orderNum < o.orderNum)
			status = -1;
		return status;
	}

	public Customer getCustomer() {
		return new Customer(customer);
	}

	public int getOrderNo() {
		return orderNum;
	}
}
