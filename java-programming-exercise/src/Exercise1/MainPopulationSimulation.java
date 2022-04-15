package Exercise1;

public class MainPopulationSimulation {
    public static void main(String[] args) throws Exception {
        // create Country instance
        Country pangea = new Country(100, 12);

        System.out.println("Starting population: " + pangea.toString());

        // randomly increase population per year over 5 years
        for (int i = 0; i < 5; i++) {
            double rand = Utility.round(Utility.getRand(0.1, 10));
            pangea.update(rand);

            System.out.println("Year " + i + " increase: " + rand + " million...");
        }

        System.out.println("Largest city: " + pangea.getMaximum().toString());
        System.out.println("Smallest city: " + pangea.getMinimum().toString());
        System.out.println("Total: " + pangea.toString());
    }
}
