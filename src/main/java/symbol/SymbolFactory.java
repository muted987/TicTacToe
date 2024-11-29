package main.java.symbol;

import main.java.gameMap.Coordinates;

public class SymbolFactory {
    public Symbol symbolSetter(boolean turnOrder, Coordinates coordinates){
        if (turnOrder) {
            return new XSymbol("╳", coordinates);
        } else {
            return new XSymbol("о", coordinates);

        }
    }
}
