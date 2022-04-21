package Exercise2;

public class City implements Comparable<City> {
    // fields
    private String ascii;
    private double latitude;
    private double longitude;
    private String country;
    private int population;
    /*
     * distance field is specifically for sorting objects based on distance to lat
     * and long args in printClosest10 method
     */
    private double distance;

    // constructor
    public City(String ascii, double latitude, double longitude, String country, int population) {
        this.ascii = ascii;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.population = population;
    }

    // methods
    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // compare cities based on their population (descending order)
    @Override
    public int compareTo(City other) {
        if (this.population == other.population) {
            return 0;
        }
        if (this.population > other.population) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.ascii + " located at " + this.latitude + " latitude " +
                this.longitude + " in " + this.country
                + " with a population of " + this.population;
    }
}
