public class Monom {

    public int coef;
    public int deg;

    public Monom(int coef, int deg) {
        this.coef = coef;
        this.deg = deg;
    }

    public Monom() {
        this(0,0);
    }

    @Override
    public String toString() {
        return "("+coef+"*x^"+deg+")";
    }
}
