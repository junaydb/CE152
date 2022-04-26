package Exercise3;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PopulationData {
    // fields
    private double[][] popData;
    private HashMap<String, String> headers = new HashMap<>();
    private int rows;
    private int cols;
    private int noDataVal;

    // constructor
    public PopulationData(String path) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));

        // store headers in map
        for (int i = 0; i < 6; i++) {
            String line = s.nextLine();
            String[] header = line.split("\s+"); // greedy match whitespace

            for (int j = 0; j < header.length; j++) {
                headers.put(header[0], header[1]);
            }
        }

        // store some of the header values in fields
        rows = Integer.parseInt(headers.get("nrows"));
        cols = Integer.parseInt(headers.get("ncols"));
        noDataVal = Integer.parseInt(headers.get("NODATA_value"));

        // initialise popData array with row and col values retrieved from file
        popData = new double[rows][cols];

        // read file into 2D array, row major order
        int i = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] densityVals = line.split("\s+");

            for (int j = 0; j < densityVals.length; j++) {
                popData[i][j] = Double.parseDouble(densityVals[j]);
            }

            i++;
        }
    }

    // methods
    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNoDataVal() {
        return noDataVal;
    }

    public double getPixelData(int i, int j) {
        return popData[i][j];
    }
}
