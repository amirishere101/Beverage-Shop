
public class Coffee extends Beverage {
	boolean extraShot;
	boolean extraSyrup;
	final double SHOT_PRICE = 0.5;
	final double SYRUP_PRICE = 0.5;

	public Coffee(String bevName, SIZE size, boolean shot, boolean syrup) {
		super(bevName, TYPE.COFFEE, size);
		extraShot = shot;
		extraSyrup = syrup;
	}

	public String toString() {
		String coffee = getBevName() + " " + getBevSize();
		if (getExtraShot() == true)
			coffee += " Extra Shot";
		if (getExtraSyrup() == true)
			coffee += " Extra Syrup";
		coffee += " $" + calcPrice();
		return coffee;
	}

	public double calcPrice() {
		double price = super.BASE_PRICE;
		if (getBevSize() == SIZE.MEDIUM || getBevSize() == SIZE.LARGE)
			price += SIZE_PRICE;
		if (getBevSize() == SIZE.LARGE)
			price += SIZE_PRICE;
		if (getExtraShot() == true)
			price += SHOT_PRICE;
		if (getExtraSyrup() == true)
			price += SYRUP_PRICE;
		return price;
	}

	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	public boolean equals(Coffee coffee) {
		boolean equals = false;
		if (super.equals(coffee) && coffee.getExtraShot() == extraShot && extraSyrup == coffee.getExtraSyrup())
			equals = true;
		return equals;
	}

}
