import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        for (int i = 0; i < word.length(); i++) {
            System.out.printf("%s%s", word.charAt(i), word.charAt(i));
        }

        sc.close();
    }
}