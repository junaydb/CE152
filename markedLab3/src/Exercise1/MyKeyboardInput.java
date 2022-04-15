package Exercise1;

import java.util.*;

public class MyKeyboardInput {
    public static void main(String[] args) {
        // read and store one line of user input
        Scanner s = new Scanner(System.in);
        String userInputRaw = s.nextLine();
        s.close();

        // split user input into individual strings and store in array
        String[] userData = userInputRaw.split("\\s+");

        // add data from userData to set, parse numbers as doubles
        Set data = new HashSet<>();
        for (String elem : userData) {
            try {
                data.add(Double.parseDouble(elem));
            } catch (NumberFormatException e) {
                data.add(elem);
            }
        }

        /*
         * create map with MyInputInfo obj as key and frequency of equal objs as value,
         * use TreeMap for sorting
         */
        Map<MyInputInfo, Integer> inputMap = new TreeMap<>();
        for (int i = 0; i < userData.length; i++) {
            MyInputInfo currentKey = new MyInputInfo(userData[i]);
            if (!inputMap.containsKey(currentKey)) {
                inputMap.put(currentKey, 1);
            } else {
                inputMap.replace(currentKey, inputMap.get(currentKey) + 1);
            }
        }
        System.out.println(inputMap);
        System.out.println(data);
    }
}