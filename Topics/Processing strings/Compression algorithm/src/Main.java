import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Character aChar = str.charAt(0);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (aChar.equals(str.charAt(i))) {
                count++;
            } else {
                System.out.print(aChar);
                System.out.print(count);
                aChar = str.charAt(i);
                count = 1;
            }
        }
        System.out.print(aChar);
        System.out.print(count);
    }
}