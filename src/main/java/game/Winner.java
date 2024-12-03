package main.java.game;

import main.java.gameMap.Coordinates;
import main.java.objects.symbol.Symbol;

import java.util.List;

public class Winner {
    private final boolean isWin;
    private final Symbol winnerSymbol;
    private final List<Coordinates> winPositions;
    public Winner(boolean isWin, Symbol winnerSymbol, List<Coordinates> winPositions) {
        this.isWin = isWin;
        this.winnerSymbol = winnerSymbol;
        this.winPositions = winPositions;
    }
    public boolean isWin() {
        return isWin;
    }
    public Symbol getWinnerSymbol() {
        return winnerSymbol;
    }
    public List<Coordinates> getWinPositions() {
        return winPositions;
    }
}
