import java.util.ArrayList;

class BevShop implements BevShopInterfce {
	int numOfAlcDrinks;
	int temp;
	ArrayList<Order> orders;

	public BevShop() {
		orders = new ArrayList<>();
	}

	public boolean validTime(int time) {
		boolean isValidTime = true;
		if (time < MIN_TIME || time > MAX_TIME)
			isValidTime = false;
		return isValidTime;
	}

	@Override
	public boolean eligibleForMore() {
		boolean isEligible = true;
		if (numOfAlcDrinks > MAX_ORDER_FOR_ALCOHOL)
			isEligible = false;
		return isEligible;
	}

	@Override
	public boolean validAge(int age) {
		boolean isValidAge = true;
		if (age < MIN_AGE_FOR_ALCOHOL)
			isValidAge = false;
		return isValidAge;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerAge, customerName);
		Order order = new Order(time, day, customer);
		orders.add(order);
		numOfAlcDrinks = 0;
		temp = orders.indexOf(order);
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(temp).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(temp).addNewBeverage(bevName, size);
		numOfAlcDrinks += 1;
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		orders.get(temp).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		int orderNum = 0;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo)
				orderNum = i;
		}
		return orderNum;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		int orderIndex = findOrder(orderNo);
		return orders.get(orderIndex).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double price = 0;
		for (int i = 0; i < orders.size(); i++) {
			price += orders.get(i).calcOrderTotal();
		}
		return price;
	}

	@Override
	public void sortOrders() {
		for (int i = 0; i < orders.size() - 1; i++) {
			int sort = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(sort).getOrderNo())
					sort = j;
			}
		}
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	public Order getCurrentOrder() {
		return orders.get(temp);
	}

	public int getNumOfAlcoholDrink() {
		return numOfAlcDrinks;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public boolean isMaxFruit(int numOfFruits) {
		boolean maxFruit = false;
		if (numOfFruits > MAX_FRUIT)
			maxFruit = true;
		return maxFruit;
	}
}
