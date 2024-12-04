package main.java.objects.symbol;

import main.java.gameMap.Coordinates;

import java.util.Objects;

public class Symbol {
    private final SymbolCaption SymbolCaption;
    public Symbol(SymbolCaption symbolCaption) {
        SymbolCaption = symbolCaption;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        if (((Symbol) o).getSymbolCaption().equals(this.getSymbolCaption())) return true;
        return Objects.equals(SymbolCaption, symbol.SymbolCaption);
    }
    @Override
    public int hashCode() {
        return Objects.hash(SymbolCaption);
    }
    public String getSymbolCaption() {
        return SymbolCaption.getSymbol();
    }
}
