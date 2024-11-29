package main.java.symbol;

import main.java.gameMap.Coordinates;

public abstract class Symbol {
    private final String SymbolCaption;
    private final Coordinates coordinates;
    public Symbol(String symbolCaption, Coordinates coordinates) {
        SymbolCaption = symbolCaption;
        this.coordinates = coordinates;
    }

    public String getSymbolCaption() {
        return SymbolCaption;
    }



}
