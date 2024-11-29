package main.java.gameMap;

import main.java.symbol.Symbol;

import java.util.ArrayList;

public class GameMapRender {
    public void render(GameMap map, ArrayList<Coordinates> winnerPositions) {
        for (int x = 1; x <= 3; x++) {
            StringBuilder line = new StringBuilder();
            line.append("|");
            for (int y = 1; y <= 3; y++) {
                Coordinates coordinates = new Coordinates(x, y);
                Symbol symbol = map.getSymbol(coordinates);
                if (winnerPositions != null) {
                    if (winnerPositions.contains(coordinates)) {
                        line.append(getColorizedString(symbol)).append("|");
                    } else line.append(getString(coordinates, map));
                } else line.append(getString(coordinates, map));
            }
            line.append("  ").append(x);
            System.out.println("------------------");
            System.out.println(line);
        }
        System.out.println("------------------");
        for (int y = 1; y <= 3; y++) {
            System.out.print("   " + y + "  ");
        }
        System.out.println("\n");
    }
    public String colorizeField(String sprite) {
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        final String ANSI_BLACK_COLOR = "\u001B[30m";
        final String ANSI_RESET = "\u001B[0m";
        return ANSI_GREEN_BACKGROUND + ANSI_BLACK_COLOR + sprite + ANSI_RESET;
    }

    public String getColorizedString(Symbol symbol) {
        return colorizeField("  " + symbol.getSymbolCaption() + "  ");
    }
    public String EmptyFieldString() {
        return ("     |");
    }
    public String ColorlessString(Symbol symbol) {
        return ("  " + symbol.getSymbolCaption() + "  |");
    }

    public String getString(Coordinates coordinates, GameMap map) {
        String result;
        if (map.isFieldEmpty(coordinates)){
            result = EmptyFieldString();
        } else {
            result = ColorlessString(map.getSymbol(coordinates));
        }
        return result;
    }

}
