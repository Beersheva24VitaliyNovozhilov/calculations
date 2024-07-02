package io.p4r53c.beersheba24.into;

/**
 * First demo class for Beersheva 24 TR Course
 * 
 * @author p4r53c
 * @since 02.07.2024
 * 
*/
public class Main {

    public static void main(String[] args) {
        printGreeting();
        printStringBuilderHellowMessage();
    }

    /**
     * Prints the greeting "Hello world!" to the standard output.
     * 
     * This method is called from the main method and should not be public.
     * It does for testing purposes and demo.
     * 
     */
    public static void printGreeting() {
        System.out.println("Hello world!");
    }

    /**
     * Returns a string that concatenates multiple lines of text using a StringBuilder.
     * 
     * This method is called from the main method and should not be public.
     * It does for testing purposes and demo.
     *
     * @return          the concatenated string
     */
    public static String printStringBuilderHellowMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello\n").append("Tel Ran\n").append("Beersheva24\n").append("Cuorse\n");
        return sb.toString();
    }

}