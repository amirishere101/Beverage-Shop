
public class Alcohol extends Beverage {
	boolean weekend;
	final double WEEKEND_PRICE = 0.6;

	public Alcohol(String bevName, SIZE size) {
		super(bevName, TYPE.ALCOHOL, size);
	}

	public String toString() {
		String alcohol = getBevName() + " " + getBevSize();
		if (weekend == true)
			alcohol += " Purchased on Weekend,";
		alcohol += " $" + calcPrice();
		return alcohol;
	}

	public double calcPrice() {
		double price = super.BASE_PRICE;
		if (getBevSize() == SIZE.MEDIUM || getBevSize() == SIZE.LARGE)
			price += SIZE_PRICE;
		if (getBevSize() == SIZE.LARGE)
			price += SIZE_PRICE;
		if (weekend == true)
			price += WEEKEND_PRICE;
		;
		return price;
	}

	public boolean getWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public boolean equals(Alcohol alcohol) {
		boolean equals = false;
		if (super.equals(alcohol) && alcohol.getWeekend() == weekend)
			equals = true;
		return equals;
	}
}
