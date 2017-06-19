package beans;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class ChocolateCandy extends Candy {

	private ChocolateType chocolateType;

	public ChocolateCandy(){ name = "Custom Chocolate Candy";}

	public ChocolateCandy(ChocolateType chocolateType, double price, double weight) {
		this.chocolateType = chocolateType;
		this.price = price;
		this.weight = weight;
	}

	public ChocolateType getChocolateType() {
		return chocolateType;
	}

	public void setChocolateType(ChocolateType chocolateType) {
		this.chocolateType = chocolateType;
	}

	@Override
	public String toString() {
		return "ChocolateCandy{" +
				"chocolateType=" + chocolateType +
				"} " + super.toString();
	}
}
