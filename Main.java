import java.util.*;


public class Main {
    public static void radixSort(int[] arr) {

        ArrayList<ArrayList<String>> output = new ArrayList<>();

        String[] strArray = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        for (char i = '0'; i < '5'; i++) {
            output.add(new ArrayList<>());
        }

        for (String s : strArray) {
            if (s.contains("1") || s.contains("3") || s.contains("5") || s.contains("7") || s.contains("9")) {
                System.out.println("*** Abort *** the input has at least one key with odd digits");
                return;
            }
        }

        for (String s : strArray) {
            int x=Integer.parseInt(s);
            s = String.format("%03d" , x);
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (s.charAt(s.length() - i) == (char) (j * 2 + '0')) {
                        output.get(j).add(s);
                    }
                }
            }
        }

        for (ArrayList<String> l1 : output) {
            for (String n : l1) {
                int y=Integer.parseInt(n);
                n = String.format("%01d" , y);
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