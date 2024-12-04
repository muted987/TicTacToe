package main.java;

import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;
import main.java.objects.symbol.Symbol;
import main.java.objects.symbol.SymbolCaption;

public class SymbolSet {
    public static void setSymbolOnCoordinates(GameMap map, Coordinates coordinates, boolean turnOrder) {
        map.setSymbol(coordinates, symbolFactory(turnOrder, coordinates));
    }

    private static Symbol symbolFactory(boolean turnOrder, Coordinates coordinates){
        if (turnOrder) {
            return new Symbol(SymbolCaption.X);
        }
        return new Symbol(SymbolCaption.O);
    }
}
