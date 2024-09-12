package lastpencil;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many pencils would you like to use:");
        String pencils = sc.nextLine();

        int pencilsValid = validationPencilGame(pencils);

        System.out.println("Who will be the first (John, Jack):");
        String playerName = sc.nextLine();

        gamePencils(playerName, pencilsValid);

        sc.close();
    }


    protected static void gamePencils(String name, int pencils) {

        while (pencils != 0) {
            String nameChoose = validationChoosePlayer(name);

            System.out.println("|".repeat(pencils));
            System.out.printf(nameChoose.equals("John") ? "%s's turn!%n" : "%s's turn:%n", nameChoose);

            String chooseQtdPencil;

            if (nameChoose.equals("John")) {
                chooseQtdPencil = sc.nextLine();
            } else {
                if (pencils == 1) {
                    chooseQtdPencil = "1";
                } else if (pencils % 4 == 0) {
                    chooseQtdPencil = "3";
                } else if (pencils % 4 == 2) {
                    chooseQtdPencil = "1";
                } else {
                    chooseQtdPencil = "2";
                }
                System.out.println(chooseQtdPencil);
            }

            int chooseQtdPencilValid = validationChooseQtdPencil(chooseQtdPencil, pencils);

            pencils -= chooseQtdPencilValid;

            name = nameChoose.equals("John") ? "Jack" : "John";
        }

        System.out.printf("%s won!", name);
    }


    private static int validationChooseQtdPencil(String chooseQtdPencil, int pencils) {

        int chooseQtdPencilValid;

        String msgError = "Possible values: '1', '2' or '3'";

        while (true) {
            try {
                chooseQtdPencilValid = Integer.parseInt(chooseQtdPencil);

                if (chooseQtdPencilValid > 3 || chooseQtdPencilValid < 1 || chooseQtdPencil.isEmpty()){
                    System.out.println(msgError);
                    chooseQtdPencil = sc.nextLine();
                }
                else if (chooseQtdPencilValid > pencils) {
                    System.out.println("Too many pencils were taken");
                    chooseQtdPencil = sc.nextLine();
                }
                else {
                    return chooseQtdPencilValid;
                }

            } catch (Exception e) {
                System.out.println(msgError);
                chooseQtdPencil = sc.nextLine();
            }
        }
    }


    private static int validationPencilGame(String pencils) {
        int pencilsValid;

        while (true) {

            if (pencils.isEmpty()){
                System.out.println("The number of pencils should be numeric");
                pencils = sc.nextLine();
            }

            try {
                pencilsValid = Integer.parseInt(pencils);

                if (pencilsValid > 0 ){
                    return pencilsValid;
                } else {
                    System.out.println("The number of pencils should be positive");
                    pencils = sc.nextLine();
                }

            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
                pencils = sc.nextLine();
            }
        }
    }


    private static String validationChoosePlayer(String name) {

        while (!name.equals("John") && !name.equals("Jack")) {
            System.out.println("Choose between 'John' and 'Jack'");
            name = sc.nextLine();
        }
        return name;
    }

}
