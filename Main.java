
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Main {
    public static void radixSort(int[] arr) {//Sort an array of only even digit integers using Radix

        int max = 0;

        //arraylist for storing and processing buckets
        ArrayList<ArrayList<String>> output = new ArrayList<>();

        //converting input integer array to string array
        String[] strArray = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        //converting string array to arraylist input
        ArrayList<String> input = new ArrayList<>();
        Collections.addAll(input, strArray);

        for (int i = 0; i < 5; i++) {//generating buckets (5 because we only have 0, 2, 4, 6 ,8)
            output.add(new ArrayList<>());
        }

        for (String s : input) {//looping through input arraylist to validate the input first
            if (s.contains("1") || s.contains("3") || s.contains("5") || s.contains("7") || s.contains("9")) {
                System.out.println("*** Abort *** the input has at least one key with odd digits");
                return;
            } else if (s.length() > max) {// finding maximum number of digits
                max = s.length();
            }
        }
        for (int digit = 1; digit <= max; digit++) {                                       //iterate to move from least significant digit (LSD) to most significant digit(MSD)
            for (String s : input) {                                                       //looping through string array to add the numbers to their respective bucket
                s = String.format("%1$" + max + "s", s).replace(' ', '0');  //formatting strings to have 'max' number of digits adding 0s to their left
                for (int bucket = 0; bucket < 5; bucket++) {
                    if (s.charAt(s.length() - digit) == (char) (bucket * 2 + '0')) {       //starting from LSD check every string up to MSD
                        output.get(bucket).add(s);                                         //add each string to their respective bucket
                    }
                }
            }
            input.clear();
            for (ArrayList<String> l1 : output) { //update input to be same as last output
                for (String n : l1) {
                    input.add(n);
                }
            }
            output.clear();              //clearing buckets for next iteration
            for (int i = 0; i < 5; i++) {//generating empty buckets
                output.add(new ArrayList<>());
            }
        }
        for (String s : input) {
            int y = Integer.parseInt(s);
            s = String.format("%01d", y);// removing all the 0s in front of the numbers
            System.out.print(s + " ");   //printing sorted array
        }
    }


    public static void main(String[] args) {
        int[] array = {208, 206, 84, 868, 884, 66, 8, 282, 44};

        radixSort(array);
    }
}