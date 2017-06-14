package beans;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class LollipopCandy extends Candy {

    private LollipopTaste lollipopTaste;

    public LollipopTaste getLollipopTaste() {
        return lollipopTaste;
    }

    public void setLollipopTaste(LollipopTaste lollipopTaste) {
        this.lollipopTaste = lollipopTaste;
    }

    @Override
    public String toString() {
        return "LollipopCandy{" +
                "lollipopTaste=" + lollipopTaste +
                "} " + super.toString();
    }
}
