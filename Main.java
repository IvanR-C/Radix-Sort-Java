import java.util.*;

public class Main {
    public static void radixSort(int[] arr) {
        int index;
        ArrayList<Integer> bucket = new ArrayList<>();

        String[] strArray = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        for (String s : strArray) {

            if(s.contains("1") || s.contains("3") || s.contains("5") || s.contains("7") || s.contains("9")){
                System.out.println("*** Abort *** the input has at least one key with odd digits");
                return;
            }

        }

        System.out.println(Arrays.toString(strArray));
    }

    public static void main(String[] args) {
        int[] array = {24, 2, 4, 46, 48, 66, 8, 44};

        radixSort(array);
    }
}