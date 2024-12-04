package main.java.objects;

import main.java.SymbolSet;
import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;
import java.util.List;
import java.util.Random;

public class Bot {
    public void makeMove(GameMap map, boolean turnOrder) {
        Coordinates coordinates = generateRandomCoordinates(map);
        SymbolSet.setSymbolOnCoordinates(map, coordinates, turnOrder);
    }
    private static Coordinates generateRandomCoordinates(GameMap map) {
        List<Coordinates> availableCoordinates = map.getEmptyFields();
        Random random = new Random();
        int randomIndexOfAvailableCoordinatesList = random.nextInt(availableCoordinates.size());
        return availableCoordinates.get(randomIndexOfAvailableCoordinatesList);
    }
}
