abstract class Beverage {
	String bevName;
	TYPE bevType;
	SIZE size;
	final double BASE_PRICE = 2.0;
	final int SIZE_PRICE = 1;

	public Beverage(String bevName, TYPE bevType, SIZE size) {
		this.bevName = bevName;
		this.bevType = bevType;
		this.size = size;
	}

	public abstract double calcPrice();

	public String ToString() {
		return bevName + " " + size;
	}

	public boolean equals(Beverage beverage) {
		boolean equals = false;
		if (bevName.equals(beverage.getBevName()) && bevType.equals(beverage.getBevType()) && size.equals(beverage.getBevSize()))
			equals = true;
		return equals;
	}

	public String getBevName() {
		return bevName;
	}

	public TYPE getBevType() {
		return bevType;
	}

	public SIZE getBevSize() {
		return size;
	}

	public void setBevName(String bevName) {
		this.bevName = bevName;
	}

	public void setBevType(TYPE bevType) {
		this.bevType = bevType;
	}

	public void setBevSize(SIZE bevSize) {
		this.size = bevSize;
	}
}
