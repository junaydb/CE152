package Exercise2;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CityData {
    // fields
    private List<City> cities = new ArrayList<City>();
    private List<City> citiesCopy = new ArrayList<City>();

    // constructor
    public CityData() throws FileNotFoundException {
        Scanner csv = new Scanner(new File("lib/worldcities.csv"));

        // skip first line and set delimeter
        csv.nextLine();

        /*
         * scan worldcities.csv line by line,
         * construct new City object from each line from required values,
         * add City object to cities list
         */
        while (csv.hasNextLine()) {
            String line = csv.nextLine();
            String[] values = line.split(",(?=\")");

            // remove double quotes from strings
            for (int i = 0; i < values.length; i++) {
                values[i] = values[i].replace("\"", "");
            }

            City city = new City(values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]), values[4],
                    Integer.parseInt(values[9]));
            cities.add(city);
        }
        csv.close();

        // store copy of original array
        citiesCopy.addAll(cities);
    }

    // methods
    public void printLargest10() {
        Collections.sort(cities);

        for (int i = 0; i < 10; i++) {
            System.out.println(cities.get(i).toString());
        }
    }

    public void printSmallest10() {
        Collections.sort(cities);

        for (int i = 1; i < 11; i++) {
            System.out.println(cities.get(cities.size() - i).toString());
        }
    }

    public void printCountry(String country) {
        for (int i = 0; i < cities.size(); i++) {
            if (citiesCopy.get(i).getCountry().toLowerCase().equals(country.toLowerCase())) {
                System.out.println(citiesCopy.get(i).toString());
            }
        }
    }

    public void printClosest10(double latitude, double longitude) {
        /*
         * implement haversine formula to calculate distance between two points on
         * sphere (sphere represents earth). First point is determined by args, second
         * point determined by current indexed city.
         * After calculating distance, assign result to distance field of City object.
         */

        // earth radius (km)
        int radius = 6371;

        double distance = 0;
        for (int i = 0; i < cities.size(); i++) {
            double latDist = Math.toRadians(latitude - cities.get(i).getLatitude());
            double longDist = Math.toRadians(longitude - cities.get(i).getLongitude());

            double a = Math.pow(Math.sin(latDist / 2), 2) + Math.cos(Math.toRadians(latitude))
                    * Math.cos(Math.toRadians(cities.get(i).getLatitude())) * Math.pow(Math.sin(longDist / 2), 2);

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            distance = radius * c;

            // set value of distance field of current City object
            this.cities.get(i).setDistance(distance);
        }

        // sort list with comparator that uses distance value for sorting
        Collections.sort(cities, new CityDistanceComparator());

        // print 10 cities closest to supplied lat/lon
        for (int i = 0; i < 10; i++) {
            System.out.println(cities.get(i).toString());
        }
    }
}
