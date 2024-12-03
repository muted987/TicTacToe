package main.java.game;

import main.java.gameMap.Coordinates;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);


    public static Coordinates coordinatesInput() {
        int x;
        int y;
        while (true) {
            System.out.println("Input coordinates (ex. 1 1)");
            String[] input;
            try {
                input = scanner.nextLine().split(" ");
                x = Integer.parseInt(input[0]);
                y = Integer.parseInt(input[1]);
            } catch (Exception e) {
                System.out.println("Wrong input. Try again");
                continue;
            }

            if ((x >= 4 || y >= 4) || (x == 0 || y == 0)) {
                System.out.println("Wrong input. Try again");
                continue;
            }
            return new Coordinates(x, y);
        }
    }
    public static int gameStartInputOption() {
        while (true) {
            System.out.println("Input option");
            int inputOption = Character.getNumericValue(scanner.nextLine().charAt(0));
            if (!(inputOption > 4 || inputOption < 0)) {
                return inputOption;
            } else {
                System.out.println("Input invalid. Try again");
            }
        }
    }

    public static void botVsBotInputOption() {
        while (true) {
            int inputOption = Character.getNumericValue(scanner.nextLine().charAt(0));
            if (inputOption == 1) {
                break;
            } else {
                System.out.println("Input invalid. Try again.");
            }
        }
    }
}
