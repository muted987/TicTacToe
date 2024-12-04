package main.java.objects;

import main.java.SymbolSet;
import main.java.game.Input;
import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;

public class Player {
    public void makeMove(GameMap map, boolean turnOrder) {
        while (true) {
            Coordinates coordinates = Input.coordinatesInput();
            if (map.isFieldEmpty(coordinates)) {
                SymbolSet.setSymbolOnCoordinates(map, coordinates, turnOrder);
                break;
            } else {
                System.out.println("Field is not empty.");
            }
        }
    }
}
