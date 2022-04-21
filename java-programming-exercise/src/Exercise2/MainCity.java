package Exercise2;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class MainCity {
    public static void main(String[] args) throws FileNotFoundException {
        // create CityData instance
        CityData worldCities = new CityData();

        String menu = "Please enter:" + "\n" + "1 to print 10 largest cities" + "\n" + "2 to print 10 smallest cities"
                + "\n" + "3 to enter a country and print cities from this country" + "\n" +
                "4 to enter a latitude and longitude and print 10 closest cities" + "\n" + "quit to quit";
        System.out.println(menu);
        System.out.println();

        // get initial user input
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();

        // main loop
        while (!userInput.equals("quit")) {
            if (userInput.equals("1")) {
                System.out.println();
                worldCities.printLargest10();
                System.out.println();
            }

            if (userInput.equals("2")) {
                System.out.println();
                worldCities.printSmallest10();
                System.out.println();
            }

            if (userInput.equals("3")) {
                System.out.println();
                System.out.println("Enter country name: ");
                userInput = s.nextLine();
                worldCities.printCountry(userInput);
                System.out.println();
            }

            if (userInput.equals("4")) {
                System.out.println();
                System.out.println("Enter latitude and longitude");
                userInput = s.nextLine();
                try {
                    String[] userInputArr = userInput.split("\s");
                    worldCities.printClosest10(Double.parseDouble(userInputArr[0]),
                            Double.parseDouble(userInputArr[1]));
                    System.out.println();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println();
                }
            }

            System.out.println(menu);
            System.out.println();
            userInput = s.nextLine();
        }
        System.out.println("Bye!");
        s.close();
    }
}
