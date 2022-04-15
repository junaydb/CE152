package Exercise1;

public class Country extends Population {
    // fields
    private City[] cities;
    final private int[] latitudeRange = { -90, 90 };
    final private int[] longitudeRange = { -180, 180 };

    // constructor
    public Country(double size, int numCities) {
        super(size);
        this.cities = new City[numCities];

        /*
         * create array of random numbers and store sum of this array,
         * this sum is for use in formula for random population distribution
         */
        double randArr[] = new double[numCities];
        double randArrSum = 0;
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = Utility.round(Utility.getRand(0.1, 1));
            randArrSum += randArr[i];
        }

        for (int i = 0; i < cities.length; i++) {
            // gen random population using a formula for random distribution w fixed sum
            double population = randArr[i] / randArrSum * size;
            // gen random latitude and longitude
            double latitude = Utility.getRand(latitudeRange[0], latitudeRange[1]);
            double longitude = Utility.getRand(longitudeRange[0], longitudeRange[1]);

            // create City obj with generated values
            cities[i] = new City(population, latitude, longitude);
        }
    }

    // methods
    // return city with lowest population
    public City getMinimum() {
        City min = cities[0];

        for (int i = 1; i < cities.length; i++) {
            if (cities[i].getSize() < min.getSize()) {
                min = cities[i];
            }
        }
        return min;
    }

    // return city with highest population
    public City getMaximum() {
        City max = cities[0];

        for (int i = 1; i < cities.length; i++) {
            if (cities[i].getSize() > max.getSize()) {
                max = cities[i];
            }
        }
        return max;
    }

    // increase total population, randomly distribute increase amount across cities
    @Override
    public void update(double increase) {
        /*
         * create array of random numbers and store sum of this array,
         * this sum is for use in formula for random population distribution
         */
        double randArr[] = new double[this.cities.length];
        double randArrSum = 0;
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = Utility.round(Utility.getRand(0.1, 1));
            randArrSum += randArr[i];
        }

        /*
         * increase each city's population using a formula for random distribution
         * w fixed sum
         */
        for (int i = 0; i < this.cities.length; i++) {
            cities[i].setSize((this.cities[i].getSize()) + (randArr[i] / randArrSum * increase));
        }

        // increase total country population
        this.setSize(this.getSize() + increase);
    }

    @Override
    public String toString() {
        return Utility.round(this.getSize()) + " million in " + this.cities.length + " cities...";
    }
}
