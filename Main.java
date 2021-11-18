import java.util.*;


public class Main {
    public static void radixSort(int[] arr) {//Sort an array of only even digit integers using Radix

        int max =0;

        ArrayList<ArrayList<String>> output = new ArrayList<>();// Arraylist of arraylists of strings

        //converting input integer array to string array
        String[] strArray = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        for (char i = '0'; i < '5'; i++) {//generating buckets (5 because we only have 0, 2, 4, 6 ,8)
            output.add(new ArrayList<>());
        }

        for (String s : strArray) {//looping through array of strings to validate the input first
            if (s.contains("1") || s.contains("3") || s.contains("5") || s.contains("7") || s.contains("9")) {
                System.out.println("*** Abort *** the input has at least one key with odd digits");
                return;
            }
            else if(s.length() > max){// finding maximum number of digits
                max = s.length();
            }
        }

        for (String s : strArray) {//looping throug string array to add the numbers to their respective bucket
            s = String.format("%1$" + max + "s", s).replace(' ', '0'); //formating strings to have max number of digits adding 0s to their left
            for (int digit = 1; digit <= s.length(); digit++) {
                for (int bucket = 0; bucket < 5; bucket++) {
                    if (s.charAt(s.length() - digit) == (char) (bucket * 2 + '0')) {//if  the last character of the string = bucket*2 (only even numbers)
                        output.get(bucket).add(s);                                  //add that string to that bucket
                    }
                }
            }
        }

        for (ArrayList<String> l1 : output) {//printing arraylist of arraylist of string
            for (String n : l1) {
                int y=Integer.parseInt(n);
                n = String.format("%01d" , y);// removing all the 0s in front of the numbers
                System.out.print(n + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int[] array = {24, 2, 4, 466, 48, 66, 8, 44};

        radixSort(array);
    }
}