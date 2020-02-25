package ar.edu.utn.frsf.dswba;

import java.util.stream.IntStream;

/**
 * Let's do a simple performance test using Java Stream API!
 *
 * @author rbravo
 */
public class Main {

    public static void main(String[] args) {

        int total = 0;

        // Calculates the sum of first 10 factorials using FOR iteration
        long t0 = System.currentTimeMillis();
        total = calculateUsingIteration();
        long t1 = System.currentTimeMillis();
        System.out.println("TOTAL: " + total + ". Total milliseconds for a regular FOR iteration: " + (t1 - t0));

        // Calculates the sum of first 10 factorials using Java Stream
        t0 = System.currentTimeMillis();
        total = calculateUsingStream();
        t1 = System.currentTimeMillis();
        System.out.println("TOTAL: " + total + ". Total milliseconds for a Stream iteration: " + (t1 - t0));

        // Calculates the sum of first 10 factorials using Java Stream and Parallel :-)
        t0 = System.currentTimeMillis();
        total = calculateUsingStreamParallel();
        t1 = System.currentTimeMillis();
        System.out.println("TOTAL: " + total + ". Total milliseconds for a Stream iteration using Parallel: " + (t1 - t0));

    }

    // Calculates the sum of first 10 factorials using FOR iteration
    static int calculateUsingIteration() {
        int total = 0;
        for (int i=0;i<10;i++) {
            total += factorial(i);
        }
        return total;
    }

    // Calculates the sum of first 10 factorials using Java Stream
    static int calculateUsingStream() {
        int total = 0;
        IntStream is = IntStream.range(0,10);
        total = is.map(Main::factorial).sum();
        return total;
    }

    // Calculates the sum of first 10 factorials using Java Stream and Parallel :-)
    static int calculateUsingStreamParallel() {
        int total = 0;
        IntStream is = IntStream.range(0,10);
        total = is.map(Main::factorial).parallel().sum();
        return total;
    }

    /**
     *
     * @param  number
     * @return factorial of a given number
     */
    public static int factorial(int number) {

        try {
            // We insert this line just for educational purposes, so we can note the difference
            Thread.sleep(200);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (number == 0)
            return 1;
        else
            return(number * factorial(number-1));
    }

}



