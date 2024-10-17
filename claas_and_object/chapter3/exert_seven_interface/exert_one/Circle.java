public class Circle {
    private double ridius;

    public Circle() {
    }

    public Circle(double ridius) {
        this.ridius = ridius;
    }

    public double getRidius() {
        return ridius;
    }

    public void setRidius(double ridius) {
        this.ridius = ridius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "ridius=" + ridius +
                '}';
    }
}
