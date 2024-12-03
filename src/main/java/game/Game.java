package main.java.game;


import main.java.gameMap.Coordinates;
import main.java.gameMap.GameMap;
import main.java.gameMap.GameMapRender;
import main.java.symbol.SymbolFactory;

public class Game {
    public void game() {
        GameMap map = new GameMap();
        GameMapRender render = new GameMapRender();
        SymbolFactory factory = new SymbolFactory();
        boolean xFirstMove = true;
        while (true) {
            render.render(map, null);
            if (xFirstMove) {
                System.out.println("╳ turn");
            } else {
                System.out.println("о turn");
            }
            while (true) {
                Coordinates coordinates = CoordinatesInput.coordinatesInput();
                if (map.isFieldEmpty(coordinates)) {
                    map.setSymbol(coordinates, factory.symbolSetter(xFirstMove, coordinates));
                    break;
                } else {
                    System.out.println("Field is not empty.");
                }
            }
            xFirstMove =! xFirstMove;
            Winner winner = WinCheck.winChecker(map);
            if (winner.isWin()) {
                render.render(map, winner.getWinPositions());
                System.out.println("GAME OVER");
                String winnerSymbol = winner.getWinnerSymbol().getSymbolCaption();
                System.out.printf("%s is winner", winnerSymbol);
                break;
            }
            if (map.isAnyFreeSpace()) {
                render.render(map, null);
                System.out.println("TIE");
                break;
            }
        }
    }
}
