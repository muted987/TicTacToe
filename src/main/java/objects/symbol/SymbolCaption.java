package main.java.objects.symbol;

public enum SymbolCaption {
    X("╳"),
    O("о");
    private final String symbol;
    SymbolCaption(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
}
