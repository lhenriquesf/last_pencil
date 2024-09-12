import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int idx = 0;
        int randomNumber;

        int[] numbersOfSeed = new int[n];

        OptionalInt[] numbersMaxOfSeed = new OptionalInt[(b - a) + 1];

        for (int i = a; i <= b; i++) {
            Random rd = new Random(i);
            for (int y = 0; y < n; y++) {
                randomNumber = rd.nextInt(k);
                numbersOfSeed[y] = randomNumber;
            }
            numbersMaxOfSeed[idx] = Arrays.stream(numbersOfSeed).max();
            idx++;
        }

        OptionalInt minOptional = Arrays.stream(numbersMaxOfSeed)
                .filter(OptionalInt::isPresent)
                .mapToInt(OptionalInt::getAsInt)
                .min();

        int minValue = minOptional.getAsInt();

        int currentSeed = a;
        for (OptionalInt aInt : numbersMaxOfSeed) {
            if (aInt.isPresent() && aInt.getAsInt() == minValue) {
                System.out.printf("%d%n%d", currentSeed, minValue);
                break;
            }
            currentSeed++;
        }

        scanner.close();
    }

}