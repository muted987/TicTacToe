package main.java.game;

import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;
import main.java.symbol.Symbol;

import java.util.ArrayList;

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
            ArrayList<Boolean> row = new ArrayList<>();
            ArrayList<Coordinates> rowCoordinates = new ArrayList<>();
            for (int y = 1; y < 4; y++) {
                Coordinates coordinates = new Coordinates(x, y);
                try {
                    boolean checkField = map.getSymbol(coordinates).getSymbolCaption().equals(symbolToCheck.getSymbolCaption());
                    if (checkField) {
                        row.add(true);
                        rowCoordinates.add(coordinates);
                    }
                } catch (Exception ignored) {
                }
            }
            if (!row.contains(false) && row.size() == 3) {
                return new Winner(true, symbolToCheck, rowCoordinates);
            }
        }
        return new Winner(false, map.getSymbol(new Coordinates(1, 1)), new ArrayList<>());
    }

    public static Winner checkColumn(GameMap map){
        for (int y = 1; y < 4; y++) {
            Symbol symbolToCheck = map.getSymbol(new Coordinates(1, y));
            ArrayList<Boolean> column = new ArrayList<>();
            ArrayList<Coordinates> columnCoordinates = new ArrayList<>();
            for (int x = 1; x < 4; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                try {
                    boolean checkField = map.getSymbol(coordinates).getSymbolCaption().equals(symbolToCheck.getSymbolCaption());
                    if (checkField) {
                        column.add(true);
                        columnCoordinates.add(coordinates);
                    }
                } catch (Exception ignored) {
                }
            }
            if (!column.contains(false) && column.size() == 3) {
                return new Winner(true, symbolToCheck, columnCoordinates);
            }
        }
        return new Winner(false, map.getSymbol(new Coordinates(1, 1)), new ArrayList<>());
    }
    public static Winner checkDiagonal(GameMap map) {
        ArrayList<Boolean> diagonal = new ArrayList<>();
        ArrayList<Coordinates> diagonalCoordinates = new ArrayList<>();
        Symbol symbolToCheck = map.getSymbol(new Coordinates(1, 1));
        for (int x = 1, y = 1; x < 4 && y < 4; x++, y++) {
            Coordinates coordinates = new Coordinates(x, y);
            try {
                boolean checkField = map.getSymbol(coordinates).getSymbolCaption().equals(symbolToCheck.getSymbolCaption());
                if (checkField) {
                    diagonal.add(true);
                    diagonalCoordinates.add(coordinates);
                }
            } catch (Exception ignored) {
            }
        }
        if (!diagonal.contains(false) && diagonal.size() == 3) {
            return new Winner(true, symbolToCheck, diagonalCoordinates);
        }
        diagonal = new ArrayList<>();
        diagonalCoordinates = new ArrayList<>();
        symbolToCheck = map.getSymbol(new Coordinates(1, 3));
        for (int x = 1, y = 3; x < 4 && y > 0; x++, y--) {
            Coordinates coordinates = new Coordinates(x, y);
            try {
                boolean checkField = map.getSymbol(coordinates).getSymbolCaption().equals(symbolToCheck.getSymbolCaption());
                if (checkField) {
                    diagonal.add(true);
                    diagonalCoordinates.add(coordinates);
                }
            } catch (Exception ignored) {
            }
        }
        if (!diagonal.contains(false) && diagonal.size() == 3) {
            return new Winner(true, symbolToCheck, diagonalCoordinates);
        }
        return new Winner(false, map.getSymbol(new Coordinates(1, 1)), new ArrayList<>());
    }
}