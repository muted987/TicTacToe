package main.java.objects;

import main.java.game.Input;
import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;
import main.java.objects.symbol.SymbolFactory;

public class Player {
    public void makeMove(GameMap map, boolean turnOrder) {
        SymbolFactory symbolFactory = new SymbolFactory();
        while (true) {
            Coordinates coordinates = Input.coordinatesInput();
            if (map.isFieldEmpty(coordinates)) {
                map.setSymbol(coordinates, symbolFactory.symbolSetter(turnOrder, coordinates));
                break;
            } else {
                System.out.println("Field is not empty.");
            }
        }
    }
}
