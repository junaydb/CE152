package Exercise1;

public class City extends Population {
    // fields
    private double latitude;
    private double longitude;

    // constructor
    public City(double size, double latitude, double longitude) {
        super(size);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // methods
    @Override
    public String toString() {
        return Utility.round(this.getSize()) + " million located at " + Utility.round(latitude) + " lat, "
                + Utility.round(longitude) + " lon...";
    }
}
