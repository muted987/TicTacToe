package main.java.game;

import main.java.gameMap.Coordinates;

import java.util.Scanner;

public class CoordinatesInput {
    public static Coordinates coordinatesInput() {
        Scanner scanner = new Scanner(System.in);
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
}
