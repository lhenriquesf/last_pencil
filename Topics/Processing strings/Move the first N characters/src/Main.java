import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String string = sc.next();
        int moves = sc.nextInt();

        String result = rotateString(string, moves);
        System.out.println(result);

        sc.close();
    }

    public static String rotateString(String string, int moves) {

        if (moves > string.length() || moves == 0) {
            return string;
        }
        return string.substring(moves) + string.substring(0, moves);
    }
}