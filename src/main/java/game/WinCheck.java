package main.java.game;

import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;
import main.java.objects.symbol.Symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinCheck {
    public static Winner winChecker(GameMap map) {
        Winner winOnRow = checkRow(map);
        Winner winOnColumn = checkColumn(map);
        Winner winONDiagonal = checkDiagonal(map);
        if (winOnRow.isWin()) {
            return winOnRow;
        }
        if (winOnColumn.isWin()) {
            return winOnColumn;
        }
        if (winONDiagonal.isWin()) {
            return winONDiagonal;
        }
        return new Winner(false, null, new ArrayList<>());
    }
    public static Winner checkRow(GameMap map) {
        for (int x = 1; x < 4; x++) {
            Symbol symbolToCheck = map.getSymbol(new Coordinates(x, 1));
            List<Boolean> lineToCheck = new ArrayList<>();
            List<Coordinates> coordinatesOfLine = new ArrayList<>();
            for (int y = 1; y < 4; y++) {
                Winner winner = checker(x, y, map, symbolToCheck, lineToCheck, coordinatesOfLine);
                if (winner.isWin()) return winner;
            }
        }
        return new Winner(false, map.getSymbol(new Coordinates(1, 1)), new ArrayList<>());
    }
    public static Winner checkColumn(GameMap map) {
        for (int y = 1; y < 4; y++) {
            Symbol symbolToCheck = map.getSymbol(new Coordinates(1, y));
            List<Boolean> lineToCheck = new ArrayList<>();
            List<Coordinates> coordinatesOfLine = new ArrayList<>();
            for (int x = 1; x < 4; x++) {
                Winner winner = checker(x, y, map, symbolToCheck, lineToCheck, coordinatesOfLine);
                if (winner.isWin()) return winner;
            }

        }
        return new Winner(false, map.getSymbol(new Coordinates(1, 1)), new ArrayList<>());
    }
    public static Winner checkDiagonal(GameMap map) {
        List<Coordinates> firstDiagonalCoordinates = Arrays.asList(new Coordinates(1, 1), new Coordinates(2, 2), new Coordinates(3, 3));
        List<Coordinates> secondDiagonalCoordinates = Arrays.asList(new Coordinates(1, 3), new Coordinates(2, 2), new Coordinates(3, 1));
        try {
            if (map.getSymbol(firstDiagonalCoordinates.get(0)).equals(map.getSymbol(firstDiagonalCoordinates.get(1))) && map.getSymbol(firstDiagonalCoordinates.get(0)).equals(map.getSymbol(firstDiagonalCoordinates.get(2)))) {
                return new Winner(true, map.getSymbol(firstDiagonalCoordinates.get(0)), firstDiagonalCoordinates);
            }
            if (map.getSymbol(secondDiagonalCoordinates.get(0)).equals(map.getSymbol(secondDiagonalCoordinates.get(1))) && map.getSymbol(secondDiagonalCoordinates.get(0)).equals(map.getSymbol(secondDiagonalCoordinates.get(2)))) {
                return new Winner(true, map.getSymbol(secondDiagonalCoordinates.get(0)), secondDiagonalCoordinates);
            }
        } catch (Exception ignored) {
        }
        return new Winner(false, map.getSymbol(new Coordinates(1, 1)), new ArrayList<>());
    }
    public static Winner checker(int x, int y, GameMap map, Symbol symbolToCheck, List<Boolean> lineToCheck, List<Coordinates> coordinatesOfLine) {
        Coordinates coordinates = new Coordinates(x, y);
        try {
            boolean checkField = map.getSymbol(coordinates).equals(symbolToCheck);
            if (checkField) {
                lineToCheck.add(true);
                coordinatesOfLine.add(coordinates);
            }
        } catch (Exception ignored) {
        }
        if (!lineToCheck.contains(false) && lineToCheck.size() == 3) {
            return new Winner(true, symbolToCheck, coordinatesOfLine);
        }
        return new Winner(false, map.getSymbol(new Coordinates(1, 1)), new ArrayList<>());
    }
}