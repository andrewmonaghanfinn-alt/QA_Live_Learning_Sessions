package Labs.lab3;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

//        System.out.println("You entered: " + getInt("Enter a number"));
//
//        System.out.println("You entered: " + getString("Enter a string"));
//
//        theLunchQueue();

        Utils helper = new Utils();

        convertInputToStonesPounds(helper.getInt("Please enter a weight in pounds: "));
        convertKgsToStonesPounds(helper.getInt("Please enter a weight in KG: "));
    }



    static void theLunchQueue() {

        Utils helper = new Utils();

        String mainCourse = helper.getString("What main dish would you like (fish, burgers or veg) ?");
        int potatoes = helper.getInt("How many potatoes would you like?");
        int sprouts = helper.getInt("How many sprouts would you like?");

        System.out.println("Hello, your lunch is " + mainCourse + " with " + potatoes + " roast potatoes and " + sprouts + " Brussel sprouts.");
    }

    static void convertInputToStonesPounds(int pounds) {

        System.out.println("that is equivalent to " + pounds / 14 + " stone and " + pounds % 14 + " pound(s)");
    }

    static void convertKgsToStonesPounds(int kg) {
        int convertToPounds = (int) (kg * 2.20462);
        convertInputToStonesPounds(convertToPounds);
    }
}

class Utils {
     int getInt(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

     String getString(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}
