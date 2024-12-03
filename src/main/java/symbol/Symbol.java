package main.java.symbol;

import main.java.gameMap.Coordinates;

import java.util.Objects;

public abstract class Symbol {
    private final String SymbolCaption;
    private final Coordinates coordinates;
    public Symbol(String symbolCaption, Coordinates coordinates) {
        SymbolCaption = symbolCaption;
        this.coordinates = coordinates;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        if (((Symbol) o).getSymbolCaption().equals(this.getSymbolCaption())) return true;
        return Objects.equals(SymbolCaption, symbol.SymbolCaption) && Objects.equals(coordinates, symbol.coordinates);
    }
    @Override
    public int hashCode() {
        return Objects.hash(SymbolCaption, coordinates);
    }
    public String getSymbolCaption() {
        return SymbolCaption;
    }
}
