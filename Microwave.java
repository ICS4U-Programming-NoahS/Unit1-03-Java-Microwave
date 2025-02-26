import java.util.Scanner;

/**
* The Microwave program asks the user which item they want to eat, and how many
* (max 3 and they must all be the same items).
* It then calculates and displays the time it takes to heat each item,
* given the quantity specified by the user.

*
* @author Noah Smith
* @version 1.0
* @since 2025-02-17
*/

final class Microwave {

    /**
    * The time it takes to heat up one pizza, in seconds.
    */
    public static final double PIZZA_TIME = 45;

    /**
    * The time it takes to heat up one sub, in seconds.
    */
    public static final double SUB_TIME = 60;

    /**
    * The time it takes to heat up one soup, in seconds.
    */
    public static final double SOUP_TIME = 105;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Greet user
        System.out.println("Welcome to the Microwave program!");

        // Loop to give user another chance to enter valid food item
        do {
            // Ask the user to choose their food item
            System.out.println("What would you like to heat up for lunch? ");
            System.out.println("Enter 'pizza', 'sub', or 'soup': ");

           // Get the item choice from the user as a string
           String userItem = scanner.nextLine();

            // Check user's item choice to make sure it is valid
            // source: https://www.geeksforgeeks.org/...
            // ...difference-between-and-equals-method-in-java/
            if (
            userItem.equals("pizza")
            || userItem.equals("sub")
            || userItem.equals("soup")
                ) {

                // Loop to give user another chance to enter a valid number
                do {
                    // Ask the user for the number of items they want to heat up
                    System.out.println(
                            "How many items do you want to heat up?"
                        );
                    System.out.println("(Max 3 items.)");

                    // Try to catch invalid number of items
                    try {
                        // Get the item choice from the user as a double
                        double numItem = scanner.nextDouble();

                        // If it is a valid number of items
                        if (numItem <= 3 && numItem > 0) {

                            // If the user chooses pizza
                            if (userItem.equals("pizza")) {

                                // Calculate the time it takes
                                // to heat up user's pizza(s)
                                double timePizza =
                                        (PIZZA_TIME * ((numItem - 1)) * 0.5)
                                + PIZZA_TIME;

                                // Convert the time it takes to heat up pizza
                                // from seconds to minutes and seconds
                                int minutes = ((int) timePizza) / 60;
                                double seconds =
                                (double) timePizza - (60 * (double) minutes);

                                // Display the time it takes
                                // to heat up user's pizza(s)
                                System.out.println(
                                        "It will take " + minutes
                                        + " minutes and "
                                        + String.format("%.2f", seconds)
                                        + " seconds to heat up "
                                        + numItem + " pizza(s)."
                                    );
                            // If the user chooses sub
                            } else if (userItem.equals("sub")) {
                                // Calculate the time it takes
                                // to heat up user's sub(s)
                                double timeSub =
                                    SUB_TIME * ((numItem - 1) * 0.5)
                                    + SUB_TIME;

                                // Convert the time it takes to heat up pizza
                                // from seconds to minutes and seconds
                                int minutes = ((int) timeSub) / 60;
                                double seconds =
                                (double) timeSub - (60 * (double) minutes);

                                // Display the time it takes
                                // to heat up user's sub(s)
                                System.out.println(
                                        "It will take " + minutes
                                        + " minutes and "
                                        + String.format("%.2f", seconds)
                                        + " seconds to heat up "
                                        + numItem + " sub(s)."
                                    );

                            // If the user chooses soup
                            } else {
                                // Calculate the time it takes
                                // to heat up user's soup(s)
                                double timeSoup =
                                    SOUP_TIME * ((numItem - 1) * 0.5)
                                    + SOUP_TIME;

                                // Convert the time it takes to heat up pizza
                                // from seconds to minutes and seconds
                                int minutes = ((int) timeSoup) / 60;
                                double seconds =
                                (double) timeSoup - (60 * (double) minutes);

                                // Display the time it takes
                                // to heat up user's soup(s)
                                System.out.println(
                                        "It will take " + minutes
                                        + " minutes and "
                                        + String.format("%.2f", seconds)
                                        + " seconds to heat up "
                                        + numItem + " soup(s)."
                                    );
                            }
                            // Break from numItem loop
                            break;
                        } else {
                            // If user enters an invalid number of items
                            System.out.println(
                                    "You must choose a positive"
                                    + " number less than or equal to 3."
                                    + "Try again."
                                );
                        }
                    } catch (Exception exception) {
                        // If the user does not enter a number
                        System.out.println("Please enter a number.");
                        System.out.println("Try again.");

                        // Move on to the next line of input
                        // to prevent potential infinite loop
                        scanner.nextLine();
                    }
                }
                // Keep looping while input is still invalid
                while (true);
                // Break from userItem loop
                break;
            } else {
                // If the user does not enter a valid food item
                System.out.println(
                        "Item must be 'pizza', 'sub', or 'soup'. Try again."
                    );
            }
        }
        // Keep looping while input is still invalid
        while (true);

        // Closing Scanner
        scanner.close();
    }
}
