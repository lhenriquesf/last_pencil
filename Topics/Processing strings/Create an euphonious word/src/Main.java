import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toLowerCase();

        int result = minimumInsertions(word);
        System.out.println(result);

        scanner.close();
    }

    public static int minimumInsertions(String word) {
        int count = 0;
        int consecutiveVowels = 0;
        int consecutiveConsonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (isVowel(currentChar)) {
                consecutiveVowels++;
                consecutiveConsonants = 0;

                if (consecutiveVowels == 3) {
                    count++;
                    consecutiveVowels = 1;
                }
            } else {
                consecutiveConsonants++;
                consecutiveVowels = 0;

                if (consecutiveConsonants == 3) {
                    count++;
                    consecutiveConsonants = 1;
                }
            }
        }

        return count;
    }

    public static boolean isVowel(char ch) {
        return "aeiouy".indexOf(ch) != -1;
    }
}