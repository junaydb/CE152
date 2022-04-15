package Exercise1;

public class Population {
    // fields
    private double size;

    // constructor
    public Population(double size) {
        this.size = size;
    }

    // methods
    public void update(double increase) {
        size += increase;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
