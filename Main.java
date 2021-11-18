import java.util.*;

public class Main {
    public static void radixSort(int[] arr) {

        ArrayList<String> bucket = new ArrayList<>();
        ArrayList<ArrayList<String>> output = new ArrayList<>();

        String[] strArray = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        for (int i = 0; i< 5; i++) {
            output.add(new ArrayList<String>());
        }

        for (String s : strArray) {
            if(s.contains("1") || s.contains("3") || s.contains("5") || s.contains("7") || s.contains("9")){
                System.out.println("*** Abort *** the input has at least one key with odd digits");
                return;
            }
            else{
                for (int i = 0; i < 5; i++) {
                    if (s.charAt(s.length()-1) == ((char)i*2)){
                        output.get(i).add(s);
                    }
                }
            }
        }

        for (int i = 0; i < output.size();i++)
            System.out.println(output.get(i));

//        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args) {
        int[] array = {24, 2, 4, 466, 48, 66, 8, 44};

        radixSort(array);
    }
}