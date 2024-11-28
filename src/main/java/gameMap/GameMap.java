package main.java.gameMap;

import main.java.symbol.Symbol;

import java.util.HashMap;

public class GameMap {
    private final HashMap<Coordinates, Symbol> symbols = new HashMap<>();
    public Symbol getSymbol(Coordinates coordinates){
        return symbols.get(coordinates);
    }
    public boolean isFieldEmpty(Coordinates coordinates){
        return !symbols.containsKey(coordinates);
    }
    public boolean isAnyFreeSpace(){
        return symbols.size() == 9;
    }

    public void setSymbol(Coordinates coordinates, Symbol symbol) {
        symbols.put(coordinates, symbol);
    }
}
