package main.java.gameMap;

import main.java.objects.symbol.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameMap {

    private static final int AMOUNT_OF_FIELDS = 9;
    private static final int X_MAXIMUM = 3;
    private static final int Y_MAXIMUM = 3;
    private final HashMap<Coordinates, Symbol> symbols = new HashMap<>();
    public Symbol getSymbol(Coordinates coordinates){
        return symbols.get(coordinates);
    }
    public boolean isFieldEmpty(Coordinates coordinates){
        return !symbols.containsKey(coordinates);
    }
    public boolean isNoFreeSpace(){
        return symbols.size() == AMOUNT_OF_FIELDS;
    }

    public List<Coordinates> getEmptyFields(){
        List<Coordinates> result = new ArrayList<>();
        for (int x = 1; x <= X_MAXIMUM; x++) {
            for (int y = 1; y <= Y_MAXIMUM; y++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (isFieldEmpty(coordinates)) {
                    result.add(coordinates);
                }
            }
        }
        return result;
    }

    public void setSymbol(Coordinates coordinates, Symbol symbol) {
        symbols.put(coordinates, symbol);
    }
}
