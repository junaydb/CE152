package Exercise2;

import java.util.Comparator;

public class CityDistanceComparator implements Comparator<City> {
    // sort list based on smallest distance
    @Override
    public int compare(City c1, City c2) {
        if (c1.getDistance() == c2.getDistance()) {
            return 0;
        }
        if (c1.getDistance() > c2.getDistance()) {
            return 1;
        } else {
            return -1;
        }
    }
}
