package main.java.game;

import main.java.gameMap.Coordinates;
import main.java.symbol.Symbol;

import java.util.ArrayList;

public class Winner {
    private boolean isWin;
    private Symbol winnerSymbol;
    private ArrayList<Coordinates> winPositions;
    public Winner(boolean isWin, Symbol winnerSymbol, ArrayList<Coordinates> winPositions) {
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
    public ArrayList<Coordinates> getWinPositions() {
        return winPositions;
    }
}
