import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowManyNumbers {
    public static void main(String[] args) {
        List<Long> result = findAll(35, 6);
        for (Long item : result) {
            System.out.print(item + " ");
        }
    }
    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        int[] number = new int[numDigits];
        for (int i = 0; i < numDigits - 1; i++) {
            number[i] = 1;
        }
        List<Long> result = new ArrayList<>();
        long amountSum = 0;
        long min = 0;
        long max = 0;
        long sumOfDigits = 0;
        while (true) {
            number = generateCombinations(number, numDigits);
            sumOfDigits = Arrays.stream(number).sum();

            if (sumOfDigits == sumDigits) {
                amountSum++;
                if (min == 0) {
                    String s = Arrays.toString(number).replaceAll("[ ,\\]\\[]", "");
                    min = Long.parseLong(s);
                }
                String s = Arrays.toString(number).replaceAll("[ ,\\]\\[]", "");
                System.out.println("+++" + s);
                max = Long.parseLong(s);
            }
            if (number[0] == number[numDigits - 1] && sumOfDigits >= sumDigits ||
                number[0] == 9 && number[numDigits - 1] == 9) break;
            //System.out.println(Arrays.toString(number));
        }
        if (amountSum == 0) return result;
        result.add(amountSum);
        result.add(min);
        result.add(max);
        return result;
    }
    private static int[] generateCombinations(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--)
            if (arr[i] < 9) {
                arr[i]++;
                for (int j = i; j < n - 1; j++)
                    arr[j + 1] = arr[j];
                return arr;
            }
        arr[0]++;
        return arr;
    }
}
