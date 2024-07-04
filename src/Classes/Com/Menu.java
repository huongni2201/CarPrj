package Classes.Com;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    /**
     *
     * @param <E> elements
     * @param options
     * @return the index of the chosen option
     */
    public <E> int int_getChoice(ArrayList<E> options) {
        int response = -1;
        int len = options.size();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < len; i++) {
            System.out.println((i + 1) + " - " + options.get(i));
        }
        System.out.println("Please choose an option (1 - " + len + "): ");

        return response;
    }

    public <E> E ref_getChoice(ArrayList<E> options) {
        int response;
        int len = options.size();
        do {
            response = int_getChoice(options);
        } while (response < 1 || response > len);

        return options.get(response - 1);
    }
}
