package main.java.objects;

import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;
import main.java.objects.symbol.SymbolFactory;

import java.util.List;
import java.util.Random;

public class Bot {
    public void makeMove(GameMap map, boolean turnOrder) {
        Random random = new Random();
        SymbolFactory symbolFactory = new SymbolFactory();
        List<Coordinates> availableCoordinates = map.getEmptyFields();
        int randomIndexOfAvailableCoordinatesList = random.nextInt(availableCoordinates.size());
        Coordinates coordinates = availableCoordinates.get(randomIndexOfAvailableCoordinatesList);
        map.setSymbol(coordinates, symbolFactory.symbolSetter(turnOrder, coordinates));
    }
}
