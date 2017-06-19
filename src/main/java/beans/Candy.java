package beans;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public abstract class Candy {

    protected double price;
    protected double weight;
    protected String name;

    public Candy() {
    }

    public Candy(double price, double weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "price=" + price +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
