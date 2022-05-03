
public class Smoothie extends Beverage {
	boolean proteinPowder;
	int numOfFruits;
	final double PROTEIN_PRICE = 1.5;
	final double FRUIT_PRICE = 0.5;

	public Smoothie(String bevName, SIZE size, int numOfFruits, boolean proteinPowder) {
		super(bevName, TYPE.SMOOTHIE, size);
		this.proteinPowder = proteinPowder;
		this.numOfFruits = numOfFruits;
	}

	public String toString() {
		String smoothie = getBevName() + " " + getBevSize();
		if (proteinPowder == true)
			smoothie += " Protein Powder";
		smoothie += " " + getNumOfFruits() + " $" + calcPrice();
		return smoothie;
	}

	public double calcPrice() {
		double price = super.BASE_PRICE;
		if (getBevSize() == SIZE.MEDIUM || getBevSize() == SIZE.LARGE)
			price += SIZE_PRICE;
		if (getBevSize() == SIZE.LARGE)
			price += SIZE_PRICE;
		if (getProteinPowder() == true)
			price += PROTEIN_PRICE;
		price += FRUIT_PRICE * getNumOfFruits();
		return price;
	}

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean getProteinPowder() {
		return proteinPowder;
	}

	public boolean equals(Smoothie smoothie) {
		boolean equals = false;
		if (super.equals(smoothie) && smoothie.getProteinPowder() == proteinPowder && smoothie.getNumOfFruits() == numOfFruits)
			equals = true;
		return equals;
	}

}
